package api.torrents.torrents;

/**
 * The Class Group.
 * 
 * @author Gwindow
 */
public class Group {
	
	/** The catalogue number. */
	private String catalogueNumber;
	
	/** The category id. */
	private Number categoryId;
	
	/** The id. */
	private Number id;
	
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
	private String year;

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
	public String getYear() {
		return this.year;
	}
}
