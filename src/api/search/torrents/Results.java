
package api.search.torrents;

import java.util.List;

/**
 * The Class Results.
 * 
 * //TODO description
 * 
 * @author Gwindow
 */
public class Results {
	
	/** The bookmarked. */
	private boolean bookmarked;
	
	/** The group id. */
	private Number groupId;
	
	/** The group name. */
	private String groupName;
	
	/** The group time. */
	private Number groupTime;
	
	/** The group year. */
	private Number groupYear;
	
	/** The max size. */
	private Number maxSize;
	
	/** The release type. */
	private String releaseType;
	
	/** The tags. */
	private List<String> tags;
	
	/** The torrents. */
	private List<Torrents> torrents;
	
	/** The total leechers. */
	private Number totalLeechers;
	
	/** The total seeders. */
	private Number totalSeeders;
	
	/** The total snatched. */
	private Number totalSnatched;
	
	/** The vanity house. */
	private Boolean vanityHouse;

	/**
	 * Gets the bookmarked.
	 * 
	 * @return the bookmarked
	 */
	public boolean getBookmarked() {
		return this.bookmarked;
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
	 * Gets the group time.
	 * 
	 * @return the group time
	 */
	public Number getGroupTime() {
		return this.groupTime;
	}

	/**
	 * Gets the group year.
	 * 
	 * @return the group year
	 */
	public Number getGroupYear() {
		return this.groupYear;
	}

	/**
	 * Gets the max size.
	 * 
	 * @return the max size
	 */
	public Number getMaxSize() {
		return this.maxSize;
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
	public List<Torrents> getTorrents() {
		return this.torrents;
	}

	/**
	 * Gets the total leechers.
	 * 
	 * @return the total leechers
	 */
	public Number getTotalLeechers() {
		return this.totalLeechers;
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
	 * Gets the total snatched.
	 * 
	 * @return the total snatched
	 */
	public Number getTotalSnatched() {
		return this.totalSnatched;
	}

	/**
	 * Gets the vanity house.
	 * 
	 * @return the vanity house
	 */
	public Boolean getVanityHouse() {
		return this.vanityHouse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Results [getBookmarked()=" + getBookmarked() + ", getGroupId()=" + getGroupId() + ", getGroupName()="
				+ getGroupName() + ", getGroupTime()=" + getGroupTime() + ", getGroupYear()=" + getGroupYear()
				+ ", getMaxSize()=" + getMaxSize() + ", getReleaseType()=" + getReleaseType() + ", getTags()=" + getTags()
				+ ", getTorrents()=" + getTorrents() + ", getTotalLeechers()=" + getTotalLeechers() + ", getTotalSeeders()="
				+ getTotalSeeders() + ", getTotalSnatched()=" + getTotalSnatched() + ", getVanityHouse()=" + getVanityHouse()
				+ "]";
	}
}
