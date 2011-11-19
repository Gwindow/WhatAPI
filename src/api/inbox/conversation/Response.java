/**
 * @author Gwindow
 */
package api.inbox.conversation;

import java.util.List;

/**
 * The Class Response.
 */
public class Response {
	private Number convId;
	private List<Messages> messages;
	private boolean sticky;
	private String subject;

	/**
	 * Gets the conv id.
	 * 
	 * @return the conv id
	 */
	public Number getConvId() {
		return this.convId;
	}

	/**
	 * Gets the messages.
	 * 
	 * @return the messages
	 */
	public List<Messages> getMessages() {
		return this.messages;
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
		return this.subject;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Response [getConvId()=" + getConvId() + ", getMessages()=" + getMessages() + ", isSticky()=" + isSticky()
				+ ", getSubject()=" + getSubject() + "]";
	}
}
