package api.inbox.conversation;

import api.comments.SimpleComment;
import api.soup.MySoup;

import java.util.Date;

/**
 * The Class Message.
 * 
 * @author Gwindow
 */
public class Message implements SimpleComment {
	/**
	 * The message id.
	 */
	private Number messageId;

	/**
	 * The sender's user id
	 */
	private Number senderId;

	/**
	 * The sender's user name
	 */
	private String senderName;

	/**
	 * The date the message was sent
	 */
	private String sentDate;

	/**
	 * Image url for the sender's avatar
	 */
	private String avatar;

	/**
	 * The bulletin board formatted body
	 */
	private String bbBody;

	/**
	 * The body text of the message.
	 */
	private String body;

	@Override
	public String getAuthor(){
		if (senderName == null || senderName.length() == 0){
			senderName = "System";
		}
		return senderName;
	}

	@Override
	public int getAuthorId(){
		return senderId.intValue();
	}

	@Override
	public String getAvatar(){
		return avatar;
	}

	@Override
	public Date getTimePosted(){
		return MySoup.parseDate(sentDate);
	}

	@Override
	public String getEditor(){
		return null;
	}

	@Override
	public int getEditorId(){
		return 0;
	}

	@Override
	public Date getTimeEdited(){
		return null;
	}

	@Override
	public String getBBbody(){
		return bbBody;
	}

	@Override
	public String getBody(){
		return body;
	}

	@Override
	public String getQuote(){
		return "[quote=" + getAuthor() + "]" + getBBbody() + "[/quote]";
	}

	@Override
	public int getPostId(){
		return messageId.intValue();
	}

	@Override
	public String toString(){
		return "Message [getBBBody()=" + getBBbody() + ", getBody()=" + getBody() + ", getPostId()=" + getPostId()
			+ ", getAuthorId()=" + getAuthorId() + ", getAuthor()=" + getAuthor() + ", getAvatar()=" + getAvatar()
			+ ", getTimePosted()=" + getTimePosted() + ", getQuote()=" + getQuote() + "]";
	}
}
