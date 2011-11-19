/**
 * @author Gwindow
 */
package api.torrents.torrents;

/**
 * The Class TorrentGroup.
 */
public class TorrentGroup {
	private String CatalogueNumber;
	private String CategoryID;
	private String ID;
	private String Name;
	private String RecordLabel;
	private String ReleaseType;
	private String Time;
	private String VanityHouse;
	private String WikiBody;
	private String WikiImage;
	private String Year;
	private boolean hasBookmarked;

	/**
	 * Gets the catalogue number.
	 * 
	 * @return the catalogue number
	 */
	public String getCatalogueNumber() {
		return this.CatalogueNumber;
	}

	/**
	 * Gets the category id.
	 * 
	 * @return the category id
	 */
	public String getCategoryID() {
		return this.CategoryID;
	}

	/**
	 * Gets the iD.
	 * 
	 * @return the iD
	 */
	public String getID() {
		return this.ID;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.Name;
	}

	/**
	 * Gets the record label.
	 * 
	 * @return the record label
	 */
	public String getRecordLabel() {
		return this.RecordLabel;
	}

	/**
	 * Checks if is bookmarked.
	 * 
	 * @return true, if is bookmarked
	 */
	public boolean isBookmarked() {
		return this.hasBookmarked;
	}

	/**
	 * Gets the release type.
	 * 
	 * @return the release type
	 */
	public String getReleaseType() {
		if (ReleaseType.equalsIgnoreCase("1"))
			return "Album";
		else if (ReleaseType.equalsIgnoreCase("3"))
			return "Soundtrack";
		else if (ReleaseType.equalsIgnoreCase("5"))
			return "EP";
		else if (ReleaseType.equalsIgnoreCase("6"))
			return "Anthology";
		else if (ReleaseType.equalsIgnoreCase("7"))
			return "Compilation";
		else if (ReleaseType.equalsIgnoreCase("9"))
			return "Single";
		else if (ReleaseType.equalsIgnoreCase("11"))
			return "Live Album";
		else if (ReleaseType.equalsIgnoreCase("13"))
			return "Remix";
		else if (ReleaseType.equalsIgnoreCase("14"))
			return "Bootleg";
		else if (ReleaseType.equalsIgnoreCase("15"))
			return "Interview";
		else if (ReleaseType.equalsIgnoreCase("16"))
			return "Mixtape";
		else if (ReleaseType.equalsIgnoreCase("21"))
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
		return this.Time;
	}

	/**
	 * Checks if is vanity house.
	 * 
	 * @return true, if is vanity house
	 */
	public boolean isVanityHouse() {
		if (VanityHouse.equals("1"))
			return true;
		return false;
	}

	/**
	 * Gets the wiki body.
	 * 
	 * @return the wiki body
	 */
	public String getWikiBody() {
		return this.WikiBody;
	}

	/**
	 * Gets the wiki image.
	 * 
	 * @return the wiki image
	 */
	public String getWikiImage() {
		return this.WikiImage;
	}

	/**
	 * Gets the year.
	 * 
	 * @return the year
	 */
	public String getYear() {
		return this.Year;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TorrentGroup [getCatalogueNumber=" + getCatalogueNumber() + ", getCategoryID=" + getCategoryID() + ", getID="
				+ getID() + ", getName=" + getName() + ", getRecordLabel=" + getRecordLabel() + ", isBookmarked="
				+ isBookmarked() + ", getReleaseType=" + getReleaseType() + ", getTime=" + getTime() + ", isVanityHouse="
				+ isVanityHouse() + ", getWikiBody=" + getWikiBody() + ", getWikiImage=" + getWikiImage() + ", getYear="
				+ getYear() + "]";
	}

}
