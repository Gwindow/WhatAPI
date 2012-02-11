package api.cli;

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

		TorrentSearch rs = TorrentSearch.torrentSearchFromSearchTerm("chopin");
		for (int i = 0; i < rs.getResponse().getResults().size(); i++) {
			System.out.println(rs.getResponse().getResults().get(i).getGroupName());
		}

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

}
