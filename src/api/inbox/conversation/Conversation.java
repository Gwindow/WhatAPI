package api.inbox.conversation;

import api.son.MySon;
import api.soup.MySoup;

public class Conversation {
	private Response response;
	private String status;

	public static Conversation conversationFromId(int id) {
		String authkey = MySoup.getAuthKey();
		String url = "/ajax.php?action=inbox&type=viewconv&id=" + id + "&auth=" + authkey;
		Conversation conversation = (Conversation) MySon.toObject(url, Conversation.class);
		return conversation;
	}

	public Response getResponse() {
		return this.response;
	}

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
