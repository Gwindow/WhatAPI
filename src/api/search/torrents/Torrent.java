package api.search.torrents;

import java.util.List;

/**
 * The Class Torrent.
 * Describes a single torrent in a TorrentGroup returned to
 * us by the TorrentSearch
 * 
 * @author Gwindow
 */
public class Torrent {
    /** The artists who made the media */
    private List<Artist> artists;

	/** If we can use a token on the torrent. */
	private boolean canUseToken;

	/** The edition id. TODO: What is this? */
	private Number editionId;

	/** The media encoding. (Lossless/Lossy/etc) */
	private String encoding;

	/** The number of files in the torrent. */
	private Number fileCount;

	/** The file format of the torrent (FLAC/MP3/etc). */
	private String format;

	/** If the torrent has a cue file. */
	private boolean hasCue;

	/** If the torrent has a log file. */
	private boolean hasLog;

	/** If the torrent is freeleech. */
	private boolean isFreeleech;

	/** If the torrent is neutral leech. */
	private boolean isNeutralLeech;

	/** If the torrent is personal free leech. */
	private boolean isPersonalFreeleech;

	/** The number of leechers. */
	private Number leechers;

	/** The log score. */
	private Number logScore;

	/** The media the torrent was ripped from. */
	private String media;

	/** The remaster catalogue number. */
	private String remasterCatalogueNumber;

	/** The remaster title. */
	private String remasterTitle;

	/** The remaster year. */
	private Number remasterYear;

	/** If the torrent is remastered */
	private boolean remastered;

	/** If the torrent is a scene release */
	private boolean scene;

	/** The number of seeders. */
	private Number seeders;

	/** The size of the torrent, in bytes. */
	private Number size;

	/** The number of snatches. */
	private Number snatches;

	/** The time the torrent was uploaded. */
	private String time;

	/** The torrent id. */
	private Number torrentId;

	/** If the torrent is vanity house. */
	private boolean vanityHouse;

    /**
     * Get the artists who made the torrent media
     *
     * @return the artists
     */
	public List<Artist> getArtists() {
		return artists;
	}

	/**
	 * Check if we can use a free leech token on the torrent
	 * 
	 * @return True if we can use a token
	 */
	public boolean canUseToken() {
		return canUseToken;
	}

	/**
	 * Get the edition id.
	 * 
	 * @return the edition id
	 */
	public Number getEditionId() {
		return editionId;
	}

	/**
	 * Get the media encoding (Lossless/Lossy/etc)
	 * 
	 * @return the encoding
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * Get the number of files in the torrent
	 * 
	 * @return the file count
	 */
	public Number getFileCount() {
		return fileCount;
	}

	/**
	 * Get the file format of the torrent
	 * 
	 * @return the file format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * Check if the torrent has a cue file
	 * 
	 * @return True if it has a cue file
	 */
	public boolean hasCue() {
		return hasCue;
	}

	/**
	 * Check if the torrent has a log file
	 * 
	 * @return True if the torrent has a log file
	 */
	public boolean hasLog() {
		return hasLog;
	}

	/**
	 * Check if the torrent is freeleech
	 * 
	 * @return True if torrent is freeleech
	 */
	public boolean isFreeleech() {
		return isFreeleech;
	}

	/**
	 * Check if the torrent is neutral leech
	 * 
	 * @return True if torrent is neutral leech
	 */
	public boolean isNeutralLeech() {
		return isNeutralLeech;
	}

	/**
	 * Check if the torrent is personal freeleech
	 * 
	 * @return True if torrent is personal freeleech
	 */
	public boolean isPersonalFreeleech() {
		return isPersonalFreeleech;
	}

	/**
	 * Get the number of leechers
	 * 
	 * @return the number of leechers
	 */
	public Number getLeechers() {
		return leechers;
	}

	/**
	 * Get the log score
	 * 
	 * @return the log score
	 */
	public Number getLogScore() {
		return logScore;
	}

	/**
	 * Get the media the torrent was ripped from
	 * 
	 * @return the media type
	 */
	public String getMedia() {
		return media;
	}

	/**
	 * Get the remaster catalogue number.
	 * 
	 * @return the remaster catalogue number
	 */
	public String getRemasterCatalogueNumber() {
		return remasterCatalogueNumber;
	}

	/**
	 * Get the remaster title.
	 * 
	 * @return the remaster title
	 */
	public String getRemasterTitle() {
		return remasterTitle;
	}

	/**
	 * Get the remaster year.
	 * 
	 * @return the remaster year
	 */
	public Number getRemasterYear() {
		return remasterYear;
	}

	/**
	 * Check if the torrent is remastered
	 * 
	 * @return True if it's a remastered release
	 */
	public boolean isRemastered() {
		return remastered;
	}

	/**
	 * Check if the torrent is a scene release
	 * 
	 * @return True if it's a scene release
	 */
	public boolean isScene() {
		return scene;
	}

	/**
	 * Get the number of seeders
	 * 
	 * @return the number of seeders
	 */
	public Number getSeeders() {
		return seeders;
	}

	/**
	 * Get the size of the torrent, in bytes
	 * 
	 * @return the size in bytes
	 */
	public Number getSize() {
		return size;
	}

	/**
	 * Get the number of snatches
	 * 
	 * @return the number of snatches
	 */
	public Number getSnatches() {
		return snatches;
	}

	/**
	 * Get the time the torrent was uploaded
	 * 
	 * @return the upload time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * Get the torrent id.
	 * 
	 * @return the torrent id
	 */
	public Number getTorrentId() {
		return torrentId;
	}

	/**
	 * Check if the torrent is a vanity house release
	 * 
	 * @return True if it's vanity house
	 */
	public boolean isVanityHouse() {
		return vanityHouse;
	}

	@Override
	public String toString() {
		return "Torrent [getArtists()=" + getArtists() + ", canUseToken()=" + canUseToken() + ", getEditionId()="
				+ getEditionId() + ", getEncoding()=" + getEncoding() + ", getFileCount()=" + getFileCount() + ", getFormat()="
				+ getFormat() + ", hasCue()=" + hasCue() + ", hasLog()=" + hasLog() + ", isFreeleech()="
				+ isFreeleech() + ", isNeutralLeech()=" + isNeutralLeech() + ", isPersonalFreeleech()="
				+ isPersonalFreeleech() + ", getLeechers()=" + getLeechers() + ", getLogScore()=" + getLogScore()
				+ ", getMedia()=" + getMedia() + ", getRemasterCatalogueNumber()=" + getRemasterCatalogueNumber()
				+ ", getRemasterTitle()=" + getRemasterTitle() + ", getRemasterYear()=" + getRemasterYear()
				+ ", getRemastered()=" + isRemastered() + ", isScene()=" + isScene() + ", getSeeders()=" + getSeeders()
				+ ", getSize()=" + getSize() + ", getSnatches()=" + getSnatches() + ", getTime()=" + getTime()
				+ ", getTorrentId()=" + getTorrentId() + ", isVanityHouse()=" + isVanityHouse() + "]";
	}

}
