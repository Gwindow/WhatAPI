package api.bookmarks;

import java.util.List;

/**
 * The Class Response.
 * 
 * @author Gwindow
 */
public class Response {
	private List<Torrents> bookmarks;
	private List<Artist> artists;

	/**
	 * Gets the artists.
	 * 
	 * @return the artists
	 */
	public List<Artist> getArtists() {
		return this.artists;
	}

	/**
	 * Get the list of bookmarks.
	 * 
	 * @return the bookmarks list
	 */
	public List<Torrents> getBookmarksList() {
		return this.bookmarks;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Response [getBookmarksList=" + getBookmarksList() + "]";
	}
}
