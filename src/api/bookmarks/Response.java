package api.bookmarks;

import java.util.List;

/**
 * The Class Response.
 * 
 * @author Gwindow
 */
public class Response {
	
	/** The bookmarks. */
	private List<Torrents> bookmarks;
	
	/** The artists. */
	private List<Artist> artists;

	/**
	 * Gets the list of artist bookmarks.
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
	public List<Torrents> getTorrents() {
		return this.bookmarks;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Response [getArtists=" + getArtists() + ", getBookmarksList=" + getTorrents() + "]";
	}
}
