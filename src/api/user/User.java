package api.user;

import api.son.MySon;
import api.soup.MySoup;
import api.util.CouldNotLoadException;

/**
 * A User, needs to be created using userFromId contains the user profile
 * 
 * @author Tim
 * 
 */
public class User {
	private Profile response;
	private String status;
	private static transient int id;

	/**
	 * Return a User object created from an id
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

	/**
	 * Add user to your friend list
	 */
	public void addToFriends() throws CouldNotLoadException {
		if (!getProfile().IsFriend()) {
			MySoup.scrape("friends.php?action=add&friendid=" + id + "&auth=" + MySoup.getAuthKey());
		}
	}

	// TODO test sending messages
	/**
	 * Send message to the user
	 * 
	 * @param
	 * @throws CouldNotLoadException
	 */
	public void sendMessage(String subject, String body) throws CouldNotLoadException {
		PrivateMessage pm = new PrivateMessage(id, subject, body);
		pm.sendMessage();
	}

	public void sendRippy(String body) {
		Rippy rippy = new Rippy(id, body);
		try {
			rippy.sendRippy();
		} catch (CouldNotLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Get the user's id
	 * 
	 * @return user id
	 */
	public static int getId() {
		return id;
	}

	public Profile getProfile() {
		return response;
	}

	public boolean getStatus() {
		if (status.equalsIgnoreCase("success"))
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", response=" + response + ", status=" + status + "]";

	}
}
