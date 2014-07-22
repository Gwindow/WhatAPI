package api.inbox.inbox;

import api.son.MySon;
import api.soup.MySoup;

/**
 * For getting and interacting with the API regarding viewing
 * the user's inbox
 *
 * @author Gwindow
 */
public class Inbox {
	/**
	 * The API response
	 */
	private Response response;

	/**
	 * The response status and error message (if an error occurred)
	 */
	private String status, error;

	/**
	 * The page of the inbox being viewed.
	 */
	private transient int page;

	/**
	 * Get the Inbox at the first page
	 *
	 * @return the Inbox
	 */
	public static Inbox init(){
		return page(1);
	}

	/**
	 * Get the Inbox at some page
	 *
	 * @param page the page to get
	 * @return the Inbox
	 */
	public static Inbox page(int page){
		String url = "ajax.php?action=inbox&page=" + page + "&auth=" + MySoup.getAuthKey();
		Inbox i = (Inbox)MySon.toObject(url, Inbox.class);
		if (i != null){
			i.page = page;
		}
		return i;
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
	 * Get the next page of search results. Returns null if there is
	 * no next page
	 *
	 * @return the next page of search results
	 */
	public Inbox nextPage(){
		return hasNextPage() ? page(page + 1) : null;
	}

	/**
	 * Check if a previous page of results is available
	 *
	 * @return True if a previous page is available
	 */
	public boolean hasPreviousPage(){
		return response.getCurrentPage() != null && response.getCurrentPage().intValue() > 1;
	}

	/**
	 * Get the previous page of search results. Returns null if there is
	 * no previous page
	 *
	 * @return the previous page of search results
	 */
	public Inbox previousPage(){
		return hasPreviousPage() ? page(page - 1) : null;
	}

	/**
	 * Get the API response containing the list of messages in the inbox
	 *
	 * @return the response
	 */
	public Response getResponse(){
		return response;
	}

	/**
	 * Get the status of the API request
	 *
	 * @return True if success
	 */
	public boolean getStatus(){
		return status.equalsIgnoreCase("success");
	}

	/**
	 * Get the error string describing the error that occurred
	 *
	 * @return error message from the API, null if no error
	 */
	public String getError(){
		return error;
	}

	/**
	 * Get the current page number being viewed
	 *
	 * @return the current page number
	 */
	public int getPage(){
		return page;
	}

	@Override
	public String toString(){
		return "Inbox [getResponse()=" + getResponse() + ", getStatus()=" + getStatus()
			+ ", hasNextPage()=" + hasNextPage() + ", hasPreviousPage()=" + hasPreviousPage() + "]";
	}
}
