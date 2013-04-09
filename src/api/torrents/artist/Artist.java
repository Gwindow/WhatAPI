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
 * 
 * @author Gwindow
 */
public class Artist {

	/** The response. */
	private Response response;

	/** The status. */
	private String status;

	/** The id. */
	private static transient int id;

	/**
	 * Artist from id.
	 * 
	 * @param id
	 *            the id
	 * @return the artist
	 */
	public static Artist fromId(int id) {
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
     * Get the status of the request.
     *
     * @return true if success
     */
    public boolean getStatus() {
        return status.equalsIgnoreCase("success");
    }

	/**
	 * Adds the bookmark.
	 */
	public boolean addBookmark() {
		String authKey = MySoup.getAuthKey();
		if (!response.isBookmarked()) {
			boolean success = MySoup.pressLink("bookmarks.php?action=add&type=artist&auth=" + authKey + "&id=" + id);
            if (success){
                response.setBookmarked(true);
                return true;
            }
            return false;
		}
        //If it's already bookmarked, just say it went ok
        return true;
	}

	/**
	 * Removes the bookmark.
	 */
	public boolean removeBookmark() {
		String authKey = MySoup.getAuthKey();
		if (response.isBookmarked()) {
			boolean success = MySoup.pressLink("bookmarks.php?action=remove&type=artist&auth=" + authKey + "&id=" + id);
            if (success){
                response.setBookmarked(false);
                return true;
            }
            else
                return false;
		}
        //If it's already not bookmarked, say it went ok
        return true;
	}

	/**
	 * Enable notifications.
	 */
	public boolean enableNotifications() {
		if (!response.hasNotificationsEnabled()) {
			boolean success = MySoup.pressLink("artist.php?action=notify&artistid=" + id + "&auth=" + MySoup.getAuthKey());
			if (success){
                response.setNotificationsEnabled(true);
                return true;
            }
            else
                return false;
		}
        //If already enabled, just say it went ok
        return true;
	}

	/**
	 * Disabale notifications.
	 */
	public boolean disableNotifications() {
		if (response.hasNotificationsEnabled()) {
			boolean success = MySoup.pressLink("artist.php?action=notifyremove&artistid=" + id + "&auth=" + MySoup.getAuthKey());
            if (success){
                response.setNotificationsEnabled(false);
                return true;
            }
            else
                return false;
		}
        //If already disabled just say it went ok
        return true;
	}

	// TODO fix: What's wrong?
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
						String name = tg.getGroupName() + " - " + tg.getGroupYear() + " (" + t.getMediaFormatEncoding() + ")";
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
						String name = tg.getGroupName() + " - " + tg.getGroupYear() + " (" + t.getMediaFormatEncoding() + ")";
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
			return "spotify:artist" + URLEncoder.encode(getResponse().getName(), "UTF-8");
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
		String s;
		try {
			s = "http://www.last.fm/search?q=" + URLEncoder.encode(getResponse().getName(), "UTF-8") + "&type=artist";
		} catch (UnsupportedEncodingException e) {
			s = "http://www.last.fm/";
		}
		return s;
	}

    @Override
	public String toString() {
		return "Artist [getResponse()=" + getResponse() + ", getSpotifyUrl()=" + getSpotifyUrl() + ", getLastFMUrl()="
				+ getLastFMUrl() + ", getStatus()=" + getStatus() + "]";
	}
}
