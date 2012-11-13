
package api.top;

import java.util.List;

import api.soup.MySoup;

//TODO add user and tags.
/**
 * The Class Results.
 * 
 * @author Gwindow
 */
public class Results {

	/** The artist. */
	private String artist;

	/** The data. */
	private Number data;

	/** The encoding. */
	private String encoding;

	/** The format. */
	private String format;

	/** The group category. */
	private Number groupCategory;

	/** The group id. */
	private Number groupId;

	/** The group name. */
	private String groupName;

	/** The group year. */
	private Number groupYear;

	/** The has cue. */
	private boolean hasCue;

	/** The has log. */
	private boolean hasLog;

	/** The leechers. */
	private Number leechers;

	/** The media. */
	private String media;

	/** The remaster title. */
	private String remasterTitle;

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
	private Number year;

	/** The name. */
	private String name;

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
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
	 * Gets the data.
	 * 
	 * @return the data
	 */
	public Number getData() {
		return this.data;
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
	 * Gets the group category.
	 * 
	 * @return the group category
	 */
	public Number getGroupCategory() {
		return this.groupCategory;
	}

	/**
	 * Gets the group id.
	 * 
	 * @return the group id
	 */
	public Number getGroupId() {
		return this.groupId;
	}

	/**
	 * Gets the group name.
	 * 
	 * @return the group name
	 */
	public String getGroupName() {
		return this.groupName;
	}

	/**
	 * Gets the group year.
	 * 
	 * @return the group year
	 */
	public Number getGroupYear() {
		return this.groupYear;
	}

	/**
	 * Gets the checks for cue.
	 * 
	 * @return the checks for cue
	 */
	public boolean getHasCue() {
		return this.hasCue;
	}

	/**
	 * Gets the checks for log.
	 * 
	 * @return the checks for log
	 */
	public boolean getHasLog() {
		return this.hasLog;
	}

	/**
	 * Gets the leechers.
	 * 
	 * @return the leechers
	 */
	public Number getLeechers() {
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
	 * Gets the remaster title.
	 * 
	 * @return the remaster title
	 */
	public String getRemasterTitle() {
		return this.remasterTitle;
	}

	/**
	 * Gets the scene.
	 * 
	 * @return the scene
	 */
	public boolean getScene() {
		return this.scene;
	}

	/**
	 * Gets the seeders.
	 * 
	 * @return the seeders
	 */
	public Number getSeeders() {
		return this.seeders;
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
	public Number getTorrentId() {
		return this.torrentId;
	}

	/**
	 * Gets the year.
	 * 
	 * @return the year
	 */
	public Number getYear() {
		return this.year;
	}

	/**
	 * Gets the download link.
	 * 
	 * @return the download link
	 */
	public String getDownloadLink() {
		String authkey = MySoup.getAuthKey();
		String passkey = MySoup.getPassKey();
		return MySoup.getSite() + "torrents.php?action=download&id=" + torrentId
                + "&authkey=" + authkey
                + "&torrent_pass=" + passkey;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Results [getArtist()=" + getArtist() + ", getData()=" + getData() + ", getEncoding()=" + getEncoding()
				+ ", getFormat()=" + getFormat() + ", getGroupCategory()=" + getGroupCategory() + ", getGroupId()="
				+ getGroupId() + ", getGroupName()=" + getGroupName() + ", getGroupYear()=" + getGroupYear() + ", getHasCue()="
				+ getHasCue() + ", getHasLog()=" + getHasLog() + ", getLeechers()=" + getLeechers() + ", getMedia()="
				+ getMedia() + ", getRemasterTitle()=" + getRemasterTitle() + ", getScene()=" + getScene() + ", getSeeders()="
				+ getSeeders() + ", getSnatched()=" + getSnatched() + ", getTags()=" + getTags() + ", getTorrentId()="
				+ getTorrentId() + ", getYear()=" + getYear() + ", getDownloadLink()=" + getDownloadLink() + "]";
	}
}
