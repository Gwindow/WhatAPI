



package api.index;

/**
 * The Class Response.
 * 
 * @author Gwindow
 */
public class Response {
	
	/** The authkey. */
	private String authkey;
	
	/** The id. */
	private Number id;
	
	/** The passkey. */
	private String passkey;
	
	/** The username. */
	private String username;
	
	/** The userstats. */
	private UserStats userstats;

	/**
	 * Gets the authkey.
	 * 
	 * @return the authkey
	 */
	public String getAuthkey() {
		return this.authkey;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Number getId() {
		return this.id;
	}

	/**
	 * Gets the passkey.
	 * 
	 * @return the passkey
	 */
	public String getPasskey() {
		return this.passkey;
	}

	/**
	 * Gets the username.
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * Gets the userstats.
	 * 
	 * @return the userstats
	 */
	public UserStats getUserstats() {
		return this.userstats;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Response [getAuthkey=" + getAuthkey() + ", getId=" + getId() + ", getPasskey=" + getPasskey() + ", getUsername="
				+ getUsername() + ", getUserstats=" + getUserstats() + "]";
	}
}
