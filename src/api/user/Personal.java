package api.user;

import com.google.gson.annotations.SerializedName;

/**
 * The personal section of a user's profile.
 * 
 * @author Gwindow
 */
public class Personal {
	// so java doesn't get confused with the "class" keyword
	/** The user class. */
	@SerializedName("class")
	private String userClass;
	
	/** The donor. */
	private boolean donor;
	
	/** The enabled. */
	private boolean enabled;
	
	/** The paranoia. */
	private Number paranoia;
	
	/** The paranoia text. */
	private String paranoiaText;
	
	/** The warned. */
	private boolean warned;

	/**
	 * Gets the user class.
	 * 
	 * @return the user class
	 */
	public String getUserClass() {
		return this.userClass;
	}

	/**
	 * Checks if is donor.
	 * 
	 * @return true, if is donor
	 */
	public boolean isDonor() {
		return this.donor;
	}

	/**
	 * Checks if is enabled.
	 * 
	 * @return true, if is enabled
	 */
	public boolean isEnabled() {
		return this.enabled;
	}

	/**
	 * Gets the paranoia.
	 * 
	 * @return the paranoia
	 */
	public Number getParanoia() {
		return this.paranoia;
	}

	/**
	 * Gets the paranoia text.
	 * 
	 * @return the paranoia text
	 */
	public String getParanoiaText() {
		return this.paranoiaText;
	}

	/**
	 * Checks if is warned.
	 * 
	 * @return true, if is warned
	 */
	public boolean isWarned() {
		return this.warned;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Personal [getUserClass=" + getUserClass() + ", isDonor=" + isDonor() + ", isEnabled=" + isEnabled()
				+ ", getParanoia=" + getParanoia() + ", getParanoiaText=" + getParanoiaText() + ", isWarned=" + isWarned() + "]";
	}

}
