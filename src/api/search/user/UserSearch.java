package api.search.user;

import api.son.MySon;
import api.soup.MySoup;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Perform User searches on the site and get back some page of the results
 * @author Gwindow
 */
public class UserSearch {
	/** The API response */
	private Response response;

	/** The response status. */
	private String status;

	/** The current page being viewed */
	private transient int page;

	/** The search term. */
	private transient String searchTerm;

	/**
	 * Perform a User search from a search term and get the first page of results
	 * @param term the term to search for
	 * @return first page of results for the term
	 */
	public static UserSearch search(String term){
		return search(term, 1);
	}

	/**
	 * Perform a user search from a search term and get a specific page of the results
	 * @param term the search term
	 * @param page the page to get
	 * @return the desired page of search results
	 */
	public static UserSearch search(String term, int page){
		String searchTerm;
		try {
			searchTerm = URLEncoder.encode(term, "UTF-8");
		}
		catch (UnsupportedEncodingException e){
			e.printStackTrace();
			return null;
		}
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=usersearch&page=" + page + "&search=" + searchTerm + "&auth=" + authkey;

		UserSearch u = (UserSearch)MySon.toObject(url, UserSearch.class);
		u.searchTerm = term;
		u.page = page;
		return u;
	}

	/**
	 * Check if a next page of results is available
	 *
	 * @return True if a next page is available
	 */
	public boolean hasNextPage(){
		return response.getCurrentPage() != null && response.getCurrentPage().intValue() < response.getPages().intValue();
	}

	/**
	 * Get the next page of results for the user search. Returns null if no next page
	 *
	 * @return the next page of the search
	 */
	public UserSearch nextPage(){
		return hasNextPage() ? search(searchTerm, page + 1) : null;
	}

	/**
	 * Check if a previous page of results is available
	 * @return True if a previous page is available
	 */
	public boolean hasPreviousPage(){
		return response.getCurrentPage() != null && response.getCurrentPage().intValue() > 1;
	}

	/**
	 * Get the previous page of results for the user search. Returns null if no previous page
	 *
	 * @return the previous page of the search
	 */
	public UserSearch previousPage(){
		return hasPreviousPage() ? search(searchTerm, page - 1) : null;
	}

	/**
	 * Get the API response
	 * @return the response
	 */
	public Response getResponse() {
		return this.response;
	}

	/**
	 * Get the status of the response
	 * @return True if success
	 */
	public boolean getStatus() {
		return this.status.equalsIgnoreCase("success");
	}

	/**
	 * Get the current page number being viewed
	 * @return the page number
	 */
	public int getPage() {
		return page;
	}

	/**
	 * Get the search term
	 * @return the search term
	 */
	public String getSearchTerm() {
		return searchTerm;
	}

	@Override
	public String toString() {
		return "UserSearch [getResponse=" + getResponse() + ", getStatus=" + getStatus() + ", hasNextPage=" + hasNextPage()
				+ ", hasPreviousPage=" + hasPreviousPage() + "]";
	}
}
