
package api.requests;

import api.son.MySon;
import api.soup.MySoup;

/**
 * The Class Request.
 * 
 * //TODO description
 * 
 * @author Gwindow
 */
public class Request {

	/** The response. */
	private Response response;

	/** The status. */
	private String status;

	/**
	 * Request from id.
	 * 
	 * @param id
	 *            the id
	 * @return the request
	 */
	public static Request fromId(int id) {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=request&id=" + id + "&auth=" + authkey;
		Request request = (Request) MySon.toObject(url, Request.class);
		return request;
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
	 * Get the status of the request.
	 * 
	 * @return true if success
	 */
	public boolean getStatus() {
        return status.equalsIgnoreCase("success");
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Request [getResponse=" + getResponse() + ", getStatus=" + getStatus() + "]";
	}
}
