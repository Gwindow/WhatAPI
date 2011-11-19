/**
 * @author Gwindow
 */
package api.torrents.torrents;

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
	private String description;
	private String encoding;
	private Number fileCount;
	private String fileList;
	private String filePath;
	private String format;
	private boolean freeTorrent;
	private boolean hasCue;
	private boolean hasLog;
	private Number id;
	private Number leechers;
	private Number logScore;
	private String media;
	private String remasterCatalogueNumber;
	private String remasterRecordLabel;
	private String remasterTitle;
	private String remasterYear;
	private boolean remastered;
	private boolean scene;
	private Number seeders;
	private Number size;
	private Number snatched;
	private String time;
	private Number userId;
	private String username;

	public String getDescription() {
		return this.description;
	}

	public String getEncoding() {
		return this.encoding;
	}

	public Number getFileCount() {
		return this.fileCount;
	}

	public String getFileList() {
		return this.fileList;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public String getFormat() {
		return this.format;
	}

	public boolean isFreeTorrent() {
		return this.freeTorrent;
	}

	public boolean hasCue() {
		return this.hasCue;
	}

	public boolean hasLog() {
		return this.hasLog;
	}

	public Number getId() {
		return this.id;
	}

	public Number getLeechers() {
		return this.leechers;
	}

	public Number getLogScore() {
		return this.logScore;
	}

	public String getMedia() {
		return this.media;
	}

	public String getRemasterCatalogueNumber() {
		return this.remasterCatalogueNumber;
	}

	public String getRemasterRecordLabel() {
		return this.remasterRecordLabel;
	}

	public String getRemasterTitle() {
		return this.remasterTitle;
	}

	public String getRemasterYear() {
		return this.remasterYear;
	}

	public boolean getRemastered() {
		return this.remastered;
	}

	public boolean isScene() {
		return this.scene;
	}

	public Number getSeeders() {
		return this.seeders;
	}

	public Number getSize() {
		return this.size;
	}

	public Number getSnatched() {
		return this.snatched;
	}

	public String getTime() {
		return this.time;
	}

	public Number getUserId() {
		return this.userId;
	}

	public String getUsername() {
		return this.username;
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
		String downloadLink =
				site + "torrents.php?action=download&id=" + this.getId() + "&authkey=" + authKey + "&torrent_pass=" + passKey;
		return downloadLink;
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

}
