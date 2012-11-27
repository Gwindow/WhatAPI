package api.subscriptions;

import java.util.List;

/**
 * The Class Response.
 * Stores the data returned by the API for viewing the
 * user's forum thread subscriptions
 * 
 * @author Gwindow
 */
public class Response {
	/** The subscribed threads. */
	private List<ForumThread> threads;

	/**
	 * Get the threads
	 * 
	 * @return the threads
	 */
	public List<ForumThread> getThreads() {
		return threads;
	}

	@Override
	public String toString() {
		return "Response [getThreads=" + getThreads() + "]";
	}
}
