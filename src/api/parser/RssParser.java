package api.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jsoup.select.Elements;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import api.soup.MySoup;
import api.util.CouldNotLoadException;
import api.util.RegexTools;
import api.util.Tuple;

public class RssParser {
	private static RegexTools regex = new RegexTools();
	private static List<Tuple<String, String>> list = new ArrayList<Tuple<String, String>>();

	/**
	 * This class should be used statically.
	 */
	private RssParser() {

	}

	/**
	 * Load list of rss feeds
	 * 
	 * @param doc
	 *            index of what.cd
	 * @throws CouldNotLoadException
	 */
	public static void loadRssFeedList(org.jsoup.nodes.Document doc) throws CouldNotLoadException {
		list.clear();
		String title, url;
		try {
			Elements e = doc.getElementsByTag("head").get(0).getElementsByTag("link");
			for (int i = 0; i < e.size(); i++) {
				if (e.get(i).toString().contains("<link rel=\"alternate\" type=\"application/rss+xml")) {
					title = regex.split(e.get(i).toString(), "title=\"", "\" />");
					url = regex.split(e.get(i).toString(), "href=\"", "\" title");
					url = url.replace("amp;", "");
					if (MySoup.isSSLEnabled()) {
						url = "https://ssl.what.cd/" + url;
					} else {
						url = MySoup.getSite() + "" + url;
					}
					list.add(new Tuple<String, String>(title, url));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Couldn't load RSS feeds");
		}
	}

	public static List<Tuple<String, String>> getRssFeedList() {
		return list;
	}

	/**
	 * Parses the given URL into a list of RssItems.
	 * 
	 * @param url
	 *            URL to be parsed.
	 * @return List of RssItems.
	 */
	public static ArrayList<RssItem> parse(String url) throws CouldNotLoadException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		ArrayList<RssItem> rssItems = new ArrayList<RssItem>();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document dom = db.parse(url);
			NodeList items = dom.getElementsByTagName("item");
			int length = items.getLength();
			for (int i = 0; i < length; i++) {
				RssItem rssItem = new RssItem();
				Element item = (Element) items.item(i);
				rssItem.setTitle(item.getElementsByTagName("title").item(0).getFirstChild().getNodeValue());
				rssItem.setDescription(item.getElementsByTagName("description").item(0).getFirstChild().getNodeValue());
				rssItem.setDate(item.getElementsByTagName("pubDate").item(0).getFirstChild().getNodeValue());
				rssItem.setCreator(item.getElementsByTagName("dc:creator").item(0).getFirstChild().getNodeValue());

				if (item.getElementsByTagName("comments").getLength() > 0) {
					String link = item.getElementsByTagName("comments").item(0).getFirstChild().getNodeValue();
					rssItem.setLink(link);
					rssItem.setId(link.substring(link.lastIndexOf("=")));
					rssItem.setDirectLink(item.getElementsByTagName("guid").item(0).getFirstChild().getNodeValue());
				} else {
					String link = item.getElementsByTagName("guid").item(0).getFirstChild().getNodeValue();
					if (link.indexOf("#") != -1) {
						rssItem.setId(link.substring(link.indexOf("#"), link.length()));
					} else if (link.indexOf("=") != -1) {
						rssItem.setId(link.substring(link.lastIndexOf("=")));
					} else {
						rssItem.setId("-1");
					}
					rssItem.setLink(link);
					rssItem.setDirectLink(null);
				}

				rssItems.add(rssItem);
			}
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
			throw new CouldNotLoadException("Couldn't load RSS feed");
		} catch (SAXException se) {
			se.printStackTrace();
			throw new CouldNotLoadException("Couldn't load RSS feed");
		} catch (IOException ioe) {
			ioe.printStackTrace();
			throw new CouldNotLoadException("Couldn't load RSS feed");
		}
		return rssItems;
	}
}
