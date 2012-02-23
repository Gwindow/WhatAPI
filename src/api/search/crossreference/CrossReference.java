package api.search.crossreference;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import api.products.Items;
import api.products.ProductSearch;
import api.search.requests.RequestsSearch;
import api.search.torrents.TorrentSearch;
import api.util.Tuple;

public class CrossReference {

	private static String determinedSearchTerm;

	public static RequestsSearch crossReferenceRequestsBySearchTerm(String searchTerm) {
		ProductSearch ps = ProductSearch.productSearchFromTitle(searchTerm);
		determinedSearchTerm = determineSearchString(ps.getItems());
		RequestsSearch r = RequestsSearch.requestSearchFromSearchTerm(determinedSearchTerm);
		return r;
	}

	public static RequestsSearch crossReferenceRequestsByUPC(String upc) {
		ProductSearch ps = ProductSearch.productSearchFromTitle(upc);
		determinedSearchTerm = determineSearchString(ps.getItems());
		RequestsSearch r = RequestsSearch.requestSearchFromSearchTerm(determinedSearchTerm);
		return r;
	}

	public static TorrentSearch crossReferenceTorrentsBySearchTerm(String searchTerm) {
		ProductSearch ps = ProductSearch.productSearchFromTitle(searchTerm);
		determinedSearchTerm = determineSearchString(ps.getItems());
		TorrentSearch t = TorrentSearch.torrentSearchFromSearchTerm(determinedSearchTerm);
		return t;
	}

	public static TorrentSearch crossReferenceTorrentsByUPC(String upc) {
		ProductSearch ps = ProductSearch.productSearchFromTitle(upc);
		determinedSearchTerm = determineSearchString(ps.getItems());
		TorrentSearch t = TorrentSearch.torrentSearchFromSearchTerm(determinedSearchTerm);
		return t;
	}

	public static Tuple<TorrentSearch, RequestsSearch> crossReferenceTorrentsAndRequestsByUPC(String upc) {
		ProductSearch ps = ProductSearch.productSearchFromTitle(upc);
		determinedSearchTerm = determineSearchString(ps.getItems());
		TorrentSearch t = TorrentSearch.torrentSearchFromSearchTerm(determinedSearchTerm);
		RequestsSearch r = RequestsSearch.requestSearchFromSearchTerm(determinedSearchTerm);
		return new Tuple<TorrentSearch, RequestsSearch>(t, r);
	}

	public static Tuple<TorrentSearch, RequestsSearch> crossReferenceTorrentsAndRequestsBySearchTerm(String searchTerm) {
		ProductSearch ps = ProductSearch.productSearchFromTitle(searchTerm);
		determinedSearchTerm = determineSearchString(ps.getItems());
		TorrentSearch t = TorrentSearch.torrentSearchFromSearchTerm(determinedSearchTerm);
		RequestsSearch r = RequestsSearch.requestSearchFromSearchTerm(determinedSearchTerm);
		return new Tuple<TorrentSearch, RequestsSearch>(t, r);
	}

	private static String determineSearchString(List<Items> items) {
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
	 * @return the determinedSearchTerm
	 */
	public static String getDeterminedSearchTerm() {
		return determinedSearchTerm;
	}

}
