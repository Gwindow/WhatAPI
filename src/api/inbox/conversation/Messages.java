package api.inbox.conversation;


public class Messages {
	private String body;
	private String messageId;
	private String senderId;
	private String senderName;
	private String sentDate;

	public String getBody() {
		return this.body;
	}

	public String getMessageId() {
		return this.messageId;
	}

	public String getSenderId() {
		return this.senderId;
	}

	public String getSenderName() {
		return this.senderName;
	}

	public String getSentDate() {
		return this.sentDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Messages [getBody()=" + getBody() + ", getMessageId()=" + getMessageId() + ", getSenderId()=" + getSenderId()
				+ ", getSenderName()=" + getSenderName() + ", getSentDate()=" + getSentDate() + "]";
	}
}
