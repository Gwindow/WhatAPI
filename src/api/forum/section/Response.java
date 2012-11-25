package api.forum.section;

import java.util.List;

/**
 * The Class Response.
 * Contains data returned by the API about a Forum
 * 
 * @author Gwindow
 */
public class Response {
	/** The current page. */
	private Number currentPage;
	
	/** The forum name. */
	private String forumName;
	
	/** The number of pages in the forum. */
	private Number pages;
	
	/** The forum specific rules. */
	private List<SpecificRules> specificRules;
	
	/** The threads in the forum */
	private List<Threads> threads;

	/**
	 * Get the current page.
	 * 
	 * @return the current page
	 */
	public Number getCurrentPage() {
		return this.currentPage;
	}

	/**
	 * Get the forum name.
	 * 
	 * @return the forum name
	 */
	public String getForumName() {
		return this.forumName;
	}

	/**
	 * Get the number of pages in the forum
	 * 
	 * @return the number of pages
	 */
	public Number getPages() {
		return this.pages;
	}

	/**
	 * Get the forum specific rules.
	 * 
	 * @return the specific rules
	 */
	public List<SpecificRules> getSpecificRules() {
		return this.specificRules;
	}

	/**
	 * Get the threads in the forum
	 * 
	 * @return the threads
	 */
	public List<Threads> getThreads() {
		return this.threads;
	}

	@Override
	public String toString() {
		return "Response [getCurrentPage=" + getCurrentPage() + ", getForumName=" + getForumName() + ", getPages=" + getPages()
				+ ", getSpecificRules=" + getSpecificRules() + ", getThreads=" + getThreads() + "]";
	}
}
