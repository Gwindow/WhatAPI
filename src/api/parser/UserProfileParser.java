package api.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import api.soup.MySoup;
import api.util.CouldNotLoadException;
import api.util.RegexTools;

/**
 * Parses the user profile
 * 
 * @author Tim
 * 
 */
public class UserProfileParser {
	private static RegexTools regex = new RegexTools();
	private static Document doc;

	public static void init(String userID) throws CouldNotLoadException {
		doc = MySoup.scrape(MySoup.getSite() + "user.php?id=" + userID);
	}

	/**
	 * Search for element in list containing a string
	 * 
	 * @param string
	 *            string to search for
	 * @param list
	 *            list to search
	 * @return string of element containing the searched for string
	 */
	private static String search(String string, ArrayList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).contains(string))
				return list.get(i);
		}
		return "Hidden";
	}

	public static String parseJoinDate() {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < doc.getElementsByClass("box").get(1).getElementsByTag("li").size(); i++) {
			list.add(doc.getElementsByClass("box").get(1).getElementsByTag("li").get(i).text());
		}
		return search("Joined:", list);
	}

	public static String parseUploaded() throws CouldNotLoadException {
		try {
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < doc.getElementsByClass("box").get(1).getElementsByTag("li").size(); i++) {
				list.add(doc.getElementsByClass("box").get(1).getElementsByTag("li").get(i).text());
			}
			return search("Uploaded:", list);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Couldn't load stats");
		}
	}

	public static String parseDownloaded() throws CouldNotLoadException {
		try {
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < doc.getElementsByClass("box").get(1).getElementsByTag("li").size(); i++) {
				list.add(doc.getElementsByClass("box").get(1).getElementsByTag("li").get(i).text());
			}
			return search("Downloaded:", list);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Couldn't load stats");
		}
	}

	public static String parseRatio() throws CouldNotLoadException {
		try {
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < doc.getElementsByClass("box").get(1).getElementsByTag("li").size(); i++) {
				list.add(doc.getElementsByClass("box").get(1).getElementsByTag("li").get(i).text());
			}
			return search("Ratio:", list);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Couldn't load stats");
		}
	}

	public static String parseRequiredRatio() {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < doc.getElementsByClass("box").get(1).getElementsByTag("li").size(); i++) {
			list.add(doc.getElementsByClass("box").get(1).getElementsByTag("li").get(i).text());
		}
		return search("Required ratio:", list);
	}

	public static String parseLastSeen() {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < doc.getElementsByClass("box").get(1).getElementsByTag("li").size(); i++) {
			list.add(doc.getElementsByClass("box").get(1).getElementsByTag("li").get(i).text());
		}
		return search("Last Seen:", list);
	}

	public static String parseForumPosts() {
		String s = doc.getElementsByClass("box").get(4).getElementsByTag("li").get(0).text().replace(" [View]", "");
		return s;
	}

	public static String parseSeeding() throws CouldNotLoadException {
		try {
			String s =
					doc.getElementsByClass("box").get(4).getElementsByTag("li").get(9).text().replace(" [View] [Download]", "");
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Couldn't load stats");
		}
	}

	public static String parseLeeching() throws CouldNotLoadException {
		try {
			String s = doc.getElementsByClass("box").get(4).getElementsByTag("li").get(10).text().replace(" [View]", "");
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Couldn't load stats");
		}
	}

	public static String parseUserClass() {
		return doc.getElementsByClass("box").get(3).getElementsByTag("li").get(0).text();
	}

	public static String parseUserProfileAvatar() throws IOException {

		Elements profile = doc.getElementsByClass("box");
		return regex.splitAvatar(profile.get(0).getElementsByTag("img").toString());
	}

	public static LinkedList<String> parseUserProfileRecentSnatches() throws IOException {
		LinkedList<String> snatchesList = new LinkedList<String>();

		Elements profile = doc.getElementsByClass("recent").get(0).getElementsByTag("a");
		for (int i = 0; i < profile.size(); i++) {
			snatchesList.add(profile.get(i).toString());
		}
		return snatchesList;
	}

	public static LinkedList<String> parseUserProfileRecentUploads() throws IOException {
		LinkedList<String> uploadsList = new LinkedList<String>();

		Elements profile = doc.getElementsByClass("recent").get(1).getElementsByTag("a");
		for (int i = 0; i < profile.size(); i++) {
			uploadsList.add(profile.get(i).toString());
		}
		return uploadsList;
	}

	public static String parseUserProfileText() throws IOException {
		Elements profile = doc.getElementsByClass("box");
		return regex.splitProfileText(profile.get(5).getElementsByClass("pad").toString());

	}

	public static String parseUserName() {
		Elements e = doc.getElementById("content").getElementsByClass("thin").get(0).getElementsByTag("h2");
		return e.text();
	}

}
