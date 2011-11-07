package api.announcements;

/**
 * The Announcements, includes both site announcements and blog posts
 * 
 * 
 */
import api.son.MySon;
import api.soup.MySoup;

public class Announcements {
	private Response response;
	private String status;

	/**
	 * Initialize the Announcements
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
	 * Get the response
	 * 
	 * @return
	 */
	public Response getResponse() {
		return this.response;
	}

	/**
	 * Get the status of the request
	 * 
	 * @return
	 */
	public boolean getStatus() {
		if (status.equalsIgnoreCase("success"))
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "Announcements [getResponse=" + getResponse() + ", getStatus=" + getStatus() + "]";
	}

}
