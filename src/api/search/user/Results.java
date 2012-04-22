
package api.search.user;

import com.google.gson.annotations.SerializedName;

/**
 * The Class Results.
 * 
 * @author Gwindow
 */
public class Results {
	// so java doesn't get confused with the "class" keyword
	/** The user class. */
	@SerializedName("class")
	private String userClass;
	
	/** The donor. */
	private boolean donor;
	
	/** The enabled. */
	private boolean enabled;
	
	/** The user id. */
	private Number userId;
	
	/** The username. */
	private String username;
	
	/** The warned. */
	private boolean warned;

	/**
	 * Gets the user class.
	 * 
	 * @return the user class
	 */
	public String getUserClass() {
		return userClass;
	}

	/**
	 * Checks if is donor.
	 * 
	 * @return true, if is donor
	 */
	public boolean isDonor() {
		return donor;
	}

	/**
	 * Checks if is enabled.
	 * 
	 * @return true, if is enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Gets the user id.
	 * 
	 * @return the user id
	 */
	public Number getUserId() {
		return userId;
	}

	/**
	 * Gets the username.
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Gets the warned.
	 * 
	 * @return the warned
	 */
	public Boolean getWarned() {
		return warned;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Results [getUserClass=" + getUserClass() + ", isDonor=" + isDonor() + ", isEnabled=" + isEnabled()
				+ ", getUserId=" + getUserId() + ", getUsername=" + getUsername() + ", getWarned=" + getWarned() + "]";
	}
}
