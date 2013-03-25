package api.search.user;

import java.util.List;

/**
 * The Class Response.
 * Stores the data returned to us by the API request
 * for a User Search
 * 
 * @author Gwindow
 */
public class Response {
	/** The current page being viewed. */
	private Number currentPage;
	
	/** The total number of pages of results. */
	private Number pages;
	
	/** The results. */
	private List<User> results;

	/**
	 * Get the current page number
	 * 
	 * @return the current page number
	 */
	public Number getCurrentPage() {
		return currentPage;
	}

	/**
	 * Get the total number of pages of results
	 * 
	 * @return the total number of pages
	 */
	public Number getPages() {
		return pages;
	}

	/**
	 * Get the results
	 * 
	 * @return the results
	 */
	public List<User> getResults() {
		return results;
	}

	@Override
	public String toString() {
		return "Response [getCurrentPage=" + getCurrentPage() + ", getPages=" + getPages() + ", getResults=" + getResults() + "]";
	}
}
