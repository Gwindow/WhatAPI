package api.torrents.artist;

import api.son.MySon;
import api.soup.MySoup;
import api.util.Tuple;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;

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

	private String error;

	/** The id. */
	private transient int id;

	private transient Releases releases;

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
		if (artist != null){
			artist.id = id;

		}
		return artist;
	}

	/**
	 * Load an artist from some name, returns null if no artist with that name is found
	 * @param name name of artist to load
	 * @return the loaded artist, or null if no such artist
	 */
	public static Artist fromName(String name){
		try {
			String url = "ajax.php?action=artist&artistname=" + URLEncoder.encode(name, "UTF-8") + "&auth=" + MySoup.getAuthKey();
			Artist a = (Artist)MySon.toObject(url, Artist.class);
			if (a != null && a.getStatus()){
				a.id = a.response.getId().intValue();
				return a;
			}
		}
		catch (UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public int getId(){
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

	public String getError(){
		return error;
	}

	public Releases getReleases(){
		if (releases == null){
			releases = new Releases(this);
		}
		return releases;
	}

	/**
	 * Bookmark some artist
	 *
	 * @param id artist id to bookmark
	 * @return true if bookmarked successfully
	 */
	public static boolean addBookmark(int id){
		return MySoup.pressLink("bookmarks.php?action=add&type=artist&auth=" + MySoup.getAuthKey() + "&id=" + id);
	}

	/**
	 * Remove some artist bookmark
	 *
	 * @param id artist id to remove bookmark from
	 * @return true if removed successfully
	 */
	public static boolean removeBookmark(int id){
		return MySoup.pressLink("bookmarks.php?action=remove&type=artist&auth=" + MySoup.getAuthKey() + "&id=" + id);
	}

	/**
	 * Adds the bookmark.
	 */
	public boolean addBookmark(){
		if (!response.isBookmarked()){
			if (addBookmark(id)){
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
	public boolean removeBookmark(){
		if (response.isBookmarked()){
			if (removeBookmark(id)){
				response.setBookmarked(false);
				return true;
			}
			return false;
		}
        //If it's already not bookmarked, say it went ok
        return true;
	}

	/**
	 * Enable notifications for some artist
	 *
	 * @param id artist id to enable notifications for
	 * @return true if successful
	 */
	public static boolean enableNotifications(int id){
		return MySoup.pressLink("artist.php?action=notify&artistid=" + id + "&auth=" + MySoup.getAuthKey());
	}

	/**
	 * Disable notifications for some artist
	 *
	 * @param id artist id to disable notifications for
	 * @return true if successful
	 */
	public static boolean disableNotifications(int id){
		return MySoup.pressLink("artist.php?action=notifyremove&artistid=" + id + "&auth=" + MySoup.getAuthKey());
	}

	/**
	 * Enable notifications.
	 */
	public boolean enableNotifications() {
		if (!response.hasNotificationsEnabled()) {
			if (enableNotifications(id)){
				response.setNotificationsEnabled(true);
				return true;
            }
			return false;
		}
        //If already enabled, just say it went ok
        return true;
	}

	/**
	 * Disable notifications.
	 */
	public boolean disableNotifications() {
		if (response.hasNotificationsEnabled()){
			if (disableNotifications(id)){
                response.setNotificationsEnabled(false);
	            return true;
            }
			return false;
		}
        //If already disabled just say it went ok
        return true;
	}

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
