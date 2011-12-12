


package api.inbox.conversation;

import org.jsoup.Jsoup;

/**
 * The Class Messages.
 * 
 * @author Gwindow
 */
public class Messages {
	
	/** The body. */
	private String body;
	
	/** The message id. */
	private Number messageId;
	
	/** The sender id. */
	private Number senderId;
	
	/** The sender name. */
	private String senderName;
	
	/** The sent date. */
	private String sentDate;

	/**
	 * Gets the body.
	 * 
	 * @return the body
	 */
	public String getBody() {
		return this.body;
	}

	/**
	 * Gets the message id.
	 * 
	 * @return the message id
	 */
	public Number getMessageId() {
		return messageId;
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
	 * Gets the sender name.
	 * 
	 * @return the sender name
	 */
	public String getSenderName() {
		return this.senderName;
	}

	/**
	 * Gets the sent date.
	 * 
	 * @return the sent date
	 */
	public String getSentDate() {
		return this.sentDate;
	}

	/**
	 * Gets the quotable body.
	 * 
	 * @return the quotable body
	 */
	public String getQuotableBody() {
		return "[quote=" + senderName + "]" + Jsoup.parse(body).text() + "[/quote]";

	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Messages [getBody()=" + getBody() + ", getMessageId()=" + getMessageId() + ", getSenderId()=" + getSenderId()
				+ ", getSenderName()=" + getSenderName() + ", getSentDate()=" + getSentDate() + "]";
	}

}
