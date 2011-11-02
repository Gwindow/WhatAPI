package api.user;

/**
 * The community section of a user's profile
 * 
 * @author Tim
 * 
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

	public String getCollagesContrib() {
		return this.collagesContrib;
	}

	public String getCollagesStarted() {
		return this.collagesStarted;
	}

	public String getGroups() {
		return this.groups;
	}

	public String getInvited() {
		return this.invited;
	}

	public String getLeeching() {
		return this.leeching;
	}

	public String getPosts() {
		return this.posts;
	}

	public String getRequestsFilled() {
		return this.requestsFilled;
	}

	public String getRequestsVoted() {
		return this.requestsVoted;
	}

	public String getSeeding() {
		return this.seeding;
	}

	public String getSnatched() {
		return this.snatched;
	}

	public String getTorrentComments() {
		return this.torrentComments;
	}

	public String getUploaded() {
		return this.uploaded;
	}

	@Override
	public String toString() {
		return "Community [collagesContrib=" + collagesContrib + ", collagesStarted=" + collagesStarted + ", groups=" + groups
				+ ", invited=" + invited + ", leeching=" + leeching + ", posts=" + posts + ", requestsFilled=" + requestsFilled
				+ ", requestsVoted=" + requestsVoted + ", seeding=" + seeding + ", snatched=" + snatched + ", torrentComments="
				+ torrentComments + ", uploaded=" + uploaded + "]";
	}
}
