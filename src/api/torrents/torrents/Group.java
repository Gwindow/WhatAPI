package api.torrents.torrents;

/**
 * The Class Group.
 * 
 * @author Gwindow
 * @since Jun 2, 2012 12:17:19 AM
 */
public class Group {

	/** The catalogue number. */
	private String catalogueNumber;

	/** The category id. */
	private Number categoryId;

	/** The category name. */
	private String categoryName;

	/** The id. */
	private Number id;

	/** The music info. */
	private MusicInfo musicInfo;

	/** The name. */
	private String name;

	/** The record label. */
	private String recordLabel;

	/** The release type. */
	private Number releaseType;

	/** The time. */
	private String time;

	/** The vanity house. */
	private boolean vanityHouse;

	/** The wiki body. */
	private String wikiBody;

	/** The wiki image. */
	private String wikiImage;

	/** The year. */
	private Number year;

    /** If the TorrentGroup is bookmarked */
    private boolean isBookmarked;

	/**
	 * Gets the catalogue number.
	 * 
	 * @return the catalogue number
	 */
	public String getCatalogueNumber() {
		return this.catalogueNumber;
	}

	/**
	 * Gets the category id.
	 * 
	 * @return the category id
	 */
	public Number getCategoryId() {
		return this.categoryId;
	}

	/**
	 * Gets the category name.
	 * 
	 * @return the category name
	 */
	public String getCategoryName() {
		return this.categoryName;
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
	 * Gets the music info.
	 * 
	 * @return the music info
	 */
	public MusicInfo getMusicInfo() {
		return this.musicInfo;
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
	 * Gets the time.
	 * 
	 * @return the time
	 */
	public String getTime() {
		return this.time;
	}

	/**
	 * Checks if is vanity house.
	 * 
	 * @return true, if is vanity house
	 */
	public boolean isVanityHouse() {
		return this.vanityHouse;
	}

	/**
	 * Gets the wiki body.
	 * 
	 * @return the wiki body
	 */
	public String getWikiBody() {
		return this.wikiBody;
	}

	/**
	 * Gets the wiki image.
	 * 
	 * @return the wiki image
	 */
	public String getWikiImage() {
		return this.wikiImage;
	}

	/**
	 * Gets the year.
	 * 
	 * @return the year
	 */
	public Number getYear() {
		return this.year;
	}

	public String getOriginal() {
		return this.getYear() + " - Original Release" + " / " + this.getRecordLabel() + " / " + this.getCatalogueNumber();
	}

    /**
     * Check if the group is bookmarked
     *
     * @return True if torrent is bookmarked
     */
    public boolean isBookmarked(){
        return this.isBookmarked;
    }

    /**
     * Set the is bookmarked property. We only do this since if add/removeBookmark
     * succeeded we know what we changed the property too and want to update the
     * Group without having to reload the entire thing. Don't change this if you
     * don't think the API request went ok! (ie. add/remove returned false)
     *
     * @param val
     *      The val to set isBookmarked too
     */
    public void setBookmarked(boolean val){
        this.isBookmarked = val;
    }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Group [getCatalogueNumber()=" + getCatalogueNumber() + ", getCategoryId()=" + getCategoryId()
				+ ", getCategoryName()=" + getCategoryName() + ", getId()=" + getId() + ", getMusicInfo()=" + getMusicInfo()
				+ ", getName()=" + getName() + ", getRecordLabel()=" + getRecordLabel() + ", getReleaseType()="
				+ getReleaseType() + ", getTime()=" + getTime() + ", isVanityHouse()=" + isVanityHouse() + ", getWikiBody()="
				+ getWikiBody() + ", getWikiImage()=" + getWikiImage() + ", getYear()=" + getYear() + "]";
	}
}
