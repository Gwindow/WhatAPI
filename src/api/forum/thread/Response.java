package api.forum.thread;

import java.util.List;

public class Response {
	private Number currentPage;
	private String forumId;
	private String forumName;
	private String locked;
	private Number pages;
	private Poll poll;
	private List<Posts> posts;
	private boolean subscribed;
	private String threadId;
	private String threadTitle;
	private String sticky;

	public boolean isSticky() {
		try {
			if (sticky.equalsIgnoreCase("0"))
				return false;
			else
				return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isLocked() {
		try {
			if (locked.equalsIgnoreCase("0"))
				return false;
			else
				return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Number getCurrentPage() {
		return this.currentPage;
	}

	public String getForumId() {
		return this.forumId;
	}

	public String getForumName() {
		return this.forumName;
	}

	public String getLocked() {
		return this.locked;
	}

	public Number getPages() {
		return this.pages;
	}

	public Poll getPoll() {
		return this.poll;
	}

	public List<Posts> getPosts() {
		return this.posts;
	}

	public boolean isSubscribed() {
		return this.subscribed;
	}

	public String getThreadId() {
		return this.threadId;
	}

	public String getThreadTitle() {
		return this.threadTitle;
	}

	@Override
	public String toString() {
		return "Response [isSticky=" + isSticky() + ", isLocked=" + isLocked() + ", getCurrentPage=" + getCurrentPage()
				+ ", getForumId=" + getForumId() + ", getForumName=" + getForumName() + ", getLocked=" + getLocked()
				+ ", getPages=" + getPages() + ", getPoll=" + getPoll() + ", getPosts=" + getPosts() + ", isSubscribed="
				+ isSubscribed() + ", getThreadId=" + getThreadId() + ", getThreadTitle=" + getThreadTitle() + "]";
	}
}
