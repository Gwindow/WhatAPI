package api.torrents.artist;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import api.soup.MySoup;

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
	 * Description of torrent
	 * 
	 * @return description
	 */
	public String getDescription() {
		return this.Description;
	}

	/**
	 * Encoding of torrent
	 * 
	 * @return encoding
	 */
	public String getEncoding() {
		return this.Encoding;
	}

	/**
	 * Number of files in torrent
	 * 
	 * @return number of files in torrent
	 */
	public String getFileCount() {
		return this.FileCount;
	}

	/**
	 * Get the list of files in a torrent
	 * 
	 * @return file list
	 */
	public String getFileList() {
		return this.FileList;
	}

	/**
	 * @return
	 */
	public String getFilePath() {
		// TODO fix this, add to json in artist.php
		// return this.FilePath;

		return this.FilePath;
	}

	/**
	 * @return
	 */
	public String getFormat() {
		return this.Format;
	}

	/**
	 * @return
	 */
	public boolean isFreeTorrent() {
		if (FreeTorrent.equals("1"))
			return true;
		return false;
	}

	/**
	 * @return
	 */
	public boolean hasCue() {
		if (HasCue.equals("1"))
			return true;
		return false;
	}

	/**
	 * @return
	 */
	public boolean hasLog() {
		if (HasLog.equals("1"))
			return true;
		return false;
	}

	/**
	 * @return
	 */
	public String getID() {
		return this.ID;
	}

	/**
	 * @return
	 */
	public String getLeechers() {
		return this.Leechers;
	}

	/**
	 * @return
	 */
	public String getLogScore() {
		return this.LogScore;
	}

	/**
	 * @return
	 */
	public String getMedia() {
		return this.Media;
	}

	/**
	 * @return
	 */
	public String getRemasterCatalogueNumber() {
		return this.RemasterCatalogueNumber;
	}

	/**
	 * @return
	 */
	public String getRemasterRecordLabel() {
		return this.RemasterRecordLabel;
	}

	/**
	 * @return
	 */
	public String getRemasterTitle() {
		return this.RemasterTitle;
	}

	/**
	 * @return
	 */
	public String getRemasterYear() {
		return this.RemasterYear;
	}

	/**
	 * @return
	 */
	public boolean isRemastered() {
		if (Remastered.equals("1"))
			return true;
		return false;
	}

	/**
	 * @return
	 */
	public boolean isScene() {
		if (Scene.equals("1"))
			return true;
		return false;
	}

	/**
	 * @return
	 */
	public String getSeeders() {
		return this.Seeders;
	}

	/**
	 * @return
	 */
	public String getSize() {
		return this.Size;
	}

	/**
	 * @return
	 */
	public String getSnatched() {
		return this.Snatched;
	}

	/**
	 * @return
	 */
	public String getTime() {
		return this.Time;
	}

	/**
	 * @return
	 */
	public String getUserID() {
		return this.UserID;
	}

	/**
	 * @return
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

	public String getDownloadLink() {
		String site = MySoup.getSite();
		String authKey = MySoup.getAuthKey();
		String passKey = MySoup.getPassKey();
		String downloadLink = site + "torrents.php?action=download&id=" + ID + "&authkey=" + authKey + "&torrent_pass=" + passKey;
		return downloadLink;
	}

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
