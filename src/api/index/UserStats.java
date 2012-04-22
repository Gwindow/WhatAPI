



package api.index;

import com.google.gson.annotations.SerializedName;

/**
 * The Class UserStats.
 * 
 * @author Gwindow
 */
public class UserStats {
	
	/** The downloaded. */
	private Number downloaded;
	
	/** The ratio. */
	private Number ratio;
	
	/** The requiredratio. */
	private Number requiredratio;
	
	/** The uploaded. */
	private Number uploaded;
	
	/** The user class. */
	@SerializedName("class")
	private String userClass;

	/**
	 * Gets the downloaded.
	 * 
	 * @return the downloaded
	 */
	public Number getDownloaded() {
		return this.downloaded;
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
	 * Gets the requiredratio.
	 * 
	 * @return the requiredratio
	 */
	public Number getRequiredratio() {
		return this.requiredratio;
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
	 * Gets the user class.
	 * 
	 * @return the user class
	 */
	public String getUserClass() {
		return this.userClass;
	}

	/**
	 * Gets the buffer.
	 * 
	 * @return the buffer
	 */
	public Number getBuffer() {
		double up = uploaded.doubleValue();
		double down = downloaded.doubleValue();
		double buffer = up - down;
		return buffer;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserStats [getDownloaded=" + getDownloaded() + ", getRatio=" + getRatio() + ", getRequiredratio="
				+ getRequiredratio() + ", getUploaded=" + getUploaded() + ", getUserClass=" + getUserClass() + ", getBuffer="
				+ getBuffer() + "]";
	}

}
