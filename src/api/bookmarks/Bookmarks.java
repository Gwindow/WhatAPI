package api.bookmarks;

import api.son.MySon;
import api.soup.MySoup;

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
	public static Bookmarks torrents(){
		String url = "ajax.php?action=bookmarks&type=torrents&auth=" + MySoup.getAuthKey();
		return (Bookmarks)MySon.toObject(url, Bookmarks.class);
	}

	/**
	 * Get the user's artist bookmarks from the site
	 *
	 * @return the artist Bookmarks
	 */
	public static Bookmarks artists(){
		String url = "ajax.php?action=bookmarks&type=artists&auth=" + MySoup.getAuthKey();
		return (Bookmarks)MySon.toObject(url, Bookmarks.class);
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
		return status.equalsIgnoreCase("success");
	}

	public String getError(){
		return error;
	}

	@Override
	public String toString(){
		return "Bookmarks [getResponse=" + getResponse() + ", getStatus=" + getStatus() + "]";
	}
}
