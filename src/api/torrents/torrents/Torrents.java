package api.torrents.torrents;

import api.soup.MySoup;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class Torrents.
 *
 * @author Gwindow
 * @since Jun 2, 2012 12:08:53 AM
 */
public class Torrents {

	/**
	 * The description.
	 */
	private String description;

	/**
	 * The encoding.
	 */
	private String encoding;

	/**
	 * The file count.
	 */
	private Number fileCount;

	/**
	 * The file list.
	 */
	private String fileList;

	/**
	 * The file path.
	 */
	private String filePath;

	/**
	 * The format.
	 */
	private String format;

	/**
	 * The free torrent.
	 */
	private boolean freeTorrent;

	private boolean reported;

	/**
	 * The has cue.
	 */
	private boolean hasCue;

	/**
	 * The has log.
	 */
	private boolean hasLog;

	/**
	 * The id.
	 */
	private Number id;

	/**
	 * The leechers.
	 */
	private Number leechers;

	/**
	 * The log score.
	 */
	private Number logScore;

	/**
	 * The media.
	 */
	private String media;

	/**
	 * The remaster catalogue number.
	 */
	private String remasterCatalogueNumber;

	/**
	 * The remaster record label.
	 */
	private String remasterRecordLabel;

	/**
	 * The remaster title.
	 */
	private String remasterTitle;

	/**
	 * The remaster year.
	 */
	private Number remasterYear;

	/**
	 * The remastered.
	 */
	private boolean remastered;

	/**
	 * The scene.
	 */
	private boolean scene;

	/**
	 * The seeders.
	 */
	private Number seeders;

	/**
	 * The size.
	 */
	private Number size;

	/**
	 * The snatched.
	 */
	private Number snatched;

	/**
	 * The time.
	 */
	private String time;

	/**
	 * The user id.
	 */
	private Number userId;

	/**
	 * The username.
	 */
	private String username;

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription(){
		return this.description;
	}

	/**
	 * Gets the encoding.
	 *
	 * @return the encoding
	 */
	public String getEncoding(){
		return this.encoding;
	}

	/**
	 * Gets the file count.
	 *
	 * @return the file count
	 */
	public Number getFileCount(){
		return this.fileCount;
	}

	/**
	 * Gets the file list.
	 *
	 * @return the file list
	 */
	public String getFileList(){
		return this.fileList;
	}

	/**
	 * Get a list of files that are in the torrent and their sizes
	 */
	public List<TorrentFile> getTorrentFiles(){
		List<TorrentFile> files = new ArrayList<TorrentFile>();
		//Torrent files are formatted: file{{{size}}}|||file2{{{size2}}}
		for (String f : fileList.split("[|]{3}")){
			files.add(new TorrentFile(f));
		}
		return files;
	}

	/**
	 * Gets the file path.
	 *
	 * @return the file path
	 */
	public String getFilePath(){
		return this.filePath;
	}

	/**
	 * Gets the format.
	 *
	 * @return the format
	 */
	public String getFormat(){
		return this.format;
	}

	/**
	 * Gets the free torrent.
	 *
	 * @return the free torrent
	 */
	public boolean isFreeTorrent(){
		return this.freeTorrent;
	}

	public boolean isReported(){
		return reported;
	}

	/**
	 * Checks for cue.
	 *
	 * @return true, if successful
	 */
	public boolean hasCue(){
		return this.hasCue;
	}

	/**
	 * Checks for log.
	 *
	 * @return true, if successful
	 */
	public boolean hasLog(){
		return this.hasLog;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Number getId(){
		return this.id;
	}

	/**
	 * Gets the leechers.
	 *
	 * @return the leechers
	 */
	public Number getLeechers(){
		return this.leechers;
	}

	/**
	 * Gets the log score.
	 *
	 * @return the log score
	 */
	public Number getLogScore(){
		return this.logScore;
	}

	/**
	 * Gets the media.
	 *
	 * @return the media
	 */
	public String getMedia(){
		return this.media;
	}

	/**
	 * Gets the remaster catalogue number.
	 *
	 * @return the remaster catalogue number
	 */
	public String getRemasterCatalogueNumber(){
		return this.remasterCatalogueNumber;
	}

	/**
	 * Gets the remaster record label.
	 *
	 * @return the remaster record label
	 */
	public String getRemasterRecordLabel(){
		return this.remasterRecordLabel;
	}

	/**
	 * Gets the remaster title.
	 *
	 * @return the remaster title
	 */
	public String getRemasterTitle(){
		return this.remasterTitle;
	}

	/**
	 * Gets the remaster year.
	 *
	 * @return the remaster year
	 */
	public Number getRemasterYear(){
		return this.remasterYear;
	}

	/**
	 * Checks if is remastered.
	 *
	 * @return true, if is remastered
	 */
	public boolean isRemastered(){
		return this.remastered;
	}

	/**
	 * Checks if is scene.
	 *
	 * @return true, if is scene
	 */
	public boolean isScene(){
		return this.scene;
	}

	/**
	 * Gets the seeders.
	 *
	 * @return the seeders
	 */
	public Number getSeeders(){
		return this.seeders;
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public Number getSize(){
		return this.size;
	}

	/**
	 * Gets the snatched.
	 *
	 * @return the snatched
	 */
	public Number getSnatched(){
		return this.snatched;
	}

	/**
	 * Gets the time.
	 *
	 * @return the time
	 */
	public String getTime(){
		return this.time;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public Number getUserId(){
		return this.userId;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername(){
		return this.username;
	}

	/**
	 * Check if this torrent is the same edition as some other one
	 *
	 * @param t other torrent to compare
	 * @return true if the torrents are part of the same edition of the album
	 */
	public boolean sameEdition(Torrents t){
		return remastered == t.remastered && getRemaster().equals(t.getRemaster());
	}

	/**
	 * Gets the download link.
	 *
	 * @return the download link
	 */
	public String getDownloadLink(){
		String site = MySoup.getSite();
		String authKey = MySoup.getAuthKey();
		String passKey = MySoup.getPassKey();
		return site + "torrents.php?action=download&id=" + this.getId()
			+ "&authkey=" + authKey + "&torrent_pass=" + passKey;
	}

	/**
	 * Get a concise representation of the torrent media, format and encoding. For example "CD - AAC - 320"
	 *
	 * @return the media, format, and encoding
	 */
	public String getMediaFormatEncoding(){
		String log = hasLog ? " - " + logScore.toString() : "";
		String cue = hasCue ? " - " + "Cue" : "";
		return this.getMedia() + " - " + this.getFormat() + " - " + this.getEncoding() + log + cue;
	}

	/**
	 * Gets the remaster.
	 *
	 * @return the remaster
	 */
	public String getRemaster(){
		StringBuilder ed = new StringBuilder();
		ed.append(remasterYear).append(" - ");
		if (!remasterRecordLabel.isEmpty()){
			ed.append(remasterRecordLabel).append(" / ");
		}
		if (!remasterTitle.isEmpty()){
			ed.append(remasterTitle).append(" / ");
		}
		if (!remasterCatalogueNumber.isEmpty()){
			ed.append(remasterCatalogueNumber).append(" / ");
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
	 * Get a string describing the title of this edition. May instead want to change
	 * where the built up edition information is stored
	 */
	public String getEditionTitle(){
		if (!isRemastered()){
			return "Original Release";
		}
		StringBuilder title = new StringBuilder();
		title.append(remasterYear).append(" - ");
		if (!remasterRecordLabel.isEmpty()){
			title.append(remasterRecordLabel);
			if (!remasterTitle.isEmpty() || !remasterCatalogueNumber.isEmpty()){
				title.append(" / ");
			}
		}
		if (!remasterTitle.isEmpty()){
			title.append(remasterTitle);
			if (!remasterCatalogueNumber.isEmpty()){
				title.append(" / ");
			}
		}
		if (!remasterCatalogueNumber.isEmpty()){
			title.append(remasterCatalogueNumber);
		}
		return title.toString();
	}

	/**
	 * Download file.
	 *
	 * @param url  the url
	 * @param path the path
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void downloadFile(String url, String path) throws IOException{
		String name = getFilePath();
		if (getFilePath().equalsIgnoreCase("") || getFilePath().equals(null)){
			// todo fix this
			name = "Unknown " + "(" + getMediaFormatEncoding() + ")";
		}
		URL u;
		u = new URL(getDownloadLink());
		ReadableByteChannel rbc = Channels.newChannel(u.openStream());
		FileOutputStream fos = new FileOutputStream(path + name + ".torrent");
		fos.getChannel().transferFrom(rbc, 0, 1 << 24);
		System.out.println("Downloaded " + name + " to " + path);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString(){
		return "Torrents [getDescription()=" + getDescription() + ", getEncoding()=" + getEncoding() + ", getFileCount()="
			+ getFileCount() + ", getFileList()=" + getFileList() + ", getFilePath()=" + getFilePath() + ", getFormat()="
			+ getFormat() + ", getFreeTorrent()=" + isFreeTorrent() + ", isReported()=" + isReported()
			+ ", hasCue()=" + hasCue() + ", hasLog()=" + hasLog()
			+ ", getId()=" + getId() + ", getLeechers()=" + getLeechers() + ", getLogScore()=" + getLogScore()
			+ ", getMedia()=" + getMedia() + ", getRemasterCatalogueNumber()=" + getRemasterCatalogueNumber()
			+ ", getRemasterRecordLabel()=" + getRemasterRecordLabel() + ", getRemasterTitle()=" + getRemasterTitle()
			+ ", getRemasterYear()=" + getRemasterYear() + ", isRemastered()=" + isRemastered() + ", isScene()=" + isScene()
			+ ", getSeeders()=" + getSeeders() + ", getSize()=" + getSize() + ", getSnatched()=" + getSnatched()
			+ ", getTime()=" + getTime() + ", getUserId()=" + getUserId() + ", getUsername()=" + getUsername() + "]";
	}
}
