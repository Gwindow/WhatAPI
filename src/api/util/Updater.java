package api.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Connects to the update site and checks for messages and updates, to be used with the android app.
 * 
 * @author Gwindow
 */
public class Updater {

	/** The doc. */
	private Document doc = null;

	/** The update site. */
	private String updateSite;

	/**
	 * Instantiates a new updater.
	 * 
	 * @param updateSite
	 *            the update site
	 */
	public Updater(String updateSite) {
		this.updateSite = updateSite;
	}

	/**
	 * Check for updates.
	 * 
	 * @throws CouldNotLoadException
	 *             the could not load exception
	 */
	public void checkForUpdates() throws CouldNotLoadException {
		try {
			doc = (Jsoup.connect(updateSite).get());
		} catch (Exception e) {
			throw new CouldNotLoadException("Could not load update site");
		}
	}

	/**
	 * Gets the message.
	 * 
	 * @return the message
	 */
	public Triple<String, String, String> getMessage() {
		if (getDoc() != null) {
			String title = getDoc().getElementsByTag("subject").text().trim();
			String body = getDoc().getElementsByTag("info").html();
			String valediction = getDoc().getElementsByTag("valediction").text().trim();
			return new Triple<String, String, String>(title, body, valediction);
		}
		return null;
	}

	/**
	 * Gets the version.
	 * 
	 * @return the version
	 */
	public Double getVersion() {
		if (getDoc() != null) {
			String version = getDoc().getElementsByTag("version").text().trim();
			return Double.parseDouble(version);
		}
		return null;
	}

	/**
	 * Gets the download link.
	 * 
	 * @return the download link
	 */
	public String getDownloadLink() {
		if (getDoc() != null) {
			String download = getDoc().getElementsByTag("update").text().trim();
			return download;
		}
		return null;
	}

	/**
	 * Gets the doc.
	 * 
	 * @return the doc
	 */
	public Document getDoc() {
		return doc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	/**
	 * To string.
	 * 
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Updater [getMessage()=" + getMessage() + ", getVersion()=" + getVersion() + ", getDownloadLink()="
				+ getDownloadLink();
	}

}