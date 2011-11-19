/**
 * @author Gwindow
 */
package api.torrents.artist;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;

import api.son.MySon;
import api.soup.MySoup;
import api.util.Tuple;

/**
 * The Class Artist.
 */
public class Artist {
	private Response response;
	private String status;
	private static transient int id;

	/**
	 * Artist from id.
	 * 
	 * @param id
	 *            the id
	 * @return the artist
	 */
	public static Artist artistFromId(int id) {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=artist&id=" + id + "&auth=" + authkey;
		Artist artist = (Artist) MySon.toObject(url, Artist.class);
		Artist.id = id;
		return artist;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public static int getId() {
		return id;
	}

	/**
	 * Gets the response.
	 * 
	 * @return the response
	 */
	public Response getResponse() {
		return this.response;
	}

	/**
	 * Adds the bookmark.
	 */
	public void addBookmark() {
		String authKey = MySoup.getAuthKey();
		if (response.isBookmarked() == false) {
			MySoup.pressLink("bookmarks.php?action=add&type=artist&auth=" + authKey + "&id=" + id);
			System.out.println("Bookmarked");
		} else {
			System.err.println("Already bookmarked");
		}
	}

	/**
	 * Removes the bookmark.
	 */
	public void removeBookmark() {
		String authKey = MySoup.getAuthKey();
		if (response.isBookmarked() == true) {
			MySoup.pressLink("bookmarks.php?action=remove&type=artist&auth=" + authKey + "&id=" + id);
			System.out.println("Removed bookmark");
		} else {
			System.err.println("Already isn't bookmarked");
		}
	}

	/**
	 * Enable notifications.
	 */
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

	/**
	 * Disbale notifications.
	 */
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

	// TODO fix
	/*
	 * public List<Tuple<String, String>> getDownloadLinksList() { List<Tuple<String, String>> list = new
	 * ArrayList<Tuple<String, String>>(); for (TorrentGroup tg : response.getTorrentgroup()) { for (Torrent t :
	 * tg.getTorrents()) { String name = t.getFilePath(); if (t.getFilePath().equalsIgnoreCase("") || t.getFilePath() ==
	 * null) { name = tg.getGroupName() + " - " + tg.getGroupYear() + " (" + t.getMediaFormatEncoding() + ")"; }
	 * list.add(new Tuple<String, String>(t.getDownloadLink(), name)); } } return list; }
	 */
	/**
	 * Gets the download links list for.
	 * 
	 * @param formatList
	 *            the format list
	 * @return the download links list for
	 */
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

	/**
	 * Gets the download links list except.
	 * 
	 * @param formatList
	 *            the format list
	 * @return the download links list except
	 */
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

	/**
	 * Download list.
	 * 
	 * @param list
	 *            the list
	 * @param path
	 *            the path
	 */
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

	/**
	 * Download torrent.
	 * 
	 * @param url
	 *            the url
	 * @param path
	 *            the path
	 * @param name
	 *            the name
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void downloadTorrent(String url, String path, String name) throws IOException {
		URL u;
		u = new URL(url);
		ReadableByteChannel rbc = Channels.newChannel(u.openStream());
		FileOutputStream fos = new FileOutputStream(path + name + ".torrent");
		fos.getChannel().transferFrom(rbc, 0, 1 << 24);
		System.out.println("Downloaded " + name + " to " + path);
	}

	/**
	 * Gets the spotify url.
	 * 
	 * @return the spotify url
	 */
	public String getSpotifyUrl() {
		try {
			String s = "spotify:artist" + URLEncoder.encode(getResponse().getName(), "UTF-8");
			return s;
		} catch (UnsupportedEncodingException e) {
			System.err.println("Could not encode url");
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * Gets the last fm url.
	 * 
	 * @return the last fm url
	 */
	public String getLastFMUrl() {
		try {
			String s = "http://www.last.fm/search?q=" + URLEncoder.encode(getResponse().getName(), "UTF-8") + "&type=artist";
			return s;
		} catch (UnsupportedEncodingException e) {
			System.err.println("Could not encode url");
			e.printStackTrace();
			return null;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Artist [getResponse()=" + getResponse() + ", getSpotifyUrl()=" + getSpotifyUrl() + ", getLastFMUrl()="
				+ getLastFMUrl() + ", getStatus()=" + getStatus() + "]";
	}

	/* public boolean getStatus() { if (status.equalsIgnoreCase("success")) return true; return false; } */

	/**
	 * Get the status of the request.
	 * 
	 * @return true if success
	 */
	public boolean getStatus() {
		if (status.equalsIgnoreCase("success"))
			return true;
		return false;
	}

}
