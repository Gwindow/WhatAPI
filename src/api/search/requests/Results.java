package api.search.requests;


public class Results {
	// private List<Artists> artists;
	private String bitrateList;
	private Number bounty;
	private String catalogueNumber;
	private Number categoryId;
	private String categoryName;
	private String description;
	private Number fillerId;
	private String fillerName;
	private String formatList;
	private String image;
	private boolean isFilled;
	private String lastVote;
	private String logCue;
	private String mediaList;
	private String releaseType;
	private Number requestId;
	private Number requestorId;
	private String requestorName;
	private String timeAdded;
	private String timeFilled;
	private String title;
	private Number torrentId;
	private Number voteCount;
	private Number year;

	/*
	 * public List<Artists> getArtists() { return this.artists; }
	 */
	public String getBitrateList() {
		return this.bitrateList;
	}

	public Number getBounty() {
		return this.bounty;
	}

	public String getCatalogueNumber() {
		return this.catalogueNumber;
	}

	public Number getCategoryId() {
		return this.categoryId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public String getDescription() {
		return this.description;
	}

	public Number getFillerId() {
		return this.fillerId;
	}

	public String getFillerName() {
		return this.fillerName;
	}

	public String getFormatList() {
		return this.formatList;
	}

	public String getImage() {
		return this.image;
	}

	public boolean getIsFilled() {
		return this.isFilled;
	}

	public String getLastVote() {
		return this.lastVote;
	}

	public String getLogCue() {
		return this.logCue;
	}

	public String getMediaList() {
		return this.mediaList;
	}

	public String getReleaseType() {
		return this.releaseType;
	}

	public Number getRequestId() {
		return this.requestId;
	}

	public Number getRequestorId() {
		return this.requestorId;
	}

	public String getRequestorName() {
		return this.requestorName;
	}

	public String getTimeAdded() {
		return this.timeAdded;
	}

	public String getTimeFilled() {
		return this.timeFilled;
	}

	public String getTitle() {
		return this.title;
	}

	public Number getTorrentId() {
		return this.torrentId;
	}

	public Number getVoteCount() {
		return this.voteCount;
	}

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
		return "Results [getArtists=" + "" + ", getBitrateList=" + getBitrateList() + ", getBounty=" + getBounty()
				+ ", getCatalogueNumber=" + getCatalogueNumber() + ", getCategoryId=" + getCategoryId() + ", getCategoryName="
				+ getCategoryName() + ", getDescription=" + getDescription() + ", getFillerId=" + getFillerId()
				+ ", getFillerName=" + getFillerName() + ", getFormatList=" + getFormatList() + ", getImage=" + getImage()
				+ ", getIsFilled=" + getIsFilled() + ", getLastVote=" + getLastVote() + ", getLogCue=" + getLogCue()
				+ ", getMediaList=" + getMediaList() + ", getReleaseType=" + getReleaseType() + ", getRequestId="
				+ getRequestId() + ", getRequestorId=" + getRequestorId() + ", getRequestorName=" + getRequestorName()
				+ ", getTimeAdded=" + getTimeAdded() + ", getTimeFilled=" + getTimeFilled() + ", getTitle=" + getTitle()
				+ ", getTorrentId=" + getTorrentId() + ", getVoteCount=" + getVoteCount() + ", getYear=" + getYear() + "]";
	}
}
