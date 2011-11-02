package api.user;

import com.google.gson.annotations.SerializedName;

/**
 * The personal section of a user's profile
 * 
 * @author Tim
 * 
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

	public String getUserClass() {
		return this.userClass;
	}

	public String getDonor() {
		return this.donor;
	}

	public boolean getEnabled() {
		return this.enabled;
	}

	public Number getParanoia() {
		return this.paranoia;
	}

	public String getParanoiaText() {
		return this.paranoiaText;
	}

	public boolean getWarned() {
		return this.warned;
	}

	@Override
	public String toString() {
		return "Personal [userClass=" + userClass + ", donor=" + donor + ", enabled=" + enabled + ", paranoia=" + paranoia
				+ ", paranoiaText=" + paranoiaText + ", warned=" + warned + "]";
	}
}
