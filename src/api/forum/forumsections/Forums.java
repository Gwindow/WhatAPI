package api.forum.forumsections;

import java.util.List;

public class Forums {
	private String forumDescription;
	private Number forumId;
	private String forumName;
	private Number lastAuthorId;
	private String lastPostAuthorName;
	private Number lastPostId;
	private String lastTime;
	private String lastTopic;
	private Number lastTopicId;
	private boolean locked;
	private Number numPosts;
	private Number numTopics;
	private boolean read;
	private List<String> specificRules;
	private boolean sticky;

	/**
	 * @return the forumDescription
	 */
	public String getForumDescription() {
		return forumDescription;
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
	 * @return the lastAuthorId
	 */
	public Number getLastAuthorId() {
		return lastAuthorId;
	}

	/**
	 * @return the lastPostAuthorName
	 */
	public String getLastPostAuthorName() {
		return lastPostAuthorName;
	}

	/**
	 * @return the lastPostId
	 */
	public Number getLastPostId() {
		return lastPostId;
	}

	/**
	 * @return the lastTime
	 */
	public String getLastTime() {
		return lastTime;
	}

	/**
	 * @return the lastTopic
	 */
	public String getLastTopic() {
		return lastTopic;
	}

	/**
	 * @return the lastTopicId
	 */
	public Number getLastTopicId() {
		return lastTopicId;
	}

	/**
	 * @return the locked
	 */
	public boolean isLocked() {
		return locked;
	}

	/**
	 * @return the numPosts
	 */
	public Number getNumPosts() {
		return numPosts;
	}

	/**
	 * @return the numTopics
	 */
	public Number getNumTopics() {
		return numTopics;
	}

	/**
	 * @return the read
	 */
	public boolean isRead() {
		return read;
	}

	/**
	 * @return the specificRules
	 */
	public List<String> getSpecificRules() {
		return specificRules;
	}

	/**
	 * @return the sticky
	 */
	public boolean isSticky() {
		return sticky;
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
