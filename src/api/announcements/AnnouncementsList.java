package api.announcements;

public class AnnouncementsList {
	private String body;
	private String newsId;
	private String newsTime;
	private String title;

	/**
	 * Body of the announcement
	 * 
	 * @return the body
	 */
	public String getBody() {
		return this.body;
	}

	/**
	 * ID of the announcement
	 * 
	 * @return the id
	 */
	public String getNewsId() {
		return this.newsId;
	}

	/**
	 * The at which the announcement was created
	 * 
	 * @return the time
	 */
	public String getNewsTime() {
		return this.newsTime;
	}

	/**
	 * The title of the announcement
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	@Override
	public String toString() {
		return "AnnouncementsList [getBody=" + getBody() + ", getNewsId=" + getNewsId() + ", getNewsTime=" + getNewsTime()
				+ ", getTitle=" + getTitle() + "]";
	}
}
