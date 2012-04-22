



package api.bookmarks;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import api.soup.MySoup;

/**
 * The Class Torrent.
 * 
 * @author Gwindow
 */
public class Torrent {
	
	/** The encoding. */
	private String encoding;
	
	/** The file count. */
	private Number fileCount;
	
	/** The format. */
	private String format;
	
	/** The free torrent. */
	private boolean freeTorrent;
	
	/** The group id. */
	private Number groupId;
	
	/** The has cue. */
	private boolean hasCue;
	
	/** The has file. */
	private Number hasFile;
	
	/** The has log. */
	private boolean hasLog;
	
	/** The id. */
	private Number id;
	
	/** The leechers. */
	private Number leechers;
	
	/** The log score. */
	private Number logScore;
	
	/** The media. */
	private String media;
	
	/** The remaster catalogue number. */
	private String remasterCatalogueNumber;
	
	/** The remaster record label. */
	private String remasterRecordLabel;
	
	/** The remaster title. */
	private String remasterTitle;
	
	/** The remaster year. */
	private String remasterYear;
	
	/** The remastered. */
	private boolean remastered;
	
	/** The scene. */
	private boolean scene;
	
	/** The seeders. */
	private Number seeders;
	
	/** The size. */
	private Number size;
	
	/** The snatched. */
	private Number snatched;
	
	/** The time. */
	private String time;

	/**
	 * Gets the encoding.
	 * 
	 * @return torrent encoding
	 */
	public String getEncoding() {
		return this.encoding;
	}

	/**
	 * Gets the file count.
	 * 
	 * @return number of files in torrent
	 */
	public Number getFileCount() {
		return (this.fileCount);
	}

	/**
	 * Gets the format.
	 * 
	 * @return format of torrent
	 */
	public String getFormat() {
		return this.format;
	}

	/**
	 * Returns true if torrent is freeleech.
	 * 
	 * @return is free leech
	 */
	public boolean isFreeTorrent() {
		return freeTorrent;
	}

	/**
	 * Gets the group id.
	 * 
	 * @return torrent group id
	 */
	public Number getGroupId() {
		return (this.groupId);
	}

	/**
	 * Returns true if the torrent has a cue.
	 * 
	 * @return has cue
	 */
	public boolean hasCue() {
		return hasCue;
	}

	/**
	 * Checks for file.
	 * 
	 * @return the number
	 */
	public Number hasFile() {
		return hasFile;
	}

	/**
	 * Returns true if torrent has a log.
	 * 
	 * @return has log
	 */
	public boolean hasLog() {
		return hasLog;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Number getId() {
		return (this.id);
	}

	/**
	 * Gets the leechers.
	 * 
	 * @return number of leechers
	 */
	public Number getLeechers() {
		return (this.leechers);
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
	 * @return media of torrent
	 */
	public String getMedia() {
		return this.media;
	}

	/**
	 * Gets the remaster catalogue number.
	 * 
	 * @return catalogue number of remastered torrent
	 */
	public String getRemasterCatalogueNumber() {
		return this.remasterCatalogueNumber;
	}

	/**
	 * Gets the remaster record label.
	 * 
	 * @return the remastered record label
	 */
	public String getRemasterRecordLabel() {
		return this.remasterRecordLabel;
	}

	/**
	 * Gets the remaster title.
	 * 
	 * @return the title of remaster
	 */
	public String getRemasterTitle() {
		return this.remasterTitle;
	}

	/**
	 * Gets the remaster year.
	 * 
	 * @return the year of remaster
	 */
	public String getRemasterYear() {
		return this.remasterYear;
	}

	/**
	 * Checks if is remastered.
	 * 
	 * @return true if remastered
	 */
	public boolean isRemastered() {
		return this.remastered;
	}

	/**
	 * Return true if torrent is a scene release.
	 * 
	 * @return is scene release
	 */
	public boolean isScene() {
		return scene;
	}

	/**
	 * Gets the seeders.
	 * 
	 * @return number of seeders
	 */
	public Number getSeeders() {
		return (this.seeders);
	}

	/**
	 * Gets the size.
	 * 
	 * @return size of torrent
	 */
	public Number getSize() {
		return this.size;
	}

	/**
	 * Gets the snatched.
	 * 
	 * @return the snatched
	 */
	public Number getSnatched() {
		return this.snatched;
	}

	/**
	 * Gets the time.
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
	 * Get the download link of the torrent.
	 * 
	 * @return download link
	 */
	public String getDownloadLink() {
		String site = MySoup.getSite();
		String authKey = MySoup.getAuthKey();
		String passKey = MySoup.getPassKey();
		String downloadLink = site + "torrents.php?action=download&id=" + id + "&authkey=" + authKey + "&torrent_pass=" + passKey;
		return downloadLink;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Torrent [getEncoding=" + getEncoding() + ", getFileCount=" + getFileCount() + ", getFormat=" + getFormat()
				+ ", isFreeTorrent=" + isFreeTorrent() + ", getGroupId=" + getGroupId() + ", hasCue=" + hasCue() + ", hasFile="
				+ hasFile() + ", hasLog=" + hasLog() + ", getId=" + getId() + ", getLeechers=" + getLeechers() + ", getLogScore="
				+ getLogScore() + ", getMedia=" + getMedia() + ", getRemasterCatalogueNumber=" + getRemasterCatalogueNumber()
				+ ", getRemasterRecordLabel=" + getRemasterRecordLabel() + ", getRemasterTitle=" + getRemasterTitle()
				+ ", getRemasterYear=" + getRemasterYear() + ", getRemastered=" + isRemastered() + ", isScene=" + isScene()
				+ ", getSeeders=" + getSeeders() + ", getSize=" + getSize() + ", getSnatched=" + getSnatched() + ", getTime="
				+ getTime() + ", getMediaFormatEncoding=" + getMediaFormatEncoding() + ", getDownloadLink=" + getDownloadLink()
				+ "]";
	}
}
