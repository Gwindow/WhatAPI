package api.torrents.artist;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;

import api.son.MySon;
import api.soup.MySoup;
import api.util.Tuple;

public class Artist {
	private Response response;
	private String status;
	private static transient String id;

	public static Artist artistFromId(String id) {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=artist&id=" + id + "&auth=" + authkey;
		Artist artist = (Artist) MySon.toObject(url, Artist.class);
		Artist.id = id;
		return artist;
	}

	public static String getId() {
		return id;
	}

	public Response getResponse() {
		return this.response;
	}

	public void addBookmark() {
		String authKey = MySoup.getAuthKey();
		if (response.isBookmarked() == false) {
			MySoup.pressLink("bookmarks.php?action=add&type=artist&auth=" + authKey + "&id=" + id);
			System.out.println("Bookmarked");
		} else {
			System.err.println("Already bookmarked");
		}
	}

	public void removeBookmark() {
		String authKey = MySoup.getAuthKey();
		if (response.isBookmarked() == true) {
			MySoup.pressLink("bookmarks.php?action=remove&type=artist&auth=" + authKey + "&id=" + id);
			System.out.println("Removed bookmark");
		} else {
			System.err.println("Already isn't bookmarked");
		}
	}

	public void enableNotifications() {
		String authkey = MySoup.getAuthKey();
		if (response.isNotificationsEnabled() == false) {
			// TODO take care of people who don't have notification privileges
			MySoup.pressLink("artist.php?action=notify&artistid=" + id + "&auth=" + authkey);
			System.out.println("Notifications enabled");
		} else {
			System.err.println("Notifications already enabled");
		}
	}

	public void disbaleNotifications() {
		String authkey = MySoup.getAuthKey();
		if (response.isNotificationsEnabled() == true) {
			// TODO take care of people who don't have notification privileges
			MySoup.pressLink("artist.php?action=notifyremove&artistid=" + id + "&auth=" + authkey);
			System.out.println("Notifications disabled");
		} else {
			System.err.println("Notifications already disabled");
		}
	}

	public List<Tuple<String, String>> getDownloadLinksList() {
		List<Tuple<String, String>> list = new ArrayList<Tuple<String, String>>();
		for (TorrentGroup tg : response.getTorrentgroup()) {
			for (Torrent t : tg.getTorrents()) {
				String name = t.getFilePath();
				if (t.getFilePath().equalsIgnoreCase("") || t.getFilePath().equals(null)) {
					name = tg.getGroupName() + " - " + tg.getGroupYear() + " (" + t.getMediaFormatEncoding() + ")";
				}
				list.add(new Tuple<String, String>(t.getDownloadLink(), name));
			}
		}
		return list;
	}

	public List<Tuple<String, String>> getDownloadLinksListFor(String[] formatList) {
		List<Tuple<String, String>> list = new ArrayList<Tuple<String, String>>();
		for (TorrentGroup tg : response.getTorrentgroup()) {
			for (Torrent t : tg.getTorrents()) {
				for (int i = 0; i < formatList.length; i++) {
					if (formatList[i].equalsIgnoreCase(t.getFormat())) {
						String name = t.getFilePath();
						if (t.getFilePath().equalsIgnoreCase("") || t.getFilePath().equals(null)) {
							name = tg.getGroupName() + " - " + tg.getGroupYear() + " (" + t.getMediaFormatEncoding() + ")";
						}
						list.add(new Tuple<String, String>(t.getDownloadLink(), name));
					}
				}
			}
		}
		return list;
	}

	public List<Tuple<String, String>> getDownloadLinksListExcept(String[] formatList) {
		List<Tuple<String, String>> list = new ArrayList<Tuple<String, String>>();
		for (TorrentGroup tg : response.getTorrentgroup()) {
			for (Torrent t : tg.getTorrents()) {
				for (int i = 0; i < formatList.length; i++) {
					if (!formatList[i].equalsIgnoreCase(t.getFormat())) {
						String name = t.getFilePath();
						if (t.getFilePath().equalsIgnoreCase("") || t.getFilePath().equals(null)) {
							name = tg.getGroupName() + " - " + tg.getGroupYear() + " (" + t.getMediaFormatEncoding() + ")";
						}
						list.add(new Tuple<String, String>(t.getDownloadLink(), name));
					}
				}
			}
		}
		return list;

	}

	public void downloadList(List<Tuple<String, String>> list, String path) {
		for (Tuple<String, String> t : list) {
			try {
				downloadTorrent(t.getA(), path, t.getB());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void downloadTorrent(String url, String path, String name) throws IOException {
		URL u;
		u = new URL(url);
		ReadableByteChannel rbc = Channels.newChannel(u.openStream());
		FileOutputStream fos = new FileOutputStream(path + name + ".torrent");
		fos.getChannel().transferFrom(rbc, 0, 1 << 24);
		System.out.println("Downloaded " + name + " to " + path);
	}

	@Override
	public String toString() {
		return "Artist [getResponse=" + getResponse() + ", getStatus=" + getStatus() + ", getDownloadLinksList="
				+ getDownloadLinksList() + "]";
	}

	/* public boolean getStatus() { if (status.equalsIgnoreCase("success")) return true; return false; } */

	public boolean getStatus() {
		// TODO Auto-generated method stub
		return true;
	}

}
