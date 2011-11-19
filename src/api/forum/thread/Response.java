/**
 * @author Gwindow
 */
package api.forum.thread;

import java.util.List;

/**
 * The Class Response.
 */
public class Response {
	private Number currentPage;
	private Number forumId;
	private String forumName;
	private boolean locked;
	private Number pages;
	private Poll poll;
	private List<Posts> posts;
	private boolean subscribed;
	private Number threadId;
	private String threadTitle;
	private boolean sticky;

	/**
	 * Gets the current page.
	 * 
	 * @return the currentPage
	 */
	public Number getCurrentPage() {
		return currentPage;
	}

	/**
	 * Gets the forum id.
	 * 
	 * @return the forumId
	 */
	public Number getForumId() {
		return forumId;
	}

	/**
	 * Gets the forum name.
	 * 
	 * @return the forumName
	 */
	public String getForumName() {
		return forumName;
	}

	/**
	 * Checks if is locked.
	 * 
	 * @return the locked
	 */
	public boolean isLocked() {
		return locked;
	}

	/**
	 * Gets the pages.
	 * 
	 * @return the pages
	 */
	public Number getPages() {
		return pages;
	}

	/**
	 * Gets the poll.
	 * 
	 * @return the poll
	 */
	public Poll getPoll() {
		return poll;
	}

	/**
	 * Gets the posts.
	 * 
	 * @return the posts
	 */
	public List<Posts> getPosts() {
		return posts;
	}

	/**
	 * Checks if is subscribed.
	 * 
	 * @return the subscribed
	 */
	public boolean isSubscribed() {
		return subscribed;
	}

	/**
	 * Gets the thread id.
	 * 
	 * @return the threadId
	 */
	public Number getThreadId() {
		return threadId;
	}

	/**
	 * Gets the thread title.
	 * 
	 * @return the threadTitle
	 */
	public String getThreadTitle() {
		return threadTitle;
	}

	/**
	 * Checks if is sticky.
	 * 
	 * @return the sticky
	 */
	public boolean isSticky() {
		return sticky;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Response [isSticky=" + isSticky() + ", isLocked=" + isLocked() + ", getCurrentPage=" + getCurrentPage()
				+ ", getForumId=" + getForumId() + ", getForumName=" + getForumName() + ", getLocked=" + isLocked()
				+ ", getPages=" + getPages() + ", getPoll=" + getPoll() + ", getPosts=" + getPosts() + ", isSubscribed="
				+ isSubscribed() + ", getThreadId=" + getThreadId() + ", getThreadTitle=" + getThreadTitle() + "]";
	}
}
