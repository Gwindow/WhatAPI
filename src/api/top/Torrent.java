package api.top;

import api.soup.MySoup;

import java.util.List;

/**
 * Stores information about a top 10 torrent
 * 
 * @author Gwindow
 */
public class Torrent {

	/**
	 * The torrent id.
	 */
	private Number torrentId;

	/**
	 * The group id.
	 */
	private Number groupId;

	/** The artist. */
	private String artist;

	/**
	 * The group name.
	 */
	private String groupName;

	/**
	 * The group category.
	 */
	private Number groupCategory;

	/**
	 * The group year.
	 */
	private Number groupYear;

	/**
	 * The remaster title.
	 */
	private String remasterTitle;

	/**
	 * The format.
	 */
	private String format;

	/**
	 * The encoding.
	 */
	private String encoding;

	/**
	 * The has log.
	 */
	private boolean hasLog;

	/**
	 * The has cue.
	 */
	private boolean hasCue;

	/**
	 * The media.
	 */
	private String media;

	/**
	 * The scene.
	 */
	private boolean scene;

	/**
	 * The remaster year if this torrent is a remaster/other edition
	 * is 0 if this is the original release
	 */
	private Number year;

	/**
	 * The tags.
	 */
	private List<String> tags;

	/**
	 * The snatched.
	 */
	private Number snatched;

	/**
	 * The leechers.
	 */
	private Number leechers;

	/**
	 * The seeders.
	 */
	private Number seeders;

	/**
	 * The total number of bytes downloaded on this torrent.
	 */
	private Number data;

    /** The size of the torrent */
    private Number size;

	/**
	 * Gets the artist.
	 * 
	 * @return the artist
	 */
	public String getArtist() {
		return this.artist;
	}

	/**
	 * Get the total number of bytes downloaded for this torrent
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
     * Get the size of the torrent, in bytes
     *
     * @return torrent size in bytes
     */
    public Number getSize() {
        return this.size;
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
		return MySoup.getSite() + "torrents.php?action=download&id=" + torrentId
			+ "&authkey=" + MySoup.getAuthKey() + "&torrent_pass=" + MySoup.getPassKey();
	}

	public boolean isRemastered(){
		return !remasterTitle.isEmpty();
	}

	/**
	 * Get a concise representation of the torrent media, format and encoding. For example "CD - AAC - 320"
	 *
	 * @return the media, format, and encoding
	 */
	public String getMediaFormatEncoding(){
		String cue = hasCue ? " - " + "Cue" : "";
		return this.getMedia() + " - " + this.getFormat() + " - " + this.getEncoding() + cue;
	}

	/**
	 * Gets the remaster.
	 *
	 * @return the remaster
	 */
	public String getRemaster(){
		StringBuilder ed = new StringBuilder();
		ed.append(year).append(" - ");
		if (!remasterTitle.isEmpty()){
			ed.append(remasterTitle).append(" / ");
		}
		if (!media.isEmpty()){
			ed.append(media);
		}
		return ed.toString();
	}

	/**
	 * Get a short title that identifies this torrent and edition.
	 * Title is format remaster title/media/format
	 */
	public String getShortTitle(){
		StringBuilder title = new StringBuilder();
		title.append(getEditionTitle());
		if (!media.isEmpty()){
			title.append("/").append(media);
		}
		if (!format.isEmpty()){
			title.append("/");
			//Display FLAC or 320/V0/V2 as appropriate.
			if (format.equalsIgnoreCase("MP3")){
				title.append(encoding);
			}
			else {
				title.append(format);
			}
		}
		return title.toString();
	}

	/**
	 * Get a string describing the title of this edition.
	 */
	public String getEditionTitle(){
		if (!isRemastered()){
			return "Original Release";
		}
		StringBuilder title = new StringBuilder();
		title.append(year).append(" - ");
		if (!remasterTitle.isEmpty()){
			title.append(remasterTitle);
		}
		return title.toString();
	}


	@Override
	public String toString(){
		return "top.Torrent [getArtist()=" + getArtist() + ", getData()=" + getData() + ", getEncoding()=" + getEncoding()
				+ ", getFormat()=" + getFormat() + ", getGroupCategory()=" + getGroupCategory() + ", getGroupId()="
				+ getGroupId() + ", getGroupName()=" + getGroupName() + ", getGroupYear()=" + getGroupYear() + ", getHasCue()="
				+ getHasCue() + ", getHasLog()=" + getHasLog() + ", getLeechers()=" + getLeechers() + ", getMedia()="
				+ getMedia() + ", getRemasterTitle()=" + getRemasterTitle() + ", getScene()=" + getScene() + ", getSeeders()="
				+ getSeeders() + ", getSnatched()=" + getSnatched() + ", getTags()=" + getTags() + ", getTorrentId()="
				+ getTorrentId() + ", getYear()=" + getYear() + ", getDownloadLink()=" + getDownloadLink() + "]";
	}
}
