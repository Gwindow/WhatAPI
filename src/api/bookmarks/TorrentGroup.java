package api.bookmarks;

import java.util.List;

/**
 * The class TorrentGroup
 * Describes a bookmarked torrent group, includes
 * a list of the torrents in the group
 * 
 * @author Gwindow
 */
public class TorrentGroup {
	/** The catalogue number. */
	private String catalogueNumber;

	/** The torrent group id */
	private Number id;

	/** The album name */
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

	/** The release year */
	private Number year;

    /** The image url */
	private String image;

	/**
	 * Get the catalogue number.
	 * 
	 * @return the catalogue number
	 */
	public String getCatalogueNumber() {
		return this.catalogueNumber;
	}

	/**
	 * Get the torrent group id.
	 * 
	 * @return the id
	 */
	public Number getId() {
		return this.id;
	}

	/**
	 * Get the album name name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Get the record label.
	 * 
	 * @return the record label
	 */
	public String getRecordLabel() {
		return this.recordLabel;
	}

	/**
	 * Get the release type.
	 * 
	 * @return the release type
	 */
	public String getReleaseType() {
		return this.releaseType;
	}

	/**
	 * Get the tag list.
	 * 
	 * @return the tags
	 */
	public String getTagList() {
		return this.tagList;
	}

	/**
	 * Get the list of torrents in the torrent group
	 * 
	 * @return list of torrents
	 */
	public List<Torrent> getTorrents() {
		return this.torrents;
	}

	/**
	 * Check if the torrent group is vanity house
	 * 
	 * @return True if the torrent is vanity house
	 */
	public boolean isVanityHouse() {
		return vanityHouse;
	}

	/**
	 * Get the release year.
	 * 
	 * @return the year
	 */
	public Number getYear() {
		return this.year;
	}

    /**
     * Get the image url
     *
     * @return the image url
     */
	public String getImage() {
		return this.image;
	}

	@Override
	public String toString() {
		return "TorrentGroup [getCatalogueNumber()=" + getCatalogueNumber() + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getRecordLabel()=" + getRecordLabel() + ", getReleaseType()=" + getReleaseType() + ", getTagList()="
				+ getTagList() + ", getTorrents()=" + getTorrents() + ", isVanityHouse()=" + isVanityHouse() + ", getYear()="
				+ getYear() + ", getImage()=" + getImage() + "]";
	}
}
