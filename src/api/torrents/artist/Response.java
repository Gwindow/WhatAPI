package api.torrents.artist;

import java.util.List;

/**
 * The Class Response.
 * 
 * @author Gwindow
 */
public class Response {
	
	/** The body. */
	private String body;
	
	/** The has bookmarked. */
	private boolean hasBookmarked;
	
	/** The id. */
	private Number id;
	
	/** The image. */
	private String image;
	
	/** The name. */
	private String name;
	
	/** The notifications enabled. */
	private boolean notificationsEnabled;
	
	/** The requests. */
	private List<Requests> requests;
	
	/** The similar artists. */
	private List<SimilarArtists> similarArtists;
	
	/** The statistics. */
	private Statistics statistics;
	
	/** The tags. */
	private List<Tags> tags;
	
	/** The torrentgroup. */
	private List<TorrentGroup> torrentgroup;
	
	/** The vanity house. */
	private boolean vanityHouse;

	/**
	 * Gets the body.
	 * 
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * Checks if is bookmarked.
	 * 
	 * @return true, if is bookmarked
	 */
	public boolean isBookmarked() {
		return hasBookmarked;
	}

    /**
     * Set the is bookmarked property. We only do this since if add/removeBookmark
     * succeeded we know what we changed the property too and want to update the
     * Artist without having to reload the entire thing. Don't change this if you
     * don't think the API request went ok! (ie. add/remove returned false)
     *
     * @param val
     *      The val to set isBookmarked too
     */
    public void setBookmarked(boolean val){
        this.hasBookmarked = val;
    }

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Number getId() {
		return id;
	}

	/**
	 * Gets the image.
	 * 
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Checks for notifications enabled.
	 * 
	 * @return true, if successful
	 */
	public boolean hasNotificationsEnabled() {
		return notificationsEnabled;
	}

    /**
     * Set the notifications enabled property. We only do this since if enable/disable
     * succeeded we know what we changed the property too and want to update the
     * Artist without having to reload the entire thing. Don't change this if you
     * don't think the API request went ok! (ie. enable/disable returned false)
     *
     * @param val
     *      The val to set isBookmarked too
     */
    public void setNotificationsEnabled(boolean val){
        this.notificationsEnabled = val;
    }

	/**
	 * Gets the requests.
	 * 
	 * @return the requests
	 */
	public List<Requests> getRequests() {
		return requests;
	}

	/**
	 * Gets the similar artists.
	 * 
	 * @return the similar artists
	 */
	public List<SimilarArtists> getSimilarArtists() {
		return similarArtists;
	}

	/**
	 * Gets the statistics.
	 * 
	 * @return the statistics
	 */
	public Statistics getStatistics() {
		return statistics;
	}

	/**
	 * Gets the tags.
	 * 
	 * @return the tags
	 */
	public List<Tags> getTags() {
		return tags;
	}

	/**
	 * Gets the torrentgroup.
	 * 
	 * @return the torrentgroup
	 */
	public List<TorrentGroup> getTorrentgroup() {
		return torrentgroup;
	}

	/**
	 * Checks if is vanity house.
	 * 
	 * @return true, if is vanity house
	 */
	public boolean isVanityHouse() {
		return vanityHouse;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Response [getBody=" + getBody() + ", isBookmarked=" + isBookmarked() + ", getId=" + getId() + ", getImage="
				+ getImage() + ", getName=" + getName() + ", hasNotificationsEnabled=" + hasNotificationsEnabled()
				+ ", getRequests=" + getRequests() + ", getSimilarArtists=" + getSimilarArtists() + ", getStatistics="
				+ getStatistics() + ", getTags=" + getTags() + ", getTorrentgroup=" + getTorrentgroup() + ", isVanityHouse="
				+ isVanityHouse() + "]";
	}

}
