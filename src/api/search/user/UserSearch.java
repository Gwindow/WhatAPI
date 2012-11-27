package api.search.user;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import api.son.MySon;
import api.soup.MySoup;

/**
 * The Class UserSearch.
 * For performing User Searches via the API and
 * interacting with the result
 * 
 * @author Gwindow
 */
public class UserSearch {
	/** The API response */
	private Response response;

	/** The response status. */
	private String status;

	/** The current page being viewed */
	private transient static int page;

	/** The search term. */
	private transient static String searchTerm;

	/**
	 * Perform a User search from a search term
	 * 
	 * @param searchTerm
	 *      the search term
	 * @return the User search
	 */
	public static UserSearch userSearchFromSearchTerm(String searchTerm) {
		return userSearchFromSearchTermAndPage(searchTerm, 1);
	}

	/**
	 * Perform a user search from a search term and get a specific page of the results
	 * 
	 * @param searchTerm
	 *      the search term
	 * @param page
	 *      the page to get
	 * @return the User search at the page
	 */
	public static UserSearch userSearchFromSearchTermAndPage(String searchTerm, int page) {
		if (searchTerm.trim().length() > 0) {
			try {
				searchTerm = URLEncoder.encode(searchTerm, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			UserSearch.searchTerm = searchTerm;
			UserSearch.page = page;
			String authkey = MySoup.getAuthKey();
			String url = "ajax.php?action=usersearch&page=" + page + "&search=" + searchTerm + "&auth=" + authkey;
			return (UserSearch) MySon.toObject(url, UserSearch.class);
		} else
			return null;
	}

	/**
	 * Get the next page of the current User search
     * Need to make sure a next page exists
	 * 
	 * @return the next page of the User search
	 */
	public static UserSearch userSearchFromNextPage() {
		++page;
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=usersearch&page=" + page + "&search=" + searchTerm + "&auth=" + authkey;
		return  (UserSearch) MySon.toObject(url, UserSearch.class);
	}

	/**
	 * Get the previous page of the current User search
     * Need to make sure a previous page exists
	 * 
	 * @return the previous page of the User search
	 */
	public static UserSearch userSearchFromPreviousPage() {
		--page;
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=usersearch&page=" + page + "&search=" + searchTerm + "&auth=" + authkey;
		return (UserSearch) MySon.toObject(url, UserSearch.class);
	}

    /**
     * Check if a next page of results exists
     *
     * @return True if a next page exists
     */
    public boolean hasNextPage() {
            return  ((response.getPages().intValue() - response.getCurrentPage().intValue()) > 0);
    }

    /**
     * Check if a previous page of results exists
     *
     * @return True if a previous page exists
     */
    public boolean hasPreviousPage() {
        return  (response.getCurrentPage().intValue() != 1 || response.getCurrentPage().intValue() == 0);
    }

	/**
	 * Get the API response
	 * 
	 * @return the response
	 */
	public Response getResponse() {
		return this.response;
	}

	/**
	 * Get the status of the response
	 * 
	 * @return True if success
	 */
	public boolean getStatus() {
		return this.status.equalsIgnoreCase("success");
	}

	/**
	 * Get the current page number being viewed
	 * 
	 * @return the page number
	 */
	public static int getPage() {
		return page;
	}

	/**
	 * Get the search term
	 * 
	 * @return the search term
	 */
	public static String getSearchTerm() {
		return searchTerm;
	}

	@Override
	public String toString() {
		return "UserSearch [getResponse=" + getResponse() + ", getStatus=" + getStatus() + ", hasNextPage=" + hasNextPage()
				+ ", hasPreviousPage=" + hasPreviousPage() + "]";
	}
}
