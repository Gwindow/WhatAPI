package api.inbox.inbox;

public class Messages {
	private String convId;
	private String date;
	private String donor;
	private boolean enabled;
	private String forwardedId;
	private String forwardedName;
	private String senderId;
	private String sticky;
	private String subject;
	private String unread;
	private String username;
	private String warned;

	public String getConvId() {
		return this.convId;
	}

	public String getDate() {
		return this.date;
	}

	public boolean isDonor() {
		if (donor.equalsIgnoreCase("1"))
			return true;
		return false;
	}

	public boolean getEnabled() {
		return this.enabled;
	}

	public String getForwardedId() {
		return this.forwardedId;
	}

	public String getForwardedName() {
		return this.forwardedName;
	}

	public String getSenderId() {
		return this.senderId;
	}

	public boolean isSticky() {
		if (sticky.equalsIgnoreCase("1"))
			return true;
		return false;
	}

	public String getSubject() {
		return this.subject;
	}

	public boolean isUnread() {
		if (unread.equalsIgnoreCase("1"))
			return true;
		return false;
	}

	public String getUsername() {
		return this.username;
	}

	public boolean isWarned() {
		if (warned.equalsIgnoreCase("1"))
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Messages [getConvId()=" + getConvId() + ", getDate()=" + getDate() + ", isDonor()=" + isDonor()
				+ ", getEnabled()=" + getEnabled() + ", getForwardedId()=" + getForwardedId() + ", getForwardedName()="
				+ getForwardedName() + ", getSenderId()=" + getSenderId() + ", isSticky()=" + isSticky() + ", getSubject()="
				+ getSubject() + ", isUnread()=" + isUnread() + ", getUsername()=" + getUsername() + ", isWarned()=" + isWarned()
				+ "]";
	}
}