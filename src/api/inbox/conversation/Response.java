package api.inbox.conversation;

import java.util.List;

public class Response {
	private String convId;
	private List<Messages> messages;
	private String sticky;
	private String subject;

	public String getConvId() {
		return this.convId;
	}

	public List<Messages> getMessages() {
		return this.messages;
	}

	public boolean isSticky() {
		if (sticky.equalsIgnoreCase("1")) {
			return true;
		}
		return false;
	}

	public String getSubject() {
		return this.subject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Response [getConvId()=" + getConvId() + ", getMessages()=" + getMessages() + ", isSticky()=" + isSticky()
				+ ", getSubject()=" + getSubject() + "]";
	}
}
