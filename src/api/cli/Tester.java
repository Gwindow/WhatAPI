package api.cli;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import api.search.torrents.TorrentSearch;
import api.soup.MySoup;
import api.util.CouldNotLoadException;

/**
 * The Class Tester.
 * 
 * @author Gwindow
 */
public class Tester {

	/**
	 * Instantiates a new tester.
	 * 
	 * @throws CouldNotLoadException
	 *             the could not load exception
	 */
	public Tester() throws CouldNotLoadException {
		MySoup.setSite("what.cd");
		TorrentSearch ts = TorrentSearch.torrentSearchFromSearchTerm("hello");
		System.out.println(ts);
		// for (int i = 0; i < ts.getResponse().getResults().size(); i++) {
		// System.out.println(ts.getResponse().getResults().get(i).getGroupYear().toString());
		// }
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 * @throws CouldNotLoadException
	 *             the could not load exception
	 */
	public static void main(String[] args) throws CouldNotLoadException {
		new Tester();

	}

	public String split(String string, String from, String to) {
		Pattern pattern = Pattern.compile(".*" + from + "(.*)" + to + ".*");
		Matcher matcher = pattern.matcher(string);
		if (matcher.matches())
			return matcher.group(1);
		return null;
	}

}
