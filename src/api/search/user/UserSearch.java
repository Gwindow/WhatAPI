/**
 * @author Gwindow
 */
package api.search.user;

import api.son.MySon;
import api.soup.MySoup;

/**
 * The Class UserSearch.
 */
public class UserSearch {
	private Response response;
	private String status;
	private transient static int page;
	private transient static String searchTerm;

	/**
	 * User search from search term.
	 * 
	 * @param searchTerm
	 *            the search term
	 * @return the user search
	 */
	public static UserSearch userSearchFromSearchTerm(String searchTerm) {
		if (searchTerm.trim().length() > 0) {
			UserSearch.searchTerm = searchTerm;
			page = 1;
			String authkey = MySoup.getAuthKey();
			String url = "ajax.php?action=usersearch&page=" + page + "&search=" + searchTerm + "&auth=" + authkey;
			UserSearch userSearch = (UserSearch) MySon.toObject(url, UserSearch.class);
			return userSearch;
		} else
			return null;
	}

	/**
	 * User search from search term and page.
	 * 
	 * @param searchTerm
	 *            the search term
	 * @param page
	 *            the page
	 * @return the user search
	 */
	public static UserSearch userSearchFromSearchTermAndPage(String searchTerm, int page) {
		if (searchTerm.trim().length() > 0) {
			UserSearch.searchTerm = searchTerm;
			UserSearch.page = page;
			String authkey = MySoup.getAuthKey();
			String url = "ajax.php?action=usersearch&page=" + page + "&search=" + searchTerm + "&auth=" + authkey;
			UserSearch userSearch = (UserSearch) MySon.toObject(url, UserSearch.class);
			return userSearch;
		} else
			return null;
	}

	/**
	 * User search from next page.
	 * 
	 * @return the user search
	 */
	public static UserSearch userSearchFromNextPage() {
		page += 1;
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=usersearch&page=" + page + "&search=" + searchTerm + "&auth=" + authkey;
		UserSearch userSearch = (UserSearch) MySon.toObject(url, UserSearch.class);
		return userSearch;
	}

	/**
	 * User search from previous page.
	 * 
	 * @return the user search
	 */
	public static UserSearch userSearchFromPreviousPage() {
		page -= 1;
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=usersearch&page=" + page + "&search=" + searchTerm + "&auth=" + authkey;
		UserSearch userSearch = (UserSearch) MySon.toObject(url, UserSearch.class);
		return userSearch;
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
	 * Gets the search term.
	 * 
	 * @return the search term
	 */
	public static String getSearchTerm() {
		return searchTerm;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserSearch [getResponse=" + getResponse() + ", getStatus=" + getStatus() + ", hasNextPage=" + hasNextPage()
				+ ", hasPreviousPage=" + hasPreviousPage() + "]";
	}
}
