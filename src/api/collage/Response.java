package api.collage;

import java.util.List;

/**
 * Response stores the actual information returned by the API about
 * the collage
 */
public class Response {
	/**
	 * id of the loaded collage
	 */
	private Integer id;
	/**
	 * Name of the collage. This will be an HTML formatted string
	 */
	private String name;
	/**
	 * Collage description text. This will be an HTML formatted string
	 */
	private String description;
	/**
	 * User id of the creator of the collage
	 */
	private Integer creatorID;
	/**
	 * If the collage is deleted
	 * TODO: Do we care?
	 */
	private Boolean deleted;
	/**
	 * ID of the category the collage belongs too
	 */
	private Integer collageCategoryID;
	/**
	 * Name of the category the collage belongs too
	 */
	private String collageCategoryName;
	/**
	 * If the collage is locked
	 */
	private Boolean locked;
	/**
	 * Max groups field. TODO: Unsure what this is for?
	 */
	private Integer maxGroups;
	/**
	 * Max groups per user. TODO: Again unsure what this field means
	 */
	private Integer maxGroupsPerUser;
	/**
	 * If we've bookmarked this collage
	 */
	private Boolean hasBookmarked;
	/**
	 * Number of people subscribing to this collage
	 */
	private Integer subscriberCount;
	/**
	 * Torrent Groups in the collage
	 */
	private List<TorrentGroup> torrentgroups;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Integer getCreatorID() {
		return creatorID;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public Integer getCollageCategoryID() {
		return collageCategoryID;
	}

	public String getCollageCategoryName() {
		return collageCategoryName;
	}

	public Boolean getLocked() {
		return locked;
	}

	public Integer getMaxGroups() {
		return maxGroups;
	}

	public Integer getMaxGroupsPerUser() {
		return maxGroupsPerUser;
	}

	public Boolean getHasBookmarked() {
		return hasBookmarked;
	}

	public Integer getSubscriberCount() {
		return subscriberCount;
	}

	public List<TorrentGroup> getTorrentgroups() {
		return torrentgroups;
	}

	@Override
	public String toString() {
		return "collage.Response [ id = " + id + ", name = " + name + ", description = " + description
				+ ", creatorID = " + creatorID + ", deleted = " + deleted + ", collageCategoryID = " + collageCategoryID
				+ ", collageCategoryName = " + collageCategoryName + ", locked = " + locked + ", maxGroups = " + maxGroups
				+ ", maxGroupsPerUser = " + maxGroupsPerUser + ", hasBookmarked = " + hasBookmarked
				+ ", subscriberCount = " + subscriberCount + " \ntorrentgroups = \n" + torrentgroups + " ]";
	}
}
