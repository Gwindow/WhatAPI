package api.forum.section;

import api.soup.MySoup;

/**
 * The Class Threads.
 * 
 * @author Gwindow
 */
public class Threads {

	/** The author id. */
	private Number authorId;

	/** The author name. */
	private String authorName;

	/** The last author id. */
	private Number lastAuthorId;

	/** The last author name. */
	private String lastAuthorName;

	/** The last id. */
	private Number lastID;

	/** The last read page. */
	private Number lastReadPage;

	/** The last read post id. */
	private Number lastReadPostId;

	/** The last time. */
	private String lastTime;

	/** The locked. */
	private boolean locked;

	/** The post count. */
	private Number postCount;

	/** The sticky. */
	private boolean sticky;

	/** The title. */
	private String title;

	/** The topic id. */
	private Number topicId;

	/**
	 * Gets the author id.
	 * 
	 * @return the authorId
	 */
	public Number getAuthorId() {
		return authorId;
	}

	/**
	 * Gets the author name.
	 * 
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * Gets the last author id.
	 * 
	 * @return the lastAuthorId
	 */
	public Number getLastAuthorId() {
		return lastAuthorId;
	}

	/**
	 * Gets the last author name.
	 * 
	 * @return the lastAuthorName
	 */
	public String getLastAuthorName() {
		return lastAuthorName;
	}

	/**
	 * Gets the last id.
	 * 
	 * @return the lastID
	 */
	public Number getLastID() {
		return lastID;
	}

	/**
	 * Gets the last read page.
	 * 
	 * @return the lastReadPage
	 */
	public Number getLastReadPage() {
		return lastReadPage;
	}

	/**
	 * Gets the last read post id.
	 * 
	 * @return the lastReadPostId
	 */
	public Number getLastReadPostId() {
		return lastReadPostId;
	}

	/**
	 * Gets the last time.
	 * 
	 * @return the lastTime
	 */
	public String getLastTime() {
		return lastTime;
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
	 * Gets the post count.
	 * 
	 * @return the postCount
	 */
	public Number getPostCount() {
		return postCount;
	}

	/**
	 * Checks if is sticky.
	 * 
	 * @return the sticky
	 */
	public boolean isSticky() {
		return sticky;
	}

	/**
	 * Gets the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Gets the topic id.
	 * 
	 * @return the topicId
	 */
	public Number getTopicId() {
		return topicId;
	}

	/**
	 * Gets the url.
	 * 
	 * @return the url
	 */
	public String getUrl() {
		String url = "forums.php?action=viewthread&threadid=" + topicId;
		return url;
	}

	/**
	 * Gets the last read url.
	 * 
	 * @return the last read url
	 */
	public String getLastReadUrl() {
		String url = "forums.php?action=viewthread&threadid=" + topicId + "&page=" + lastReadPage;
		return url;
	}

	/**
	 * Checks if is read.
	 * 
	 * @return true, if is read
	 */
	public boolean isRead() {
		if (getLastReadPage().intValue() > 0)
			return true;
		return false;
	}

	/**
	 * Subscribe to thread.
	 */
	public void subscribe() {
		try {
			MySoup.pressLink("userhistory.php?action=thread_subscribe&topicid=" + getTopicId().intValue() + "&auth="
					+ MySoup.getAuthKey());
			System.out.println("Subscribed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * unsubscribe to thread.
	 */
	public void unsubscribe() {
		try {
			MySoup.pressLink("userhistory.php?action=thread_subscribe&topicid=" + getTopicId().intValue() + "&auth="
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
		return "Threads [getAuthorId=" + getAuthorId() + ", getAuthorName=" + getAuthorName() + ", getLastAuthorId="
				+ getLastAuthorId() + ", getLastAuthorName=" + getLastAuthorName() + ", getLastID=" + getLastID()
				+ ", getLastReadPage=" + getLastReadPage() + ", getLastReadPostId=" + getLastReadPostId() + ", getLastTime="
				+ getLastTime() + ", isLocked=" + isLocked() + ", getPostCount=" + getPostCount() + ", isSticky=" + isSticky()
				+ ", getTitle=" + getTitle() + ", getTopicId=" + getTopicId() + ", getUrl=" + getUrl() + ", getLastReadUrl="
				+ getLastReadUrl() + ", isRead=" + isRead() + "]";
	}
}
