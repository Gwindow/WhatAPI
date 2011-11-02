package api.search.user;

import com.google.gson.annotations.SerializedName;

public class Results {
	// so java doesn't get confused with the "class" keyword
	@SerializedName("class")
	private String userClass;
	private String donor;
	private boolean enabled;
	private String userId;
	private String username;
	private String warned;

	public String getUserClass() {
		return this.userClass;
	}

	public String getDonor() {
		return this.donor;
	}

	public boolean getEnabled() {
		return this.enabled;
	}

	public String getUserId() {
		return this.userId;
	}

	public String getUsername() {
		return this.username;
	}

	public String getWarned() {
		return this.warned;
	}

	@Override
	public String toString() {
		return "Results [getUserClass=" + getUserClass() + ", getDonor=" + getDonor() + ", getEnabled=" + getEnabled()
				+ ", getUserId=" + getUserId() + ", getUsername=" + getUsername() + ", getWarned=" + getWarned() + "]";
	}
}
