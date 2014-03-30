package api.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * User's stats.
 *
 * @author Tim
 */
public class Stats {
	/**
	 * Format that dates are returned (site uses GMT time)
	 */
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * The downloaded.
	 */
	private Number downloaded;

	/**
	 * The joined date.
	 */
	private String joinedDate;
	private transient Date joined;

	/**
	 * The last access.
	 */
	private String lastAccess;
	private transient Date accessed;

	/**
	 * The ratio from the api. Must be a string to handle the case where ratio is infinity
	 */
	private String ratio;
	/**
	 * When getRatio is called for the first time we parse the ratio string into this number
	 * and then return it for future calls
	 */
	private transient Number r = null;

	/**
	 * The required ratio.
	 */
	private Number requiredRatio;

	/**
	 * The uploaded.
	 */
	private Number uploaded;

	/**
	 * Gets the downloaded.
	 *
	 * @return the downloaded
	 */
	public Number getDownloaded(){
		return this.downloaded;
	}

	/**
	 * Gets the joined date string
	 *
	 * @return the joined date
	 */
	public String getJoinedString(){
		return this.joinedDate;
	}

	public Date getJoinedDate(){
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		if (joined == null){
			try {
				joined = dateFormat.parse(joinedDate);
			}
			catch (ParseException e){
				e.printStackTrace();
			}
		}
		return joined;
	}

	/**
	 * Gets the last access.
	 *
	 * @return the last access
	 */
	public String getLastAccess(){
		return this.lastAccess;
	}

	public Date getAccessedDate(){
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		if (accessed == null){
			try {
				accessed = dateFormat.parse(lastAccess);
			}
			catch (ParseException e){
				e.printStackTrace();
			}
		}
		return accessed;
	}

	/**
	 * Gets the ratio.
	 *
	 * @return the ratio
	 */
	public Number getRatio(){
		//If the ratio was the infinity character change it to Infinity
		//so that it can be parsed
		if (r == null && ratio != null){
			if (ratio.equalsIgnoreCase("\u221e")){
				ratio = "Infinity";
			}
			r = Double.parseDouble(ratio);
		}
		return r;
	}

	/**
	 * Gets the required ratio.
	 *
	 * @return the required ratio
	 */
	public Number getRequiredRatio(){
		return this.requiredRatio;
	}

	/**
	 * Gets the uploaded.
	 *
	 * @return the uploaded
	 */
	public Number getUploaded(){
		return this.uploaded;
	}

	/**
	 * Gets the buffer.
	 *
	 * @return the buffer
	 */
	public double getBuffer(){
		if (getUploaded() != null && getDownloaded() != null)
			return getUploaded().doubleValue() - getDownloaded().doubleValue();
		else
			return 0;
	}

	@Override
	public String toString(){
		return "Stats [getDownloaded=" + getDownloaded() + ", getJoinedDate=" + getJoinedDate() + ", getLastAccess="
			+ getLastAccess() + ", getRatio=" + getRatio() + ", getRequiredRatio=" + getRequiredRatio() + ", getUploaded="
			+ getUploaded() + ", getBuffer=" + getBuffer() + "]";
	}
}
