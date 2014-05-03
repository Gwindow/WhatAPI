package api.search.requests;

import java.util.List;

/**
 * The Class Request.
 * Stores information about a request, as returned by
 * a Request search
 * 
 * @author Gwindow
 */
public class Request {
	/**
	 * Artists on the request. For some reason it's an array of arrays
	 * but the first array only has one entry filled, which is the array containing all
	 * the artists.
	 */
	private List<List<Artist>> artists;

	/** The acceptable bitrates. */
	private String bitrateList;

	/** The bounty, in bytes */
	private Number bounty;

	/** The catalogue number. */
	private String catalogueNumber;

	/** The id of the torrent category. */
	private Number categoryId;

	/** The category name of the torrent (Music/etc). */
	private String categoryName;

	/** The request description. */
	private String description;

	/** The filler's user id. */
	private Number fillerId;

	/** The filler's user name. */
	private String fillerName;

	/** The acceptable media format list (Lossless/MP3/etc). */
	private String formatList;

	/** The image url for the request. */
	private String image;

	/** If the request is filled. */
	private boolean isFilled;

	/** The time of the last vote. */
	private String lastVote;

	/** The log cue. */
	private String logCue;

	/** The acceptable media formats */
	private String mediaList;

	/** The release type. */
	private String releaseType;

	/** The request id. */
	private Number requestId;

	/** The requestor's user id. */
	private Number requestorId;

	/** The requestor's user name. */
	private String requestorName;

	/** The time the request was added */
	private String timeAdded;

	/** The time the request was filled */
	private String timeFilled;

	/** The title of the request. */
	private String title;

	/** The torrent id of the torrent that filled the request. */
	private Number torrentId;

	/** The total votes on the request */
	private Number voteCount;

	/** The release year of the media desired */
	private Number year;


	public List<List<Artist>> getArtists(){
		return artists;
	}

	/**
	 * Get the acceptable bitrate list
	 * 
	 * @return the acceptable bitrate list
	 */
	public String getBitrateList() {
		return bitrateList;
	}

	/**
	 * Get the total bounty on the request, in bytes
	 * 
	 * @return the bounty, in bytes
	 */
	public Number getBounty() {
		return bounty;
	}

	/**
	 * Get the catalogue number.
	 * 
	 * @return the catalogue number
	 */
	public String getCatalogueNumber() {
		return catalogueNumber;
	}

	/**
	 * Get the category id.
	 * 
	 * @return the category id
	 */
	public Number getCategoryId() {
		return categoryId;
	}

	/**
	 * Get the category name.
	 * 
	 * @return the category name
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * Get the request description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Get the filler's user id
	 * 
	 * @return the filler's user id
	 */
	public Number getFillerId() {
		return fillerId;
	}

	/**
	 * Get the filler's user name
	 * 
	 * @return the filler's user name
	 */
	public String getFillerName() {
		return fillerName;
	}

	/**
	 * Get the acceptable media format list
	 * 
	 * @return the format list
	 */
	public String getFormatList() {
		return formatList;
	}

	/**
	 * Get the url for the request image
	 * 
	 * @return the image url
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Check if the request is filled
	 * 
	 * @return True if filled
	 */
	public boolean filled() {
		return isFilled;
	}

	/**
	 * Get the last time the request was voted on
	 * 
	 * @return time of the last vote
	 */
	public String getLastVote() {
		return lastVote;
	}

	/**
	 * Get the log cue.
	 * 
	 * @return the log cue
	 */
	public String getLogCue() {
		return logCue;
	}

	/**
	 * Get the acceptable media list
	 * 
	 * @return the acceptable media list
	 */
	public String getMediaList() {
		return mediaList;
	}

	/**
	 * Get the acceptable release types
	 * 
	 * @return the acceptable release type
	 */
	public String getReleaseType() {
		return releaseType;
	}

	/**
	 * Get the request id.
	 * 
	 * @return the request id
	 */
	public Number getRequestId() {
		return requestId;
	}

	/**
	 * Get the requestor's user id
	 * 
	 * @return the requestor's user id
	 */
	public Number getRequestorId() {
		return requestorId;
	}

	/**
	 * Get the requestor's user name
	 * 
	 * @return the requestor's user name
	 */
	public String getRequestorName() {
		return requestorName;
	}

	/**
	 * Get the time the request was added
	 * 
	 * @return the time the request was added
	 */
	public String getTimeAdded() {
		return timeAdded;
	}

	/**
	 * Get the time the request was filled
	 * 
	 * @return the time the request was filled
	 */
	public String getTimeFilled() {
		return timeFilled;
	}

	/**
	 * Get the request title
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Get the torrent id of the torrent that filled the request
	 * 
	 * @return the torrent id
	 */
	public Number getTorrentId() {
		return torrentId;
	}

	/**
	 * Get the total number of votes on the request
	 * 
	 * @return the vote count
	 */
	public Number getVoteCount() {
		return voteCount;
	}

	/**
	 * Get the release year of the media requested
	 * 
	 * @return the release year of the media
	 */
	public Number getYear() {
		return year;
	}

	@Override
	public String toString() {
		return "Request [getArtists=" + "" + ", getBitrateList=" + getBitrateList() + ", getBounty=" + getBounty()
				+ ", getCatalogueNumber=" + getCatalogueNumber() + ", getCategoryId=" + getCategoryId() + ", getCategoryName="
				+ getCategoryName() + ", getDescription=" + getDescription() + ", getFillerId=" + getFillerId()
				+ ", getFillerName=" + getFillerName() + ", getFormatList=" + getFormatList() + ", getImage=" + getImage()
			+ ", filled=" + filled() + ", getLastVote=" + getLastVote() + ", getLogCue=" + getLogCue()
				+ ", getMediaList=" + getMediaList() + ", getReleaseType=" + getReleaseType() + ", getRequestId="
				+ getRequestId() + ", getRequestorId=" + getRequestorId() + ", getRequestorName=" + getRequestorName()
				+ ", getTimeAdded=" + getTimeAdded() + ", getTimeFilled=" + getTimeFilled() + ", getTitle=" + getTitle()
				+ ", getTorrentId=" + getTorrentId() + ", getVoteCount=" + getVoteCount() + ", getYear=" + getYear() + "]";
	}
}
