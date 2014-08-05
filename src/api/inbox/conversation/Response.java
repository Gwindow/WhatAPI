package api.inbox.conversation;

import api.soup.MySoup;

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
	 * Get the id of the user we're having the conversation with,
	 * will return 0 if we somehow couldn't find the other users id.
	 */
	public int getToId(){
		//Just run through the messages and find the id that isn't our own
		for (Message m : messages){
			if (m.getAuthorId() != MySoup.getUserId()){
				return m.getAuthorId();
			}
		}
		return 0;
	}

    /**
     * Check if the conversation is stickied
     *
     * @return True if the conversation is stickied
     */
    public boolean isSticky() {
        return sticky;
    }

	public void setSticky(boolean sticky){
		this.sticky = sticky;
	}

	@Override
	public String toString() {
		return "Response [getConvId()=" + getConvId() + ", isSticky()=" + isSticky()
			+ ", getSubject()=" + getSubject() + ", getMessages()=" + getMessages() + "]";
	}
}
