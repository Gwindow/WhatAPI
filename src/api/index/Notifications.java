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
	public Number getNotifications() {
		return notifications;
	}

	/**
	 * Check if there are any new messages
	 * 
	 * @return True if there are new messages
	 */
	public boolean hasNewMessages() {
		return (messages.intValue() > 0);
	}

	/**
	 * Check if there are any new torrent notifications
	 * 
	 * @return True if there are any new torrent notifications
	 */
	public boolean hasNewNotifications() {
		return (notifications.intValue() > 0);
    }

	@Override
	public String toString() {
		return "Notifications [getMessages()=" + getMessages() + ", getNotifications()=" + getNotifications()
				+ ", hasNewMessages()=" + hasNewMessages() + ", hasNewNotifications()=" + hasNewNotifications() + "]";
	}

}
