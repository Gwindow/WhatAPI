package api.index;

/**
 * The Class Response.
 * Stores the data returned by the API in response
 * to our Index API request
 *
 * @author Gwindow
 */
public class Response {
	/** The user's authkey for this session. */
	private String authkey;

	/** The user's id */
	private Number id;

	/** The user's torrent passkey */
	private String passkey;

	/** The user's name */
	private String username;

	/** The user's notifications */
	private Notifications notifications;

	/** The user's stats */
	private UserStats userstats;

	/**
	 * Get the session authkey
	 * 
	 * @return the authkey
	 */
	public String getAuthkey() {
		return authkey;
	}

	/**
	 * Get the user id
	 * 
	 * @return the user id
	 */
	public Number getId() {
		return id;
	}

	/**
	 * Get the user's passky
	 * 
	 * @return the passkey
	 */
	public String getPasskey() {
		return passkey;
	}

	/**
	 * Get the user's name
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Get the user's notifications
	 * 
	 * @return the notifications
	 */

	public Notifications getNotifications() {
		return notifications;
	}

	/**
	 * Gets the user's stats
	 * 
	 * @return the user's stats
	 */

	public UserStats getUserstats() {
		return userstats;
	}

	@Override
	public String toString() {
		return "Response [getAuthkey()=" + getAuthkey() + ", getId()=" + getId() + ", getPasskey()=" + getPasskey()
				+ ", getUsername()=" + getUsername() + ", getNotifications()=" + getNotifications() + ", getUserstats()="
				+ getUserstats() + "]";
	}

}
