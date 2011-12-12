package api.requests;

/**
 * The Class TopContributors.
 * 
 * //TODO description
 * 
 * @author Gwindow
 */
public class TopContributors {
	
	/** The bounty. */
	private Number bounty;
	
	/** The user id. */
	private Number userId;
	
	/** The user name. */
	private String userName;

	/**
	 * Gets the bounty.
	 * 
	 * @return the bounty
	 */
	public Number getBounty() {
		return this.bounty;
	}

	/**
	 * Gets the user id.
	 * 
	 * @return the user id
	 */
	public Number getUserId() {
		return this.userId;
	}

	/**
	 * Gets the user name.
	 * 
	 * @return the user name
	 */
	public String getUserName() {
		return this.userName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TopContributors [getBounty=" + getBounty() + ", getUserId=" + getUserId() + ", getUserName=" + getUserName()
				+ "]";
	}
}
