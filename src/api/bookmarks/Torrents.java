
package api.bookmarks;

import java.util.List;

/**
 * Each Bookmark in the bookmark list.
 * 
 * @author Gwindow
 */
public class Torrents {

	/** The catalogue number. */
	private String catalogueNumber;

	/** The id. */
	private Number id;

	/** The name. */
	private String name;

	/** The record label. */
	private String recordLabel;

	/** The release type. */
	private String releaseType;

	/** The tag list. */
	private String tagList;

	/** The torrents. */
	private List<Torrent> torrents;

	/** The vanity house. */
	private boolean vanityHouse;

	/** The year. */
	private Number year;

	/**
	 * Gets the catalogue number.
	 * 
	 * @return the catalogue number
	 */
	public String getCatalogueNumber() {
		return this.catalogueNumber;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Number getId() {
		return this.id;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the record label.
	 * 
	 * @return the record label
	 */
	public String getRecordLabel() {
		return this.recordLabel;
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
	 * Gets the tag list.
	 * 
	 * @return the tags
	 */
	public String getTagList() {
		return this.tagList;
	}

	/**
	 * Get a list of the torrents under the bookmark.
	 * 
	 * @return list of torrents
	 */
	public List<Torrent> getTorrents() {
		return this.torrents;
	}

	/**
	 * Returns true if bookmark is under vanity house.
	 * 
	 * @return is under vanity house
	 */
	public boolean isVanityHouse() {
		return vanityHouse;
	}

	/**
	 * Gets the year.
	 * 
	 * @return the year
	 */
	public Number getYear() {
		return this.year;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BookmarksList [getCatalogueNumber=" + getCatalogueNumber() + ", getId=" + getId() + ", getName=" + getName()
				+ ", getRecordLabel=" + getRecordLabel() + ", getReleaseType=" + getReleaseType() + ", getTagList="
				+ getTagList() + ", getTorrents=" + getTorrents() + ", isVanityHouse=" + isVanityHouse() + ", getYear="
				+ getYear() + "]";
	}
}
