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
		String url = "http://whatstatus.info/json.php";
		WhatStatus ws = (WhatStatus) MySon.toObjectOther(url, WhatStatus.class);
		return ws;
	}

	/**
	 * Gets the status.
	 * 
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/* public ArrayList<Tuple<String, String>> getTweets() { ArrayList<Tuple<String, String>> tweetList = new
	 * ArrayList<Tuple<String, String>>(); try { Twitter unauthenticatedTwitter = new TwitterFactory().getInstance(); //
	 * get the first 6 tweets on the first page Paging paging = new Paging(1, 6); List<twitter4j.Status> status; status
	 * = unauthenticatedTwitter.getUserTimeline("whatcd", paging);
	 * 
	 * for (int i = 0; i < status.size(); i++) { tweetList.add(new Tuple<String, String>(status.get(i).getText(),
	 * status.get(i).getCreatedAt().toString())); } return tweetList; } catch (TwitterException e) {
	 * e.printStackTrace(); } return null; } */

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "WhatStatus [getStatus()=" + getStatus() + "]";
	}
}
