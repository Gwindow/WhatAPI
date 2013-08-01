package api.whatstatus;

/**
 * The Class Status.
 * See https://whatstatus.info/about for information about the api
 * @author Gwindow
 */
public class Status {
	
	/** The irc. */
	private String irc;
	
	/** The site. */
	private String site;
	
	/** The tracker. */
	private String tracker;

	/**
	 * Gets the irc status information
	 * 1 = up, 0 = down
	 * @return the irc status
	 */
	public int getIrc() {
		return Integer.parseInt(irc);
	}

	/**
	 * Gets the site status information
	 * 1 = up, 0 = down
	 * @return the site status
	 */
	public int getSite() {
		return Integer.parseInt(site);
	}

	/**
	 * Gets the tracker status information
	 * 1 = up, 0 = down
	 * @return the tracker status
	 */
	public int getTracker() {
		return Integer.parseInt(tracker);
	}

	/**
	 * Check if the site is up
	 * @return true if the site is up
	 */
	public boolean siteUp(){
		return getSite() == 1;
	}

	/**
	 * Check if the IRC is up
	 * @return true if the IRC is up
	 */
	public boolean ircUp(){
		return getIrc() == 1;
	}

	/**
	 * Check if the tracker is up
	 * @return true if the tracker is up
	 */
	public boolean trackerUp(){
		return getTracker() == 1;
	}

	@Override
	public String toString() {
		return "Status [getIrc()=" + getIrc() + ", getSite()=" + getSite() + ", getTracker()=" + getTracker() + "]";
	}
}
