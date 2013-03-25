package api.notifications;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import api.soup.MySoup;

/**
 * The Class Torrent.
 * Describes a torrent we're being notified about
 * 
 * @author Gwindow
 */
public class Torrent {
	/** The encoding (Lossless/320/V0/etc) */
	private String encoding;

	/** The number of files in the torrent. */
	private Number fileCount;

	/** The file format of the torrent (FLAC/MP3/etc) */
	private String format;

	/** The group category id. TODO: What is this? */
	private Number groupCategoryId;

	/** The torrent group id */
	private Number groupId;

    /** The torrent id. */
    private Number torrentId;

	/** The torrent group name */
	private String groupName;

	/** The release year */
	private Number groupYear;

	/** The log in db. TODO What is this? */
	private String logInDb;

	/** The log score. */
	private Number logScore;

	/** The media the torrent was ripped from */
	private String media;

	/** The time we were notified of the torrent */
	private String notificationTime;

	/** The remaster title. */
	private String remasterTitle;

	/** The remaster year. */
	private Number remasterYear;

    /** The torrent tags. */
    private String torrentTags;

    /** The size of the torrent */
    private Number size;

	/** The number of seeders */
	private Number seeders;

    /** The number of leechers */
    private Number leechers;

	/** The number of snatches */
	private Number snatched;

    /** If the torrent is freeleech */
    private Boolean freeTorrent;

    /** If the torrent is a scene release */
    private Boolean scene;

    /** If the torrent has a cue file */
    private Boolean hasCue;

    /** If the torrent has a log file */
    private Boolean hasLog;

	/** If the notification is unread */
	private Boolean unread;

	/**
	 * Get the encoding.
	 * 
	 * @return the encoding
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * Get the number of files.
	 * 
	 * @return the file count
	 */
	public Number getFileCount() {
		return fileCount;
	}

	/**
	 * Get the format.
	 * 
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * Get the group category id.
	 * 
	 * @return the group category id
	 */
	public Number getGroupCategoryId() {
		return groupCategoryId;
	}

	/**
	 * Get the group id.
	 * 
	 * @return the group id
	 */
	public Number getGroupId() {
		return groupId;
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
	 * Get the group name.
	 * 
	 * @return the group name
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * Get the group year.
	 * 
	 * @return the group year
	 */
	public Number getGroupYear() {
		return groupYear;
	}

	/**
	 * Get the log in db.
	 * 
	 * @return the log in db
	 */
	public String getLogInDb() {
		return logInDb;
	}

	/**
	 * Get the log score.
	 * 
	 * @return the log score
	 */
	public Number getLogScore() {
		return logScore;
	}

	/**
	 * Get the media type the torrent was ripped from
	 * 
	 * @return the media type
	 */
	public String getMedia() {
		return media;
	}

	/**
	 * Get the time we were notified of the torrent
	 * 
	 * @return the notification time
	 */
	public String getNotificationTime() {
		return notificationTime;
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
	 * Gets the remaster year.
	 * 
	 * @return the remaster year
	 */
	public Number getRemasterYear() {
		return remasterYear;
	}

    /**
     * Get the torrent tags.
     *
     * @return the torrent tags
     */
    public String getTorrentTags() {
        return torrentTags;
    }

    /**
     * Get the size of the torrent
     *
     * @return the size of the torrent
     */
    public Number getSize() {
        return size;
    }

    /**
     * Get the number of seeders
     *
     * @return number of seeders
     */
    public Number getSeeders() {
        return seeders;
    }

    /**
     * Get the number of leechers
     *
     * @return number of leechers
     */
    public Number getLeechers() {
        return leechers;
    }

	/**
	 * Get the number of snatches
	 * 
	 * @return number of snatches
	 */
	public Number getSnatched() {
		return snatched;
	}

    /**
     * Check if the torrent is freeleech
     *
     * @return True if it's freeleech
     */
    public Boolean isFreeTorrent() {
        return freeTorrent;
    }

    /**
     * Check if the torrent is a scene release
     *
     * @return True if it's a scene release
     */
    public Boolean isScene() {
        return scene;
    }

    /**
     * Check if the torrent has a cue file
     *
     * @return True if it has a cue file
     */
    public Boolean hasCue() {
        return hasCue;
    }

    /**
     * Check if the torrent has a log file
     *
     * @return True if it has a log file
     */
    public Boolean hasLog() {
        return hasLog;
    }

	/**
	 * Check if the notification is unread
	 * 
	 * @return True if it's unread
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
		return (getMedia() + " - " + getFormat() + " - " + getEncoding() + log + cue);

	}

	/**
	 * Get a concise representation of the information about the torrent remastering
	 * ex. 2005 - Remaster Title
     *
	 * @return the remaster
	 */
	public String getRemaster() {
		return (getRemasterYear() + " - " + getRemasterTitle());
	}

	/**
	 * Get the download link for the torrent
	 * 
	 * @return the download link
	 */
	public String getDownloadLink() {
		String site = MySoup.getSite();
		String authKey = MySoup.getAuthKey();
		String passKey = MySoup.getPassKey();
		return site + "torrents.php?action=download&id=" + torrentId + "&authkey=" + authKey
            + "&torrent_pass=" + passKey;
	}

	/**
	 * Download the torrent file
	 * 
	 * @param url
	 *      the torrent download url TODO Why not used?
	 * @param path
	 *      the path to save too
	 * @throws IOException
	 *      Signals that an I/O exception has occurred.
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

	@Override
	public String toString() {
		return "Torrent [getEncoding=" + getEncoding() + ", getFileCount=" + getFileCount() + ", getFormat=" + getFormat()
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
