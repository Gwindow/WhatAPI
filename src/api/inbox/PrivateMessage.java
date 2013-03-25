package api.inbox;

import java.util.ArrayList;
import java.util.List;

import api.search.user.UserSearch;
import api.soup.MySoup;
import api.util.CouldNotLoadException;
import api.util.Tuple;

/**
 * The Class PrivateMessage.
 * For use in sending Private Messages to other users
 * 
 * @author Gwindow
 */
public class PrivateMessage {
	/** The user id to send the message to */
	private int userId;

	/** The subject of the message */
	private String subject;

	/** The body text of the message */
	private String body;

	/** The conversation id */
	private int convId;

	/**
	 * Create a new message to be sent to a user with some user id
	 * 
	 * @param id
	 *      recipient user id
	 * @param subject
	 *      subject of message
	 * @param body
	 *      body of the message
	 */
	public PrivateMessage(int id, String subject, String body) {
		this.userId = id;
		this.subject = subject;
		this.body = body;
	}

	/**
	 * Create a new message to be sent to a user using the user name to
     * lookup the id
	 * 
	 * @param username
	 *      recipient user name
	 * @param subject
	 *      subject of message
	 * @param body
	 *      body of the message
	 * @throws CouldNotLoadException
	 *      if we fail to find the user we're trying to send a PM too
	 */
	public PrivateMessage(String username, String subject, String body) throws CouldNotLoadException {
		UserSearch us = UserSearch.userSearchFromSearchTerm(username.toLowerCase());
		if (us.getResponse().getResults() != null && !us.getResponse().getResults().isEmpty()) {
			this.userId = us.getResponse().getResults().get(0).getUserId().intValue();
			this.subject = subject;
			this.body = body;
		} else {
			throw new CouldNotLoadException("User not found");
		}
	}

	/**
	 * Create a new message in reply to an existing message
	 * 
	 * @param userId
	 *      recipient user id
	 * @param convId
	 *      the conversation id of the conversation the message is for
	 * @param body
	 *      body of the message
	 */
	public PrivateMessage(int userId, int convId, String body) {
		this.userId = userId;
		this.convId = convId;
		this.body = body;
	}

	/**
	 * Create a new empty message to be sent to some user
	 * 
	 * @param id
	 *      recipient user id
	 */
	public PrivateMessage(int id) {
		this.userId = id;
	}

	/**
	 * Create a new empty message to be sent to some user, the user id is looked up
     * from the user name passed
	 * 
	 * @param username
	 *      recipient user name
	 * @throws CouldNotLoadException
	 *      if we fail to find the user we're trying to send PM too
	 */
	public PrivateMessage(String username) throws CouldNotLoadException {
		UserSearch us = UserSearch.userSearchFromSearchTerm(username);
		if (us.getResponse().getResults() != null && !us.getResponse().getResults().isEmpty()) {
			this.userId = us.getResponse().getResults().get(0).getUserId().intValue();
		} else {
			throw new CouldNotLoadException("User not found");
		}
	}

	/**
	 * Send the message.
	 * 
	 */
	public void sendMessage() {
		if (subject.length() > 0 && body.length() > 0) {
			try {
				String url = "inbox.php?action=compose&to=" + userId;
				List<Tuple<String, String>> list = new ArrayList<Tuple<String, String>>();
				list.add(new Tuple<String, String>("action", "takecompose"));
				list.add(new Tuple<String, String>("toid", String.valueOf(userId)));
				list.add(new Tuple<String, String>("auth", MySoup.getAuthKey()));
				list.add(new Tuple<String, String>("subject", subject));
				list.add(new Tuple<String, String>("body", body));
				MySoup.postMethod(url, list);
				System.out.println("Message sent");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Send the message as a reply to an existing conversation
	 */
	public void replyMessage() {
		if (body.length() > 0) {
			try {
				String url = "inbox.php?action=viewconv&id=" + convId;
				List<Tuple<String, String>> list = new ArrayList<Tuple<String, String>>();
				list.add(new Tuple<String, String>("action", "takecompose"));
				list.add(new Tuple<String, String>("toid", String.valueOf(userId)));
				list.add(new Tuple<String, String>("convid", String.valueOf(convId)));
				list.add(new Tuple<String, String>("auth", MySoup.getAuthKey()));
				list.add(new Tuple<String, String>("body", body));
				MySoup.postMethod(url, list);
				System.out.println("Message sent");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Get the recipient user id
	 * 
	 * @return recipient user id
	 */
	public int getId() {
		return this.userId;
	}

	/**
	 * Get the message subject
	 * 
	 * @return the message subject
	 */
	public String getSubject() {
		return this.subject;
	}

	/**
	 * Set the subject line of the message
	 * 
	 * @param subject
	 *      the subject text to set
	 */
	public void setSubject(String subject) {
        this.subject = subject;
	}

	/**
	 * Get the message body
	 * 
	 * @return the message body
	 */
	public String getBody() {
		return this.body;
	}

	/**
	 * Set message body.
	 * 
	 * @param body
	 *      the text to set as the body
	 */
	public void setBody(String body) {
        this.body = body;
	}
}
