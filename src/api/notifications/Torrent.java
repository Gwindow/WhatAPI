package api.notifications;

/**
 * The Class Torrent.
 * Describes a torrent we're being notified about
 *
 * @author Gwindow
 */
public class Torrent {
	/**
	 * The torrent id.
	 */
	private Number torrentId;

	/**
	 * The torrent group id
	 */
	private Number groupId;

	/**
	 * The torrent group name
	 */
	private String groupName;

	/**
	 * The group category id.
	 */
	private Number groupCategoryId;

	/**
	 * Album art url
	 */
	private String wikiImage;

	/**
	 * The torrent tags.
	 */
	private String torrentTags;

	/**
	 * The size of the torrent
	 */
	private Number size;

	/**
	 * The number of files in the torrent.
	 */
	private Number fileCount;

	/**
	 * The file format of the torrent (FLAC/MP3/etc)
	 */
	private String format;

	/**
	 * The encoding (Lossless/320/V0/etc)
	 */
	private String encoding;

	/**
	 * The media the torrent was ripped from
	 */
	private String media;

	/**
	 * If the torrent is a scene release
	 */
	private Boolean scene;

	/**
	 * The release year
	 */
	private Number groupYear;

	/**
	 * The remaster year.
	 */
	private Number remasterYear;

	/**
	 * The remaster title.
	 */
	private String remasterTitle;

	/**
	 * The number of snatches
	 */
	private Number snatched;

	/**
	 * The number of seeders
	 */
	private Number seeders;

	/**
	 * The number of leechers
	 */
	private Number leechers;

	/**
	 * The time we were notified of the torrent
	 */
	private String notificationTime;

	/**
	 * If the torrent has a log file
	 */
	private Boolean hasLog;

	/**
	 * If the torrent has a cue file
	 */
	private Boolean hasCue;

	/**
	 * The log score.
	 */
	private Number logScore;

	/**
	 * If the torrent is freeleech
	 */
	private Boolean freeTorrent;

	/**
	 * The log in db
	 */
	private String logInDb;

	/**
	 * If the notification is unread
	 */
	private Boolean unread;

	public Number getTorrentId(){
		return torrentId;
	}

	public Number getGroupId(){
		return groupId;
	}

	public String getGroupName(){
		return groupName;
	}

	public Number getGroupCategoryId(){
		return groupCategoryId;
	}

	public String getWikiImage(){
		return wikiImage;
	}

	public String getTorrentTags(){
		return torrentTags;
	}

	public Number getSize(){
		return size;
	}

	public Number getFileCount(){
		return fileCount;
	}

	public String getFormat(){
		return format;
	}

	public String getEncoding(){
		return encoding;
	}

	public String getMedia(){
		return media;
	}

	public Boolean isScene(){
		return scene;
	}

	public Number getGroupYear(){
		return groupYear;
	}

	public Number getRemasterYear(){
		return remasterYear;
	}

	public String getRemasterTitle(){
		return remasterTitle;
	}

	public Number getSnatched(){
		return snatched;
	}

	public Number getSeeders(){
		return seeders;
	}

	public Number getLeechers(){
		return leechers;
	}

	public String getNotificationTime(){
		return notificationTime;
	}

	public Boolean hasLog(){
		return hasLog;
	}

	public Boolean hasCue(){
		return hasCue;
	}

	public Number getLogScore(){
		return logScore;
	}

	public Boolean isFreeTorrent(){
		return freeTorrent;
	}

	public String isLogInDb(){
		return logInDb;
	}

	public Boolean isUnread(){
		return unread;
	}

	public Boolean isRemastered(){
		return remasterYear.intValue() != 0;
	}

	/**
	 * Get a concise representation of the torrent media, format and encoding. For example "CD - AAC - 320"
	 *
	 * @return the media, format, and encoding
	 */
	public String getMediaFormatEncoding(){
		String log = hasLog ? " - " + logScore.toString() : "";
		String cue = hasCue ? " - " + "Cue" : "";
		return media + " - " + format + " - " + encoding + log + cue;

	}

	/**
	 * Get a concise representation of the information about the torrent edition
	 * ex. 2005 - Remaster Title or 1998 - Original Release
	 */
	public String getEdition(){
		if (remasterYear.intValue() == 0){
			return groupYear + " - " + "Original Release";
		}
		return remasterYear + (!remasterTitle.isEmpty() ? " - " + remasterTitle : "");
	}

	@Override
	public String toString(){
		return "Torrent [ torrentId=" + torrentId + ", groupId=" + groupId + ", groupName=" + groupName
			+ ", groupCategoryId=" + groupCategoryId + ", wikiImage=" + wikiImage
			+ ", torrentTags=" + torrentTags + ", size=" + size + ", fileCount=" + fileCount
			+ ", format=" + format + ", encoding=" + encoding + ", media=" + media + ", scene=" + scene
			+ ", groupYear=" + groupYear + ", remasterYear=" + remasterYear + ", remasterTitle=" + remasterTitle
			+ ", snatched=" + snatched + ", seeders=" + seeders + ", leechers=" + leechers
			+ ", notificationTime=" + notificationTime + ", hasLog=" + hasLog + ", hasCue=" + hasCue
			+ ", logScore=" + logScore + ", freeTorrent=" + freeTorrent + ", logInDb=" + logInDb
			+ ", unread=" + unread + "]";
	}
}
