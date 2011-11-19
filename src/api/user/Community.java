/**
 * @author Gwindow
 */
package api.user;

/**
 * The community section of a user's profile.
 * 
 * @author Tim
 */
public class Community {
	private String collagesContrib;
	private String collagesStarted;
	private String groups;
	private String invited;
	private String leeching;
	private String posts;
	private String requestsFilled;
	private String requestsVoted;
	private String seeding;
	private String snatched;
	private String torrentComments;
	private String uploaded;

	/**
	 * Gets the collages contrib.
	 * 
	 * @return the collages contrib
	 */
	public String getCollagesContrib() {
		return this.collagesContrib;
	}

	/**
	 * Gets the collages started.
	 * 
	 * @return the collages started
	 */
	public String getCollagesStarted() {
		return this.collagesStarted;
	}

	/**
	 * Gets the groups.
	 * 
	 * @return the groups
	 */
	public String getGroups() {
		return this.groups;
	}

	/**
	 * Gets the invited.
	 * 
	 * @return the invited
	 */
	public String getInvited() {
		return this.invited;
	}

	/**
	 * Gets the leeching.
	 * 
	 * @return the leeching
	 */
	public String getLeeching() {
		return this.leeching;
	}

	/**
	 * Gets the posts.
	 * 
	 * @return the posts
	 */
	public String getPosts() {
		return this.posts;
	}

	/**
	 * Gets the requests filled.
	 * 
	 * @return the requests filled
	 */
	public String getRequestsFilled() {
		return this.requestsFilled;
	}

	/**
	 * Gets the requests voted.
	 * 
	 * @return the requests voted
	 */
	public String getRequestsVoted() {
		return this.requestsVoted;
	}

	/**
	 * Gets the seeding.
	 * 
	 * @return the seeding
	 */
	public String getSeeding() {
		return this.seeding;
	}

	/**
	 * Gets the snatched.
	 * 
	 * @return the snatched
	 */
	public String getSnatched() {
		return this.snatched;
	}

	/**
	 * Gets the torrent comments.
	 * 
	 * @return the torrent comments
	 */
	public String getTorrentComments() {
		return this.torrentComments;
	}

	/**
	 * Gets the uploaded.
	 * 
	 * @return the uploaded
	 */
	public String getUploaded() {
		return this.uploaded;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Community [collagesContrib=" + collagesContrib + ", collagesStarted=" + collagesStarted + ", groups=" + groups
				+ ", invited=" + invited + ", leeching=" + leeching + ", posts=" + posts + ", requestsFilled=" + requestsFilled
				+ ", requestsVoted=" + requestsVoted + ", seeding=" + seeding + ", snatched=" + snatched + ", torrentComments="
				+ torrentComments + ", uploaded=" + uploaded + "]";
	}
}
