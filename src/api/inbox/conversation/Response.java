package api.inbox.conversation;

import java.util.List;

/**
 * The Class Response.
 * Describes the data received in response to a Conversation
 * API request
 * 
 * @author Gwindow
 */
public class Response {
	/** The conversation id. */
	private Number convId;
	
	/** The messages in the conversation. */
	private List<Message> messages;

    /** The subject of the conversation */
    private String subject;
	
	/** If the conversation is stickied */
	private boolean sticky;

	/**
	 * Get the conversation id
	 * 
	 * @return the conversation id
	 */
	public Number getConvId() {
		return this.convId;
	}

	/**
	 * Get the messages in the conversation
	 * 
	 * @return the messages
	 */
	public List<Message> getMessages() {
		return this.messages;
	}

	/**
	 * Get the subject of the conversation
	 * 
	 * @return the subject
	 */
	public String getSubject() {
		return this.subject;
	}

    /**
     * Check if the conversation is stickied
     *
     * @return True if the conversation is stickied
     */
    public boolean isSticky() {
        return sticky;
    }

	@Override
	public String toString() {
		return "Response [getConvId()=" + getConvId() + ", isSticky()=" + isSticky()
			+ ", getSubject()=" + getSubject() + ", getMessages()=" + getMessages() + "]";
	}
}
