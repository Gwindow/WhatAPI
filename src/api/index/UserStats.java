package api.index;

import com.google.gson.annotations.SerializedName;

/**
 * The Class UserStats.
 * Stores information about a user's statistics
 * ratio, up/down, etc.
 * 
 * @author Gwindow
 */
public class UserStats {
    /** The number of bytes uploaded */
    private Number uploaded;

	/** The amount of bytes downloaded. */
	private Number downloaded;

	/** The ratio of up / down */
	private Number ratio;

	/** The required ratio. */
	private Number requiredratio;

	/** The user's class. */
	@SerializedName("class")
	private String userClass;

    /**
     * Get the number of bytes uploaded.
     *
     * @return number of bytes uploaded
     */
    public Number getUploaded() {
        return uploaded;
    }

	/**
	 * Get the number of bytes downloaded
	 * 
	 * @return number of bytes downloaded
	 */
	public Number getDownloaded() {
		return downloaded;
	}

	/**
	 * Get the user's ratio of up / down.
	 * 
	 * @return the ratio
	 */
	public Number getRatio() {
		return ratio;
	}

	/**
	 * Get the required ratio
	 * 
	 * @return the required ratio
	 */
	public Number getRequiredRatio() {
		return requiredratio;
	}

	/**
	 * Get the user's class
	 * 
	 * @return the user's class
	 */
	public String getUserClass() {
		return userClass;
	}

	/**
	 * Get the buffer the user has, up - down
	 * 
	 * @return size of buffer in bytes
	 */
	public Number getBuffer() {
		return (uploaded.doubleValue() - downloaded.doubleValue());
	}

	@Override
	public String toString() {
		return "UserStats [getDownloaded=" + getDownloaded() + ", getRatio=" + getRatio() + ", getRequiredratio="
				+ getRequiredRatio() + ", getUploaded=" + getUploaded() + ", getUserClass=" + getUserClass() + ", getBuffer="
				+ getBuffer() + "]";
	}

}
