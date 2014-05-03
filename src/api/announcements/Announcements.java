package api.announcements;

import api.son.MySon;
import api.soup.MySoup;

/**
 * The Class Announcements.
 * Contains the results of the announcements API
 * request, the status and the response
 *
 * @author Gwindow
 */
public class Announcements {
	/**
	 * The response to the API request, contains our data
	 */
	private Response response;

	/**
	 * The status of our API request
	 */
	private String status;

	private String error;

	/**
	 * Initialize the Announcements.
	 * Gets the Announcements from the site and returns
	 * them as an Announcements instance
	 *
	 * @return an Announcements object
	 */
	public static Announcements init(){
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=announcements&auth=" + authkey;
		return (Announcements)MySon.toObject(url, Announcements.class);
	}

	/**
	 * Get the response we received from the site.
	 * The response is where the actual information from the
	 * API response is stored.
	 *
	 * @return the response
	 */
	public Response getResponse(){
		return this.response;
	}

	/**
	 * Get the status of the request.
	 * True for success, false for failure
	 *
	 * @return the status
	 */
	public boolean getStatus(){
		return this.status.equalsIgnoreCase("success");
	}

	public String getError(){
		return error;
	}

	@Override
	public String toString(){
		return "Announcements [getResponse=" + getResponse() + ", getStatus=" + getStatus() + "]";
	}

}
