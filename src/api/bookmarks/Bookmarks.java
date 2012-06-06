package api.bookmarks;

/**
 * The Bookmarks
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.List;

import api.son.MySon;
import api.soup.MySoup;
import api.util.Tuple;

/**
 * The Class Bookmarks.
 * 
 * @author Gwindow
 */
public class Bookmarks {

	/** The response. */
	private Response response;

	/** The status. */
	private String status;

	/**
	 * Inits the torrent bookmarks.
	 * 
	 * @return the bookmarks
	 */
	public static Bookmarks initTorrentBookmarks() {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=bookmarks&type=torrents&auth=" + authkey;
		Bookmarks bookmarks = (Bookmarks) MySon.toObject(url, Bookmarks.class);
		return bookmarks;
	}

	/**
	 * Inits the artist bookmarks.
	 * 
	 * @return the bookmarks
	 */
	public static Bookmarks initArtistBookmarks() {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=bookmarks&type=artists&auth=" + authkey;
		Bookmarks bookmarks = (Bookmarks) MySon.toObject(url, Bookmarks.class);
		return bookmarks;
	}

	/**
	 * Checks for torrent bookmarks.
	 * 
	 * @return true, if successful
	 */
	public boolean hasTorrentBookmarks() {
		if ((response.getTorrents() == null) || response.getTorrents().isEmpty())
			return false;
		return true;
	}

	/**
	 * Checks for artist bookmarks.
	 * 
	 * @return true, if successful
	 */
	public boolean hasArtistBookmarks() {
		if ((response.getArtists() == null) || response.getArtists().isEmpty())
			return false;
		return true;
	}

	/**
	 * Get the response.
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
		if (status.equalsIgnoreCase("success"))
			return true;
		return false;
	}

	/**
	 * Download a list of torrents.
	 * 
	 * @param list
	 *            list of torrents
	 * @param path
	 *            the local path to download them to
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
	 * Download a torrent.
	 * 
	 * @param url
	 *            the url of the torrent
	 * @param path
	 *            the local path to download it to
	 * @param name
	 *            the name to save it as
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Bookmarks [getResponse=" + getResponse() + ", getStatus=" + getStatus() + "]";
	}
}
