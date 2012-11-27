package api.bookmarks;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import api.soup.MySoup;

/**
 * The Class Torrent
 * Contains information about a specific torrent
 * 
 * @author Gwindow
 */
public class Torrent {
	/** The file encoding. */
	private String encoding;

	/** The number of files */
	private Number fileCount;

	/** The file format */
	private String format;

	/** If the torrent is freeleech */
	private boolean freeTorrent;

	/** The torrent group id */
	private Number groupId;

	/** If the torrent has a cue file */
	private boolean hasCue;

	/** The has file.
     * TODO: What does this mean?
     */
	private Number hasFile;

	/** If the torrent has a log file */
	private boolean hasLog;

    /** The log score. */
    private Number logScore;

	/** The torrent id */
	private Number id;

	/** The media the files were ripped from. */
	private String media;

	/** The remaster catalogue number. */
	private String remasterCatalogueNumber;

	/** The remaster record label. */
	private String remasterRecordLabel;

	/** The remaster title. */
	private String remasterTitle;

	/** The remaster year. */
	private String remasterYear;

	/** If the torrent is a remaster */
	private boolean remastered;

	/** If the torrent is a scene release */
	private boolean scene;

    /** The number of leechers. */
    private Number leechers;

	/** The number of seeders. */
	private Number seeders;

    /** The number of snatches */
    private Number snatched;

	/** The size of the torrent */
	private Number size;

	/** The torrent upload date */
	private String time;

	/**
	 * Get the file encoding.
	 * 
	 * @return torrent encoding
	 */
	public String getEncoding() {
		return this.encoding;
	}

	/**
	 * Get the file count.
	 * 
	 * @return number of files in torrent
	 */
	public Number getFileCount() {
		return this.fileCount;
	}

	/**
	 * Get the file format.
	 * 
	 * @return format of torrent
	 */
	public String getFormat() {
		return this.format;
	}

	/**
	 * Check if the torrent is free leech
	 * 
	 * @return True if the torrent is freeleech
	 */
	public boolean isFreeTorrent() {
		return this.freeTorrent;
	}

	/**
	 * Get the torrent group id.
	 * 
	 * @return torrent group id
	 */
	public Number getGroupId() {
		return this.groupId;
	}

	/**
	 * Check if the torrent has a cue file
	 * 
	 * @return True if the torrent has a cue file
	 */
	public boolean hasCue() {
		return this.hasCue;
	}

	/**
	 * Checks for file.
	 * 
	 * @return the number
	 */
	public Number hasFile() {
		return this.hasFile;
	}

	/**
	 * Check if the torrent has a log file
	 * 
	 * @return True if the torrent has a log file
	 */
	public boolean hasLog() {
		return this.hasLog;
	}

	/**
	 * Get the torrent id
	 * 
	 * @return the torrent id
	 */
	public Number getId() {
		return this.id;
	}

	/**
	 * Get the log score.
	 * 
	 * @return the log score
	 */
	public Number getLogScore() {
		return this.logScore;
	}

	/**
	 * Get the media type the torrent was ripped from
	 * 
	 * @return media of torrent
	 */
	public String getMedia() {
		return this.media;
	}

	/**
	 * Get the remaster catalogue number.
	 * 
	 * @return catalogue number of remastered torrent
	 */
	public String getRemasterCatalogueNumber() {
		return this.remasterCatalogueNumber;
	}

	/**
	 * Get the remaster record label.
	 * 
	 * @return the remastered record label
	 */
	public String getRemasterRecordLabel() {
		return this.remasterRecordLabel;
	}

	/**
	 * Get the remaster title.
	 * 
	 * @return the title of remaster
	 */
	public String getRemasterTitle() {
		return this.remasterTitle;
	}

	/**
	 * Get the remaster year.
	 * 
	 * @return the year of remaster
	 */
	public String getRemasterYear() {
		return this.remasterYear;
	}

	/**
	 * Check if the torrent is remastered.
	 * 
	 * @return True if the torrent is remastered
	 */
	public boolean isRemastered() {
		return this.remastered;
	}

	/**
	 * Check if the torrent is a scene release
	 * 
	 * @return True if the torrent is a scene release
	 */
	public boolean isScene() {
		return this.scene;
	}

    /**
     * Get the number of leechers
     *
     * @return number of leechers
     */
    public Number getLeechers() {
        return this.leechers;
    }

	/**
	 * Get the number of seeders
	 * 
	 * @return number of seeders
	 */
	public Number getSeeders() {
		return this.seeders;
	}

    /**
     * Get the number of snatches
     *
     * @return number of snatches
     */
    public Number getSnatched() {
        return this.snatched;
    }

	/**
	 * Get the size of the torrent
	 * 
	 * @return size of torrent
	 */
	public Number getSize() {
		return this.size;
	}

	/**
	 * Get the time the torrent was uploaded
	 * 
	 * @return time of upload
	 */
	public String getTime() {
		return this.time;
	}

	/**
	 * Get a concise representation of the torrent media, format and encoding. For example "CD - AAC - 320"
	 * 
	 * @return the media, format, and encoding
	 */
	public String getMediaFormatEncoding() {
		return this.getMedia() + " - " + this.getFormat() + " - " + this.getEncoding();

	}

	/**
	 * Get the download link for the torrent.
	 * 
	 * @return download link
	 */
	public String getDownloadLink() {
		String site = MySoup.getSite();
		String authKey = MySoup.getAuthKey();
		String passKey = MySoup.getPassKey();
		return site + "torrents.php?action=download&id=" + id + "&authkey=" + authKey + "&torrent_pass=" + passKey;
	}

	/**
	 * Download a file.
	 * 
	 * @param url
	 *            url to file
	 * @param path
	 *            local path to save the file
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void downloadFile(String url, String path) throws IOException {
		// todo fix this
		String name = "Unknown " + "(" + getMediaFormatEncoding() + ")";
		URL u;
		u = new URL(getDownloadLink());
		ReadableByteChannel rbc = Channels.newChannel(u.openStream());
		FileOutputStream fos = new FileOutputStream(path + name + ".torrent");
		fos.getChannel().transferFrom(rbc, 0, 1 << 24);
		System.out.println("Downloaded " + name + " to " + path);

	}

	@Override
	public String toString() {
		return "Torrent [getEncoding=" + getEncoding() + ", getFileCount=" + getFileCount() + ", getFormat=" + getFormat()
				+ ", isFreeTorrent=" + isFreeTorrent() + ", getGroupId=" + getGroupId() + ", hasCue=" + hasCue() + ", hasFile="
				+ hasFile() + ", hasLog=" + hasLog() + ", getId=" + getId() + ", getLeechers=" + getLeechers() + ", getLogScore="
				+ getLogScore() + ", getMedia=" + getMedia() + ", getRemasterCatalogueNumber=" + getRemasterCatalogueNumber()
				+ ", getRemasterRecordLabel=" + getRemasterRecordLabel() + ", getRemasterTitle=" + getRemasterTitle()
				+ ", getRemasterYear=" + getRemasterYear() + ", isRemastered=" + isRemastered() + ", isScene=" + isScene()
				+ ", getSeeders=" + getSeeders() + ", getSize=" + getSize() + ", getSnatched=" + getSnatched() + ", getTime="
				+ getTime() + ", getMediaFormatEncoding=" + getMediaFormatEncoding() + ", getDownloadLink=" + getDownloadLink()
				+ "]";
	}
}
