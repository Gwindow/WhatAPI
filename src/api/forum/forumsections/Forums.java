/**
 * @author Gwindow
 */
package api.forum.forumsections;

import java.util.List;

/**
 * The Class Forums.
 */
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
	 * Gets the forum description.
	 * 
	 * @return the forumDescription
	 */
	public String getForumDescription() {
		return forumDescription;
	}

	/**
	 * Gets the forum id.
	 * 
	 * @return the forumId
	 */
	public Number getForumId() {
		return forumId;
	}

	/**
	 * Gets the forum name.
	 * 
	 * @return the forumName
	 */
	public String getForumName() {
		return forumName;
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
	 * Gets the last post author name.
	 * 
	 * @return the lastPostAuthorName
	 */
	public String getLastPostAuthorName() {
		return lastPostAuthorName;
	}

	/**
	 * Gets the last post id.
	 * 
	 * @return the lastPostId
	 */
	public Number getLastPostId() {
		return lastPostId;
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
	 * Gets the last topic.
	 * 
	 * @return the lastTopic
	 */
	public String getLastTopic() {
		return lastTopic;
	}

	/**
	 * Gets the last topic id.
	 * 
	 * @return the lastTopicId
	 */
	public Number getLastTopicId() {
		return lastTopicId;
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
	 * Gets the num posts.
	 * 
	 * @return the numPosts
	 */
	public Number getNumPosts() {
		return numPosts;
	}

	/**
	 * Gets the num topics.
	 * 
	 * @return the numTopics
	 */
	public Number getNumTopics() {
		return numTopics;
	}

	/**
	 * Checks if is read.
	 * 
	 * @return the read
	 */
	public boolean isRead() {
		return read;
	}

	/**
	 * Gets the specific rules.
	 * 
	 * @return the specificRules
	 */
	public List<String> getSpecificRules() {
		return specificRules;
	}

	/**
	 * Checks if is sticky.
	 * 
	 * @return the sticky
	 */
	public boolean isSticky() {
		return sticky;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
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
