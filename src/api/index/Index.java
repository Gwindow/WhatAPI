package api.index;

import api.son.MySon;

/**
 * The Class Index.
 * For getting and working with the API related
 * to viewing the index for a user. Contains information such
 * as notifications, user stats, messages, etc.
 *
 * @author Gwindow
 */
public class Index {
	/**
	 * The API response.
	 */
	private Response response;

	/**
	 * The response status
	 */
	private String status;

	private String error;

	/**
	 * Get the Index data from the site
	 *
	 * @return the Index
	 */
	public static Index init(){
		String url = "ajax.php?action=index";
		return (Index)MySon.toObject(url, Index.class);
	}

	/**
	 * Get the API response data
	 *
	 * @return the response
	 */
	public Response getResponse(){
		return response;
	}

	/**
	 * Get the status of the request.
	 *
	 * @return True if success
	 */
	public boolean getStatus(){
		return status.equalsIgnoreCase("success");
	}

	public String getError(){
		return error;
	}

	@Override
	public String toString(){
		return "Index [response=" + response + ", status=" + status + ", getResponse=" + getResponse() + ", getStatus="
			+ getStatus() + "]";
	}
}
