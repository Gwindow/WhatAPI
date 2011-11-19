/**
 * @author Gwindow
 */
package api.subscriptions;

import com.google.gson.annotations.SerializedName;

/**
 * The Class Threads.
 */
public class Threads {
	private Number forumId;
	private String forumName;
	private Number lastPostId;
	private boolean locked;
	// so java doesn't get confused
	@SerializedName("new")
	private boolean isNew;
	private Number postId;
	private Number threadId;
	private String threadTitle;

	/**
	 * Gets the forum id.
	 * 
	 * @return the forum id
	 */
	public Number getForumId() {
		return forumId;
	}

	/**
	 * Gets the forum name.
	 * 
	 * @return the forum name
	 */
	public String getForumName() {
		return forumName;
	}

	/**
	 * Gets the last post id.
	 * 
	 * @return the last post id
	 */
	public Number getLastPostId() {
		return lastPostId;
	}

	/**
	 * Checks if is locked.
	 * 
	 * @return true, if is locked
	 */
	public boolean isLocked() {
		return locked;
	}

	/**
	 * Checks if is new.
	 * 
	 * @return true, if is new
	 */
	public boolean isNew() {
		return isNew;
	}

	/**
	 * Gets the post id.
	 * 
	 * @return the post id
	 */
	public Number getPostId() {
		return postId;
	}

	/**
	 * Gets the thread id.
	 * 
	 * @return the thread id
	 */
	public Number getThreadId() {
		return threadId;
	}

	/**
	 * Gets the thread title.
	 * 
	 * @return the thread title
	 */
	public String getThreadTitle() {
		return threadTitle;
	}

	/**
	 * Gets the url.
	 * 
	 * @return the url
	 */
	public String getUrl() {
		String url = "forums.php?action=viewthread&threadid=" + threadId;
		return url;
	}

	/**
	 * Gets the last read url.
	 * 
	 * @return the last read url
	 */
	public String getLastReadUrl() {
		String url = "forums.php?action=viewthread&threadid=" + threadId + "&postid=" + lastPostId;
		return url;
	}

	@Override
	public String toString() {
		return "Threads [getForumId=" + getForumId() + ", getForumName=" + getForumName() + ", getLastPostId=" + getLastPostId()
				+ ", isLocked=" + isLocked() + ", isNew=" + isNew() + ", getPostId=" + getPostId() + ", getThreadId="
				+ getThreadId() + ", getThreadTitle=" + getThreadTitle() + ", getUrl=" + getUrl() + ", getLastReadUrl="
				+ getLastReadUrl() + "]";
	}
}
