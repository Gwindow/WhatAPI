package api.subscriptions;

import api.son.MySon;
import api.soup.MySoup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * The Class Subscriptions.
 * For getting and interacting with the site API related to viewing
 * forum thread subscriptions
 * 
 * @author Gwindow
 */
public class Subscriptions {
	/** The API response. */
	private Response response;

	/** The response status. */
	private String status;

	private String error;

	/**
	 * Get the list subscripts that have new posts
	 * 
	 * @return the subscriptions
	 */
	public static Subscriptions init() {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=subscriptions&auth=" + authkey;
		return (Subscriptions) MySon.toObject(url, Subscriptions.class);
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
	 * Check if there are any unread posts in the subscribed threads
	 * 
	 * @return True if unread posts exist
	 */
	public boolean hasUnreadThreads() {
        return !(response.getThreads().isEmpty() || response.getThreads() == null);
	}

	/**
	 * Get the status of the API response
	 * 
	 * @return True if success
	 */
	public boolean getStatus() {
        return status.equalsIgnoreCase("success");
	}

	public String getError(){
		return error;
	}

	/**
	 * Dont call me just yet!.
     * TODO: Finish this function
	 * 
	 * @return the hash map
	 */
	public HashMap<String, ForumThread> sortThreadsBySection() {
		HashMap<String, ForumThread> map = new HashMap<String, ForumThread>();
		for (ForumThread t : response.getThreads()) {
			map.put(t.getForumName(), t);
		}
		ArrayList<String> sortedKeys = new ArrayList<String>(map.keySet());
		Collections.sort(sortedKeys);
		return map;
	}

    /**
     * Catch up with all subscribed topics
     */
	public static void catchUp() {
		try {
			MySoup.pressLink("userhistory.php?action=catchup&auth=" + MySoup.getAuthKey());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Subscriptions [getResponse()=" + getResponse() + ", hasUnreadThreads()=" + hasUnreadThreads() + ", getStatus()="
				+ getStatus() + ", sortThreadsBySection()=" + sortThreadsBySection() + "]";
	}
}
