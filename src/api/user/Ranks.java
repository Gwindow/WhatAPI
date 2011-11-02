package api.user;

/**
 * A user's ranks
 * 
 * @author Tim
 * 
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

	public Number getArtists() {
		return this.artists;
	}

	public Number getBounty() {
		return this.bounty;
	}

	public Number getDownloaded() {
		return this.downloaded;
	}

	public String getOverall() {
		return this.overall;
	}

	public Number getPosts() {
		return this.posts;
	}

	public Number getRequests() {
		return this.requests;
	}

	public Number getUploaded() {
		return this.uploaded;
	}

	public Number getUploads() {
		return this.uploads;
	}

	public String getBuffer() {
		double up = uploaded.doubleValue();
		double down = downloaded.doubleValue();
		double buffer = up - down;
		return String.valueOf(buffer);

	}

	@Override
	public String toString() {
		return "Ranks [getArtists=" + getArtists() + ", getBounty=" + getBounty() + ", getDownloaded=" + getDownloaded()
				+ ", getOverall=" + getOverall() + ", getPosts=" + getPosts() + ", getRequests=" + getRequests()
				+ ", getUploaded=" + getUploaded() + ", getUploads=" + getUploads() + ", getBuffer=" + getBuffer() + "]";
	}
}
