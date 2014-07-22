package api.inbox.conversation;

import api.son.MySon;
import api.soup.MySoup;
import api.util.CouldNotLoadException;
import api.util.Tuple;

import java.util.ArrayList;
import java.util.List;

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
	 * Manage the properties of a conversation
	 *
	 * @param convId     id of conversation to manage
	 * @param sticky     if we want to make the conversation sticky
	 * @param markUnread if we want to mark the conversation unread
	 * @param delete     if we want delete the conversation
	 * @return true if successfully updated the conversation
	 */
	public static boolean manage(int convId, boolean sticky, boolean markUnread, boolean delete){
		try {
			List<Tuple<String, String>> params = new ArrayList<Tuple<String, String>>();
			params.add(new Tuple<String, String>("action", "takeedit"));
			params.add(new Tuple<String, String>("convid", Integer.toString(convId)));
			params.add(new Tuple<String, String>("auth", MySoup.getAuthKey()));
			if (sticky){
				params.add(new Tuple<String, String>("sticky", "on"));
			}
			if (markUnread){
				params.add(new Tuple<String, String>("mark_unread", "on"));
			}
			if (delete){
				params.add(new Tuple<String, String>("delete", "on"));
			}
			MySoup.postMethod("inbox.php", params);
		}
		catch (CouldNotLoadException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Make the conversation sticky
	 *
	 * @return true if successful
	 */
	public boolean makeSticky(){
		return manage(response.getConvId().intValue(), true, false, false);
	}

	/**
	 * Mark the conversation as unread
	 *
	 * @return true if successful
	 */
	public boolean markUnread(){
		return manage(response.getConvId().intValue(), response.isSticky(), true, false);
	}

	/**
	 * Delete the conversation
	 *
	 * @return true if successful
	 */
	public boolean delete(){
		return manage(response.getConvId().intValue(), false, false, true);
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
