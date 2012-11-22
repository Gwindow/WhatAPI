
package api.announcements;

/**
 * The Class Announcement
 * Contains the data relevant to an announcement
 * its title, body, id and date published
 *
 * @author Gwindow
 */
public class Announcement {
	/** The body text. */
	private String body;
	
	/** The news id. */
	private Number newsId;
	
	/** The news time, the post date. */
	private String newsTime;
	
	/** The title. */
	private String title;

	/**
	 * Get the body text of the Announcement
	 * 
	 * @return the body
	 */
	public String getBody() {
		return this.body;
	}

	/**
	 * Get the ID of the announcement.
	 * 
	 * @return the id
	 */
	public Number getNewsId() {
		return this.newsId;
	}

	/**
	 * Get the date when the announcement was created.
	 * 
	 * @return the time
	 */
	public String getNewsTime() {
		return this.newsTime;
	}

	/**
	 * Get the title of the announcement.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	@Override
	public String toString() {
		return "Announcement [getBody=" + getBody() + ", getNewsId=" + getNewsId() + ", getNewsTime=" + getNewsTime()
				+ ", getTitle=" + getTitle() + "]";
	}
}
