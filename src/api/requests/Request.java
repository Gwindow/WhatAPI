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
	 * @param amount bounty to add in bytes
	 */
	public void vote(long amount){
		String url = "requests.php?action=takevote&id=" + response.getRequestId()
			+ "&auth=" + MySoup.getAuthKey() + "&amount=" + Long.toString(amount);
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
