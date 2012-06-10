package api.search.torrents;

import java.util.List;

/**
 * The Class Torrents.
 * 
 * //TODO description
 * 
 * @author Gwindow
 */
public class Torrents {

	/** The can use token. */
	private boolean canUseToken;

	/** The edition id. */
	private Number editionId;

	/** The encoding. */
	private String encoding;

	/** The file count. */
	private Number fileCount;

	/** The format. */
	private String format;

	/** The has cue. */
	private boolean hasCue;

	/** The has log. */
	private boolean hasLog;

	/** The is freeleech. */
	private boolean isFreeleech;

	/** The is neutral leech. */
	private boolean isNeutralLeech;

	/** The is personal freeleech. */
	private boolean isPersonalFreeleech;

	/** The leechers. */
	private Number leechers;

	/** The log score. */
	private Number logScore;

	/** The media. */
	private String media;

	/** The remaster catalogue number. */
	private String remasterCatalogueNumber;

	/** The remaster title. */
	private String remasterTitle;

	/** The remaster year. */
	private Number remasterYear;

	/** The remastered. */
	private boolean remastered;

	/** The scene. */
	private boolean scene;

	/** The seeders. */
	private Number seeders;

	/** The size. */
	private Number size;

	/** The snatches. */
	private Number snatches;

	/** The time. */
	private String time;

	/** The torrent id. */
	private Number torrentId;

	/** The vanity house. */
	private boolean vanityHouse;

	private List<Artists> artists;

	public List<Artists> getArtists() {
		return this.artists;
	}

	/**
	 * Gets the can use token.
	 * 
	 * @return the can use token
	 */
	public boolean getCanUseToken() {
		return this.canUseToken;
	}

	/**
	 * Gets the edition id.
	 * 
	 * @return the edition id
	 */
	public Number getEditionId() {
		return this.editionId;
	}

	/**
	 * Gets the encoding.
	 * 
	 * @return the encoding
	 */
	public String getEncoding() {
		return this.encoding;
	}

	/**
	 * Gets the file count.
	 * 
	 * @return the file count
	 */
	public Number getFileCount() {
		return this.fileCount;
	}

	/**
	 * Gets the format.
	 * 
	 * @return the format
	 */
	public String getFormat() {
		return this.format;
	}

	/**
	 * Gets the checks for cue.
	 * 
	 * @return the checks for cue
	 */
	public boolean getHasCue() {
		return this.hasCue;
	}

	/**
	 * Gets the checks for log.
	 * 
	 * @return the checks for log
	 */
	public boolean getHasLog() {
		return this.hasLog;
	}

	/**
	 * Gets the checks if is freeleech.
	 * 
	 * @return the checks if is freeleech
	 */
	public boolean getIsFreeleech() {
		return this.isFreeleech;
	}

	/**
	 * Gets the checks if is neutral leech.
	 * 
	 * @return the checks if is neutral leech
	 */
	public boolean getIsNeutralLeech() {
		return this.isNeutralLeech;
	}

	/**
	 * Gets the checks if is personal freeleech.
	 * 
	 * @return the checks if is personal freeleech
	 */
	public boolean getIsPersonalFreeleech() {
		return this.isPersonalFreeleech;
	}

	/**
	 * Gets the leechers.
	 * 
	 * @return the leechers
	 */
	public Number getLeechers() {
		return this.leechers;
	}

	/**
	 * Gets the log score.
	 * 
	 * @return the log score
	 */
	public Number getLogScore() {
		return this.logScore;
	}

	/**
	 * Gets the media.
	 * 
	 * @return the media
	 */
	public String getMedia() {
		return this.media;
	}

	/**
	 * Gets the remaster catalogue number.
	 * 
	 * @return the remaster catalogue number
	 */
	public String getRemasterCatalogueNumber() {
		return this.remasterCatalogueNumber;
	}

	/**
	 * Gets the remaster title.
	 * 
	 * @return the remaster title
	 */
	public String getRemasterTitle() {
		return this.remasterTitle;
	}

	/**
	 * Gets the remaster year.
	 * 
	 * @return the remaster year
	 */
	public Number getRemasterYear() {
		return this.remasterYear;
	}

	/**
	 * Gets the remastered.
	 * 
	 * @return the remastered
	 */
	public boolean getRemastered() {
		return this.remastered;
	}

	/**
	 * Gets the scene.
	 * 
	 * @return the scene
	 */
	public boolean getScene() {
		return this.scene;
	}

	/**
	 * Gets the seeders.
	 * 
	 * @return the seeders
	 */
	public Number getSeeders() {
		return this.seeders;
	}

	/**
	 * Gets the size.
	 * 
	 * @return the size
	 */
	public Number getSize() {
		return this.size;
	}

	/**
	 * Gets the snatches.
	 * 
	 * @return the snatches
	 */
	public Number getSnatches() {
		return this.snatches;
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
	 * Gets the torrent id.
	 * 
	 * @return the torrent id
	 */
	public Number getTorrentId() {
		return this.torrentId;
	}

	/**
	 * Gets the vanity house.
	 * 
	 * @return the vanity house
	 */
	public boolean getVanityHouse() {
		return this.vanityHouse;
	}

	@Override
	public String toString() {
		return "Torrents [getArtists()=" + getArtists() + ", getCanUseToken()=" + getCanUseToken() + ", getEditionId()="
				+ getEditionId() + ", getEncoding()=" + getEncoding() + ", getFileCount()=" + getFileCount() + ", getFormat()="
				+ getFormat() + ", getHasCue()=" + getHasCue() + ", getHasLog()=" + getHasLog() + ", getIsFreeleech()="
				+ getIsFreeleech() + ", getIsNeutralLeech()=" + getIsNeutralLeech() + ", getIsPersonalFreeleech()="
				+ getIsPersonalFreeleech() + ", getLeechers()=" + getLeechers() + ", getLogScore()=" + getLogScore()
				+ ", getMedia()=" + getMedia() + ", getRemasterCatalogueNumber()=" + getRemasterCatalogueNumber()
				+ ", getRemasterTitle()=" + getRemasterTitle() + ", getRemasterYear()=" + getRemasterYear()
				+ ", getRemastered()=" + getRemastered() + ", getScene()=" + getScene() + ", getSeeders()=" + getSeeders()
				+ ", getSize()=" + getSize() + ", getSnatches()=" + getSnatches() + ", getTime()=" + getTime()
				+ ", getTorrentId()=" + getTorrentId() + ", getVanityHouse()=" + getVanityHouse() + "]";
	}

}
