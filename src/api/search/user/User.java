package api.search.user;

import com.google.gson.annotations.SerializedName;

/**
 * The Class User.
 * Describes a User as returned to us in a User search
 * 
 * @author Gwindow
 */
public class User {
	/** The user class. */
	@SerializedName("class")
	private String userClass;
	
	/** If the user is a donor. */
	private boolean donor;
	
	/** If the user's account is enabled */
	private boolean enabled;
	
	/** The user id. */
	private Number userId;
	
	/** The user name. */
	private String username;
	
	/** If the user is warned. */
	private boolean warned;

	/**
	 * Get the user class.
	 * 
	 * @return the user class
	 */
	public String getUserClass() {
		return userClass;
	}

	/**
	 * Check if the user is a donor
	 * 
	 * @return True if a donor
	 */
	public boolean isDonor() {
		return donor;
	}

	/**
	 * Check if the user is enabled
	 * 
	 * @return True if enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Get the user id
	 * 
	 * @return the user id
	 */
	public Number getUserId() {
		return userId;
	}

	/**
	 * Get the username
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Check if the user is warned
	 * 
	 * @return True if warned
	 */
	public Boolean isWarned() {
		return warned;
	}

	@Override
	public String toString() {
		return "User [getUserClass=" + getUserClass() + ", isDonor=" + isDonor() + ", isEnabled=" + isEnabled()
				+ ", getUserId=" + getUserId() + ", getUsername=" + getUsername() + ", isWarned=" + isWarned() + "]";
	}
}
