/**
 * @author Gwindow
 */
package api.whatstatus;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import twitter4j.Paging;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import api.soup.MySoup;
import api.util.CouldNotLoadException;
import api.util.Tuple;

/**
 * The Class Status2.
 * 
 * @author Tim Get the status of what.cd 0 is up 1 is down 2 is maintenance
 */
public class Status2 {
	String whatstatus = "http://whatstatus.info/";
	Document whatDoc;

	/**
	 * Instantiates a new status2.
	 * 
	 * @throws CouldNotLoadException
	 *             the could not load exception
	 */
	public Status2() throws CouldNotLoadException {
		try {
			whatDoc = MySoup.scrapeOther(whatstatus);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Could now load whatstatus.info");
		}
	}

	/**
	 * Get status of the site.
	 * 
	 * @return 0 is up 1 is down 2 is maintenance
	 */
	public int getSiteStatus() {

		Elements e = whatDoc.getElementById("status").getElementById("service_table").getElementsByTag("tr");

		if ((e.get(0).getElementsByClass("status").text().equalsIgnoreCase("up"))) {
			System.out.println("Site Up");
			return 0;
		} else if ((e.get(0).getElementsByClass("status").text().equalsIgnoreCase("down"))) {
			System.out.println("Site Down");
			return 1;
		} else {
			System.out.println("Site Maintenance");
			return 2;
		}
	}

	/**
	 * Get status of tracker.
	 * 
	 * @return 0 is up 1 is down 2 is maintenance
	 */
	public int getTrackerStatus() {
		Elements e = whatDoc.getElementById("status").getElementById("service_table").getElementsByTag("tr");

		if ((e.get(1).getElementsByClass("status").text().equalsIgnoreCase("up"))) {
			System.out.println("Tracker Up");
			return 0;
		} else if ((e.get(1).getElementsByClass("status").text().equalsIgnoreCase("down"))) {
			System.out.println("Tracker Down");
			return 1;
		} else {
			System.out.println("Tracker Maintenance");
			return 2;
		}
	}

	/**
	 * Get status of irc network.
	 * 
	 * @return 0 is up 1 is down 2 is maintenance
	 */
	public int getIrcStatus() {
		Elements e = whatDoc.getElementById("status").getElementById("service_table").getElementsByTag("tr");

		if ((e.get(2).getElementsByClass("status").text().equalsIgnoreCase("up"))) {
			System.out.println("IRC Up");
			return 0;
		} else if ((e.get(2).getElementsByClass("status").text().equalsIgnoreCase("down"))) {
			System.out.println("IRC Down");
			return 1;
		} else {
			System.out.println("IRC Maintenance");
			return 2;
		}
	}

	/**
	 * Get a list of tweets containing the text and date.
	 * 
	 * @return list of tweets
	 * @throws TwitterException
	 *             the twitter exception
	 */
	public ArrayList<Tuple<String, String>> getTweets() throws TwitterException {
		Twitter unauthenticatedTwitter = new TwitterFactory().getInstance();
		// get the first 6 tweets on the first page
		Paging paging = new Paging(1, 6);
		List<twitter4j.Status> status = unauthenticatedTwitter.getUserTimeline("whatcd", paging);
		ArrayList<Tuple<String, String>> tweetList = new ArrayList<Tuple<String, String>>();

		for (int i = 0; i < status.size(); i++) {
			tweetList.add(new Tuple<String, String>(status.get(i).getText(), status.get(i).getCreatedAt().toString()));
		}
		return tweetList;
	}
}
