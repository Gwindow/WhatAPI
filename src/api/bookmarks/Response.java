package api.bookmarks;

import java.util.List;

public class Response {
	private List<BookmarksList> bookmarks;

	public List<BookmarksList> getBookmarksList() {
		return this.bookmarks;
	}

	@Override
	public String toString() {
		return "Response [getBookmarksList=" + getBookmarksList() + "]";
	}
}
