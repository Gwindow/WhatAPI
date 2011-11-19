/**
 * @author Gwindow
 */
package api.whatstatus;

/**
 * The Class Status.
 */
public class Status {
	private String irc;
	private String site;
	private String tracker;

	/**
	 * Gets the irc.
	 * 
	 * @return the irc
	 */
	public int getIrc() {
		if ((irc.equalsIgnoreCase("up"))) {
			System.out.println("IRC Up");
			return 0;
		} else if ((irc.equalsIgnoreCase("down"))) {
			System.out.println("IRC Down");
			return 1;
		} else {
			System.out.println("IRC Maintenance");
			return 2;
		}
	}

	/**
	 * Gets the site.
	 * 
	 * @return the site
	 */
	public int getSite() {
		if ((site.equalsIgnoreCase("up"))) {
			System.out.println("Site Up");
			return 0;
		} else if ((site.equalsIgnoreCase("down"))) {
			System.out.println("Site Down");
			return 1;
		} else {
			System.out.println("Site Maintenance");
			return 2;
		}
	}

	/**
	 * Gets the tracker.
	 * 
	 * @return the tracker
	 */
	public int getTracker() {
		if ((tracker.equalsIgnoreCase("up"))) {
			System.out.println("Tracker Up");
			return 0;
		} else if ((tracker.equalsIgnoreCase("down"))) {
			System.out.println("Tracker Down");
			return 1;
		} else {
			System.out.println("Tracker Maintenance");
			return 2;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Status [getIrc()=" + getIrc() + ", getSite()=" + getSite() + ", getTracker()=" + getTracker() + "]";
	}
}
