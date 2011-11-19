package api.forum.thread;

import java.util.List;

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
	 * @return the currentPage
	 */
	public Number getCurrentPage() {
		return currentPage;
	}

	/**
	 * @return the forumId
	 */
	public Number getForumId() {
		return forumId;
	}

	/**
	 * @return the forumName
	 */
	public String getForumName() {
		return forumName;
	}

	/**
	 * @return the locked
	 */
	public boolean isLocked() {
		return locked;
	}

	/**
	 * @return the pages
	 */
	public Number getPages() {
		return pages;
	}

	/**
	 * @return the poll
	 */
	public Poll getPoll() {
		return poll;
	}

	/**
	 * @return the posts
	 */
	public List<Posts> getPosts() {
		return posts;
	}

	/**
	 * @return the subscribed
	 */
	public boolean isSubscribed() {
		return subscribed;
	}

	/**
	 * @return the threadId
	 */
	public Number getThreadId() {
		return threadId;
	}

	/**
	 * @return the threadTitle
	 */
	public String getThreadTitle() {
		return threadTitle;
	}

	/**
	 * @return the sticky
	 */
	public boolean isSticky() {
		return sticky;
	}

	@Override
	public String toString() {
		return "Response [isSticky=" + isSticky() + ", isLocked=" + isLocked() + ", getCurrentPage=" + getCurrentPage()
				+ ", getForumId=" + getForumId() + ", getForumName=" + getForumName() + ", getLocked=" + getLocked()
				+ ", getPages=" + getPages() + ", getPoll=" + getPoll() + ", getPosts=" + getPosts() + ", isSubscribed="
				+ isSubscribed() + ", getThreadId=" + getThreadId() + ", getThreadTitle=" + getThreadTitle() + "]";
	}
}
