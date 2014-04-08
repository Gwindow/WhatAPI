package api.bookmarks;

import api.son.MySon;
import api.soup.MySoup;
import api.util.Tuple;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.List;

/**
 * The Class Bookmarks
 * Used for getting and reading the users Bookmarks
 * from the site
 *
 * @author Gwindow
 */
public class Bookmarks {
	/**
	 * The API response, contains the data we want to look at
	 */
	private Response response;

	/**
	 * The status of the API response
	 */
	private String status;

	private String error;

	/**
	 * Get the user's torrent bookmarks from the site
	 *
	 * @return the torrent Bookmarks
	 */
	public static Bookmarks initTorrentBookmarks(){
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=bookmarks&type=torrents&auth=" + authkey;
		Bookmarks bookmarks = (Bookmarks)MySon.toObject(url, Bookmarks.class);
		return bookmarks;
	}

	/**
	 * Get the user's artist bookmarks from the site
	 *
	 * @return the artist Bookmarks
	 */
	public static Bookmarks initArtistBookmarks(){
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=bookmarks&type=artists&auth=" + authkey;
		Bookmarks bookmarks = (Bookmarks)MySon.toObject(url, Bookmarks.class);
		return bookmarks;
	}

	/**
	 * Check if the response has torrent bookmarks
	 *
	 * @return True if has torrent bookmarks
	 */
	public boolean hasTorrentBookmarks(){
		return !(response.getTorrents() == null || response.getTorrents().isEmpty());
	}

	/**
	 * Checks if the response has artist bookmarks
	 *
	 * @return True if has artist bookmakrs
	 */
	public boolean hasArtistBookmarks(){
		return !(response.getArtists() == null || response.getArtists().isEmpty());
	}

	/**
	 * Get the API response data
	 *
	 * @return the response
	 */
	public Response getResponse(){
		return this.response;
	}

	/**
	 * Get the status of the request.
	 *
	 * @return true if success
	 */
	public boolean getStatus(){
		return this.status.equalsIgnoreCase("success");
	}

	public String getError(){
		return error;
	}

	/**
	 * Download a list of torrents to some path
	 *
	 * @param list list of torrents
	 * @param path the local path to download them to
	 */
	public void downloadList(List<Tuple<String, String>> list, String path){
		for (Tuple<String, String> t : list){
			try {
				downloadTorrent(t.getA(), path, t.getB());
			}
			catch (IOException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Download a torrent to some path with the desired file name
	 *
	 * @param url  the url of the torrent
	 * @param path the local path to download it to
	 * @param name the name to save it as
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void downloadTorrent(String url, String path, String name) throws IOException{
		URL u;
		u = new URL(url);
		ReadableByteChannel rbc = Channels.newChannel(u.openStream());
		FileOutputStream fos = new FileOutputStream(path + name + ".torrent");
		fos.getChannel().transferFrom(rbc, 0, 1 << 24);
		System.out.println("Downloaded " + name + " to " + path);
	}

	@Override
	public String toString(){
		return "Bookmarks [getResponse=" + getResponse() + ", getStatus=" + getStatus() + "]";
	}
}
