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
			// TODO fix update url
			doc = Jsoup.connect(UPDATE_SITE).get();
		} catch (Exception e) {
			throw new CouldNotLoadException("Could not load update site");
		}
	}

	public Tuple<String, String> getMessage() {
		if (doc != null) {
			String title = doc.getElementsByTag("subject").text();
			String body = doc.getElementsByTag("info").text();
			return new Tuple<String, String>(title, body);
		}
		return null;
	}

	public Double getVersion() {
		if (doc != null) {
			String version = doc.getElementsByTag("version").text();
			return Double.parseDouble(version);
		}
		return null;
	}

	public String getDownloadLink() {
		if (doc != null) {
			String download = doc.getElementsByTag("link").text();
			return download;
		}
		return null;
	}
}