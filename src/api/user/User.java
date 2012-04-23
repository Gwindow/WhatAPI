package api.user;

import api.inbox.PrivateMessage;
import api.search.user.UserSearch;
import api.son.MySon;
import api.soup.MySoup;
import api.util.CouldNotLoadException;

/**
 * A User, needs to be created using userFromId contains the user profile.
 * 
 * @author Gwindow
 */
public class User {

	/** The response. */
	private Profile response;

	/** The status. */
	private String status;

	/** The id. */
	private static transient int id;

	/**
	 * Return a User object created from an id.
	 * 
	 * @param id
	 *            id of user
	 * @return User object
	 */
	public static User userFromId(int id) {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=user&id=" + id + "&auth=" + authkey;
		User user = (User) MySon.toObject(url, User.class);
		User.id = id;
		return user;
	}

	public static User userFromName(String username) throws CouldNotLoadException {
		UserSearch us = UserSearch.userSearchFromSearchTerm(username.toLowerCase());
		if (us.getResponse().getResults() != null && !us.getResponse().getResults().isEmpty()) {
			return userFromId(us.getResponse().getResults().get(0).getUserId().intValue());
		} else {
			throw new CouldNotLoadException("User not found");
		}
	}

	/**
	 * Add user to your friend list.
	 * 
	 */
	public void addToFriends() {
		if (!getProfile().IsFriend()) {
			MySoup.pressLink("friends.php?action=add&friendid=" + id + "&auth=" + MySoup.getAuthKey());
			System.out.println("Added to friends");
		} else {
			System.out.println("Already added as friend");
		}
	}

	// TODO test sending messages
	/**
	 * Send message to the user.
	 * 
	 * @param subject
	 *            the subject
	 * @param body
	 *            the body
	 * @throws CouldNotLoadException
	 *             the could not load exception
	 */
	public void sendMessage(String subject, String body) throws CouldNotLoadException {
		PrivateMessage pm = new PrivateMessage(id, subject, body);
		pm.sendMessage();
	}

	/**
	 * Send rippy.
	 * 
	 * @param body
	 *            the body
	 */
	public void sendRippy(String body) {
		Rippy rippy = new Rippy(id, body);
		rippy.sendRippy();
	}

	/**
	 * Get the user's id.
	 * 
	 * @return user id
	 */
	public static int getId() {
		return id;
	}

	/**
	 * Gets the profile.
	 * 
	 * @return the profile
	 */
	public Profile getProfile() {
		return response;
	}

	/**
	 * Gets the status.
	 * 
	 * @return the status
	 * 
	 */
	public boolean getStatus() {
		if (status.equalsIgnoreCase("success"))
			return true;
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", response=" + response + ", status=" + status + "]";

	}
}
