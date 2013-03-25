package api.comments;

import java.util.List;

/**
 * The class Response
 * The TorrentComments API response
 *
 * @author Gwindow
 */
public class Response {
    /** A list of the comments in the response */
	private List<Comment> comments;

    /** The page number of the current comments */
	private Number page;

    /** The total number of pages of comments */
	private Number pages;

    /**
     * Get the List of Comments
     *
     * @return the Comments
     */
	public List<Comment> getComments() {
		return this.comments;
	}

    /**
     * Get the current comment page being viewed
     *
     * @return the current page number
     */
	public Number getPage() {
		return this.page;
	}

    /**
     * Get the total number of pages of comments available
     * to view
     *
     * @return the total number of pages
     */
	public Number getPages() {
		return this.pages;
	}

	@Override
	public String toString() {
		return "Response [getComments()=" + getComments() + ", getPage()=" + getPage() + ", getPages()=" + getPages() + "]";
	}
}
