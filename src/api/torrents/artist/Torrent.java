/**
 * @author Gwindow
 */
package api.torrents.artist;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import api.soup.MySoup;

/**
 * The Class Torrent.
 */
public class Torrent {
	private String Description;
	private String Encoding;
	private String FileCount;
	private String FileList;
	private String FilePath;
	private String Format;
	private String FreeTorrent;
	private String HasCue;
	private String HasLog;
	private String ID;
	private String Leechers;
	private String LogScore;
	private String Media;
	private String RemasterCatalogueNumber;
	private String RemasterRecordLabel;
	private String RemasterTitle;
	private String RemasterYear;
	private String Remastered;
	private String Scene;
	private String Seeders;
	private String Size;
	private String Snatched;
	private String Time;
	private String UserID;
	private String Username;

	/**
	 * Description of torrent.
	 * 
	 * @return description
	 */
	public String getDescription() {
		return this.Description;
	}

	/**
	 * Encoding of torrent.
	 * 
	 * @return encoding
	 */
	public String getEncoding() {
		return this.Encoding;
	}

	/**
	 * Number of files in torrent.
	 * 
	 * @return number of files in torrent
	 */
	public String getFileCount() {
		return this.FileCount;
	}

	/**
	 * Get the list of files in a torrent.
	 * 
	 * @return file list
	 */
	public String getFileList() {
		return this.FileList;
	}

	/**
	 * Gets the file path.
	 * 
	 * @return the file path
	 */
	public String getFilePath() {
		// TODO fix this, add to json in artist.php
		// return this.FilePath;

		return this.FilePath;
	}

	/**
	 * Gets the format.
	 * 
	 * @return the format
	 */
	public String getFormat() {
		return this.Format;
	}

	/**
	 * Checks if is free torrent.
	 * 
	 * @return true, if is free torrent
	 */
	public boolean isFreeTorrent() {
		if (FreeTorrent.equals("1"))
			return true;
		return false;
	}

	/**
	 * Checks for cue.
	 * 
	 * @return true, if successful
	 */
	public boolean hasCue() {
		if (HasCue.equals("1"))
			return true;
		return false;
	}

	/**
	 * Checks for log.
	 * 
	 * @return true, if successful
	 */
	public boolean hasLog() {
		if (HasLog.equals("1"))
			return true;
		return false;
	}

	/**
	 * Gets the iD.
	 * 
	 * @return the iD
	 */
	public String getID() {
		return this.ID;
	}

	/**
	 * Gets the leechers.
	 * 
	 * @return the leechers
	 */
	public String getLeechers() {
		return this.Leechers;
	}

	/**
	 * Gets the log score.
	 * 
	 * @return the log score
	 */
	public String getLogScore() {
		return this.LogScore;
	}

	/**
	 * Gets the media.
	 * 
	 * @return the media
	 */
	public String getMedia() {
		return this.Media;
	}

	/**
	 * Gets the remaster catalogue number.
	 * 
	 * @return the remaster catalogue number
	 */
	public String getRemasterCatalogueNumber() {
		return this.RemasterCatalogueNumber;
	}

	/**
	 * Gets the remaster record label.
	 * 
	 * @return the remaster record label
	 */
	public String getRemasterRecordLabel() {
		return this.RemasterRecordLabel;
	}

	/**
	 * Gets the remaster title.
	 * 
	 * @return the remaster title
	 */
	public String getRemasterTitle() {
		return this.RemasterTitle;
	}

	/**
	 * Gets the remaster year.
	 * 
	 * @return the remaster year
	 */
	public String getRemasterYear() {
		return this.RemasterYear;
	}

	/**
	 * Checks if is remastered.
	 * 
	 * @return true, if is remastered
	 */
	public boolean isRemastered() {
		if (Remastered.equals("1"))
			return true;
		return false;
	}

	/**
	 * Checks if is scene.
	 * 
	 * @return true, if is scene
	 */
	public boolean isScene() {
		if (Scene.equals("1"))
			return true;
		return false;
	}

	/**
	 * Gets the seeders.
	 * 
	 * @return the seeders
	 */
	public String getSeeders() {
		return this.Seeders;
	}

	/**
	 * Gets the size.
	 * 
	 * @return the size
	 */
	public String getSize() {
		return this.Size;
	}

	/**
	 * Gets the snatched.
	 * 
	 * @return the snatched
	 */
	public String getSnatched() {
		return this.Snatched;
	}

	/**
	 * Gets the time.
	 * 
	 * @return the time
	 */
	public String getTime() {
		return this.Time;
	}

	/**
	 * Gets the user id.
	 * 
	 * @return the user id
	 */
	public String getUserID() {
		return this.UserID;
	}

	/**
	 * Gets the username.
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return this.Username;
	}

	/**
	 * Get a concise representation of the torrent media, format and encoding. For example "CD - AAC - 320"
	 * 
	 * @return the media, format, and encoding
	 */
	public String getMediaFormatEncoding() {
		return this.getMedia() + " - " + this.getFormat() + " - " + this.getEncoding();

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
		String downloadLink = site + "torrents.php?action=download&id=" + ID + "&authkey=" + authKey + "&torrent_pass=" + passKey;
		return downloadLink;
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
		String name = getFilePath();
		if (getFilePath().equalsIgnoreCase("") || getFilePath().equals(null)) {
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

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Torrent [getDescription=" + getDescription() + ", getEncoding=" + getEncoding() + ", getFileCount="
				+ getFileCount() + ", getFileList=" + getFileList() + ", getFilePath=" + getFilePath() + ", getFormat="
				+ getFormat() + ", isFreeTorrent=" + isFreeTorrent() + ", hasCue=" + hasCue() + ", hasLog=" + hasLog()
				+ ", getID=" + getID() + ", getLeechers=" + getLeechers() + ", getLogScore=" + getLogScore() + ", getMedia="
				+ getMedia() + ", getRemasterCatalogueNumber=" + getRemasterCatalogueNumber() + ", getRemasterRecordLabel="
				+ getRemasterRecordLabel() + ", getRemasterTitle=" + getRemasterTitle() + ", getRemasterYear="
				+ getRemasterYear() + ", isRemastered=" + isRemastered() + ", isScene=" + isScene() + ", getSeeders="
				+ getSeeders() + ", getSize=" + getSize() + ", getSnatched=" + getSnatched() + ", getTime=" + getTime()
				+ ", getUserID=" + getUserID() + ", getUsername=" + getUsername() + ", getDownloadLink=" + getDownloadLink()
				+ "]";
	}

}
