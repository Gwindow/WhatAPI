package api.subscriptions;

import com.google.gson.annotations.SerializedName;

public class Threads {
	private String forumId;
	private String forumName;
	private String lastPostId;
	private String locked;
	// so java doesn't get confused
	@SerializedName("new")
	private boolean isNew;
	private String postId;
	private String threadId;
	private String threadTitle;
	private String lastReadPage;

	public int getLastReadPage() {
		return 1;
	}

	public int getForumId() {
		return Integer.valueOf(this.forumId);
	}

	public String getForumName() {
		return this.forumName;
	}

	public int getLastPostId() {
		return Integer.valueOf(this.lastPostId);
	}

	public boolean isLocked() {
		if (locked.equalsIgnoreCase("0"))
			return false;
		else
			return true;
	}

	public boolean isNew() {
		return this.isNew;
	}

	public int getPostId() {
		return Integer.valueOf(this.postId);
	}

	public int getThreadId() {
		return Integer.valueOf(this.threadId);
	}

	public String getThreadTitle() {
		return this.threadTitle;
	}

	public String getUrl() {
		String url = "forums.php?action=viewthread&threadid=" + threadId;
		return url;
	}

	public String getLastReadUrl() {
		String url = "forums.php?action=viewthread&threadid=" + threadId + "&postid=" + lastPostId;
		return url;
	}

	@Override
	public String toString() {
		return "Threads [getLastReadPage=" + getLastReadPage() + ", getForumId=" + getForumId() + ", getForumName="
				+ getForumName() + ", getLastPostId=" + getLastPostId() + ", isLocked=" + isLocked() + ", isNew=" + isNew()
				+ ", getPostId=" + getPostId() + ", getThreadId=" + getThreadId() + ", getThreadTitle=" + getThreadTitle()
				+ ", getUrl=" + getUrl() + ", getLastReadUrl=" + getLastReadUrl() + "]";
	}
}
