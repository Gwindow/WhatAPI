package api.index;

/**
 * The Class Notifications.
 * Describes the notifications the user has, new messages
 * and new torrent notifications
 * 
 * @author Gwindow
 * @since May 5, 2012 10:37:31 AM
 */
public class Notifications {
	/** Number of new messages. */
	private Number messages;

	/** Number of torrent notifications */
	private Number notifications;

	/**
	 * If a new announcement has been posted
	 */
	private Boolean newAnnouncement;

	/**
	 * If a new blog has been posted
	 */
	private Boolean newBlog;

	/**
	 * If we have new subscription notifications
	 */
	private Boolean newSubscriptions;

	/**
	 * Get the number of new messages
	 * 
	 * @return number of new messages
	 */
	public Number getMessages() {
		return messages;
	}

	/**
	 * Get the number of torrent notifications
	 * 
	 * @return number of torrent notifications
	 */
	public Number getTorrentNotifications() {
		return notifications;
	}

	/**
	 * Check if there are any new messages
	 * 
	 * @return True if there are new messages
	 */
	public boolean hasMessages() {
		return messages.intValue() > 0;
	}

	/**
	 * Check if there are any new torrent notifications
	 * 
	 * @return True if there are any new torrent notifications
	 */
	public boolean hasTorrentNotifications(){
		return notifications.intValue() > 0;
	}

	/**
	 * True if a new announcement has been posted on the site
	 */
	public Boolean hasNewAnnouncement(){
		return newAnnouncement;
	}

	/**
	 * True if the user has new subscription notifications
	 */
	public Boolean hasNewSubscriptions(){
		return newSubscriptions;
	}

	/**
	 * True if a new blog post has been posted on the site
	 */
	public Boolean hasNewBlog(){
		return newBlog;
	}

	@Override
	public String toString(){
		return "Notifications [getMessages()=" + getMessages() + ", getNotifications()=" + getTorrentNotifications()
			+ ", hasNewAnnouncement()=" + hasNewAnnouncement() + ", hasNewSubscriptions()=" + hasNewSubscriptions()
			+ ", hasNewBlog()=" + hasNewBlog() + "]";
	}
}
