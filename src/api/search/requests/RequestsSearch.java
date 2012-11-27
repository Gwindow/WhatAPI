package api.search.requests;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import api.son.MySon;
import api.soup.MySoup;

/**
 * The Class RequestsSearch.
 * For performing and interacting with the results of a Request search
 * 
 * @author Gwindow
 */
public class RequestsSearch {
	/** The API response. */
	private Response response;

	/** The response status. */
	private String status;

	/** The current page being viewed */
	private transient static int page;

	/** The search term. */
	private transient static String searchTerm;

	/** The search tags */
	private transient static String tags;

	/**
	 * Perform a Request search from a search term.
	 * 
	 * @param searchTerm
	 *      the search term
	 * @return the Requests search
	 */
	public static RequestsSearch requestSearchFromSearchTerm(String searchTerm) {
		return requestSearchFromSearchTerm(searchTerm, 1);
	}

	/**
	 * Get the next page of the existing Request search from term
	 * 
	 * @return the next page of the Requests search
	 */
	public static RequestsSearch requestSearchFromSearchTermNextPage() {
		return requestSearchFromSearchTerm(searchTerm, page + 1);
	}

	/**
	 * Get the previous page of the existing Request search from term
	 * 
	 * @return the previous page of the Requests search
	 */
	public static RequestsSearch requestSearchFromSearchTermPreviousPage() {
		return requestSearchFromSearchTerm(searchTerm, page - 1);
	}

	/**
	 * Perform a Request search from a search term and tags
	 * 
	 * @param searchTerm
	 *      the search term
	 * @param tags
	 *      the search tags
	 * @return the Requests search
	 */
	public static RequestsSearch requestSearchFromSearchTermAndTags(String searchTerm, String tags) {
		return requestSearchFromSearchTermAndTags(searchTerm, tags, 1);
	}

	/**
	 * Get the next page of the existing Request search from term and tags
	 * 
	 * @return the next page of the Requests search
	 */
	public static RequestsSearch requestSearchFromSearchTermAndTagsNextPage() {
		return requestSearchFromSearchTermAndTags(searchTerm, tags, page + 1);
	}

	/**
	 * Get the previous page of the existing Request search from term and tags
	 * 
	 * @return the previous page of the Requests search
	 */
	public static RequestsSearch requestSearchFromSearchTermAndTagsPreviousPage() {
		return requestSearchFromSearchTermAndTags(searchTerm, tags, page - 1);
	}

	/**
	 * Perform a Request search with some search term and return the desired page
     * of results
	 * 
	 * @param searchTerm
	 *      the search term
	 * @param page
	 *      the page of results to return
	 * @return the Requests search
	 */
	public static RequestsSearch requestSearchFromSearchTerm(String searchTerm, int page) {
		if (searchTerm != null) {
			try {
				searchTerm = URLEncoder.encode(searchTerm, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			RequestsSearch.searchTerm = searchTerm;
			RequestsSearch.page = page;
			String authkey = MySoup.getAuthKey();
			String url = "ajax.php?action=requests&page=" + page
                    + "&search=" + searchTerm + "&auth=" + authkey;
			return (RequestsSearch) MySon.toObject(url, RequestsSearch.class);
		}
        else
			return null;
	}

	/**
	 * Perform a Request search from search term and tags. Separate tags must be separated by commas, while whitespace should be
	 * replaced by periods. For example, hip.hop,pop,indie
	 * 
	 * @param searchTerm
	 *      the search term
	 * @param tags
	 *      the search tags
	 * @param page
	 *      the page of results to return
	 * @return the Requests search
	 */
	public static RequestsSearch requestSearchFromSearchTermAndTags(String searchTerm, String tags, int page) {
		if (searchTerm != null) {
			try {
				searchTerm = URLEncoder.encode(searchTerm, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			RequestsSearch.searchTerm = searchTerm;
			RequestsSearch.page = page;
			String authkey = MySoup.getAuthKey();
			RequestsSearch.tags = tags;
			try {
				tags = tags.replace(",", "&");
			} catch (Exception e) {
				e.printStackTrace();
			}
			String url = "ajax.php?action=requests&page=" + page
                    + "&search=" + searchTerm + "&tags=" + tags + "&auth=" + authkey;
			return (RequestsSearch) MySon.toObject(url, RequestsSearch.class);
		}
        else
			return null;
	}

	/**
	 * Check if a next page of results is available
	 * 
	 * @return True if a next page is available
	 */
	public boolean hasNextPage() {
		try {
			return ((response.getPages().intValue() - response.getCurrentPage().intValue()) > 0);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Check if a previous page of results is available
	 * 
	 * @return True if a previous page is available
	 */
	public boolean hasPreviousPage() {
		try {
			return (response.getCurrentPage().intValue() != 1 || response.getCurrentPage().intValue() == 0);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Get the current page number being viewed
	 * 
	 * @return the current page number
	 */
	public static int getPage() {
		return page;
	}

	/**
	 * Get the API response
	 * 
	 * @return the API response
	 */
	public Response getResponse() {
		return this.response;
	}

	/**
	 * Get the response status
	 * 
	 * @return True if success
	 */
	public boolean getStatus() {
        return this.status.equalsIgnoreCase("success");
	}

	/**
	 * Get the search term used
	 * 
	 * @return the search term
	 */
	public static String getSearchTerm() {
		return searchTerm;
	}

	/**
	 * Get the search tags used
	 * 
	 * @return the search tags
	 */
	public static String getTags() {
		return tags;
	}

	@Override
	public String toString() {
		return "RequestsSearch [hasNextPage()=" + hasNextPage() + ", hasPreviousPage()=" + hasPreviousPage() + ", getResponse()="
				+ getResponse() + ", getStatus()=" + getStatus() + "]";
	}

}
