


package api.top;

import java.util.List;

import api.soup.MySoup;

/**
 * The results of the top list.
 * 
 * @author Tim
 */
public class Results {
	// torrents
	/** The artist. */
	private String artist;
	
	/** The encoding. */
	private String encoding;
	
	/** The format. */
	private String format;
	
	/** The group id. */
	private Number groupId;
	
	/** The group year. */
	private String groupYear;
	
	/** The has cue. */
	private boolean hasCue;
	
	/** The has log. */
	private boolean hasLog;
	
	/** The leechers. */
	private Number leechers;
	
	/** The media. */
	private String media;
	
	/** The scene. */
	private boolean scene;
	
	/** The seeders. */
	private Number seeders;
	
	/** The snatched. */
	private Number snatched;
	
	/** The tags. */
	private List<String> tags;
	
	/** The torrent id. */
	private Number torrentId;
	
	/** The year. */
	private String year;
	// tags
	/** The name. */
	private String name;
	
	/** The neg votes. */
	private Number negVotes;
	
	/** The pos votes. */
	private Number posVotes;
	
	/** The uses. */
	private Number uses;
	// users
	/** The down speed. */
	private Number downSpeed;
	
	/** The downloaded. */
	private Number downloaded;
	
	/** The id. */
	private Number id;
	
	/** The join date. */
	private String joinDate;
	
	/** The num uploads. */
	private Number numUploads;
	
	/** The up speed. */
	private Number upSpeed;
	
	/** The uploaded. */
	private Number uploaded;

	/**
	 * Gets the artist.
	 * 
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * Gets the encoding.
	 * 
	 * @return the encoding
	 */
	public String getEncoding() {
		return encoding;
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
	 * Gets the group id.
	 * 
	 * @return the group id
	 */
	public Number getGroupId() {
		return groupId;
	}

	/**
	 * Gets the group year.
	 * 
	 * @return the group year
	 */
	public String getGroupYear() {
		return groupYear;
	}

	/**
	 * Checks if is checks for cue.
	 * 
	 * @return true, if is checks for cue
	 */
	public boolean hasCue() {
		return hasCue;
	}

	/**
	 * Checks if is checks for log.
	 * 
	 * @return true, if is checks for log
	 */
	public boolean hasLog() {
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
	 * Gets the media.
	 * 
	 * @return the media
	 */
	public String getMedia() {
		return media;
	}

	/**
	 * Checks if is scene.
	 * 
	 * @return true, if is scene
	 */
	public boolean isScene() {
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
	 * Gets the snatched.
	 * 
	 * @return the snatched
	 */
	public Number getSnatched() {
		return snatched;
	}

	/**
	 * Gets the tags.
	 * 
	 * @return the tags
	 */
	public List<String> getTags() {
		return tags;
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
	 * Gets the year.
	 * 
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the neg votes.
	 * 
	 * @return the neg votes
	 */
	public Number getNegVotes() {
		return negVotes;
	}

	/**
	 * Gets the pos votes.
	 * 
	 * @return the pos votes
	 */
	public Number getPosVotes() {
		return posVotes;
	}

	/**
	 * Gets the uses.
	 * 
	 * @return the uses
	 */
	public Number getUses() {
		return uses;
	}

	/**
	 * Gets the down speed.
	 * 
	 * @return the down speed
	 */
	public Number getDownSpeed() {
		return downSpeed;
	}

	/**
	 * Gets the downloaded.
	 * 
	 * @return the downloaded
	 */
	public Number getDownloaded() {
		return downloaded;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Number getId() {
		return id;
	}

	/**
	 * Gets the join date.
	 * 
	 * @return the join date
	 */
	public String getJoinDate() {
		return joinDate;
	}

	/**
	 * Gets the num uploads.
	 * 
	 * @return the num uploads
	 */
	public Number getNumUploads() {
		return numUploads;
	}

	/**
	 * Gets the up speed.
	 * 
	 * @return the up speed
	 */
	public Number getUpSpeed() {
		return upSpeed;
	}

	/**
	 * Gets the uploaded.
	 * 
	 * @return the uploaded
	 */
	public Number getUploaded() {
		return uploaded;
	}

	/**
	 * Gets the username.
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/** The username. */
	private String username;

	// TODO return SSL link
	/**
	 * Gets the download link.
	 * 
	 * @return the download link
	 */
	public String getDownloadLink() {
		String link;
		String authkey = MySoup.getAuthKey();
		String passkey = MySoup.getPassKey();
		link =
				MySoup.getSite() + "torrents.php?action=download&id=" + torrentId + "5&authkey=" + authkey + "&torrent_pass="
						+ passkey;
		return link;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Results [getArtist=" + getArtist() + ", getEncoding=" + getEncoding() + ", getFormat=" + getFormat()
				+ ", getGroupId=" + getGroupId() + ", getGroupYear=" + getGroupYear() + ", hasCue=" + hasCue() + ", hasLog="
				+ hasLog() + ", getLeechers=" + getLeechers() + ", getMedia=" + getMedia() + ", isScene=" + isScene()
				+ ", getSeeders=" + getSeeders() + ", getSnatched=" + getSnatched() + ", getTags=" + getTags()
				+ ", getTorrentId=" + getTorrentId() + ", getYear=" + getYear() + ", getName=" + getName() + ", getNegVotes="
				+ getNegVotes() + ", getPosVotes=" + getPosVotes() + ", getUses=" + getUses() + ", getDownSpeed="
				+ getDownSpeed() + ", getDownloaded=" + getDownloaded() + ", getId=" + getId() + ", getJoinDate=" + getJoinDate()
				+ ", getNumUploads=" + getNumUploads() + ", getUpSpeed=" + getUpSpeed() + ", getUploaded=" + getUploaded()
				+ ", getUsername=" + getUsername() + ", getDownloadLink=" + getDownloadLink() + "]";
	}

}
