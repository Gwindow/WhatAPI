package api.forum.thread;

import java.util.List;

/**
 * The Class Response.
 * Stores the information from the API response for
 * a forum thread
 * 
 * @author Gwindow
 */
public class Response {
	/** The current page. */
	private Number currentPage;

	/** The forum id. */
	private Number forumId;

	/** The forum name. */
	private String forumName;

	/** The number of pages in the thread */
	private Number pages;

	/**
	 * The poll for the thread (null if no poll)
	 */
	private Poll poll;

	/** The posts in the thread */
	private List<Post> posts;

	/** The thread id. */
	private Number threadId;

	/** The thread title. */
	private String threadTitle;

    /** If the thread is locked */
    private boolean locked;

    /** If the thread is subscribed too */
    private boolean subscribed;

	/** If the thread is a sticky */
	private boolean sticky;

	/**
	 * Get the current page number
	 * 
	 * @return the current page number
	 */
	public Number getCurrentPage() {
		return this.currentPage;
	}

	/**
	 * Get the forum id.
	 * 
	 * @return the forum id
	 */
	public Number getForumId() {
		return this.forumId;
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
	 * Get the total number of pages in the thread
	 * 
	 * @return the number of pages in the thread
	 */
	public Number getPages() {
		return this.pages;
	}

	/**
	 * Get the thread poll
	 * 
	 * @return the poll
	 */
	public Poll getPoll() {
		return this.poll;
	}

	/**
	 * Check if the thread has a poll
	 * @return true if the thread has a poll
	 */
	public boolean hasPoll(){
		return poll != null;
	}

	/**
	 * Get the posts in the thread
	 * 
	 * @return the posts
	 */
	public List<Post> getPosts() {
		return this.posts;
	}

	/**
	 * Get the thread id.
	 * 
	 * @return the thread id
	 */
	public Number getThreadId() {
		return this.threadId;
	}

	/**
	 * Get the thread title.
	 * 
	 * @return the thread title
	 */
	public String getThreadTitle() {
		return this.threadTitle;
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
     * Check if we're subscribed to the thread
     *
     * @return True if subscribed
     */
    public boolean isSubscribed() {
        return this.subscribed;
    }

	/**
	 * Check if the thread is a sticky
	 * 
	 * @return True if it's a sticky
	 */
	public boolean isSticky() {
		return this.sticky;
	}

	@Override
	public String toString() {
		return "Response [isSticky=" + isSticky() + ", isLocked=" + isLocked() + ", getCurrentPage=" + getCurrentPage()
				+ ", getForumId=" + getForumId() + ", getForumName=" + getForumName() + ", getLocked=" + isLocked()
				+ ", getPages=" + getPages() + ", getPoll=" + getPoll() + ", getPosts=" + getPosts() + ", isSubscribed="
				+ isSubscribed() + ", getThreadId=" + getThreadId() + ", getThreadTitle=" + getThreadTitle() + "]";
	}
}
