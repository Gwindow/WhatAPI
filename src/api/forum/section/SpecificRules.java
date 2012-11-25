package api.forum.section;

/**
 * The Class SpecificRules.
 * Describes the thread containing the list
 * of specific rules for the forum
 *
 * @author Gwindow
 */
public class SpecificRules {
	/** The rules thread id. */
	private Number threadId;
	
	/** The rules thread title. */
	private String thread;

	/**
	 * Get the rules thread id.
	 * 
	 * @return the rules thread id
	 */
	public Number getThreadId() {
		return this.threadId;
	}

	/**
	 * Get the rules thread title
	 * 
	 * @return the rules thread title
	 */
	public String getThread() {
		return this.thread;
	}

	@Override
	public String toString() {
		return "SpecificRules [getThreadId=" + getThreadId() + ", getThread=" + getThread() + "]";
	}

}
