package api.bookmarks;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import api.soup.MySoup;

public class Torrent {
	private String encoding;
	private String fileCount;
	private String format;
	private String freeTorrent;
	private String groupId;
	private String hasCue;
	private String hasFile;
	private String hasLog;
	private String id;
	private String leechers;
	private String logScore;
	private String media;
	private String remasterCatalogueNumber;
	private String remasterRecordLabel;
	private String remasterTitle;
	private String remasterYear;
	private String remastered;
	private String scene;
	private String seeders;
	private String size;
	private String snatched;
	private String time;

	/**
	 * 
	 * @return torrent encoding
	 */
	public String getEncoding() {
		return this.encoding;
	}

	/**
	 * 
	 * @return number of files in torrent
	 */
	public int getFileCount() {
		return Integer.parseInt(this.fileCount);
	}

	/**
	 * 
	 * @return format of torrent
	 */
	public String getFormat() {
		return this.format;
	}

	/**
	 * Returns true if torrent is freeleech
	 * 
	 * @return is free leech
	 */
	public boolean isFreeTorrent() {
		if (freeTorrent.equals("1"))
			return true;
		return false;
	}

	/**
	 * 
	 * @return torrent group id
	 */
	public int getGroupId() {
		return Integer.parseInt(this.groupId);
	}

	/**
	 * Returns true if the torrent has a cue
	 * 
	 * @return has cue
	 */
	public boolean hasCue() {
		if (hasCue.equals("1"))
			return true;
		return false;
	}

	public boolean hasFile() {
		if (hasFile.equals("1"))
			return true;
		return false;
	}

	/**
	 * Returns true if torrent has a log
	 * 
	 * @return has log
	 */
	public boolean hasLog() {
		if (hasLog.equals("1"))
			return true;
		return false;
	}

	/**
	 * 
	 * @return the id
	 */
	public int getId() {
		return Integer.parseInt(this.id);
	}

	/**
	 * 
	 * @return number of leechers
	 */
	public int getLeechers() {
		return Integer.parseInt(this.leechers);
	}

	/**
	 * 
	 * @return the log score
	 */
	public String getLogScore() {
		return this.logScore;
	}

	/**
	 * 
	 * @return media of torrent
	 */
	public String getMedia() {
		return this.media;
	}

	/**
	 * 
	 * @return catalogue number of remastered torrent
	 */
	public String getRemasterCatalogueNumber() {
		return this.remasterCatalogueNumber;
	}

	/**
	 * 
	 * @return the remastered record label
	 */
	public String getRemasterRecordLabel() {
		return this.remasterRecordLabel;
	}

	/**
	 * 
	 * @return the title of remaster
	 */
	public String getRemasterTitle() {
		return this.remasterTitle;
	}

	/**
	 * 
	 * @return the year of remaster
	 */
	public String getRemasterYear() {
		return this.remasterYear;
	}

	public String getRemastered() {
		return this.remastered;
	}

	/**
	 * Return true if torrent is a scene release
	 * 
	 * @return is scene release
	 */
	public boolean isScene() {
		if (scene.equals("1"))
			return true;
		return false;
	}

	/**
	 * 
	 * @return number of seeders
	 */
	public int getSeeders() {
		return Integer.valueOf(this.seeders);
	}

	/**
	 * 
	 * @return size of torrent
	 */
	public String getSize() {
		return this.size;
	}

	public String getSnatched() {
		return this.snatched;
	}

	/**
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
	 * Get the download link of the torrent
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
	 * Download a file
	 * 
	 * @param url
	 *            url to file
	 * @param path
	 *            local path to save the file
	 * @throws IOException
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
				+ ", getRemasterYear=" + getRemasterYear() + ", getRemastered=" + getRemastered() + ", isScene=" + isScene()
				+ ", getSeeders=" + getSeeders() + ", getSize=" + getSize() + ", getSnatched=" + getSnatched() + ", getTime="
				+ getTime() + ", getMediaFormatEncoding=" + getMediaFormatEncoding() + ", getDownloadLink=" + getDownloadLink()
				+ "]";
	}
}
