package api.search.requests;

/**
 * The Class Results.
 * 
 * @author Gwindow
 */
public class Results {

	/** The artist. */
	private String artist;

	/** The bitrate list. */
	private String bitrateList;

	/** The catalogue number. */
	private String catalogueNumber;

	/** The category id. */
	private Number categoryId;

	/** The description. */
	private String description;

	/** The filler id. */
	private Number fillerId;

	/** The fillter name. */
	private String fillterName;

	/** The format list. */
	private String formatList;

	/** The image. */
	private String image;

	/** The is filled. */
	private boolean isFilled;

	/** The last vote. */
	private String lastVote;

	/** The log cue. */
	private String logCue;

	/** The media list. */
	private String mediaList;

	/** The release type. */
	private String releaseType;

	/** The request id. */
	private Number requestId;

	/** The requestor id. */
	private Number requestorId;

	/** The requestor name. */
	private String requestorName;

	/** The time added. */
	private String timeAdded;

	/** The time filled. */
	private String timeFilled;

	/** The title. */
	private String title;

	/** The torrent id. */
	private Number torrentId;

	/** The year. */
	private Number year;

	/**
	 * Gets the artist.
	 * 
	 * @return the artist
	 */
	public String getArtist() {
		return this.artist;
	}

	/**
	 * Gets the bitrate list.
	 * 
	 * @return the bitrate list
	 */
	public String getBitrateList() {
		return this.bitrateList;
	}

	/**
	 * Gets the catalogue number.
	 * 
	 * @return the catalogue number
	 */
	public String getCatalogueNumber() {
		return this.catalogueNumber;
	}

	/**
	 * Gets the category id.
	 * 
	 * @return the category id
	 */
	public Number getCategoryId() {
		return this.categoryId;
	}

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Gets the filler id.
	 * 
	 * @return the filler id
	 */
	public Number getFillerId() {
		return this.fillerId;
	}

	/**
	 * Gets the fillter name.
	 * 
	 * @return the fillter name
	 */
	public String getFillterName() {
		return this.fillterName;
	}

	/**
	 * Gets the format list.
	 * 
	 * @return the format list
	 */
	public String getFormatList() {
		return this.formatList;
	}

	/**
	 * Gets the image.
	 * 
	 * @return the image
	 */
	public String getImage() {
		return this.image;
	}

	/**
	 * Gets the checks if is filled.
	 * 
	 * @return the checks if is filled
	 */
	public boolean getIsFilled() {
		return this.isFilled;
	}

	/**
	 * Gets the last vote.
	 * 
	 * @return the last vote
	 */
	public String getLastVote() {
		return this.lastVote;
	}

	/**
	 * Gets the log cue.
	 * 
	 * @return the log cue
	 */
	public String getLogCue() {
		return this.logCue;
	}

	/**
	 * Gets the media list.
	 * 
	 * @return the media list
	 */
	public String getMediaList() {
		return this.mediaList;
	}

	/**
	 * Gets the release type.
	 * 
	 * @return the release type
	 */
	public String getReleaseType() {
		return this.releaseType;
	}

	/**
	 * Gets the request id.
	 * 
	 * @return the request id
	 */
	public Number getRequestId() {
		return this.requestId;
	}

	/**
	 * Gets the requestor id.
	 * 
	 * @return the requestor id
	 */
	public Number getRequestorId() {
		return this.requestorId;
	}

	/**
	 * Gets the requestor name.
	 * 
	 * @return the requestor name
	 */
	public String getRequestorName() {
		return this.requestorName;
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
	 * Gets the time filled.
	 * 
	 * @return the time filled
	 */
	public String getTimeFilled() {
		return this.timeFilled;
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
	 * Gets the torrent id.
	 * 
	 * @return the torrent id
	 */
	public Number getTorrentId() {
		return this.torrentId;
	}

	/**
	 * Gets the year.
	 * 
	 * @return the year
	 */
	public Number getYear() {
		return this.year;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Results [getArtist()=" + getArtist() + ", getBitrateList()=" + getBitrateList() + ", getCatalogueNumber()="
				+ getCatalogueNumber() + ", getCategoryId()=" + getCategoryId() + ", getDescription()=" + getDescription()
				+ ", getFillerId()=" + getFillerId() + ", getFillterName()=" + getFillterName() + ", getFormatList()="
				+ getFormatList() + ", getImage()=" + getImage() + ", getIsFilled()=" + getIsFilled() + ", getLastVote()="
				+ getLastVote() + ", getLogCue()=" + getLogCue() + ", getMediaList()=" + getMediaList() + ", getReleaseType()="
				+ getReleaseType() + ", getRequestId()=" + getRequestId() + ", getRequestorId()=" + getRequestorId()
				+ ", getRequestorName()=" + getRequestorName() + ", getTimeAdded()=" + getTimeAdded() + ", getTimeFilled()="
				+ getTimeFilled() + ", getTitle()=" + getTitle() + ", getTorrentId()=" + getTorrentId() + ", getYear()="
				+ getYear() + "]";
	}
}
