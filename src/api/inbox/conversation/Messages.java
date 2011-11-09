package api.inbox.conversation;

import org.jsoup.Jsoup;

public class Messages {
	private String body;
	private String messageId;
	private String senderId;
	private String senderName;
	private String sentDate;

	public String getBody() {
		return this.body;
	}

	public int getMessageId() {
		return Integer.valueOf(this.messageId);
	}

	public int getSenderId() {
		return Integer.valueOf(this.senderId);
	}

	public String getSenderName() {
		return this.senderName;
	}

	public String getSentDate() {
		return this.sentDate;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Messages [getBody()=" + getBody() + ", getMessageId()=" + getMessageId() + ", getSenderId()=" + getSenderId()
				+ ", getSenderName()=" + getSenderName() + ", getSentDate()=" + getSentDate() + "]";
	}

	public String getQuotableBody() {
		return "[quote=" + senderName + "]" + Jsoup.parse(body).text() + "[/quote]";

	}
}
