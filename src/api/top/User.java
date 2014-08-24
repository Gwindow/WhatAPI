package api.top;

/**
 * Information about a top user
 */
public class User {
	/**
	 * The user's id
	 */
	private Integer id;

	/**
	 * The user's name
	 * TODO The API seems to always return null for the username?
	 */
	private String username;

	/**
	 * The total bytes the user has uploaded
	 */
	private Number uploaded;

	/**
	 * The average upload speed of the user in bytes/sec
	 */
	private Number upSpeed;

	/**
	 * The number of bytes downloaded by the user
	 */
	private Number downloaded;

	/**
	 * The average download speed of the user in bytes/sec
	 */
	private Number downSpeed;

	/**
	 * The number of uploads the user has made
	 */
	private Integer numUploads;

	/**
	 * The date the user joined
	 */
	private String joinDate;

	public Integer getId(){
		return id;
	}

	public String getUsername(){
		return username;
	}

	public Number getUploaded(){
		return uploaded;
	}

	public Number getUpSpeed(){
		return upSpeed;
	}

	public Number getDownloaded(){
		return downloaded;
	}

	public Number getDownSpeed(){
		return downSpeed;
	}

	public Integer getNumUploads(){
		return numUploads;
	}

	public String getJoinDate(){
		return joinDate;
	}

	@Override
	public String toString(){
		return "top.User [ id = " + id + ", username = " + username + ", uploaded = " + uploaded
			+ ", upSpeed = " + upSpeed + ", downloaded = " + downloaded + ", downSpeed = " + downSpeed
			+ ", numUploads = " + numUploads + ", joinDate = " + joinDate + " ]";
	}
}
