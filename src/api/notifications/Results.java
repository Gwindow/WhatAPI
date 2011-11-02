package api.notifications;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import api.soup.MySoup;

public class Results {
	private String encoding;
	private String fileCount;
	private String format;
	private String freeTorrent;
	private String groupCategoryId;
	private String groupId;
	private String groupName;
	private String groupYear;
	private String hasCue;
	private String hasLog;
	private String leechers;
	private String logInDb;
	private String logScore;
	private String media;
	private String notificationTime;
	private String remasterTitle;
	private String remasterYear;
	private String scene;
	private String seeders;
	private String size;
	private String snatched;
	private String torrentId;
	private String torrentTags;
	private String unread;

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
		if (freeTorrent.equalsIgnoreCase("1"))
			return true;
		return false;
	}

	public String getGroupCategoryId() {
		return this.groupCategoryId;
	}

	public String getGroupId() {
		return this.groupId;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public String getGroupYear() {
		return this.groupYear;
	}

	public boolean hasCue() {
		if (hasCue.equalsIgnoreCase("1"))
			return true;
		return false;
	}

	public boolean hasLog() {
		if (hasLog.equalsIgnoreCase("1"))
			return true;
		return false;
	}

	public String getLeechers() {
		return this.leechers;
	}

	public String getLogInDb() {
		return this.logInDb;
	}

	public String getLogScore() {
		return this.logScore;
	}

	public String getMedia() {
		return this.media;
	}

	public String getNotificationTime() {
		return this.notificationTime;
	}

	public String getRemasterTitle() {
		return this.remasterTitle;
	}

	public String getRemasterYear() {
		return this.remasterYear;
	}

	public boolean isScene() {
		if (scene.equalsIgnoreCase("1"))
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

	public String getTorrentId() {
		return this.torrentId;
	}

	public String getTorrentTags() {
		return this.torrentTags;
	}

	public boolean isUnread() {
		if (unread.equalsIgnoreCase("1"))
			return true;
		return false;
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
	 * Get a concise representation of the torrent year, media, format and encoding. For example "[2004] CD - AAC - 320"
	 * 
	 * @return the media, format, and encoding
	 */
	public String getYearMediaFormatEncoding() {
		return "[" + this.getGroupYear() + "] " + this.getMedia() + " - " + this.getFormat() + " - " + this.getEncoding();

	}

	public String getDownloadLink() {
		String site = MySoup.getSite();
		String authKey = MySoup.getAuthKey();
		String passKey = MySoup.getPassKey();
		String downloadLink =
				site + "torrents.php?action=download&id=" + torrentId + "&authkey=" + authKey + "&torrent_pass=" + passKey;
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
		return "Results [getEncoding=" + getEncoding() + ", getFileCount=" + getFileCount() + ", getFormat=" + getFormat()
				+ ", isFreeTorrent=" + isFreeTorrent() + ", getGroupCategoryId=" + getGroupCategoryId() + ", getGroupId="
				+ getGroupId() + ", getGroupName=" + getGroupName() + ", getGroupYear=" + getGroupYear() + ", hasCue=" + hasCue()
				+ ", hasLog=" + hasLog() + ", getLeechers=" + getLeechers() + ", getLogInDb=" + getLogInDb() + ", getLogScore="
				+ getLogScore() + ", getMedia=" + getMedia() + ", getNotificationTime=" + getNotificationTime()
				+ ", getRemasterTitle=" + getRemasterTitle() + ", getRemasterYear=" + getRemasterYear() + ", isScene="
				+ isScene() + ", getSeeders=" + getSeeders() + ", getSize=" + getSize() + ", getSnatched=" + getSnatched()
				+ ", getTorrentId=" + getTorrentId() + ", getTorrentTags=" + getTorrentTags() + ", isUnread=" + isUnread() + "]";
	}
}
