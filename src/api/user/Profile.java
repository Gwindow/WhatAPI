package api.user;

/**
 * The user profile
 * 
 * @author Tim
 * 
 */
public class Profile {
	private String avatar;
	private Community community;
	private boolean isFriend;
	private Personal personal;
	private Ranks ranks;
	private Stats stats;
	private String username;

	public String getAvatar() {
		return this.avatar;
	}

	public Community getCommunity() {
		return this.community;
	}

	public boolean IsFriend() {
		return this.isFriend;
	}

	public Personal getPersonal() {
		return this.personal;
	}

	public Ranks getRanks() {
		return this.ranks;
	}

	public Stats getStats() {
		return this.stats;
	}

	public String getUsername() {
		return this.username;
	}

	@Override
	public String toString() {
		return "Profile [avatar=" + avatar + ", community=" + community + ", isFriend=" + isFriend + ", personal=" + personal
				+ ", ranks=" + ranks + ", stats=" + stats + ", username=" + username + "]";
	}
}
