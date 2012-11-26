package api.inbox.conversation;

import api.son.MySon;
import api.soup.MySoup;

/**
 * The Class Conversation.
 * For using the API to get information about a Conversation
 * 
 * @author Gwindow
 */
public class Conversation {
	/** The API response data */
	private Response response;

	/** The API response status */
	private String status;

	/**
	 * Get a Conversation by its conversation id.
	 * 
	 * @param id
	 *      the conversation id to get
	 * @return the conversation
	 */
	public static Conversation conversationFromId(int id) {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=inbox&type=viewconv&id=" + id + "&auth=" + authkey;
		return (Conversation) MySon.toObject(url, Conversation.class);
	}

	/**
	 * Get the API response data
	 * 
	 * @return the API response data
	 */
	public Response getResponse() {
		return this.response;
	}

	/**
	 * Get the status of the request.
	 * 
	 * @return the status
	 */
	public boolean getStatus() {
        return this.status.equalsIgnoreCase("success");
	}

	@Override
	public String toString() {
		return "Conversation [getResponse()=" + getResponse() + ", getStatus()=" + getStatus() + "]";
	}
}
