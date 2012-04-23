package api.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Connects to the update site and checks for messages and updates, to be used with the android app
 * 
 * @author Gwindow
 * 
 */
public class Updater {
	private Document doc = null;
	private static String UPDATE_SITE;

	public Updater(String updateSite) throws CouldNotLoadException {
		UPDATE_SITE = updateSite;
		try {
			doc = (Jsoup.connect(UPDATE_SITE).get());
		} catch (Exception e) {
			throw new CouldNotLoadException("Could not load update site");
		}
	}

	public Triple<String, String, String> getMessage() {
		if (getDoc() != null) {
			String title = getDoc().getElementsByTag("subject").text().trim();
			String body = getDoc().getElementsByTag("info").html();
			String valediction = getDoc().getElementsByTag("valediction").text().trim();
			return new Triple<String, String, String>(title, body, valediction);
		}
		return null;
	}

	public Double getVersion() {
		if (getDoc() != null) {
			String version = getDoc().getElementsByTag("version").text().trim();
			return Double.parseDouble(version);
		}
		return null;
	}

	public String getDownloadLink() {
		if (getDoc() != null) {
			String download = getDoc().getElementsByTag("update").text().trim();
			return download;
		}
		return null;
	}

	public Document getDoc() {
		return doc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Updater [getMessage()=" + getMessage() + ", getVersion()=" + getVersion() + ", getDownloadLink()="
				+ getDownloadLink() + ", getDoc()=" + getDoc() + "]";
	}

}