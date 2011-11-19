package api.forum.section;


public class Threads {
	private Number authorId;
	private String authorName;
	private Number lastAuthorId;
	private String lastAuthorName;
	private Number lastID;
	private Number lastReadPage;
	private Number lastReadPostId;
	private String lastTime;
	private boolean locked;
	private Number postCount;
	private boolean sticky;
	private String title;
	private Number topicId;

	/**
	 * @return the authorId
	 */
	public Number getAuthorId() {
		return authorId;
	}

	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * @return the lastAuthorId
	 */
	public Number getLastAuthorId() {
		return lastAuthorId;
	}

	/**
	 * @return the lastAuthorName
	 */
	public String getLastAuthorName() {
		return lastAuthorName;
	}

	/**
	 * @return the lastID
	 */
	public Number getLastID() {
		return lastID;
	}

	/**
	 * @return the lastReadPage
	 */
	public Number getLastReadPage() {
		return lastReadPage;
	}

	/**
	 * @return the lastReadPostId
	 */
	public Number getLastReadPostId() {
		return lastReadPostId;
	}

	/**
	 * @return the lastTime
	 */
	public String getLastTime() {
		return lastTime;
	}

	/**
	 * @return the locked
	 */
	public boolean isLocked() {
		return locked;
	}

	/**
	 * @return the postCount
	 */
	public Number getPostCount() {
		return postCount;
	}

	/**
	 * @return the sticky
	 */
	public boolean isSticky() {
		return sticky;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the topicId
	 */
	public Number getTopicId() {
		return topicId;
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
