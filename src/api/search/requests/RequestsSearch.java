package api.search.requests;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import api.son.MySon;
import api.soup.MySoup;

/**
 * The Class RequestsSearch.
 * 
 * @author Gwindow
 */
public class RequestsSearch {

	/** The response. */
	private Response response;

	/** The status. */
	private String status;

	/** The page. */
	private transient static int page;

	/** The search term. */
	private transient static String searchTerm;

	/** The tags. */
	private transient static String tags;

	/**
	 * Request search from search term.
	 * 
	 * @param searchTerm
	 *            the search term
	 * @return the requests search
	 */
	public static RequestsSearch requestSearchFromSearchTerm(String searchTerm) {
		return requestSearchFromSearchTerm(searchTerm, 1);
	}

	/**
	 * Request search from search term next page.
	 * 
	 * @return the requests search
	 */
	public static RequestsSearch requestSearchFromSearchTermNextPage() {
		return requestSearchFromSearchTerm(searchTerm, page + 1);
	}

	/**
	 * Request search from search term previous page.
	 * 
	 * @return the requests search
	 */
	public static RequestsSearch requestSearchFromSearchTermPreviousPage() {
		return requestSearchFromSearchTerm(searchTerm, page - 1);
	}

	/**
	 * Request search from search term and page.
	 * 
	 * @param searchTerm
	 *            the search term
	 * @param tags
	 *            the tags
	 * @return the requests search
	 */
	public static RequestsSearch requestSearchFromSearchTermAndTags(String searchTerm, String tags) {
		return requestSearchFromSearchTermAndTags(searchTerm, tags, 1);
	}

	/**
	 * Request search from search term and tags next page.
	 * 
	 * @return the requests search
	 */
	public static RequestsSearch requestSearchFromSearchTermAndTagsNextPage() {
		return requestSearchFromSearchTermAndTags(searchTerm, tags, page + 1);
	}

	/**
	 * Request search from search term and tags previous page.
	 * 
	 * @return the requests search
	 */
	public static RequestsSearch requestSearchFromSearchTermAndTagsPreviousPage() {
		return requestSearchFromSearchTermAndTags(searchTerm, tags, page - 1);
	}

	/**
	 * Request search from search term.
	 * 
	 * @param searchTerm
	 *            the search term
	 * @param page
	 *            the page
	 * @return the requests search
	 */
	public static RequestsSearch requestSearchFromSearchTerm(String searchTerm, int page) {
		if (searchTerm.trim().length() > 0) {
			try {
				searchTerm = URLEncoder.encode(searchTerm, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			RequestsSearch.searchTerm = searchTerm;
			RequestsSearch.page = page;
			String authkey = MySoup.getAuthKey();
			String url = "ajax.php?action=requests&page=" + page + "&search=" + searchTerm + "&auth=" + authkey;
			RequestsSearch requestSearch = (RequestsSearch) MySon.toObject(url, RequestsSearch.class);
			return requestSearch;
		} else
			return null;
	}

	/**
	 * Request search from search term and tags. Separate tags must be separated by commas, while whitespace should be
	 * replaced by periods. For example, hip.hop,pop,indie
	 * 
	 * @param searchTerm
	 *            the search term
	 * @param tags
	 *            the tags
	 * @param page
	 *            the page
	 * @return the requests search
	 */
	public static RequestsSearch requestSearchFromSearchTermAndTags(String searchTerm, String tags, int page) {
		if (searchTerm.trim().length() > 0) {
			try {
				searchTerm = URLEncoder.encode(searchTerm, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			RequestsSearch.searchTerm = searchTerm;
			RequestsSearch.page = page;
			String authkey = MySoup.getAuthKey();
			RequestsSearch.tags = tags;
			tags = tags.replace(",", "&");
			String url = "ajax.php?action=requests&page=" + page + "&search=" + searchTerm + "&tags=" + tags + "&auth=" + authkey;
			RequestsSearch requestSearch = (RequestsSearch) MySon.toObject(url, RequestsSearch.class);
			return requestSearch;
		} else
			return null;
	}

	/**
	 * Checks for next page.
	 * 
	 * @return true, if successful
	 */
	public boolean hasNextPage() {
		try {
			if (((response.getPages().intValue() - (response.getCurrentPage().intValue())) > 0))
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Checks for previous page.
	 * 
	 * @return true, if successful
	 */
	public boolean hasPreviousPage() {
		try {
			if ((((response.getCurrentPage().intValue()) != 1) || ((response.getCurrentPage().intValue()) == 0)))
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Gets the page.
	 * 
	 * @return the page
	 */
	public static int getPage() {
		return page;
	}

	/**
	 * Gets the response.
	 * 
	 * @return the response
	 */
	public Response getResponse() {
		return this.response;
	}

	/**
	 * Gets the status.
	 * 
	 * @return the status
	 */
	public boolean getStatus() {
		if (status.equalsIgnoreCase("success"))
			return true;
		return false;
	}

	/**
	 * Gets the search term.
	 * 
	 * @return the search term
	 */
	public static String getSearchTerm() {
		return searchTerm;
	}

	/**
	 * Gets the tags.
	 * 
	 * @return the tags
	 */
	public static String getTags() {
		return tags;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RequestsSearch [hasNextPage()=" + hasNextPage() + ", hasPreviousPage()=" + hasPreviousPage() + ", getResponse()="
				+ getResponse() + ", getStatus()=" + getStatus() + "]";
	}

}
