package api.index;

public class Response {
	private String authkey;
	private String id;
	private String passkey;
	private String username;
	private UserStats userstats;

	public String getAuthkey() {
		return this.authkey;
	}

	public String getId() {
		return this.id;
	}

	public String getPasskey() {
		return this.passkey;
	}

	public String getUsername() {
		return this.username;
	}

	public UserStats getUserstats() {
		return this.userstats;
	}

	@Override
	public String toString() {
		return "Response [getAuthkey=" + getAuthkey() + ", getId=" + getId() + ", getPasskey=" + getPasskey() + ", getUsername="
				+ getUsername() + ", getUserstats=" + getUserstats() + "]";
	}
}
