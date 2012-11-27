package api.subscriptions;

import api.soup.MySoup;

import com.google.gson.annotations.SerializedName;

/**
 * The Class Thread.
 * Describes a subscribed forum thread
 * 
 * @author Gwindow
 */
public class Thread {
	/** The forum id. */
	private Number forumId;

	/** The forum name. */
	private String forumName;

	/** The last viewed post id. */
	private Number lastPostId;

	/** If the thread is locked */
	private boolean locked;

	/** If there's been a new post. */
	@SerializedName("new")
	private boolean isNew;

	/** The new post id. */
	private Number postId;

	/** The thread id. */
	private Number threadId;

	/** The thread title. */
	private String threadTitle;

	/**
	 * Get the forum id.
	 * 
	 * @return the forum id
	 */
	public Number getForumId() {
		return forumId;
	}

	/**
	 * Get the forum name.
	 * 
	 * @return the forum name
	 */
	public String getForumName() {
		return forumName;
	}

	/**
	 * Get the last viewed post id.
	 * 
	 * @return the new post id
	 */
	public Number getLastPostId() {
		return lastPostId;
	}

	/**
	 * Check if the thread is locked
	 * 
	 * @return True if locked
	 */
	public boolean isLocked() {
		return locked;
	}

	/**
	 * Check if the thread has new posts
	 * 
	 * @return True if it has new posts
	 */
	public boolean isNew() {
		return isNew;
	}

	/**
	 * Get the new post id.
	 * 
	 * @return the post id
	 */
	public Number getPostId() {
		return postId;
	}

	/**
	 * Get the thread id.
	 * 
	 * @return the thread id
	 */
	public Number getThreadId() {
		return threadId;
	}

	/**
	 * Get the thread title.
	 * 
	 * @return the thread title
	 */
	public String getThreadTitle() {
		return threadTitle;
	}

	/**
	 * Get the thread url
	 * 
	 * @return the thread url
	 */
	public String getUrl() {
		return "forums.php?action=viewthread&threadid=" + threadId;
    }

	/**
	 * Gets the last read post url
	 * 
	 * @return the last read post url
	 */
	public String getLastReadUrl() {
		return "forums.php?action=viewthread&threadid=" + threadId + "&postid=" + lastPostId;
	}

	/**
	 * Subscribe to the thread
	 */
	public void subscribe() {
		try {
			MySoup.pressLink("userhistory.php?action=thread_subscribe&topicid=" + getThreadId().intValue() + "&auth="
					+ MySoup.getAuthKey());
			System.out.println("Subscribed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Unsubscribe from the thread
	 */
	public void unsubscribe() {
		try {
			MySoup.pressLink("userhistory.php?action=thread_subscribe&topicid=" + getThreadId().intValue() + "&auth="
					+ MySoup.getAuthKey());
			System.out.println("Unsubscribed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Thread [getForumId=" + getForumId() + ", getForumName=" + getForumName() + ", getLastPostId=" + getLastPostId()
				+ ", isLocked=" + isLocked() + ", isNew=" + isNew() + ", getPostId=" + getPostId() + ", getThreadId="
				+ getThreadId() + ", getThreadTitle=" + getThreadTitle() + ", getUrl=" + getUrl() + ", getLastReadUrl="
				+ getLastReadUrl() + "]";
	}
}
