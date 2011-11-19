/**
 * @author Gwindow
 */
package api.user;

/**
 * User's stats.
 * 
 * @author Tim
 */
public class Stats {
	private String downloaded;
	private String joinedDate;
	private String lastAccess;
	private Number ratio;
	private String requiredRatio;
	private String uploaded;

	/**
	 * Gets the downloaded.
	 * 
	 * @return the downloaded
	 */
	public String getDownloaded() {
		return this.downloaded;
	}

	/**
	 * Gets the joined date.
	 * 
	 * @return the joined date
	 */
	public String getJoinedDate() {
		return this.joinedDate;
	}

	/**
	 * Gets the last access.
	 * 
	 * @return the last access
	 */
	public String getLastAccess() {
		return this.lastAccess;
	}

	/**
	 * Gets the ratio.
	 * 
	 * @return the ratio
	 */
	public Number getRatio() {
		return this.ratio;
	}

	/**
	 * Gets the required ratio.
	 * 
	 * @return the required ratio
	 */
	public String getRequiredRatio() {
		return this.requiredRatio;
	}

	/**
	 * Gets the uploaded.
	 * 
	 * @return the uploaded
	 */
	public String getUploaded() {
		return this.uploaded;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Stats [downloaded=" + downloaded + ", joinedDate=" + joinedDate + ", lastAccess=" + lastAccess + ", ratio="
				+ ratio + ", requiredRatio=" + requiredRatio + ", uploaded=" + uploaded + "]";
	}
}
