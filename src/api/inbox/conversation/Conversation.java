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
	/**
	 * The API response data
	 */
	private Response response;

	/**
	 * The API response status and error if an error occurred
	 */
	private String status, error;

	/**
	 * Get a Conversation by its conversation id.
	 *
	 * @param id the conversation id to get
	 * @return the conversation
	 */
	public static Conversation conversation(int id){
		String url = "ajax.php?action=inbox&type=viewconv&id=" + id
			+ "&auth=" + MySoup.getAuthKey();
		return (Conversation)MySon.toObject(url, Conversation.class);
	}

	/**
	 * Get the API response data
	 *
	 * @return the API response data
	 */
	public Response getResponse(){
		return this.response;
	}

	/**
	 * Get the status of the request.
	 *
	 * @return the status
	 */
	public boolean getStatus(){
		return this.status.equalsIgnoreCase("success");
	}

	public String getError(){
		return error;
	}

	@Override
	public String toString(){
		return "Conversation [getResponse()=" + getResponse() + ", getStatus()=" + getStatus() + "]";
	}
}
