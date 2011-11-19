/**
 * @author Gwindow
 */
package api.inbox.inbox;

/**
 * The Class Messages.
 */
public class Messages {
	private Number convId;
	private String date;
	private boolean donor;
	private boolean enabled;
	private Number forwardedId;
	private String forwardedName;
	private Number senderId;
	private boolean sticky;
	private String subject;
	private boolean unread;
	private String username;
	private boolean warned;

	/**
	 * Gets the conv id.
	 * 
	 * @return the conv id
	 */
	public Number getConvId() {
		return convId;
	}

	/**
	 * Gets the date.
	 * 
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Checks if is donor.
	 * 
	 * @return true, if is donor
	 */
	public boolean isDonor() {
		return donor;
	}

	/**
	 * Checks if is enabled.
	 * 
	 * @return true, if is enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Gets the forwarded id.
	 * 
	 * @return the forwarded id
	 */
	public Number getForwardedId() {
		return forwardedId;
	}

	/**
	 * Gets the forwarded name.
	 * 
	 * @return the forwarded name
	 */
	public String getForwardedName() {
		return forwardedName;
	}

	/**
	 * Gets the sender id.
	 * 
	 * @return the sender id
	 */
	public Number getSenderId() {
		return senderId;
	}

	/**
	 * Checks if is sticky.
	 * 
	 * @return true, if is sticky
	 */
	public boolean isSticky() {
		return sticky;
	}

	/**
	 * Gets the subject.
	 * 
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Checks if is unread.
	 * 
	 * @return true, if is unread
	 */
	public boolean isUnread() {
		return unread;
	}

	/**
	 * Gets the username.
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Checks if is warned.
	 * 
	 * @return true, if is warned
	 */
	public boolean isWarned() {
		return warned;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Messages [getConvId()=" + getConvId() + ", getDate()=" + getDate() + ", isDonor()=" + isDonor()
				+ ", getEnabled()=" + isEnabled() + ", getForwardedId()=" + getForwardedId() + ", getForwardedName()="
				+ getForwardedName() + ", getSenderId()=" + getSenderId() + ", isSticky()=" + isSticky() + ", getSubject()="
				+ getSubject() + ", isUnread()=" + isUnread() + ", getUsername()=" + getUsername() + ", isWarned()=" + isWarned()
				+ "]";
	}
}