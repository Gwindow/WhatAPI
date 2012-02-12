package api.cli;

import api.soup.MySoup;
import api.subscriptions.Subscriptions;
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
		/*
		 * RequestsSearch rs = RequestsSearch.requestSearchFromSearchTerm("chopin"); for (int i = 0; i <
		 * rs.getResponse().getResults().size(); i++) {
		 * System.out.println(rs.getResponse().getResults().get(i).getTitle()); }
		 */
		Subscriptions s = Subscriptions.init();
		for (int i = 0; i < s.getResponse().getThreads().size(); i++) {
			System.out.println(s.getResponse().getThreads().get(i).getThreadTitle());
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
