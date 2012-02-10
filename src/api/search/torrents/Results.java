package api.search.torrents;

import java.util.List;

public class Results {
	private boolean bookmarked;
	private Number groupId;
	private String groupName;
	private Number groupTime;
	private Number groupYear;
	private Number maxSize;
	private String releaseType;
	private List<String> tags;
	private List<Torrents> torrents;
	private Number totalLeechers;
	private Number totalSeeders;
	private Number totalSnatched;
	private Boolean vanityHouse;

	public boolean getBookmarked() {
		return this.bookmarked;
	}

	public Number getGroupId() {
		return this.groupId;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public Number getGroupTime() {
		return this.groupTime;
	}

	public Number getGroupYear() {
		return this.groupYear;
	}

	public Number getMaxSize() {
		return this.maxSize;
	}

	public String getReleaseType() {
		return this.releaseType;
	}

	public List<String> getTags() {
		return this.tags;
	}

	public List<Torrents> getTorrents() {
		return this.torrents;
	}

	public Number getTotalLeechers() {
		return this.totalLeechers;
	}

	public Number getTotalSeeders() {
		return this.totalSeeders;
	}

	public Number getTotalSnatched() {
		return this.totalSnatched;
	}

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
