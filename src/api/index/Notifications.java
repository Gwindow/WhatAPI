package api.index;

/**
 * The Class Notifications.
 * 
 * @author Gwindow
 * @since May 5, 2012 10:37:31 AM
 */
public class Notifications {

	/** The messages. */
	private Number messages;

	/** The notifications. */
	private Number notifications;

	/**
	 * Gets the messages.
	 * 
	 * @return the messages
	 */
	public Number getMessages() {
		return messages;
	}

	/**
	 * Gets the notifications.
	 * 
	 * @return the notifications
	 */
	public Number getNotifications() {
		return notifications;
	}

	/**
	 * Checks for new messages.
	 * 
	 * @return true, if successful
	 */
	public boolean hasNewMessages() {
		return messages.intValue() > 0;
	}

	/**
	 * Checks for new notifications.
	 * 
	 * @return true, if successful
	 */
	public boolean hasNewNotifications() {
		return notifications.intValue() > 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Notifications [getMessages()=" + getMessages() + ", getNotifications()=" + getNotifications()
				+ ", hasNewMessages()=" + hasNewMessages() + ", hasNewNotifications()=" + hasNewNotifications() + "]";
	}

}
