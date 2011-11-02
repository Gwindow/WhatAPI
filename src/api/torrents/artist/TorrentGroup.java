package api.torrents.artist;

import java.util.List;

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

	public String getGroupCatalogueNumber() {
		return this.groupCatalogueNumber;
	}

	public String getGroupId() {
		return this.groupId;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public String getGroupRecordLabel() {
		return this.groupRecordLabel;
	}

	public String getGroupVanityHouse() {
		return this.groupVanityHouse;
	}

	public String getGroupYear() {
		return this.groupYear;
	}

	public boolean isBookmarked() {
		return this.isBookmarked;
	}

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

	public List<String> getTags() {
		return this.tags;
	}

	public List<Torrent> getTorrents() {
		return this.torrent;
	}

	@Override
	public String toString() {
		return "Torrentgroup [getGroupCatalogueNumber=" + getGroupCatalogueNumber() + ", getGroupId=" + getGroupId()
				+ ", getGroupName=" + getGroupName() + ", getGroupRecordLabel=" + getGroupRecordLabel()
				+ ", getGroupVanityHouse=" + getGroupVanityHouse() + ", getGroupYear=" + getGroupYear() + ", isBookmarked="
				+ isBookmarked() + ", getReleaseType=" + getReleaseType() + ", getTags=" + getTags() + ", getTorrents="
				+ getTorrents() + "]";
	}
}
