package api.search.torrents;

import java.util.List;

/**
 * The Class Response.
 * Stores data returned to us by the API when
 * performing a Torrent search
 *
 * @author Gwindow
 */
public class Response {
	/** The current page of results being viewed. */
	private Number currentPage;
	
	/** The total number of pages of results */
	private Number pages;
	
	/** The search results. */
	private List<TorrentGroup> results;

	/**
	 * Get the current page number
	 * 
	 * @return the current page number
	 */
	public Number getCurrentPage() {
		return currentPage;
	}

	/**
	 * Get the total number of pages
	 * 
	 * @return the total number of pages
	 */
	public Number getPages() {
		return pages;
	}

	/**
	 * Get the search results
	 * 
	 * @return the results
	 */
	public List<TorrentGroup> getResults() {
		return results;
	}

	@Override
	public String toString() {
		return "Response [getCurrentPage()=" + getCurrentPage() + ", getPages()=" + getPages() + ", getResults()=" + getResults()
				+ "]";
	}
}
