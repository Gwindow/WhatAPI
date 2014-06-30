package api.subscriptions;

import com.google.gson.annotations.SerializedName;

/**
 * Describes a subscribed forum thread
 * 
 * @author Gwindow
 */
public class ForumThread {
	/**
	 * The forum id.
	 */
	private Number forumId;

	/**
	 *  The forum name
	 */
	private String forumName;

	/**
	 * The thread id.
	 */
	private Number threadId;

	/**
	 * The thread title.
	 */
	private String threadTitle;

	/**
	 * id of the last read post in the thread
	 */
	private Number postId;

	/**
	 * id of the most recent post made in the thread
	 */
	private Number lastPostId;

	/**
	 * If the thread is locked
	 */
	private boolean locked;

	/**
	 * If there's been a new post.
	 */
	@SerializedName("new")
	private boolean isNew;

	/**
	 * Get the forum id.
	 *
	 * @return the forum id
	 */
	public Number getForumId(){
		return forumId;
	}

	/**
	 * Get the forum name.
	 *
	 * @return the forum name
	 */
	public String getForumName(){
		return forumName;
	}

	/**
	 * Get the thread id.
	 *
	 * @return the thread id
	 */
	public Number getThreadId(){
		return threadId;
	}

	/**
	 * Get the thread title.
	 *
	 * @return the thread title
	 */
	public String getThreadTitle(){
		return threadTitle;
	}

	/**
	 * Get the last read post id
	 *
	 * @return last read post id
	 */
	public Number getPostId(){
		return postId;
	}

	/**
	 * Get the most recent post id for the thread
	 *
	 * @return most recent post in the thread
	 */
	public Number getLastPostId(){
		return lastPostId;
	}

	/**
	 * Check if the thread is locked
	 *
	 * @return True if locked
	 */
	public boolean isLocked(){
		return locked;
	}

	/**
	 * Check if the thread has new posts
	 *
	 * @return True if it has new posts
	 */
	public boolean hasUnreadPosts(){
		return isNew;
	}

	@Override
	public String toString() {
		return "ForumThread [getForumId=" + getForumId() + ", getForumName=" + getForumName() + ", getLastPostId=" + getLastPostId()
			+ ", isLocked=" + isLocked() + ", hasUnreadPosts=" + hasUnreadPosts() + ", getPostId=" + getPostId() + ", getThreadId="
			+ getThreadId() + ", getThreadTitle=" + getThreadTitle() + "]";
	}
}
