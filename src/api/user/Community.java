package api.user;

/**
 * The community section of a user's profile.
 * 
 * @author Gwindow
 */
public class Community {

	/** The collages contrib. */
	private Number collagesContrib;

	/** The collages started. */
	private Number collagesStarted;

	/** The groups. */
	private Number groups;

	/** The invited. */
	private Number invited;

	/** The leeching. */
	private Number leeching;

	/** The posts. */
	private Number posts;

	/** The requests filled. */
	private Number requestsFilled;

	/** The requests voted. */
	private Number requestsVoted;

	/** The seeding. */
	private Number seeding;

	/** The snatched. */
	private Number snatched;

	/** The torrent comments. */
	private Number torrentComments;

	/** The uploaded. */
	private Number uploaded;

	/** The perfect flacs. */
	private Number perfectFlacs;

	/**
	 * Gets the perfect flacs.
	 * 
	 * @return the perfect flacs
	 */
	public Number getPerfectFlacs() {
		return this.perfectFlacs;
	}

	/**
	 * Gets the collages contrib.
	 * 
	 * @return the collages contrib
	 */
	public Number getCollagesContrib() {
		return this.collagesContrib;
	}

	/**
	 * Gets the collages started.
	 * 
	 * @return the collages started
	 */
	public Number getCollagesStarted() {
		return this.collagesStarted;
	}

	/**
	 * Gets the groups.
	 * 
	 * @return the groups
	 */
	public Number getGroups() {
		return this.groups;
	}

	/**
	 * Gets the invited.
	 * 
	 * @return the invited
	 */
	public Number getInvited() {
		return this.invited;
	}

	/**
	 * Gets the leeching.
	 * 
	 * @return the leeching
	 */
	public Number getLeeching() {
		return this.leeching;
	}

	/**
	 * Gets the posts.
	 * 
	 * @return the posts
	 */
	public Number getPosts() {
		return this.posts;
	}

	/**
	 * Gets the requests filled.
	 * 
	 * @return the requests filled
	 */
	public Number getRequestsFilled() {
		return this.requestsFilled;
	}

	/**
	 * Gets the requests voted.
	 * 
	 * @return the requests voted
	 */
	public Number getRequestsVoted() {
		return this.requestsVoted;
	}

	/**
	 * Gets the seeding.
	 * 
	 * @return the seeding
	 */
	public Number getSeeding() {
		return this.seeding;
	}

	/**
	 * Gets the snatched.
	 * 
	 * @return the snatched
	 */
	public Number getSnatched() {
		return this.snatched;
	}

	/**
	 * Gets the torrent comments.
	 * 
	 * @return the torrent comments
	 */
	public Number getTorrentComments() {
		return this.torrentComments;
	}

	/**
	 * Gets the uploaded.
	 * 
	 * @return the uploaded
	 */
	public Number getUploaded() {
		return this.uploaded;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Community [getPerfectFlacs()=" + getPerfectFlacs() + ", getCollagesContrib()=" + getCollagesContrib()
				+ ", getCollagesStarted()=" + getCollagesStarted() + ", getGroups()=" + getGroups() + ", getInvited()="
				+ getInvited() + ", getLeeching()=" + getLeeching() + ", getPosts()=" + getPosts() + ", getRequestsFilled()="
				+ getRequestsFilled() + ", getRequestsVoted()=" + getRequestsVoted() + ", getSeeding()=" + getSeeding()
				+ ", getSnatched()=" + getSnatched() + ", getTorrentComments()=" + getTorrentComments() + ", getUploaded()="
				+ getUploaded() + "]";
	}

}
