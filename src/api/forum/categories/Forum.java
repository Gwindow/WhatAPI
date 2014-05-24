package api.forum.categories;

import java.util.List;

/**
 * The Class Forum
 * Describes information about a single forum
 *
 * @author Gwindow
 */
public class Forum {
	/**
	 * The forum id.
	 */
	private Number forumId;

	/**
	 * The forum name.
	 */
	private String forumName;

	/**
	 * The forum description.
	 */
	private String forumDescription;

	/**
	 * The number of topics in the forum
	 */
	private Number numTopics;

	/**
	 * The number of posts in the forum
	 */
	private Number numPosts;

	/**
	 * The last post id.
	 */
	private Number lastPostId;

	/**
	 * The last post author id.
	 */
	private Number lastAuthorId;

	/**
	 * The last post author name.
	 */
	private String lastPostAuthorName;

	/**
	 * The last post topic id.
	 */
	private Number lastTopicId;

	/**
	 * The last post time.
	 */
	private String lastTime;

	/**
	 * The last post topic.
	 */
	private String lastTopic;

	/**
	 * The forum specific rules.
	 */
	private List<String> specificRules;

	/**
	 * If the last post has been read
	 */
	private boolean read;

	/**
	 * If the last post is in a locked thread
	 */
	private boolean locked;

	/**
	 * If the last post is in a sticky thread
	 */
	private boolean sticky;

	/**
	 * Get the forum description.
	 *
	 * @return the forumDescription
	 */
	public String getForumDescription(){
		return this.forumDescription;
	}

	/**
	 * Get the forum id.
	 *
	 * @return the forumId
	 */
	public Number getForumId(){
		return this.forumId;
	}

	/**
	 * Get the forum name.
	 *
	 * @return the forumName
	 */
	public String getForumName(){
		return this.forumName;
	}

	/**
	 * Get the last post author id.
	 *
	 * @return the lastAuthorId
	 */
	public Number getLastAuthorId(){
		return this.lastAuthorId;
	}

	/**
	 * Get the last post author name.
	 *
	 * @return the lastPostAuthorName
	 */
	public String getLastPostAuthorName(){
		return this.lastPostAuthorName;
	}

	/**
	 * Get the last post id.
	 *
	 * @return the lastPostId
	 */
	public Number getLastPostId(){
		return this.lastPostId;
	}

	/**
	 * Get the last post time.
	 *
	 * @return the lastTime
	 */
	public String getLastTime(){
		return this.lastTime;
	}

	/**
	 * Get the last post topic.
	 *
	 * @return the lastTopic
	 */
	public String getLastTopic(){
		return this.lastTopic;
	}

	/**
	 * Get the last post topic id.
	 *
	 * @return the lastTopicId
	 */
	public Number getLastTopicId(){
		return this.lastTopicId;
	}

	/**
	 * Get the total number of posts in the forum
	 *
	 * @return the number of posts
	 */
	public Number getNumPosts(){
		return this.numPosts;
	}

	/**
	 * Get the total number of topics in the forum
	 *
	 * @return the number of topics
	 */
	public Number getNumTopics(){
		return this.numTopics;
	}

	/**
	 * Get the forum specific rules.
	 *
	 * @return the specific rules
	 */
	public List<String> getSpecificRules(){
		return this.specificRules;
	}

	/**
	 * Check if the last post is in a locked thread
	 *
	 * @return True if the thread is locked
	 */
	public boolean isLocked(){
		return this.locked;
	}

	/**
	 * Check if the last post has been read
	 *
	 * @return True if it's been read
	 */
	public boolean isRead(){
		return this.read;
	}

	/**
	 * Check if the last posted in thread is a sticky
	 *
	 * @return True if it's a sticky
	 */
	public boolean isSticky(){
		return this.sticky;
	}

	@Override
	public String toString(){
		return "Forum [getForumDescription=" + getForumDescription() + ", getForumId=" + getForumId() + ", getForumName="
			+ getForumName() + ", getLastAuthorId=" + getLastAuthorId() + ", getLastPostAuthorName="
			+ getLastPostAuthorName() + ", getLastPostId=" + getLastPostId() + ", getLastTime=" + getLastTime()
			+ ", getLastTopic=" + getLastTopic() + ", getLastTopicId=" + getLastTopicId() + ", isLocked=" + isLocked()
			+ ", getNumPosts=" + getNumPosts() + ", getNumTopics=" + getNumTopics() + ", isRead=" + isRead()
			+ ", getSpecificRules=" + getSpecificRules() + ", isSticky=" + isSticky() + "]";
	}
}
