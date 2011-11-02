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

	public String getEncoding() {
		return this.encoding;
	}

	public String getFileCount() {
		return this.fileCount;
	}

	public String getFormat() {
		return this.format;
	}

	public boolean isFreeTorrent() {
		if (freeTorrent.equals("1"))
			return true;
		return false;
	}

	public String getGroupId() {
		return this.groupId;
	}

	public boolean hasCue() {
		if (hasCue.equals("1"))
			return true;
		return false;
	}

	public boolean hasFile() {
		if (hasCue.equals("1"))
			return true;
		return false;
	}

	public boolean hasLog() {
		if (hasLog.equals("1"))
			return true;
		return false;
	}

	public String getId() {
		return this.id;
	}

	public String getLeechers() {
		return this.leechers;
	}

	public String getLogScore() {
		return this.logScore;
	}

	public String getMedia() {
		return this.media;
	}

	public String getRemasterCatalogueNumber() {
		return this.remasterCatalogueNumber;
	}

	public String getRemasterRecordLabel() {
		return this.remasterRecordLabel;
	}

	public String getRemasterTitle() {
		return this.remasterTitle;
	}

	public String getRemasterYear() {
		return this.remasterYear;
	}

	public String getRemastered() {
		return this.remastered;
	}

	public boolean isScene() {
		if (scene.equals("1"))
			return true;
		return false;
	}

	public String getSeeders() {
		return this.seeders;
	}

	public String getSize() {
		return this.size;
	}

	public String getSnatched() {
		return this.snatched;
	}

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

	public String getDownloadLink() {
		String site = MySoup.getSite();
		String authKey = MySoup.getAuthKey();
		String passKey = MySoup.getPassKey();
		String downloadLink = site + "torrents.php?action=download&id=" + id + "&authkey=" + authKey + "&torrent_pass=" + passKey;
		return downloadLink;
	}

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
