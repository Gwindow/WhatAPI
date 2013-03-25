package api.bookmarks;

import java.util.List;

/**
 * The Class Response
 * Contains the data returned by the bookmarks API request
 * 
 * @author Gwindow
 */
public class Response {
	/** The list of bookmarked torrents */
	private List<TorrentGroup> bookmarks;
	
	/** The list of bookmarked artists */
	private List<Artist> artists;

	/**
	 * Get the list of artist bookmarks.
	 * 
	 * @return the artist bookmarks
	 */
	public List<Artist> getArtists() {
		return this.artists;
	}

	/**
	 * Get the list of torrent bookmarks.
	 * 
	 * @return the torrent bookmarks
	 */
	public List<TorrentGroup> getTorrents() {
		return this.bookmarks;
	}

	@Override
	public String toString() {
		return "Response [getArtists=" + getArtists() + ", getBookmarksList=" + getTorrents() + "]";
	}
}
