package api.better;

import java.util.List;

/**
 * The Class Response.
 * 
 * //TODO description
 * 
 * @author Gwindow
 */
public class Response {
	private List<Results> results;

	/** The artist. */
	private List<Artist> artist;

	/** The download url. */
	private String downloadUrl;

	/** The group id. */
	private Number groupId;

	/** The group name. */
	private String groupName;

	/** The group year. */
	private Number groupYear;

	/** The torrent id. */
	private Number torrentId;

	/**
	 * Gets the artist.
	 * 
	 * @return the artist
	 */
	public List<Artist> getArtist() {
		return this.artist;
	}

	/**
	 * Gets the download url.
	 * 
	 * @return the download url
	 */
	public String getDownloadUrl() {
		return this.downloadUrl;
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
	 * Gets the torrent id.
	 * 
	 * @return the torrent id
	 */
	public Number getTorrentId() {
		return this.torrentId;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Response [getArtist=" + getArtist() + ", getDownloadUrl=" + getDownloadUrl() + ", getGroupId=" + getGroupId()
				+ ", getGroupName=" + getGroupName() + ", getGroupYear=" + getGroupYear() + ", getTorrentId=" + getTorrentId()
				+ "]";
	}
}
