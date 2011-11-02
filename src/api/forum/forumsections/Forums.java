package api.forum.forumsections;

import java.util.List;

public class Forums {
	private String forumDescription;
	private String forumId;
	private String forumName;
	private String lastAuthorId;
	private String lastPostAuthorName;
	private String lastPostId;
	private String lastTime;
	private String lastTopic;
	private String lastTopicId;
	private String locked;
	private String numPosts;
	private String numTopics;
	private String read;
	private List<String> specificRules;
	private String sticky;

	public String getForumDescription() {
		return this.forumDescription;
	}

	public String getForumId() {
		return this.forumId;
	}

	public String getForumName() {
		return this.forumName;
	}

	public String getLastAuthorId() {
		return this.lastAuthorId;
	}

	public String getLastPostAuthorName() {
		return this.lastPostAuthorName;
	}

	public String getLastPostId() {
		return this.lastPostId;
	}

	public String getLastTime() {
		return this.lastTime;
	}

	public String getLastTopic() {
		return this.lastTopic;
	}

	public String getLastTopicId() {
		return this.lastTopicId;
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

	public String getNumPosts() {
		return this.numPosts;
	}

	public String getNumTopics() {
		return this.numTopics;
	}

	public boolean isRead() {
		try {
			if (read.equalsIgnoreCase("read"))
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public List<String> getSpecificRules() {
		return this.specificRules;
	}

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

	@Override
	public String toString() {
		return "Forums [getForumDescription=" + getForumDescription() + ", getForumId=" + getForumId() + ", getForumName="
				+ getForumName() + ", getLastAuthorId=" + getLastAuthorId() + ", getLastPostAuthorName="
				+ getLastPostAuthorName() + ", getLastPostId=" + getLastPostId() + ", getLastTime=" + getLastTime()
				+ ", getLastTopic=" + getLastTopic() + ", getLastTopicId=" + getLastTopicId() + ", isLocked=" + isLocked()
				+ ", getNumPosts=" + getNumPosts() + ", getNumTopics=" + getNumTopics() + ", isRead=" + isRead()
				+ ", getSpecificRules=" + getSpecificRules() + ", isSticky=" + isSticky() + "]";
	}
}
