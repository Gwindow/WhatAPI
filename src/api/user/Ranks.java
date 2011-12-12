


package api.user;

/**
 * A user's ranks.
 * 
 * @author Tim
 */
public class Ranks {
	
	/** The artists. */
	private Number artists;
	
	/** The bounty. */
	private Number bounty;
	
	/** The downloaded. */
	private Number downloaded;
	
	/** The overall. */
	private Number overall;
	
	/** The posts. */
	private Number posts;
	
	/** The requests. */
	private Number requests;
	
	/** The uploaded. */
	private Number uploaded;
	
	/** The uploads. */
	private Number uploads;

	/**
	 * Gets the artists.
	 * 
	 * @return the artists
	 */
	public Number getArtists() {
		return this.artists;
	}

	/**
	 * Gets the bounty.
	 * 
	 * @return the bounty
	 */
	public Number getBounty() {
		return this.bounty;
	}

	/**
	 * Gets the downloaded.
	 * 
	 * @return the downloaded
	 */
	public Number getDownloaded() {
		return this.downloaded;
	}

	/**
	 * Gets the overall.
	 * 
	 * @return the overall
	 */
	public Number getOverall() {
		return this.overall;
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
	 * Gets the requests.
	 * 
	 * @return the requests
	 */
	public Number getRequests() {
		return this.requests;
	}

	/**
	 * Gets the uploaded.
	 * 
	 * @return the uploaded
	 */
	public Number getUploaded() {
		return this.uploaded;
	}

	/**
	 * Gets the uploads.
	 * 
	 * @return the uploads
	 */
	public Number getUploads() {
		return this.uploads;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ranks [getArtists=" + getArtists() + ", getBounty=" + getBounty() + ", getDownloaded=" + getDownloaded()
				+ ", getOverall=" + getOverall() + ", getPosts=" + getPosts() + ", getRequests=" + getRequests()
				+ ", getUploaded=" + getUploaded() + ", getUploads=" + getUploads() + "]";
	}
}
