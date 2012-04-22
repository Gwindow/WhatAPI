



package api.announcements;

/**
 * The Class AnnouncementsList.
 * 
 * @author Gwindow
 */
public class AnnouncementsList {
	
	/** The body. */
	private String body;
	
	/** The news id. */
	private Number newsId;
	
	/** The news time. */
	private String newsTime;
	
	/** The title. */
	private String title;

	/**
	 * Body of the announcement.
	 * 
	 * @return the body
	 */
	public String getBody() {
		return this.body;
	}

	/**
	 * ID of the announcement.
	 * 
	 * @return the id
	 */
	public Number getNewsId() {
		return this.newsId;
	}

	/**
	 * The at which the announcement was created.
	 * 
	 * @return the time
	 */
	public String getNewsTime() {
		return this.newsTime;
	}

	/**
	 * The title of the announcement.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AnnouncementsList [getBody=" + getBody() + ", getNewsId=" + getNewsId() + ", getNewsTime=" + getNewsTime()
				+ ", getTitle=" + getTitle() + "]";
	}
}
