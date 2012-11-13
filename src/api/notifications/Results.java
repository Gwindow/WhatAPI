package api.notifications;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import api.soup.MySoup;

/**
 * The Class Results.
 * 
 * @author Gwindow
 */
public class Results {

	/** The encoding. */
	private String encoding;

	/** The file count. */
	private Number fileCount;

	/** The format. */
	private String format;

	/** The free torrent. */
	private Boolean freeTorrent;

	/** The group category id. */
	private Number groupCategoryId;

	/** The group id. */
	private Number groupId;

	/** The group name. */
	private String groupName;

	/** The group year. */
	private Number groupYear;

	/** The has cue. */
	private Boolean hasCue;

	/** The has log. */
	private Boolean hasLog;

	/** The leechers. */
	private Number leechers;

	/** The log in db. */
	private String logInDb;

	/** The log score. */
	private Number logScore;

	/** The media. */
	private String media;

	/** The notification time. */
	private String notificationTime;

	/** The remaster title. */
	private String remasterTitle;

	/** The remaster year. */
	private Number remasterYear;

	/** The scene. */
	private Boolean scene;

	/** The seeders. */
	private Number seeders;

	/** The size. */
	private Number size;

	/** The snatched. */
	private Number snatched;

	/** The torrent id. */
	private Number torrentId;

	/** The torrent tags. */
	private String torrentTags;

	/** The unread. */
	private Boolean unread;

	/**
	 * Gets the encoding.
	 * 
	 * @return the encoding
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * Gets the file count.
	 * 
	 * @return the file count
	 */
	public Number getFileCount() {
		return fileCount;
	}

	/**
	 * Gets the format.
	 * 
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * Checks if is free torrent.
	 * 
	 * @return the boolean
	 */
	public Boolean isFreeTorrent() {
		return freeTorrent;
	}

	/**
	 * Gets the group category id.
	 * 
	 * @return the group category id
	 */
	public Number getGroupCategoryId() {
		return groupCategoryId;
	}

	/**
	 * Gets the group id.
	 * 
	 * @return the group id
	 */
	public Number getGroupId() {
		return groupId;
	}

	/**
	 * Gets the group name.
	 * 
	 * @return the group name
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * Gets the group year.
	 * 
	 * @return the group year
	 */
	public Number getGroupYear() {
		return groupYear;
	}

	/**
	 * Checks for cue.
	 * 
	 * @return the checks for cue
	 */
	public Boolean hasCue() {
		return hasCue;
	}

	/**
	 * Checks for log.
	 * 
	 * @return the checks for log
	 */
	public Boolean hasLog() {
		return hasLog;
	}

	/**
	 * Gets the leechers.
	 * 
	 * @return the leechers
	 */
	public Number getLeechers() {
		return leechers;
	}

	/**
	 * Gets the log in db.
	 * 
	 * @return the log in db
	 */
	public String getLogInDb() {
		return logInDb;
	}

	/**
	 * Gets the log score.
	 * 
	 * @return the log score
	 */
	public Number getLogScore() {
		return logScore;
	}

	/**
	 * Gets the media.
	 * 
	 * @return the media
	 */
	public String getMedia() {
		return media;
	}

	/**
	 * Gets the notification time.
	 * 
	 * @return the notification time
	 */
	public String getNotificationTime() {
		return notificationTime;
	}

	/**
	 * Gets the remaster title.
	 * 
	 * @return the remaster title
	 */
	public String getRemasterTitle() {
		return remasterTitle;
	}

	/**
	 * Gets the remaster year.
	 * 
	 * @return the remaster year
	 */
	public Number getRemasterYear() {
		return remasterYear;
	}

	/**
	 * Checks if is scene.
	 * 
	 * @return the boolean
	 */
	public Boolean isScene() {
		return scene;
	}

	/**
	 * Gets the seeders.
	 * 
	 * @return the seeders
	 */
	public Number getSeeders() {
		return seeders;
	}

	/**
	 * Gets the size.
	 * 
	 * @return the size
	 */
	public Number getSize() {
		return size;
	}

	/**
	 * Gets the snatched.
	 * 
	 * @return the snatched
	 */
	public Number getSnatched() {
		return snatched;
	}

	/**
	 * Gets the torrent id.
	 * 
	 * @return the torrent id
	 */
	public Number getTorrentId() {
		return torrentId;
	}

	/**
	 * Gets the torrent tags.
	 * 
	 * @return the torrent tags
	 */
	public String getTorrentTags() {
		return torrentTags;
	}

	/**
	 * Checks if is unread.
	 * 
	 * @return the boolean
	 */
	public Boolean isUnread() {
		return unread;
	}

	/**
	 * Get a concise representation of the torrent media, format and encoding. For example "CD - AAC - 320"
	 * 
	 * @return the media, format, and encoding
	 */
	public String getMediaFormatEncoding() {
		String log = hasLog ? " - " + logScore.toString() : "";
		String cue = hasCue ? " - " + "Cue" : "";
		return this.getMedia() + " - " + this.getFormat() + " - " + this.getEncoding() + log + cue;

	}

	/**
	 * Gets the remaster.
	 * 
	 * @return the remaster
	 */
	public String getRemaster() {
		return this.getRemasterYear() + " - " + this.getRemasterTitle();
	}

	/**
	 * Gets the download link.
	 * 
	 * @return the download link
	 */
	public String getDownloadLink() {
		String site = MySoup.getSite();
		String authKey = MySoup.getAuthKey();
		String passKey = MySoup.getPassKey();
		return site + "torrents.php?action=download&id="
                + torrentId + "&authkey=" + authKey
                + "&torrent_pass=" + passKey;
	}

	/**
	 * Download file.
	 * 
	 * @param url
	 *            the url
	 * @param path
	 *            the path
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void downloadFile(String url, String path) throws IOException {
		// todo fix this
        //What's broken?
		String name = "Unknown " + "(" + getMediaFormatEncoding() + ")";
		URL u;
		u = new URL(getDownloadLink());
		ReadableByteChannel rbc = Channels.newChannel(u.openStream());
		FileOutputStream fos = new FileOutputStream(path + name + ".torrent");
		fos.getChannel().transferFrom(rbc, 0, 1 << 24);
		System.out.println("Downloaded " + name + " to " + path);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Results [getEncoding=" + getEncoding() + ", getFileCount=" + getFileCount() + ", getFormat=" + getFormat()
				+ ", isFreeTorrent=" + isFreeTorrent() + ", getGroupCategoryId=" + getGroupCategoryId() + ", getGroupId="
				+ getGroupId() + ", getGroupName=" + getGroupName() + ", getGroupYear=" + getGroupYear() + ", hasCue=" + hasCue()
				+ ", hasLog=" + hasLog() + ", getLeechers=" + getLeechers() + ", getLogInDb=" + getLogInDb() + ", getLogScore="
				+ getLogScore() + ", getMedia=" + getMedia() + ", getNotificationTime=" + getNotificationTime()
				+ ", getRemasterTitle=" + getRemasterTitle() + ", getRemasterYear=" + getRemasterYear() + ", isScene="
				+ isScene() + ", getSeeders=" + getSeeders() + ", getSize=" + getSize() + ", getSnatched=" + getSnatched()
				+ ", getTorrentId=" + getTorrentId() + ", getTorrentTags=" + getTorrentTags() + ", isUnread=" + isUnread()
				+ ", getMediaFormatEncoding=" + getMediaFormatEncoding() + ", getYearMediaFormatEncoding="
				+ getMediaFormatEncoding() + ", getDownloadLink=" + getDownloadLink() + "]";
	}
}
