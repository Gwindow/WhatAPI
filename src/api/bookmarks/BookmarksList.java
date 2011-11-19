package api.bookmarks;

import java.util.List;

/**
 * Each Bookmark in the bookmark list
 * 
 * 
 */
public class BookmarksList {
	private Number catalogueNumber;
	private Number id;
	private String name;
	private String recordLabel;
	private String releaseType;
	private String tagList;
	private List<Torrent> torrents;
	private boolean vanityHouse;
	private String year;

	/**
	 * 
	 * @return the catalogue number
	 */
	public Number getCatalogueNumber() {
		return this.catalogueNumber;
	}

	/**
	 * 
	 * @return the id
	 */
	public Number getId() {
		return this.id;
	}

	/**
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @return the record label
	 */
	public String getRecordLabel() {
		return this.recordLabel;
	}

	/**
	 * 
	 * @return the release type
	 */
	public String getReleaseType() {
		return this.releaseType;
	}

	/**
	 * 
	 * @return the tags
	 */
	public String getTagList() {
		return this.tagList;
	}

	/**
	 * Get a list of the torrents under the bookmark
	 * 
	 * @return list of torrents
	 */
	public List<Torrent> getTorrents() {
		return this.torrents;
	}

	/**
	 * Returns true if bookmark is under vanity house
	 * 
	 * @return is under vanity house
	 */
	public boolean isVanityHouse() {
		return vanityHouse;
	}

	/**
	 * 
	 * @return the year
	 */
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
