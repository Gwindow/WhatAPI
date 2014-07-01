package api.subscriptions;

import api.son.MySon;
import api.soup.MySoup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
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
	 * The threads grouped by section, cached so we don't
	 * need to re-compute it each time it's needed
	 */
	Map<String, List<ForumThread>> groupedSubscriptions;

	/**
	 * Load the user's unread subscriptions
	 */
	public static Subscriptions init(){
		return init(false);
	}

	/**
	 * Load the list of subscriptions, optionally showing all of them, not just those
	 * with unread posts
	 * @param showAll True if we want to load all subscriptions, not just those with
	 *                new posts
	 */
	public static Subscriptions init(boolean showAll){
		String url = "ajax.php?action=subscriptions&auth=" + MySoup.getAuthKey();
		if (showAll){
			url += "&showunread=0";
		}
		return (Subscriptions)MySon.toObject(url, Subscriptions.class);
	}

	/**
	 * Get the list of subscribed threads
	 */
	public List<ForumThread> getThreads(){
		return response.getThreads();
	}

	/**
	 * Check if there are any unread posts in the subscribed threads
	 * Note: this has no meaning if you requested to load all subscribed
	 * threads, check thread.hasUnreadPosts in this case.
	 * @return True if unread posts exist
	 */
	public boolean hasUnreadThreads() {
		return response.getThreads() != null && !response.getThreads().isEmpty();
	}

	/**
	 * Get the status of the API response
	 * 
	 * @return True if success
	 */
	public boolean getStatus() {
        return status.equalsIgnoreCase("success");
	}

	/**
	 * Get the error string for the error that occurred, null if no error
	 */
	public String getError(){
		return error;
	}

	/**
	 * Get the list of subscribed threads grouped by their section
	 */
	public Map<String, List<ForumThread>> groupThreadsBySection(){
		if (groupedSubscriptions != null){
			return groupedSubscriptions;
		}
		groupedSubscriptions = new TreeMap<String, List<ForumThread>>();
		for (ForumThread t : response.getThreads()){
			//If we haven't started a list for this section yet, start one
			if (!groupedSubscriptions.containsKey(t.getForumName())){
				groupedSubscriptions.put(t.getForumName(), new ArrayList<ForumThread>());
			}
			groupedSubscriptions.get(t.getForumName()).add(t);
		}
		return groupedSubscriptions;
	}

	/**
	 * Catch up with all subscribed threads
	 */
	public static void catchUp(){
		MySoup.pressLink("userhistory.php?action=catchup&auth=" + MySoup.getAuthKey());
	}

	@Override
	public String toString(){
		return "Subscriptions [getThreads()=" + getThreads() + ", hasUnreadThreads()=" + hasUnreadThreads() + ", getStatus()="
			+ getStatus() + ", groupThreadsBySection()=" + groupThreadsBySection() + "]";
	}
}
