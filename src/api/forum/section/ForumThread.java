package api.forum.section;

import api.soup.MySoup;

/**
 * The Class ForumThread.
 * Describes a single forum thread
 * 
 * @author Gwindow
 */
public class ForumThread {
	/** The author id. */
	private Number authorId;

	/** The author name. */
	private String authorName;

	/** The last post author id. */
	private Number lastAuthorId;

	/** The last post author name. */
	private String lastAuthorName;

	/** The last post id. */
	private Number lastID;

	/** The last read page. */
	private Number lastReadPage;

	/** The last read post id. */
	private Number lastReadPostId;

	/** The last post time. */
	private String lastTime;

	/** The thread post count */
	private Number postCount;

	/** The thread title. */
	private String title;

	/** The topic id. */
	private Number topicId;

    /** If the thread is locked */
    private boolean locked;

    /** If the thread is stickied */
    private boolean sticky;

    /** If the thread has been read */
	private boolean read;

	/**
	 * Get the author id.
	 * 
	 * @return the author id
	 */
	public Number getAuthorId() {
		return this.authorId;
	}

	/**
	 * Get the author name.
	 * 
	 * @return the author name
	 */
	public String getAuthorName() {
		return this.authorName;
	}

	/**
	 * Get the last post author id.
	 * 
	 * @return the last post author id
	 */
	public Number getLastAuthorId() {
		return this.lastAuthorId;
	}

	/**
	 * Get the last post author name.
	 * 
	 * @return the last post author name
	 */
	public String getLastAuthorName() {
		return this.lastAuthorName;
	}

	/**
	 * Get the last post id
	 * 
	 * @return the last post id
	 */
	public Number getLastID() {
		return this.lastID;
	}

	/**
	 * Get the last read page.
	 * 
	 * @return the last read page number
	 */
	public Number getLastReadPage() {
		return this.lastReadPage;
	}

	/**
	 * Get the last read post id.
	 * 
	 * @return the last read post id
	 */
	public Number getLastReadPostId() {
		return this.lastReadPostId;
	}

	/**
	 * Get the last post time
	 * 
	 * @return the post time
	 */
	public String getLastTime() {
		return this.lastTime;
	}

	/**
	 * Get the post count.
	 * 
	 * @return the post count
	 */
	public Number getPostCount() {
		return this.postCount;
	}

	/**
	 * Get the thread title
	 * 
	 * @return the thread title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Get the topic id.
	 * 
	 * @return the topicId
	 */
	public Number getTopicId() {
		return this.topicId;
	}

    /**
     * Check if the thread is locked
     *
     * @return True if the thread is locked
     */
    public boolean isLocked() {
        return this.locked;
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
     * Checks if is read.
     *
     * @return true, if is read
     */
    public boolean isRead() {
        return this.read;
    }

	/**
	 * Get the url to view the thread
	 * 
	 * @return the thread url
	 */
	public String getUrl() {
		return "forums.php?action=viewthread&threadid=" + topicId;
	}

	/**
	 * Gets the url to jump to the last read post
	 * 
	 * @return the last read url
	 */
	public String getLastReadUrl() {
		return "forums.php?action=viewthread&threadid=" + topicId + "&page=" + lastReadPage;
	}

	/**
	 * Subscribe to the thread.
	 */
	public void subscribe() {
		try {
			MySoup.pressLink("userhistory.php?action=thread_subscribe&topicid=" + getTopicId().intValue() + "&auth="
					+ MySoup.getAuthKey());
			System.out.println("Subscribed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Unsubscribe to the thread.
	 */
	public void unsubscribe() {
		try {
			MySoup.pressLink("userhistory.php?action=thread_subscribe&topicid=" + getTopicId().intValue() + "&auth="
					+ MySoup.getAuthKey());
			System.out.println("Unsubscribed");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public String toString() {
		return "ForumThread [getAuthorId=" + getAuthorId() + ", getAuthorName=" + getAuthorName() + ", getLastAuthorId="
				+ getLastAuthorId() + ", getLastAuthorName=" + getLastAuthorName() + ", getLastID=" + getLastID()
				+ ", getLastReadPage=" + getLastReadPage() + ", getLastReadPostId=" + getLastReadPostId() + ", getLastTime="
				+ getLastTime() + ", isLocked=" + isLocked() + ", getPostCount=" + getPostCount() + ", isSticky=" + isSticky()
				+ ", getTitle=" + getTitle() + ", getTopicId=" + getTopicId() + ", getUrl=" + getUrl() + ", getLastReadUrl="
				+ getLastReadUrl() + ", isRead=" + isRead() + "]";
	}
}