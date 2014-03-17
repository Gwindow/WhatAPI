package api.requests;

import java.util.List;

/**
 * The Class Response.
 * The API response data for torrent Requests
 *
 * @author Gwindow
 */
public class Response {
	/**
	 * The list of acceptable bitrates
	 */
	private List<String> bitrateList;

	/**
	 * If we can edit the request
	 */
	private boolean canEdit;

	/**
	 * If we can vote on the request
	 */
	private boolean canVote;

	/**
	 * The catalogue number.
	 */
	private String catalogueNumber;

	/**
	 * The id of the torrent category
	 */
	private Number categoryId;

	/**
	 * The category of the torrent (Music/etc.).
	 */
	private String categoryName;

	/**
	 * The comment page number being viewed
	 */
	private Number commentPage;

	/**
	 * The comment number of comment pages
	 */
	private Number commentPages;

	/**
	 * The comments
	 */
	private List<Comment> comments;

	/**
	 * The description.
	 */
	private String description;

	/**
	 * The filler's user id
	 */
	private Number fillerId;

	/**
	 * The filler's user name.
	 */
	private String fillerName;

	/**
	 * The acceptable media format list (Lossless/MP3/etc)
	 */
	private List<String> formatList;

	/**
	 * The url for the image for the request
	 */
	private String image;

	/**
	 * If the request has been filled
	 */
	private boolean isFilled;

	/**
	 * The last time the request was voted on
	 */
	private String lastVote;

	/**
	 * The log cue.
	 */
	private String logCue;

	/**
	 * The list of acceptable media formats
	 */
	private List<String> mediaList;

	/**
	 * The minimum bounty required to vote, in bytes
	 */
	private Number minimumVote;

	/**
	 * The information about the musicians who made the desired media
	 */
	private MusicInfo musicInfo;

	/**
	 * The release type.
	 */
	private Number releaseType;

	/**
	 * The request id.
	 */
	private Number requestId;

	/**
	 * The request tax deducted by the system when voting.
	 */
	private Number requestTax;

	/**
	 * The requestor's user id
	 */
	private Number requestorId;

	/**
	 * The requestor's user name.
	 */
	private String requestorName;

	/**
	 * The tags for the request
	 */
	private List<String> tags;

	/**
	 * The time the request was added.
	 */
	private String timeAdded;

	/**
	 * The time the request was filled
	 */
	private String timeFilled;

	/**
	 * The title.
	 */
	private String title;

	/**
	 * The top contributors to the bounty
	 */
	private List<TopContributor> topContributors;

	/**
	 * The torrent id of the torrent that filled the request.
	 */
	private Number torrentId;

	/**
	 * The total bounty, in bytes
	 */
	private Number totalBounty;

	/**
	 * The vote count.
	 */
	private Number voteCount;

	/**
	 * The year the desired media was released
	 */
	private Number year;

	/**
	 * The release name.
	 */
	private String releaseName;

	/**
	 * Get the release name.
	 *
	 * @return the release name
	 */
	public String getReleaseName(){
		return releaseName;
	}

	/**
	 * Get the list of acceptable bitrates
	 *
	 * @return acceptable bitrates
	 */
	public List<String> getBitrateList(){
		return bitrateList;
	}

	/**
	 * Check if we can edit the request
	 *
	 * @return True if we can edit it
	 */
	public boolean canEdit(){
		return canEdit;
	}

	/**
	 * Check if we can vote on the request
	 *
	 * @return True if we can vote
	 */
	public boolean canVote(){
		return canVote;
	}

	/**
	 * Get the catalogue number.
	 *
	 * @return the catalogue number
	 */
	public String getCatalogueNumber(){
		return catalogueNumber;
	}

	/**
	 * Get the id of the torrent category
	 *
	 * @return the category id
	 */
	public Number getCategoryId(){
		return categoryId;
	}

	/**
	 * Get the name of the torrent category (Music/etc)
	 *
	 * @return the category name
	 */
	public String getCategoryName(){
		return categoryName;
	}

	/**
	 * Get the current comment page number being viewed
	 *
	 * @return the comment page number
	 */
	public Number getCommentPage(){
		return commentPage;
	}

	/**
	 * Get the total number of pages of comments
	 *
	 * @return the number of comment pages
	 */
	public Number getCommentPages(){
		return commentPages;
	}

	/**
	 * Get the comments.
	 *
	 * @return the comments
	 */
	public List<Comment> getComments(){
		return comments;
	}

	/**
	 * Get the request description
	 *
	 * @return the description
	 */
	public String getDescription(){
		return description;
	}

	/**
	 * Get the filler's user id
	 *
	 * @return the filler's user id
	 */
	public Number getFillerId(){
		return fillerId;
	}

	/**
	 * Gets the filler's user name.
	 *
	 * @return the filler's user name
	 */
	public String getFillerName(){
		return fillerName;
	}

	/**
	 * Get the acceptable file format list
	 *
	 * @return the acceptable format list
	 */
	public List<String> getFormatList(){
		return formatList;
	}

	/**
	 * Get the image url
	 *
	 * @return the image
	 */
	public String getImage(){
		return image;
	}

	/**
	 * Check if the request has been filled
	 *
	 * @return True if the request is filled
	 */
	public boolean isFilled(){
		return isFilled;
	}

	/**
	 * Get the last vote time
	 *
	 * @return the time of last vote
	 */
	public String getLastVote(){
		return lastVote;
	}

	/**
	 * Gets the log cue.
	 *
	 * @return the log cue
	 */
	public String getLogCue(){
		return logCue;
	}

	/**
	 * Get the list of acceptable media
	 *
	 * @return the list of acceptable media
	 */
	public List<String> getMediaList(){
		return mediaList;
	}

	/**
	 * Get the minimum bounty cost of a vote, in bytes
	 *
	 * @return the minimum vote cost
	 */
	public Number getMinimumVote(){
		return minimumVote;
	}

	/**
	 * Get the information about the musicians who made the desired media
	 *
	 * @return the musician information
	 */
	public MusicInfo getMusicInfo(){
		return musicInfo;
	}

	/**
	 * Get the acceptable release type
	 *
	 * @return the release type
	 */
	public Number getReleaseType(){
		return releaseType;
	}

	/**
	 * Get the request id.
	 *
	 * @return the request id
	 */
	public Number getRequestId(){
		return requestId;
	}

	/**
	 * Get the tax applied when adding to the bounty
	 *
	 * @return the request tax
	 */
	public Number getRequestTax(){
		return requestTax;
	}

	/**
	 * Get the requestor's user id
	 *
	 * @return the requestor's user id
	 */
	public Number getRequestorId(){
		return requestorId;
	}

	/**
	 * Gets the requestor's user name.
	 *
	 * @return the requestor's user name
	 */
	public String getRequestorName(){
		return requestorName;
	}

	/**
	 * Get the tags for the request
	 *
	 * @return the tags
	 */
	public List<String> getTags(){
		return tags;
	}

	/**
	 * Get the time the request was added
	 *
	 * @return the time the request was added
	 */
	public String getTimeAdded(){
		return timeAdded;
	}

	/**
	 * Get the time the request was filled
	 *
	 * @return the time filled
	 */
	public String getTimeFilled(){
		return timeFilled;
	}

	/**
	 * Get the title of the request
	 *
	 * @return the title
	 */
	public String getTitle(){
		return title;
	}

	/**
	 * Get the top bounty contributors.
	 *
	 * @return the top contributors
	 */
	public List<TopContributor> getTopContributors(){
		return topContributors;
	}

	/**
	 * Get the torrent id that filled the request
	 *
	 * @return the torrent id
	 */
	public Number getTorrentId(){
		return torrentId;
	}

	/**
	 * Get the total bounty, in bytes
	 *
	 * @return the total bounty
	 */
	public Number getTotalBounty(){
		return totalBounty;
	}

	/**
	 * Get the vote count
	 *
	 * @return the vote count
	 */
	public Number getVoteCount(){
		return voteCount;
	}

	/**
	 * Get the year the desired media was released
	 *
	 * @return the release year of the media
	 */
	public Number getYear(){
		return year;
	}

	@Override
	public String toString(){
		return "Response [getBitrateList=" + getBitrateList() + ", getCanEdit=" + canEdit() + ", getCanVote=" + canVote()
			+ ", getCatalogueNumber=" + getCatalogueNumber() + ", getCategoryId=" + getCategoryId() + ", getCategoryName="
			+ getCategoryName() + ", getCommentPage=" + getCommentPage() + ", getCommentPages=" + getCommentPages()
			+ ", getComments=" + getComments() + ", getDescription=" + getDescription() + ", getFillerId=" + getFillerId()
			+ ", getFillerName=" + getFillerName() + ", getFormatList=" + getFormatList() + ", getImage=" + getImage()
			+ ", filled=" + isFilled() + ", getLastVote=" + getLastVote() + ", getLogCue=" + getLogCue()
			+ ", getMediaList=" + getMediaList() + ", getMinimumVote=" + getMinimumVote() + ", getMusicInfo="
			+ getMusicInfo() + ", getReleaseType=" + getReleaseType() + ", getRequestId=" + getRequestId()
			+ ", getRequestTax=" + getRequestTax() + ", getRequestorId=" + getRequestorId() + ", getRequestorName="
			+ getRequestorName() + ", getTags=" + getTags() + ", getTimeAdded=" + getTimeAdded() + ", getTimeFilled="
			+ getTimeFilled() + ", getTitle=" + getTitle() + ", getTopContributors=" + getTopContributors()
			+ ", getTorrentId=" + getTorrentId() + ", getTotalBounty=" + getTotalBounty() + ", getVoteCount="
			+ getVoteCount() + ", getYear=" + getYear() + "]";
	}
}
