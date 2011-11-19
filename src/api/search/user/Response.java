/**
 * @author Gwindow
 */
package api.search.user;

import java.util.List;

/**
 * The Class Response.
 */
public class Response {
	private Number currentPage;
	private Number pages;
	private List<Results> results;

	/**
	 * Gets the current page.
	 * 
	 * @return the current page
	 */
	public Number getCurrentPage() {
		return this.currentPage;
	}

	/**
	 * Gets the pages.
	 * 
	 * @return the pages
	 */
	public Number getPages() {
		return this.pages;
	}

	/**
	 * Gets the results.
	 * 
	 * @return the results
	 */
	public List<Results> getResults() {
		return this.results;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Response [getCurrentPage=" + getCurrentPage() + ", getPages=" + getPages() + ", getResults=" + getResults() + "]";
	}
}
