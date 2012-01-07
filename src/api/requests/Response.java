package api.requests;

import java.util.List;

/**
 * The Class Response.
 * 
 * //TODO description
 * 
 * @author Gwindow
 */
public class Response {

	/** The bitrate list. */
	private String bitrateList;

	/** The can edit. */
	private boolean canEdit;

	/** The can vote. */
	private boolean canVote;

	/** The catalogue number. */
	private String catalogueNumber;

	/** The category id. */
	private Number categoryId;

	/** The category name. */
	private String categoryName;

	/** The comment page. */
	private Number commentPage;

	/** The comment pages. */
	private Number commentPages;

	/** The comments. */
	private List<Comments> comments;

	/** The description. */
	private String description;

	/** The filler id. */
	private Number fillerId;

	/** The filler name. */
	private String fillerName;

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

	/** The minimum vote. */
	private Number minimumVote;

	/** The music info. */
	private MusicInfo musicInfo;

	/** The release type. */
	private Number releaseType;

	/** The request id. */
	private Number requestId;

	/** The request tax. */
	private Number requestTax;

	/** The requestor id. */
	private Number requestorId;

	/** The requestor name. */
	private String requestorName;

	/** The tags. */
	private List<String> tags;

	/** The time added. */
	private String timeAdded;

	/** The time filled. */
	private String timeFilled;

	/** The title. */
	private String title;

	/** The top contributors. */
	private List<TopContributors> topContributors;

	/** The torrent id. */
	private Number torrentId;

	/** The total bounty. */
	private Number totalBounty;

	/** The vote count. */
	private Number voteCount;

	/** The year. */
	private Number year;

	/** The release name. */
	private String releaseName;

	/**
	 * Gets the release name.
	 * 
	 * @return the releaseName
	 */
	public String getReleaseName() {
		return releaseName;
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
	 * Gets the can edit.
	 * 
	 * @return the can edit
	 */
	public boolean canEdit() {
		return this.canEdit;
	}

	/**
	 * Gets the can vote.
	 * 
	 * @return the can vote
	 */
	public boolean canVote() {
		return this.canVote;
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
	 * Gets the category name.
	 * 
	 * @return the category name
	 */
	public String getCategoryName() {
		return this.categoryName;
	}

	/**
	 * Gets the comment page.
	 * 
	 * @return the comment page
	 */
	public Number getCommentPage() {
		return this.commentPage;
	}

	/**
	 * Gets the comment pages.
	 * 
	 * @return the comment pages
	 */
	public Number getCommentPages() {
		return this.commentPages;
	}

	/**
	 * Gets the comments.
	 * 
	 * @return the comments
	 */
	public List<Comments> getComments() {
		return this.comments;
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
	 * Gets the filler name.
	 * 
	 * @return the filler name
	 */
	public String getFillerName() {
		return this.fillerName;
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
	public boolean isFilled() {
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
	 * Gets the minimum vote.
	 * 
	 * @return the minimum vote
	 */
	public Number getMinimumVote() {
		return this.minimumVote;
	}

	/**
	 * Gets the music info.
	 * 
	 * @return the music info
	 */
	public MusicInfo getMusicInfo() {
		return this.musicInfo;
	}

	/**
	 * Gets the release type.
	 * 
	 * @return the release type
	 */
	public Number getReleaseType() {
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
	 * Gets the request tax.
	 * 
	 * @return the request tax
	 */
	public Number getRequestTax() {
		return this.requestTax;
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
	 * Gets the tags.
	 * 
	 * @return the tags
	 */
	public List<String> getTags() {
		return this.tags;
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
	 * Gets the top contributors.
	 * 
	 * @return the top contributors
	 */
	public List<TopContributors> getTopContributors() {
		return this.topContributors;
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
	 * Gets the total bounty.
	 * 
	 * @return the total bounty
	 */
	public Number getTotalBounty() {
		return this.totalBounty;
	}

	/**
	 * Gets the vote count.
	 * 
	 * @return the vote count
	 */
	public Number getVoteCount() {
		return this.voteCount;
	}

	/**
	 * Gets the year.
	 * 
	 * @return the year
	 */
	public Number getYear() {
		return this.year;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Response [getBitrateList=" + getBitrateList() + ", getCanEdit=" + canEdit() + ", getCanVote=" + canVote()
				+ ", getCatalogueNumber=" + getCatalogueNumber() + ", getCategoryId=" + getCategoryId() + ", getCategoryName="
				+ getCategoryName() + ", getCommentPage=" + getCommentPage() + ", getCommentPages=" + getCommentPages()
				+ ", getComments=" + getComments() + ", getDescription=" + getDescription() + ", getFillerId=" + getFillerId()
				+ ", getFillerName=" + getFillerName() + ", getFormatList=" + getFormatList() + ", getImage=" + getImage()
				+ ", getIsFilled=" + isFilled() + ", getLastVote=" + getLastVote() + ", getLogCue=" + getLogCue()
				+ ", getMediaList=" + getMediaList() + ", getMinimumVote=" + getMinimumVote() + ", getMusicInfo="
				+ getMusicInfo() + ", getReleaseType=" + getReleaseType() + ", getRequestId=" + getRequestId()
				+ ", getRequestTax=" + getRequestTax() + ", getRequestorId=" + getRequestorId() + ", getRequestorName="
				+ getRequestorName() + ", getTags=" + getTags() + ", getTimeAdded=" + getTimeAdded() + ", getTimeFilled="
				+ getTimeFilled() + ", getTitle=" + getTitle() + ", getTopContributors=" + getTopContributors()
				+ ", getTorrentId=" + getTorrentId() + ", getTotalBounty=" + getTotalBounty() + ", getVoteCount="
				+ getVoteCount() + ", getYear=" + getYear() + "]";
	}
}
