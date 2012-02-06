package api.cli;

import api.search.requests.CrossReference;
import api.search.requests.RequestsSearch;
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
		RequestsSearch rs = CrossReference.crossReferenceRequestsByUPC("4011222222428");
		/*
		 * ProductSearch ps = ProductSearch.productSearchFromTitle("under dog world strike"); for (int i = 0; i <
		 * ps.getItems().size(); i++) { System.out.println(ps.getItems().get(i).getProduct().getTitle()); }
		 * System.err.println(CrossReference.determineSearchString(ps.getItems()));
		 */

		for (int i = 0; i < rs.getResponse().getResults().size(); i++) {
			System.out.println(rs.getResponse().getResults().get(i).getTitle());
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
