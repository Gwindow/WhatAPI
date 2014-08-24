package api.whatstatus;

import api.son.MySon;

/**
 * Get information about the various site service uptime in hours
 * using the whatstatus API
 */
public class WhatUptime {
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
	public static WhatUptime uptime(){
		String url = "https://whatstatus.info/api/uptime";
		return (WhatUptime)MySon.toObjectOther(url, WhatUptime.class);
	}

	/**
	 * Get the site uptime in hours
	 */
	public Integer site(){
		return Integer.parseInt(site);
	}

	/**
	 * Get the IRC uptime in hours
	 */
	public Integer irc(){
		return Integer.parseInt(irc);
	}

	/**
	 * Get the tracker uptime in hours
	 */
	public Integer tracker(){
		return Integer.parseInt(tracker);
	}

	@Override
	public String toString(){
		return "Status [getIrc()=" + irc + ", getSite()=" + site + ", getTracker()=" + tracker + "]";
	}
}
