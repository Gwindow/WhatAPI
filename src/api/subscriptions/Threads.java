
package api.subscriptions;

import api.soup.MySoup;

import com.google.gson.annotations.SerializedName;

/**
 * The Class Threads.
 * 
 * @author Gwindow
 */
public class Threads {

	/** The forum id. */
	private Number forumId;

	/** The forum name. */
	private String forumName;

	/** The last post id. */
	private Number lastPostId;

	/** The locked. */
	private boolean locked;
	// so java doesn't get confused
	/** The is new. */
	@SerializedName("new")
	private boolean isNew;

	/** The post id. */
	private Number postId;

	/** The thread id. */
	private Number threadId;

	/** The thread title. */
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

	/**
	 * Subscribe to thread.
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
	 * unsubscribe to thread.
	 */
	public void unsubscribe() {
		try {
			MySoup.pressLink("userhistory.php?action=thread_subscribe&topicid=" + getThreadId().intValue() + "&auth="
					+ MySoup.getAuthKey());
			System.out.println("Unsubscribed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Threads [getForumId=" + getForumId() + ", getForumName=" + getForumName() + ", getLastPostId=" + getLastPostId()
				+ ", isLocked=" + isLocked() + ", isNew=" + isNew() + ", getPostId=" + getPostId() + ", getThreadId="
				+ getThreadId() + ", getThreadTitle=" + getThreadTitle() + ", getUrl=" + getUrl() + ", getLastReadUrl="
				+ getLastReadUrl() + "]";
	}
}
