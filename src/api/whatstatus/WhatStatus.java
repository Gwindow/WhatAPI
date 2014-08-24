package api.whatstatus;

import api.son.MySon;

/**
 * The Class WhatStatus.
 * 
 * Checks the status of What.CD using the site whatstatus.info
 * 
 * @author Gwindow
 */
public class WhatStatus {
	/**
	 * The irc.
	 */
	private String irc;

	/**
	 * The site.
	 */
	private String site;

	/**
	 * The tracker.
	 */
	private String tracker;

	/**
	 * Load the WhatStatus information
	 *
	 * @return the what status
	 */
	public static WhatStatus status(){
		String url = "https://whatstatus.info/api/status";
		return (WhatStatus) MySon.toObjectOther(url, WhatStatus.class);
	}

	/**
	 * Check if the site is up
	 *
	 * @return true if the site is up
	 */
	public boolean siteUp(){
		return site.equalsIgnoreCase("1");
	}

	/**
	 * Check if the IRC is up
	 *
	 * @return true if the IRC is up
	 */
	public boolean ircUp(){
		return irc.equalsIgnoreCase("1");
	}

	/**
	 * Check if the tracker is up
	 *
	 * @return true if the tracker is up
	 */
	public boolean trackerUp(){
		return tracker.equalsIgnoreCase("1");
	}

	@Override
	public String toString(){
		return "Status [getIrc()=" + irc + ", getSite()=" + site + ", getTracker()=" + tracker + "]";
	}
}
