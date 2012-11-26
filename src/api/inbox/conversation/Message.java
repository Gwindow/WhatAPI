package api.inbox.conversation;


/**
 * The Class Message.
 * 
 * @author Gwindow
 */
public class Message {
	/** The body text of the message. */
	private String body;

    /** The bulletin board formatted body */
    private String bbBody;

	/** The message id. */
	private Number messageId;

	/** The sender's user id */
	private Number senderId;

	/** The sender's user name */
	private String senderName;

	/** The date the message was sent */
	private String sentDate;

	/**
	 * Get the body text
	 * 
	 * @return the body text
	 */
	public String getBody() {
		return body;
	}

    /**
     * Get the bulletin board formatted body text
     *
     * @return the bulletin board formatted body
     */
    public String getBBBody() {
        return bbBody.replace("\r", "");
    }

	/**
	 * Get the message id
	 * 
	 * @return the message id
	 */
	public Number getMessageId() {
		return messageId;
	}

	/**
	 * Get the sender's user id
	 * 
	 * @return the sender's user id
	 */
	public Number getSenderId() {
		return senderId;
	}

	/**
	 * Get the sender's user name
	 * 
	 * @return the sender's user name
	 */
	public String getSenderName() {
		if (senderName == null || senderName.length() == 0)
			senderName = "System";
		return senderName;
	}

    /**
     * Check if the message was sent by the system
     *
     * @return True if the message was sent by the system
     */
	public boolean isSystem() {
		return getSenderName().equals("System");
	}

	/**
	 * Get the date the message was sent
	 * 
	 * @return the sent date
	 */
	public String getSentDate() {
		return sentDate;
	}

	/**
	 * Get the bulletin board quote formatted body
	 * 
	 * @return the quoted message body
	 */
	public String getQuotableBody() {
		return "[quote=" + senderName + "]" + getBBBody() + "[/quote]";

	}

	@Override
	public String toString() {
		return "Message [getBBBody()=" + getBBBody() + ", getBody()=" + getBody() + ", getMessageId()=" + getMessageId()
				+ ", getSenderId()=" + getSenderId() + ", getSenderName()=" + getSenderName() + ", isSystem()=" + isSystem()
				+ ", getSentDate()=" + getSentDate() + ", getQuotableBody()=" + getQuotableBody() + "]";
	}

}
