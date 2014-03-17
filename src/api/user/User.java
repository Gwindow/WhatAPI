package api.user;

import api.inbox.PrivateMessage;
import api.search.user.UserSearch;
import api.son.MySon;
import api.soup.MySoup;
import api.util.CouldNotLoadException;

/**
 * A User, needs to be created using fromId contains the user profile.
 * 
 * @author Gwindow
 */
public class User {

	/** The response. */
	private Profile response;

	/** The status. */
	private String status;

	/** The id. */
	private transient int id;

	/**
	 * Return a User object created from an id.
	 * 
	 * @param id
	 *            id of user
	 * @return User object
	 */
	public static User fromId(int id){
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=user&id=" + id + "&auth=" + authkey;
		User user = (User) MySon.toObject(url, User.class);
		user.id = id;
		return user;
	}

	/**
	 * User from name.
	 * 
	 * @param username
	 *            the username
	 * @return the user
	 * @throws CouldNotLoadException
	 *             the could not load exception
	 */
	public static User userFromName(String username) throws CouldNotLoadException {
		UserSearch us = UserSearch.search(username.toLowerCase());
		if (us.getResponse().getResults() != null && !us.getResponse().getResults().isEmpty()) {
			return fromId(us.getResponse().getResults().get(0).getUserId().intValue());
		} else {
			throw new CouldNotLoadException("User not found");
		}
	}

	/**
	 * Add user to your friend list.
	 * 
	 */
	public void addToFriends() {
		if (!getProfile().isFriend()){
			MySoup.pressLink("friends.php?action=add&friendid=" + id + "&auth=" + MySoup.getAuthKey());
			System.out.println("Added to friends");
		} else {
			System.out.println("Already added as friend");
		}
	}

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
		new Rippy(id, body).sendRippy();
	}

	/**
	 * Get the user's id.
	 * 
	 * @return user id
	 */
	public int getId(){
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
        return status.equalsIgnoreCase("success");
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", response=" + response + ", status=" + status + "]";

	}
}
