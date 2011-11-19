package api.inbox.inbox;

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

	public int getConvId() {
		return Integer.valueOf(this.convId);
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

	public int getForwardedId() {
		return Integer.valueOf(this.forwardedId);
	}

	public String getForwardedName() {
		return this.forwardedName;
	}

	public int getSenderId() {
		return Integer.valueOf(this.senderId);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Messages [getConvId()=" + getConvId() + ", getDate()=" + getDate() + ", isDonor()=" + isDonor()
				+ ", getEnabled()=" + getEnabled() + ", getForwardedId()=" + getForwardedId() + ", getForwardedName()="
				+ getForwardedName() + ", getSenderId()=" + getSenderId() + ", isSticky()=" + isSticky() + ", getSubject()="
				+ getSubject() + ", isUnread()=" + isUnread() + ", getUsername()=" + getUsername() + ", isWarned()=" + isWarned()
				+ "]";
	}
}