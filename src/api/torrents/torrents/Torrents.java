package api.torrents.torrents;

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

public class Torrents {
	private Response response;
	private String status;
	private static transient String id;

	/**
	 * create the Torrents
	 * 
	 * @param id
	 *            the id of the torrent group
	 * @return Torrents
	 */
	public static Torrents torrentsFromId(String id) {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=torrentgroup&id=" + id + "&auth=" + authkey;
		Torrents torrents = (Torrents) MySon.toObject(url, Torrents.class);
		Torrents.id = id;
		return torrents;
	}

	/**
	 * the id of the torrent group
	 * 
	 * @return the torrent group id
	 */
	public static String getId() {
		return id;
	}

	public boolean hasFreeLeech() {
		for (int i = 0; i < getResponse().getTorrents().size(); i++) {
			if (getResponse().getTorrents().get(i).isFreeTorrent())
				return true;
		}
		return false;
	}

	/**
	 * Get the response containing the torrentgroup information
	 * 
	 * @return response
	 */
	public Response getResponse() {
		return this.response;
	}

	public void addBookmark() {
		String authKey = MySoup.getAuthKey();
		if (response.getGroup().isBookmarked() == false) {
			MySoup.pressLink("bookmarks.php?action=add&type=torrent&auth=" + authKey + "&id=" + id);
			System.out.println("Bookmarked");
		} else {
			System.err.println("Already bookmarked");
		}
	}

	public void removeBookmark() {
		String authKey = MySoup.getAuthKey();
		if (response.getGroup().isBookmarked() == true) {
			MySoup.pressLink("bookmarks.php?action=remove&type=torrent&auth=" + authKey + "&id=" + id);
			System.out.println("Removed bookmark");
		} else {
			System.err.println("Already isn't bookmarked");
		}
	}

	/**
	 * Get the status of the request
	 * 
	 * @return true if success
	 */
	public boolean getStatus() {
		if (status.equalsIgnoreCase("success"))
			return true;
		return false;
	}

	public List<Tuple<String, String>> getDownloadLinksList() {
		List<Tuple<String, String>> list = new ArrayList<Tuple<String, String>>();
		for (Torrent t : response.getTorrents()) {
			String name = t.getFilePath();
			if (t.getFilePath().equalsIgnoreCase("") || t.getFilePath().equals(null)) {
				name =
						response.getGroup().getName() + " - " + response.getGroup().getYear() + " (" + t.getMediaFormatEncoding()
								+ ")";
			}
			list.add(new Tuple<String, String>(t.getDownloadLink(), name));
		}
		return list;
	}

	public List<Tuple<String, String>> getDownloadLinksListFor(String[] formatList) {
		List<Tuple<String, String>> list = new ArrayList<Tuple<String, String>>();
		for (Torrent t : response.getTorrents()) {
			for (int i = 0; i < formatList.length; i++) {
				if (formatList[i].equalsIgnoreCase(t.getFormat())) {
					String name = t.getFilePath();
					if (t.getFilePath().equalsIgnoreCase("") || t.getFilePath().equals(null)) {
						name =
								response.getGroup().getName() + " - " + response.getGroup().getYear() + " ("
										+ t.getMediaFormatEncoding() + ")";
					}
					list.add(new Tuple<String, String>(t.getDownloadLink(), name));
				}
			}
		}
		return list;

	}

	public List<Tuple<String, String>> getDownloadLinksListExcept(String[] formatList) {
		List<Tuple<String, String>> list = new ArrayList<Tuple<String, String>>();
		for (Torrent t : response.getTorrents()) {
			for (int i = 0; i < formatList.length; i++) {
				if (!formatList[i].equalsIgnoreCase(t.getFormat())) {
					String name = t.getFilePath();
					if (t.getFilePath().equalsIgnoreCase("") || t.getFilePath().equals(null)) {
						name =
								response.getGroup().getName() + " - " + response.getGroup().getYear() + " ("
										+ t.getMediaFormatEncoding() + ")";
					}
					list.add(new Tuple<String, String>(t.getDownloadLink(), name));
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

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Torrents [id =" + id + ", response=" + response + ", status=" + status + "]";
	}
}
