package api.inbox.inbox;

import api.son.MySon;
import api.soup.MySoup;

/**
 * The Class Inbox.
 * For getting and interacting with the API regarding viewing
 * the user's inbox
 *
 * @author Gwindow
 */
public class Inbox {
	/** The API response */
	private Response response;

	/** The response status. */
	private String status;

	/** The page of the inbox being viewed. */
	private static int page;

	/**
	 * Get the Inbox at the first page
	 * 
	 * @return the Inbox
	 */
	public static Inbox init() {
		return fromPage(1);
	}

	/**
	 * Get the Inbox at some page
	 * 
	 * @param page
	 *      the page to get
	 * @return the Inbox
	 */
	public static Inbox fromPage(int page) {
		String authkey = MySoup.getAuthKey();
		Inbox.page = page;
		String url = "ajax.php?action=inbox&page=" + page + "&auth=" + authkey;
		return (Inbox) MySon.toObject(url, Inbox.class);
	}

	/**
     * Get the next page of the Inbox
	 * Should only be called if hasNextPage() returned true.
	 * 
	 * @return the Inbox at the next page
	 */
	public static Inbox fromNextPage() {
		++page;
		return fromPage(page);
	}

	/**
     * Get the previous page of the Inbox
	 * Should only be called if hasPreviousPage() returned true.
	 * 
	 * @return the Inbox at the previous page
	 */
	public static Inbox fromPreviousPage() {
		--page;
		return fromPage(page);
	}

	/**
	 * Get the API response.
	 * 
	 * @return the response
	 */
	public Response getResponse() {
		return response;
	}

	/**
	 * Get the status of the API request
	 * 
	 * @return True if success
	 */
	public boolean getStatus() {
        return status.equalsIgnoreCase("success");
	}

	/**
	 * Get the last page number of the Inbox
	 * 
	 * @return the last page number
	 */
	public int getLastPage() {
        return response.getPages().intValue();
	}

	/**
	 * Check if the Inbox has a next page
	 * 
	 * @return True if a next page exists
	 */
	public boolean hasNextPage() {
        return ((response.getPages().intValue() - response.getCurrentPage().intValue()) > 0);
	}

	/**
	 * Check if the Inbox has a previous page
	 * 
	 * @return True if a previous page exists
	 */
	public boolean hasPreviousPage() {
        return (response.getCurrentPage().intValue() != 1 || response.getCurrentPage().intValue() == 0);
	}

	/**
	 * Get the current page number being viewed
	 * 
	 * @return the current page number
	 */
	public static int getPage() {
		return page;
	}

	@Override
	public String toString() {
		return "Inbox [getResponse()=" + getResponse() + ", getStatus()=" + getStatus() + ", getLastPage()=" + getLastPage()
				+ ", hasNextPage()=" + hasNextPage() + ", hasPreviousPage()=" + hasPreviousPage() + "]";
	}

}
