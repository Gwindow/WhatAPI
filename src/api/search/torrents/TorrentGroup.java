package api.search.torrents;

import java.util.List;

/**
 * The Class TorrentGroup
 * Describes a TorrentGroup as returned to us in a
 * torrent search
 * 
 * @author Gwindow
 */
public class TorrentGroup {
	/** If the group is bookmarked. */
	private boolean bookmarked;

	/** The torrent group id. */
	private Number groupId;

	/** The torrent group name. */
	private String groupName;

	/** The time the torrent group was created. */
	private String groupTime;

	/** The time the group media was released. */
	private Number groupYear;

	/** The size of the biggest torrent in the group, in bytes. */
	private Number maxSize;

	/** The release type. */
	private String releaseType;

	/** The group tags */
	private List<String> tags;

	/** The torrents in the group. */
	private List<Torrent> torrents;

	/** The total number of leechers. */
	private Number totalLeechers;

	/** The total number of seeders. */
	private Number totalSeeders;

	/** The total number of snatches. */
	private Number totalSnatched;

	/** If the torrent is vanity house. */
	private boolean vanityHouse;

	/** The artist name. */
	private String artist;

	/**
	 * The album cover
	 */
	private String cover;

	/**
	 * Check if the torrent group is bookmarked
	 * 
	 * @return True if the group is bookmarked
	 */
	public boolean isBookmarked() {
		return bookmarked;
	}

	/**
	 * Get the torrent group id.
	 * 
	 * @return the group id
	 */
	public Number getGroupId() {
		return groupId;
	}

	/**
	 * Get the torrent group name.
	 * 
	 * @return the group name
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * Get the time the torrent group was created
	 * 
	 * @return the group creation time
	 */
	public String getGroupTime() {
		return groupTime;
	}

	/**
	 * Get the year the torrent media was released
	 * 
	 * @return the release year
	 */
	public Number getGroupYear() {
		return groupYear;
	}

	/**
	 * Get the size of the biggest torrent in the group, in bytes
	 * 
	 * @return size of the biggest torrent in the group
	 */
	public Number getMaxSize() {
		return maxSize;
	}

	/**
	 * Get the release type.
	 * 
	 * @return the release type
	 */
	public String getReleaseType() {
		return releaseType;
	}

	/**
	 * Get the group tags
	 * 
	 * @return the tags
	 */
	public List<String> getTags() {
		return tags;
	}

	/**
	 * Get the torrents in the group
	 * 
	 * @return the torrents
	 */
	public List<Torrent> getTorrents() {
		return torrents;
	}

	/**
	 * Get the total number of leechers
	 * 
	 * @return the total number of leechers
	 */
	public Number getTotalLeechers() {
		return totalLeechers;
	}

	/**
	 * Gets the total seeders.
	 * 
	 * @return the total seeders
	 */
	public Number getTotalSeeders() {
		return this.totalSeeders;
	}

	/**
	 * Get the total number of snatches
	 * 
	 * @return the total number of snatches
	 */
	public Number getTotalSnatched() {
		return totalSnatched;
	}

	/**
	 * Check if the group is a vanity house torrent
	 * 
	 * @return True if the group is a vanity house release
	 */
	public boolean isVanityHouse() {
		return vanityHouse;
	}

	/**
	 * Get the artist name
	 * 
	 * @return the artist name
	 */
	public String getArtist() {
		return artist;
	}

	public String getCover(){
		return cover;
	}

	@Override
	public String toString() {
		return "TorrentGroup [isBookmarked()=" + isBookmarked() + ", getGroupId()=" + getGroupId() + ", getGroupName()="
				+ getGroupName() + ", getGroupTime()=" + getGroupTime() + ", getGroupYear()=" + getGroupYear()
				+ ", getMaxSize()=" + getMaxSize() + ", getReleaseType()=" + getReleaseType() + ", getTags()=" + getTags()
				+ ", getTorrents()=" + getTorrents() + ", getTotalLeechers()=" + getTotalLeechers() + ", getTotalSeeders()="
				+ getTotalSeeders() + ", getTotalSnatched()=" + getTotalSnatched() + ", isVanityHouse()=" + isVanityHouse()
				+ ", getArtist()=" + getArtist() + "]";
	}

}
