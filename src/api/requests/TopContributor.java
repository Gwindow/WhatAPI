package api.requests;

/**
 * The Class TopContributor.
 * Stores data about a top bounty contributor to a Request
 * 
 * @author Gwindow
 */
public class TopContributor {
	/** The bounty they've contributed, in bytes. */
	private Number bounty;
	
	/** The user id. */
	private Number userId;
	
	/** The user name. */
	private String userName;

	/**
	 * Get the bounty contributed, in bytes
	 * 
	 * @return the bounty contributed
	 */
	public Number getBounty() {
		return bounty;
	}

	/**
	 * Get the user id.
	 * 
	 * @return the user id
	 */
	public Number getUserId() {
		return userId;
	}

	/**
	 * Get the user name.
	 * 
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	@Override
	public String toString() {
		return "TopContributor [getBounty=" + getBounty() + ", getUserId=" + getUserId() + ", getUserName=" + getUserName()
				+ "]";
	}
}
