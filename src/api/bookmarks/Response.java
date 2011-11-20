package api.bookmarks;

import java.util.List;

/**
 * The Class Response.
 * 
 * @author Gwindow
 */
public class Response {
	private List<BookmarksList> bookmarks;

	/**
	 * Get the list of bookmarks.
	 * 
	 * @return the bookmarks list
	 */
	public List<BookmarksList> getBookmarksList() {
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
