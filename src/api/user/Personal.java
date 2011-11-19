/**
 * @author Gwindow
 */
package api.user;

import com.google.gson.annotations.SerializedName;

/**
 * The personal section of a user's profile.
 * 
 * @author Tim
 */
public class Personal {
	// so java doesn't get confused with the "class" keyword
	@SerializedName("class")
	private String userClass;
	private String donor;
	private boolean enabled;
	private Number paranoia;
	private String paranoiaText;
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
	 * Gets the donor.
	 * 
	 * @return the donor
	 */
	public String getDonor() {
		return this.donor;
	}

	/**
	 * Gets the enabled.
	 * 
	 * @return the enabled
	 */
	public boolean getEnabled() {
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
	 * Gets the warned.
	 * 
	 * @return the warned
	 */
	public boolean getWarned() {
		return this.warned;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Personal [userClass=" + userClass + ", donor=" + donor + ", enabled=" + enabled + ", paranoia=" + paranoia
				+ ", paranoiaText=" + paranoiaText + ", warned=" + warned + "]";
	}
}
