/**
 * @author Gwindow
 */
package api.torrents.artist;

/**
 * The Class Requests.
 */
public class Requests {
	private String bounty;
	private String categoryId;
	private String requestId;
	private String timeAdded;
	private String title;
	private String votes;
	private String year;

	/**
	 * Gets the bounty.
	 * 
	 * @return the bounty
	 */
	public String getBounty() {
		return this.bounty;
	}

	/**
	 * Gets the category id.
	 * 
	 * @return the category id
	 */
	public String getCategoryId() {
		return this.categoryId;
	}

	/**
	 * Gets the request id.
	 * 
	 * @return the request id
	 */
	public String getRequestId() {
		return this.requestId;
	}

	/**
	 * Gets the time added.
	 * 
	 * @return the time added
	 */
	public String getTimeAdded() {
		return this.timeAdded;
	}

	/**
	 * Gets the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Gets the votes.
	 * 
	 * @return the votes
	 */
	public String getVotes() {
		return this.votes;
	}

	/**
	 * Gets the year.
	 * 
	 * @return the year
	 */
	public String getYear() {
		return this.year;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Requests [getBounty=" + getBounty() + ", getCategoryId=" + getCategoryId() + ", getRequestId=" + getRequestId()
				+ ", getTimeAdded=" + getTimeAdded() + ", getTitle=" + getTitle() + ", getVotes=" + getVotes() + ", getYear="
				+ getYear() + "]";
	}
}
