/**
 * @author Gwindow
 */
package api.torrents.artist;

import java.util.List;

/**
 * The Class TorrentGroup.
 */
public class TorrentGroup {
	private String groupCatalogueNumber;
	private Number groupId;
	private String groupName;
	private String groupRecordLabel;
	private boolean groupVanityHouse;
	private String groupYear;
	private boolean isBookmarked;
	private Number releaseType;
	private List<String> tags;
	private List<Torrent> torrent;

	/**
	 * Gets the group catalogue number.
	 * 
	 * @return the group catalogue number
	 */
	public String getGroupCatalogueNumber() {
		return this.groupCatalogueNumber;
	}

	/**
	 * Gets the group id.
	 * 
	 * @return the group id
	 */
	public Number getGroupId() {
		return this.groupId;
	}

	/**
	 * Gets the group name.
	 * 
	 * @return the group name
	 */
	public String getGroupName() {
		return this.groupName;
	}

	/**
	 * Gets the group record label.
	 * 
	 * @return the group record label
	 */
	public String getGroupRecordLabel() {
		return this.groupRecordLabel;
	}

	/**
	 * Checks if is group vanity house.
	 * 
	 * @return true, if is group vanity house
	 */
	public boolean isGroupVanityHouse() {
		return this.groupVanityHouse;
	}

	/**
	 * Gets the group year.
	 * 
	 * @return the group year
	 */
	public String getGroupYear() {
		return this.groupYear;
	}

	/**
	 * Checks if is bookmarked.
	 * 
	 * @return true, if is bookmarked
	 */
	public boolean isBookmarked() {
		return this.isBookmarked;
	}

	/**
	 * Gets the release type.
	 * 
	 * @return the release type
	 */
	public String getreleaseType() {
		if (releaseType.toString().equalsIgnoreCase("1"))
			return "Album";
		else if (releaseType.toString().equalsIgnoreCase("3"))
			return "Soundtrack";
		else if (releaseType.toString().equalsIgnoreCase("5"))
			return "EP";
		else if (releaseType.toString().equalsIgnoreCase("6"))
			return "Anthology";
		else if (releaseType.toString().equalsIgnoreCase("7"))
			return "Compilation";
		else if (releaseType.toString().equalsIgnoreCase("9"))
			return "Single";
		else if (releaseType.toString().equalsIgnoreCase("11"))
			return "Live Album";
		else if (releaseType.toString().equalsIgnoreCase("13"))
			return "Remix";
		else if (releaseType.toString().equalsIgnoreCase("14"))
			return "Bootleg";
		else if (releaseType.toString().equalsIgnoreCase("15"))
			return "Interview";
		else if (releaseType.toString().equalsIgnoreCase("16"))
			return "Mixtape";
		else if (releaseType.toString().equalsIgnoreCase("21"))
			return "Unknown";
		else
			return "API Error";

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
	 * Gets the torrents.
	 * 
	 * @return the torrents
	 */
	public List<Torrent> getTorrents() {
		return this.torrent;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Torrentgroup [getGroupCatalogueNumber=" + getGroupCatalogueNumber() + ", getGroupId=" + getGroupId()
				+ ", getGroupName=" + getGroupName() + ", getGroupRecordLabel=" + getGroupRecordLabel()
				+ ", getGroupVanityHouse=" + isGroupVanityHouse() + ", getGroupYear=" + getGroupYear() + ", isBookmarked="
				+ isBookmarked() + ", getreleaseType.toString()=" + getreleaseType() + ", getTags=" + getTags()
				+ ", getTorrents=" + getTorrents() + "]";
	}
}
