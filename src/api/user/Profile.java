/**
 * @author Gwindow
 */
package api.user;

/**
 * The user profile.
 * 
 * @author Tim
 */
public class Profile {
	private String avatar;
	private Community community;
	private boolean isFriend;
	private Personal personal;
	private Ranks ranks;
	private Stats stats;
	private String username;

	/**
	 * Gets the avatar.
	 * 
	 * @return the avatar
	 */
	public String getAvatar() {
		return this.avatar;
	}

	/**
	 * Gets the community.
	 * 
	 * @return the community
	 */
	public Community getCommunity() {
		return this.community;
	}

	/**
	 * Checks if is friend.
	 * 
	 * @return true, if successful
	 */
	public boolean IsFriend() {
		return this.isFriend;
	}

	/**
	 * Gets the personal.
	 * 
	 * @return the personal
	 */
	public Personal getPersonal() {
		return this.personal;
	}

	/**
	 * Gets the ranks.
	 * 
	 * @return the ranks
	 */
	public Ranks getRanks() {
		return this.ranks;
	}

	/**
	 * Gets the stats.
	 * 
	 * @return the stats
	 */
	public Stats getStats() {
		return this.stats;
	}

	/**
	 * Gets the username.
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return this.username;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Profile [avatar=" + avatar + ", community=" + community + ", isFriend=" + isFriend + ", personal=" + personal
				+ ", ranks=" + ranks + ", stats=" + stats + ", username=" + username + "]";
	}
}
