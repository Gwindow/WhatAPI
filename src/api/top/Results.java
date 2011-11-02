package api.top;

import java.util.List;

import api.soup.MySoup;

/**
 * The results of the top list
 * 
 * @author Tim
 * 
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

	public String getDownSpeed() {
		return this.downSpeed;
	}

	public String getDownloaded() {
		return this.downloaded;
	}

	public String getId() {
		return this.id;
	}

	public String getJoinDate() {
		return this.joinDate;
	}

	public String getNumUploads() {
		return this.numUploads;
	}

	public String getUpSpeed() {
		return this.upSpeed;
	}

	public String getUploaded() {
		return this.uploaded;
	}

	public String getUsername() {
		return this.username;
	}

	public String getName() {
		return this.name;
	}

	public String getNegVotes() {
		return this.negVotes;
	}

	public String getPosVotes() {
		return this.posVotes;
	}

	public String getUses() {
		return this.uses;
	}

	public String getArtist() {
		return this.artist;
	}

	public String getEncoding() {
		return this.encoding;
	}

	public String getFormat() {
		return this.format;
	}

	public String getGroupId() {
		return this.groupId;
	}

	public String getGroupYear() {
		return this.groupYear;
	}

	public String getHasCue() {
		return this.hasCue;
	}

	public String getHasLog() {
		return this.hasLog;
	}

	public String getLeechers() {
		return this.leechers;
	}

	public String getMedia() {
		return this.media;
	}

	public String getScene() {
		return this.scene;
	}

	public String getSeeders() {
		return this.seeders;
	}

	public String getSnatched() {
		return this.snatched;
	}

	public List<String> getTags() {
		return this.tags;
	}

	public String getTorrentId() {
		return this.torrentId;
	}

	public String getYear() {
		return this.year;
	}

	// TODO finish by adding passkey
	// TODO return SSL link
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
