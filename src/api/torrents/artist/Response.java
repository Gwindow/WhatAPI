/**
 * @author Gwindow
 */
package api.torrents.artist;

import java.util.List;

/**
 * The Class Response.
 */
public class Response {
	private String body;
	private boolean hasBookmarked;
	private String id;
	private String image;
	private String name;
	private boolean notificationsEnabled;
	private List<Requests> requests;
	private List<SimilarArtists> similarArtists;
	private Statistics statistics;
	private List<Tags> tags;
	private List<TorrentGroup> torrentgroup;
	private String vanityHouse;

	/**
	 * Gets the body.
	 * 
	 * @return the body
	 */
	public String getBody() {
		return this.body;
	}

	/**
	 * Checks if is bookmarked.
	 * 
	 * @return true, if is bookmarked
	 */
	public boolean isBookmarked() {
		return this.hasBookmarked;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Gets the image.
	 * 
	 * @return the image
	 */
	public String getImage() {
		return this.image;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Checks if is notifications enabled.
	 * 
	 * @return true, if is notifications enabled
	 */
	public boolean isNotificationsEnabled() {
		return this.notificationsEnabled;
	}

	/**
	 * Gets the requests.
	 * 
	 * @return the requests
	 */
	public List<Requests> getRequests() {
		return this.requests;
	}

	/**
	 * Gets the similar artists.
	 * 
	 * @return the similar artists
	 */
	public List<SimilarArtists> getSimilarArtists() {
		return this.similarArtists;
	}

	/**
	 * Gets the statistics.
	 * 
	 * @return the statistics
	 */
	public Statistics getStatistics() {
		return this.statistics;
	}

	/**
	 * Gets the tags.
	 * 
	 * @return the tags
	 */
	public List<Tags> getTags() {
		return this.tags;
	}

	/**
	 * Gets the torrentgroup.
	 * 
	 * @return the torrentgroup
	 */
	public List<TorrentGroup> getTorrentgroup() {
		return this.torrentgroup;
	}

	/**
	 * Gets the vanity house.
	 * 
	 * @return the vanity house
	 */
	public String getVanityHouse() {
		if (vanityHouse == null) {
			return "0";
		}
		return this.vanityHouse;

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Response [getBody=" + getBody() + ", isBookmarked=" + isBookmarked() + ", getId=" + getId() + ", getImage="
				+ getImage() + ", getName=" + getName() + ", isNotificationsEnabled=" + isNotificationsEnabled()
				+ ", getRequests=" + getRequests() + ", getSimilarArtists=" + getSimilarArtists() + ", getStatistics="
				+ getStatistics() + ", getTags=" + getTags() + ", getTorrentgroup=" + getTorrentgroup() + ", getVanityHouse="
				+ getVanityHouse() + "]";
	}
}
