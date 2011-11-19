/**
 * @author Gwindow
 */
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
	private String artist;
	private String encoding;
	private String format;
	private String groupId;
	private String groupYear;
	private String hasCue;
	private String hasLog;
	private String leechers;
	private String media;
	private String scene;
	private String seeders;
	private String snatched;
	private List<String> tags;
	private String torrentId;
	private String year;
	// tags
	private String name;
	private String negVotes;
	private String posVotes;
	private String uses;
	// users
	private String downSpeed;
	private String downloaded;
	private String id;
	private String joinDate;
	private String numUploads;
	private String upSpeed;
	private String uploaded;
	private String username;

	/**
	 * Gets the down speed.
	 * 
	 * @return the down speed
	 */
	public String getDownSpeed() {
		return this.downSpeed;
	}

	/**
	 * Gets the downloaded.
	 * 
	 * @return the downloaded
	 */
	public String getDownloaded() {
		return this.downloaded;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Gets the join date.
	 * 
	 * @return the join date
	 */
	public String getJoinDate() {
		return this.joinDate;
	}

	/**
	 * Gets the num uploads.
	 * 
	 * @return the num uploads
	 */
	public String getNumUploads() {
		return this.numUploads;
	}

	/**
	 * Gets the up speed.
	 * 
	 * @return the up speed
	 */
	public String getUpSpeed() {
		return this.upSpeed;
	}

	/**
	 * Gets the uploaded.
	 * 
	 * @return the uploaded
	 */
	public String getUploaded() {
		return this.uploaded;
	}

	/**
	 * Gets the username.
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the neg votes.
	 * 
	 * @return the neg votes
	 */
	public String getNegVotes() {
		return this.negVotes;
	}

	/**
	 * Gets the pos votes.
	 * 
	 * @return the pos votes
	 */
	public String getPosVotes() {
		return this.posVotes;
	}

	/**
	 * Gets the uses.
	 * 
	 * @return the uses
	 */
	public String getUses() {
		return this.uses;
	}

	/**
	 * Gets the artist.
	 * 
	 * @return the artist
	 */
	public String getArtist() {
		return this.artist;
	}

	/**
	 * Gets the encoding.
	 * 
	 * @return the encoding
	 */
	public String getEncoding() {
		return this.encoding;
	}

	/**
	 * Gets the format.
	 * 
	 * @return the format
	 */
	public String getFormat() {
		return this.format;
	}

	/**
	 * Gets the group id.
	 * 
	 * @return the group id
	 */
	public String getGroupId() {
		return this.groupId;
	}

	/**
	 * Gets the group year.
	 * 
	 * @return the group year
	 */
	public String getGroupYear() {
		return this.groupYear;
	}

	/**
	 * Gets the checks for cue.
	 * 
	 * @return the checks for cue
	 */
	public String getHasCue() {
		return this.hasCue;
	}

	/**
	 * Gets the checks for log.
	 * 
	 * @return the checks for log
	 */
	public String getHasLog() {
		return this.hasLog;
	}

	/**
	 * Gets the leechers.
	 * 
	 * @return the leechers
	 */
	public String getLeechers() {
		return this.leechers;
	}

	/**
	 * Gets the media.
	 * 
	 * @return the media
	 */
	public String getMedia() {
		return this.media;
	}

	/**
	 * Gets the scene.
	 * 
	 * @return the scene
	 */
	public String getScene() {
		return this.scene;
	}

	/**
	 * Gets the seeders.
	 * 
	 * @return the seeders
	 */
	public String getSeeders() {
		return this.seeders;
	}

	/**
	 * Gets the snatched.
	 * 
	 * @return the snatched
	 */
	public String getSnatched() {
		return this.snatched;
	}

	/**
	 * Gets the tags.
	 * 
	 * @return the tags
	 */
	public List<String> getTags() {
		return this.tags;
	}

	/**
	 * Gets the torrent id.
	 * 
	 * @return the torrent id
	 */
	public String getTorrentId() {
		return this.torrentId;
	}

	/**
	 * Gets the year.
	 * 
	 * @return the year
	 */
	public String getYear() {
		return this.year;
	}

	// TODO finish by adding passkey
	// TODO return SSL link
	/**
	 * Gets the download link.
	 * 
	 * @return the download link
	 */
	public String getDownloadLink() {
		String link;
		String authkey = MySoup.getAuthKey();
		link = MySoup.getSite() + "torrents.php?action=download&id=" + torrentId + "5&authkey=" + authkey + "&torrent_pass=";
		return link;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Results [artist=" + artist + ", encoding=" + encoding + ", format=" + format + ", groupId=" + groupId
				+ ", groupYear=" + groupYear + ", hasCue=" + hasCue + ", hasLog=" + hasLog + ", leechers=" + leechers
				+ ", media=" + media + ", scene=" + scene + ", seeders=" + seeders + ", snatched=" + snatched + ", tags=" + tags
				+ ", torrentId=" + torrentId + ", year=" + year + ", name=" + name + ", negVotes=" + negVotes + ", posVotes="
				+ posVotes + ", uses=" + uses + ", downSpeed=" + downSpeed + ", downloaded=" + downloaded + ", id=" + id
				+ ", joinDate=" + joinDate + ", numUploads=" + numUploads + ", upSpeed=" + upSpeed + ", uploaded=" + uploaded
				+ ", username=" + username + "]";
	}
}
