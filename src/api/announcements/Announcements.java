
package api.announcements;

/**
 * The Announcements, includes both site announcements and blog posts
 * 
 * 
 */
import api.son.MySon;
import api.soup.MySoup;

/**
 * The Class Announcements.
 * 
 * @author Gwindow
 */
public class Announcements {
	
	/** The response. */
	private Response response;
	
	/** The status. */
	private String status;

	/**
	 * Initialize the Announcements.
	 * 
	 * @return an Announcements object
	 */
	public static Announcements init() {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=announcements&auth=" + authkey;
		Announcements a = (Announcements) MySon.toObject(url, Announcements.class);
		return a;
	}

	/**
	 * Get the response.
	 * 
	 * @return the response
	 */
	public Response getResponse() {
		return this.response;
	}

	/**
	 * Get the status of the request.
	 * 
	 * @return the status
	 */
	public boolean getStatus() {
		if (status.equalsIgnoreCase("success"))
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Announcements [getResponse=" + getResponse() + ", getStatus=" + getStatus() + "]";
	}

}
