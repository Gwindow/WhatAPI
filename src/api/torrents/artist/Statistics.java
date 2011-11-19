/**
 * @author Gwindow
 */
package api.torrents.artist;


/**
 * The Class Statistics.
 */
public class Statistics {
	private Number numGroups;
	private Number numLeechers;
	private Number numSeeders;
	private Number numSnatches;
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
