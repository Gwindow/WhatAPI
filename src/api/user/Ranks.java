/**
 * @author Gwindow
 */
package api.user;

/**
 * A user's ranks.
 * 
 * @author Tim
 */
public class Ranks {
	private Number artists;
	private Number bounty;
	private Number downloaded;
	private String overall;
	private Number posts;
	private Number requests;
	private Number uploaded;
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
	public String getOverall() {
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

	/**
	 * Gets the buffer.
	 * 
	 * @return the buffer
	 */
	public String getBuffer() {
		double up = uploaded.doubleValue();
		double down = downloaded.doubleValue();
		double buffer = up - down;
		return String.valueOf(buffer);

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ranks [getArtists=" + getArtists() + ", getBounty=" + getBounty() + ", getDownloaded=" + getDownloaded()
				+ ", getOverall=" + getOverall() + ", getPosts=" + getPosts() + ", getRequests=" + getRequests()
				+ ", getUploaded=" + getUploaded() + ", getUploads=" + getUploads() + ", getBuffer=" + getBuffer() + "]";
	}
}
