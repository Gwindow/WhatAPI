/**
 * @author Gwindow
 */
package api.inbox.conversation;

import api.son.MySon;
import api.soup.MySoup;

/**
 * The Class Conversation.
 */
public class Conversation {
	private Response response;
	private String status;

	/**
	 * Conversation from id.
	 * 
	 * @param id
	 *            the id
	 * @return the conversation
	 */
	public static Conversation conversationFromId(int id) {
		String authkey = MySoup.getAuthKey();
		String url = "/ajax.php?action=inbox&type=viewconv&id=" + id + "&auth=" + authkey;
		Conversation conversation = (Conversation) MySon.toObject(url, Conversation.class);
		return conversation;
	}

	/**
	 * Gets the response.
	 * 
	 * @return the response
	 */
	public Response getResponse() {
		return this.response;
	}

	/**
	 * Gets the status.
	 * 
	 * @return the status
	 */
	public boolean getStatus() {
		if (status.equalsIgnoreCase("success"))
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Conversation [getResponse()=" + getResponse() + ", getStatus()=" + getStatus() + "]";
	}
}
