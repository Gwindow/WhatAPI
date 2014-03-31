package api.requests;

import api.son.MySon;
import api.soup.MySoup;

/**
 * The Class Request.
 * For using the API related to viewing Requests
 *
 * @author Gwindow
 */
public class Request {
	/** The API response. */
	private Response response;

	/** The response status */
	private String status;

	/**
	 * Get a request from the request id
	 * 
	 * @param id
	 *      the request id
	 * @return the request
	 */
	public static Request fromId(int id) {
		String url = "ajax.php?action=request&id=" + id + "&auth=" + MySoup.getAuthKey();
		return (Request) MySon.toObject(url, Request.class);
	}

	/**
	 * Add some bounty to the request
	 * @param id id of request to add to
	 * @param amount bounty to add in bytes
	 * @return true if successful
	 */
	public static boolean addBounty(int id, long amount){
		String url = "requests.php?action=takevote&id=" + id
			+ "&auth=" + MySoup.getAuthKey() + "&amount=" + amount;
		return MySoup.pressLink(url);
	}

	public boolean addBounty(long amount){
		return addBounty(response.getRequestId().intValue(), amount);
	}

	public void addBookmark(){
		String url = "bookmarks.php?action=add&type=request&auth=" + MySoup.getAuthKey()
			+ "&id=" + response.getRequestId();
		MySoup.pressLink(url);
	}

	public void removeBookmark(){
		String url = "bookmarks.php?action=remove&type=request&auth=" + MySoup.getAuthKey()
			+ "&id=" + response.getRequestId();
		MySoup.pressLink(url);
	}

	/**
	 * Get the API response
	 * 
	 * @return the response
	 */
	public Response getResponse() {
		return response;
	}

	/**
	 * Get the status of the request
	 * 
	 * @return True if success
	 */
	public boolean getStatus() {
        return status.equalsIgnoreCase("success");
	}

	@Override
	public String toString() {
		return "Request [getResponse=" + getResponse() + ", getStatus=" + getStatus() + "]";
	}
}
