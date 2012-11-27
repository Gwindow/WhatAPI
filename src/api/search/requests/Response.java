package api.search.requests;

import java.util.List;

/**
 * The Class Response.
 * Stores data returned to us by the API when performing a
 * Requests search
 * 
 * @author Gwindow
 */
public class Response {
	/** The current page being viewed */
	private Number currentPage;
	
	/** The total number of pages of results. */
	private Number pages;
	
	/** The request search results. */
	private List<Request> results;

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
	 * Get the requests returned by the search
	 * 
	 * @return the requests found in the search
	 */
	public List<Request> getResults() {
		return results;
	}

	@Override
	public String toString() {
		return "Response [getCurrentPage=" + getCurrentPage() + ", getPages=" + getPages() + ", getResults=" + getResults() + "]";
	}
}
