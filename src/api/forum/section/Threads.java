package api.forum.section;

import api.son.Converter;

public class Threads {
	private String authorId;
	private String authorName;
	private String lastAuthorId;
	private String lastAuthorName;
	private String lastID;
	private String lastReadPage;
	private String lastReadPostId;
	private String lastTime;
	private String locked;
	private String postCount;
	private String sticky;
	private String title;
	private String topicId;

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

	public int getAuthorId() {
		return Integer.parseInt(this.authorId);
	}

	public String getAuthorName() {
		return this.authorName;
	}

	public int getLastAuthorId() {
		return Integer.parseInt(this.lastAuthorId);
	}

	public String getLastAuthorName() {
		return this.lastAuthorName;
	}

	public int getLastID() {
		return Integer.parseInt(this.lastID);
	}

	public int getLastReadPage() {
		System.out.println(Converter.parseInt(this.lastReadPage));
		return Converter.parseInt((this.lastReadPage));
	}

	public int getLastReadPostId() {
		return Integer.parseInt(this.lastReadPostId);
	}

	public String getLastTime() {
		return this.lastTime;
	}

	public int getPostCount() {
		return Integer.parseInt(this.postCount);
	}

	public String getTitle() {
		return this.title;
	}

	public int getTopicId() {
		return Integer.parseInt(this.topicId);
	}

	public String getUrl() {
		String url = "forums.php?action=viewthread&threadid=" + topicId;
		return url;
	}

	public String getLastReadUrl() {
		String url = "forums.php?action=viewthread&threadid=" + topicId + "&page=" + lastReadPage;
		return url;
	}

	@Override
	public String toString() {
		return "Threads [isSticky=" + isSticky() + ", isLocked=" + isLocked() + ", getAuthorId=" + getAuthorId()
				+ ", getAuthorName=" + getAuthorName() + ", getLastAuthorId=" + getLastAuthorId() + ", getLastAuthorName="
				+ getLastAuthorName() + ", getLastID=" + getLastID() + ", getLastReadPage=" + getLastReadPage()
				+ ", getLastReadPostId=" + getLastReadPostId() + ", getLastTime=" + getLastTime() + ", getPostCount="
				+ getPostCount() + ", getTitle=" + getTitle() + ", getTopicId=" + getTopicId() + "]";
	}
}
