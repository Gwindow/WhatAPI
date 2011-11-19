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
	private String groupId;
	private String groupName;
	private String groupRecordLabel;
	private String groupVanityHouse;
	private String groupYear;
	private boolean isBookmarked;
	private String releaseType;
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
	public String getGroupId() {
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
	 * Gets the group vanity house.
	 * 
	 * @return the group vanity house
	 */
	public String getGroupVanityHouse() {
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
	public String getReleaseType() {
		if (releaseType.equalsIgnoreCase("1"))
			return "Album";
		else if (releaseType.equalsIgnoreCase("3"))
			return "Soundtrack";
		else if (releaseType.equalsIgnoreCase("5"))
			return "EP";
		else if (releaseType.equalsIgnoreCase("6"))
			return "Anthology";
		else if (releaseType.equalsIgnoreCase("7"))
			return "Compilation";
		else if (releaseType.equalsIgnoreCase("9"))
			return "Single";
		else if (releaseType.equalsIgnoreCase("11"))
			return "Live Album";
		else if (releaseType.equalsIgnoreCase("13"))
			return "Remix";
		else if (releaseType.equalsIgnoreCase("14"))
			return "Bootleg";
		else if (releaseType.equalsIgnoreCase("15"))
			return "Interview";
		else if (releaseType.equalsIgnoreCase("16"))
			return "Mixtape";
		else if (releaseType.equalsIgnoreCase("21"))
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
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Torrentgroup [getGroupCatalogueNumber=" + getGroupCatalogueNumber() + ", getGroupId=" + getGroupId()
				+ ", getGroupName=" + getGroupName() + ", getGroupRecordLabel=" + getGroupRecordLabel()
				+ ", getGroupVanityHouse=" + getGroupVanityHouse() + ", getGroupYear=" + getGroupYear() + ", isBookmarked="
				+ isBookmarked() + ", getReleaseType=" + getReleaseType() + ", getTags=" + getTags() + ", getTorrents="
				+ getTorrents() + "]";
	}
}
