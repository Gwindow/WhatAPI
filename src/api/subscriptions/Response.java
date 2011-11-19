/**
 * @author Gwindow
 */
package api.subscriptions;

import java.util.List;

/**
 * The Class Response.
 */
public class Response {
	private List<Threads> threads;

	/**
	 * Gets the threads.
	 * 
	 * @return the threads
	 */
	public List<Threads> getThreads() {
		return this.threads;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Response [getThreads=" + getThreads() + "]";
	}

}
