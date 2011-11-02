package api.bookmarks;

import java.util.List;

public class BookmarksList {
	private String catalogueNumber;
	private String id;
	private String name;
	private String recordLabel;
	private String releaseType;
	private String tagList;
	private List<Torrent> torrents;
	private String vanityHouse;
	private String year;

	public String getCatalogueNumber() {
		return this.catalogueNumber;
	}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getRecordLabel() {
		return this.recordLabel;
	}

	public String getReleaseType() {
		return this.releaseType;
	}

	public String getTagList() {
		return this.tagList;
	}

	public List<Torrent> getTorrents() {
		return this.torrents;
	}

	public boolean isVanityHouse() {
		if (vanityHouse.equalsIgnoreCase("1"))
			return true;
		return false;
	}

	public String getYear() {
		return this.year;
	}

	@Override
	public String toString() {
		return "BookmarksList [getCatalogueNumber=" + getCatalogueNumber() + ", getId=" + getId() + ", getName=" + getName()
				+ ", getRecordLabel=" + getRecordLabel() + ", getReleaseType=" + getReleaseType() + ", getTagList="
				+ getTagList() + ", getTorrents=" + getTorrents() + ", isVanityHouse=" + isVanityHouse() + ", getYear="
				+ getYear() + "]";
	}
}
