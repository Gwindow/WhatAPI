


package api.subscriptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import api.son.MySon;
import api.soup.MySoup;

/**
 * The Class Subscriptions.
 * 
 * @author Gwindow
 */
public class Subscriptions {
	private Response response;
	private String status;

	/**
	 * Inits the.
	 * 
	 * @return the subscriptions
	 */
	public static Subscriptions init() {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=subscriptions&auth=" + authkey;
		Subscriptions subscriptions = (Subscriptions) MySon.toObject(url, Subscriptions.class);
		return subscriptions;
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
	 * Checks for unread threads.
	 * 
	 * @return true, if successful
	 */
	public boolean hasUnreadThreads() {
		if (response.getThreads().isEmpty() || (response.getThreads() == null))
			return true;
		return false;
	}

	/**
	 * Gets the status.
	 * 
	 * @return the status
	 */
	public boolean getStatus() {
		if (status.equalsIgnoreCase("success"))
			return true;
		return false;
	}

	// TODO needs to be tested
	/**
	 * Dont call me just yet!.
	 * 
	 * @return the hash map
	 */
	public HashMap<String, Threads> sortThreadsBySection() {
		HashMap<String, Threads> map = new HashMap<String, Threads>();
		for (Threads t : response.getThreads()) {
			map.put(t.getForumName(), t);
		}
		ArrayList<String> sortedKeys = new ArrayList<String>(map.keySet());
		Collections.sort(sortedKeys);
		return map;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Subscriptions [getResponse=" + getResponse() + ", getStatus=" + getStatus() + "]";
	}
}
