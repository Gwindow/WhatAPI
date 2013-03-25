package api.torrents.artist;


/**
 * The Class Statistics.
 * 
 * @author Gwindow
 */
public class Statistics {
	
	/** The num groups. */
	private Number numGroups;
	
	/** The num leechers. */
	private Number numLeechers;
	
	/** The num seeders. */
	private Number numSeeders;
	
	/** The num snatches. */
	private Number numSnatches;
	
	/** The num torrents. */
	private Number numTorrents;

	/**
	 * Gets the num groups.
	 * 
	 * @return the num groups
	 */
	public Number getNumGroups() {
		return this.numGroups;
	}

	/**
	 * Gets the num leechers.
	 * 
	 * @return the num leechers
	 */
	public Number getNumLeechers() {
		return this.numLeechers;
	}

	/**
	 * Gets the num seeders.
	 * 
	 * @return the num seeders
	 */
	public Number getNumSeeders() {
		return this.numSeeders;
	}

	/**
	 * Gets the num snatches.
	 * 
	 * @return the num snatches
	 */
	public Number getNumSnatches() {
		return this.numSnatches;
	}

	/**
	 * Gets the num torrents.
	 * 
	 * @return the num torrents
	 */
	public Number getNumTorrents() {
		return this.numTorrents;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Statistics [getNumGroups=" + getNumGroups() + ", getNumLeechers=" + getNumLeechers() + ", getNumSeeders="
				+ getNumSeeders() + ", getNumSnatches=" + getNumSnatches() + ", getNumTorrents=" + getNumTorrents() + "]";
	}
}
