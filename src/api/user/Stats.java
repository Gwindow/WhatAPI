package api.user;

/**
 * User's stats.
 * 
 * @author Tim
 */
public class Stats {

	/** The downloaded. */
	private Number downloaded;

	/** The joined date. */
	private String joinedDate;

	/** The last access. */
	private String lastAccess;

	/** The ratio. */
	private Number ratio;

	/** The required ratio. */
	private Number requiredRatio;

	/** The uploaded. */
	private Number uploaded;

	/**
	 * Gets the downloaded.
	 * 
	 * @return the downloaded
	 */
	public Number getDownloaded() {
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
	public Number getRequiredRatio() {
		return this.requiredRatio;
	}

	/**
	 * Gets the uploaded.
	 * 
	 * @return the uploaded
	 */
	public Number getUploaded() {
		return this.uploaded;
	}

	/**
	 * Gets the buffer.
	 * 
	 * @return the buffer
	 */
	public double getBuffer() {
		if (getUploaded() != null && getDownloaded() != null)
			return getUploaded().doubleValue() - getDownloaded().doubleValue();
		else
			return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Stats [getDownloaded=" + getDownloaded() + ", getJoinedDate=" + getJoinedDate() + ", getLastAccess="
				+ getLastAccess() + ", getRatio=" + getRatio() + ", getRequiredRatio=" + getRequiredRatio() + ", getUploaded="
				+ getUploaded() + ", getBuffer=" + getBuffer() + "]";
	}
}
