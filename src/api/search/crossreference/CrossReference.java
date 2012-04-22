
package api.search.crossreference;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import api.products.Items;
import api.products.ProductSearch;
import api.search.requests.RequestsSearch;
import api.search.torrents.TorrentSearch;
import api.util.Tuple;

/**
 * The Class CrossReference.
 * 
 * //TODO description
 * 
 * @author Gwindow
 */
public class CrossReference {

	/** The determined search term. */
	private static String determinedSearchTerm;

	/**
	 * Cross reference requests by search term.
	 * 
	 * @param searchTerm
	 *            the search term
	 * @return the requests search
	 */
	public static RequestsSearch crossReferenceRequestsBySearchTerm(String searchTerm) {
		ProductSearch ps = ProductSearch.productSearchFromTitle(searchTerm);
		determinedSearchTerm = determineSearchString(ps.getItems());
		RequestsSearch r = RequestsSearch.requestSearchFromSearchTerm(determinedSearchTerm);
		return r;
	}

	/**
	 * Cross reference requests by upc.
	 * 
	 * @param upc
	 *            the upc
	 * @return the requests search
	 */
	public static RequestsSearch crossReferenceRequestsByUPC(String upc) {
		ProductSearch ps = ProductSearch.productSearchFromTitle(upc);
		determinedSearchTerm = determineSearchString(ps.getItems());
		RequestsSearch r = RequestsSearch.requestSearchFromSearchTerm(determinedSearchTerm);
		return r;
	}

	/**
	 * Cross reference torrents by search term.
	 * 
	 * @param searchTerm
	 *            the search term
	 * @return the torrent search
	 */
	public static TorrentSearch crossReferenceTorrentsBySearchTerm(String searchTerm) {
		ProductSearch ps = ProductSearch.productSearchFromTitle(searchTerm);
		determinedSearchTerm = determineSearchString(ps.getItems());
		TorrentSearch t = TorrentSearch.torrentSearchFromSearchTerm(determinedSearchTerm);
		return t;
	}

	/**
	 * Cross reference torrents by upc.
	 * 
	 * @param upc
	 *            the upc
	 * @return the torrent search
	 */
	public static TorrentSearch crossReferenceTorrentsByUPC(String upc) {
		ProductSearch ps = ProductSearch.productSearchFromTitle(upc);
		determinedSearchTerm = determineSearchString(ps.getItems());
		TorrentSearch t = TorrentSearch.torrentSearchFromSearchTerm(determinedSearchTerm);
		return t;
	}

	/**
	 * Cross reference torrents and requests by upc.
	 * 
	 * @param upc
	 *            the upc
	 * @return the tuple
	 */
	public static Tuple<TorrentSearch, RequestsSearch> crossReferenceTorrentsAndRequestsByUPC(String upc) {
		ProductSearch ps = ProductSearch.productSearchFromTitle(upc);
		determinedSearchTerm = determineSearchString(ps.getItems());
		TorrentSearch t = TorrentSearch.torrentSearchFromSearchTerm(determinedSearchTerm);
		RequestsSearch r = RequestsSearch.requestSearchFromSearchTerm(determinedSearchTerm);
		return new Tuple<TorrentSearch, RequestsSearch>(t, r);
	}

	/**
	 * Cross reference torrents and requests by search term.
	 * 
	 * @param searchTerm
	 *            the search term
	 * @return the tuple
	 */
	public static Tuple<TorrentSearch, RequestsSearch> crossReferenceTorrentsAndRequestsBySearchTerm(String searchTerm) {
		ProductSearch ps = ProductSearch.productSearchFromTitle(searchTerm);
		determinedSearchTerm = determineSearchString(ps.getItems());
		TorrentSearch t = TorrentSearch.torrentSearchFromSearchTerm(determinedSearchTerm);
		RequestsSearch r = RequestsSearch.requestSearchFromSearchTerm(determinedSearchTerm);
		return new Tuple<TorrentSearch, RequestsSearch>(t, r);
	}

	/**
	 * Determine search string.
	 * 
	 * @param items
	 *            the items
	 * @return the string
	 */
	public static String determineSearchString(List<Items> items) {
		StringTokenizer tokenizer;
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<String> combinations = new ArrayList<String>();
		String shortestString = "";
		int length = 0;

		for (int i = 0; i < items.size(); i++) {
			if (i == 0) {
				length = items.get(i).getProduct().getTitle().length();
				shortestString = items.get(i).getProduct().getTitle();
			} else {
				if (items.get(i).getProduct().getTitle().length() < length) {
					length = items.get(i).getProduct().getTitle().length();
					shortestString = items.get(i).getProduct().getTitle();
				}
			}
		}
		tokenizer = new StringTokenizer(shortestString);
		while (tokenizer.hasMoreTokens()) {
			String s = tokenizer.nextToken();
			words.add(s);
		}

		for (int i = 0; i < words.size(); i++) {
			String s = "";
			for (int j = 0; j <= i; j++) {
				if (j != 0) {
					s += " " + words.get(j);
				} else {
					s += words.get(j);
				}
			}
			combinations.add(s);
		}

		int k = 0;
		for (int i = 0; i < combinations.size(); i++) {
			for (int j = 0; j < items.size(); j++) {
				String title = items.get(j).getProduct().getTitle().toLowerCase();
				String phrase = combinations.get(i).toLowerCase();
				if (title.contains(phrase)) {
					k = i;
				}
			}
		}

		return combinations.get(k);
	}

	/**
	 * Gets the determined search term.
	 * 
	 * @return the determinedSearchTerm
	 */
	public static String getDeterminedSearchTerm() {
		return determinedSearchTerm;
	}

}
