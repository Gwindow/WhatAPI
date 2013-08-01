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
	/** The status. */
	private Status status;

	/**
	 * Inits the.
	 * 
	 * @return the what status
	 */
	public static WhatStatus init() {
		String url = "http://whatstatus.info/api/status";
		return (WhatStatus) MySon.toObjectOther(url, WhatStatus.class);
	}

	/**
	 * Gets the status.
	 * 
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "WhatStatus [getStatus()=" + getStatus() + "]";
	}
}
