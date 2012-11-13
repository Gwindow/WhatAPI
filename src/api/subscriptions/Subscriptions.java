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

	/** The response. */
	private Response response;

	/** The status. */
	private String status;

	/**
	 * Inits the.
	 * 
	 * @return the subscriptions
	 */
	public static Subscriptions init() {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=subscriptions&auth=" + authkey;
		return (Subscriptions) MySon.toObject(url, Subscriptions.class);
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
        return !(response.getThreads().isEmpty() || (response.getThreads() == null));
	}

	/**
	 * Gets the status.
	 * 
	 * @return the status
	 */
	public boolean getStatus() {
        return status.equalsIgnoreCase("success");
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

	public static void catchUp() {
		try {
			MySoup.pressLink("userhistory.php?action=catchup&auth=" + MySoup.getAuthKey());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Subscriptions [getResponse()=" + getResponse() + ", hasUnreadThreads()=" + hasUnreadThreads() + ", getStatus()="
				+ getStatus() + ", sortThreadsBySection()=" + sortThreadsBySection() + "]";
	}
}
