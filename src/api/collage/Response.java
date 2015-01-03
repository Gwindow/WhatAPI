package api.collage;

import api.util.Tuple;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

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

	/**
	 * Compute and return the top 5 tags for the collage
	 *
	 * @return the top 5 tags in the collage and their frequencies. Fewer than 5 tags
	 * may be returned if the collage has less than 5 tags
	 */
	public List<Tuple<String, Integer>> topTags() {
		Hashtable<String, Integer> tags = new Hashtable<String, Integer>();
		for (TorrentGroup group : torrentgroups) {
			List<String> groupTags = group.getTags();
			for (String t : groupTags) {
				Integer count = tags.get(t);
				if (count == null) {
					tags.put(t, 1);
				} else {
					tags.put(t, count + 1);
				}
			}
		}
		// Find the top 5 tags
		List<Tuple<String, Integer>> top = new ArrayList<Tuple<String, Integer>>(5);
		for (Map.Entry<String, Integer> t : tags.entrySet()) {
			if (top.size() < 5) {
				top.add(new Tuple<String, Integer>(t.getKey(), t.getValue()));
			} else {
				// Find if there's an element in the list that has a frequency lower than
				// this tag and replace it
				for (Tuple<String, Integer> k : top) {
					if (k.getB() < t.getValue()) {
						k.set(t.getKey(), t.getValue());
						break;
					}
				}
			}
		}
		return top;
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
