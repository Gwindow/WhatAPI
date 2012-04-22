package api.user;

/**
 * The user profile.
 * 
 * @author Tim
 */
public class Profile {

	/** The avatar. */
	private String avatar;

	/** The community. */
	private Community community;

	/** The is friend. */
	private boolean isFriend;

	/** The personal. */
	private Personal personal;

	/** The ranks. */
	private Ranks ranks;

	/** The stats. */
	private Stats stats;

	/** The username. */
	private String username;

	/** The profile text. */
	private String profileText;

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

	/**
	 * Gets the profile text.
	 * 
	 * @return the profile text
	 */
	public String getProfileText() {
		return this.profileText;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Profile [getAvatar()=" + getAvatar() + ", getCommunity()=" + getCommunity() + ", IsFriend()=" + IsFriend()
				+ ", getPersonal()=" + getPersonal() + ", getRanks()=" + getRanks() + ", getStats()=" + getStats()
				+ ", getUsername()=" + getUsername() + ", getProfileText()=" + getProfileText() + "]";
	}

}
