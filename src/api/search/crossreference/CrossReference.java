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
 * For usage in executing Torrent or Request searches based
 * on product data recieved from google via ProductSearch
 *
 * @author Gwindow
 */
public class CrossReference {
	/** The determined search term. */
	private static String determinedSearchTerm;

	/**
	 * Cross reference a Requests search by a Google product search result
	 * 
	 * @param searchTerm
	 *      the search term for the product search
	 * @return the Requests search
	 */
	public static RequestsSearch crossReferenceRequestsBySearchTerm(String searchTerm) {
		ProductSearch ps = ProductSearch.fromTitle(searchTerm);
		determinedSearchTerm = determineSearchString(ps.getItems());
		return RequestsSearch.requestSearchFromSearchTerm(determinedSearchTerm);
	}

	/**
	 * Cross reference a Requests search by a Google product search result
	 * 
	 * @param upc
	 *      the UPC for the product search
	 * @return the Requests search
	 */
	public static RequestsSearch crossReferenceRequestsByUPC(String upc) {
		ProductSearch ps = ProductSearch.fromTitle(upc);
		determinedSearchTerm = determineSearchString(ps.getItems());
		return RequestsSearch.requestSearchFromSearchTerm(determinedSearchTerm);
	}

	/**
	 * Cross reference a Torrents search by a Google product search result
	 * 
	 * @param searchTerm
	 *      the search term for the product search
	 * @return the Torrent search
	 */
	public static TorrentSearch crossReferenceTorrentsBySearchTerm(String searchTerm) {
		ProductSearch ps = ProductSearch.fromTitle(searchTerm);
		determinedSearchTerm = determineSearchString(ps.getItems());
		return TorrentSearch.torrentSearchFromSearchTerm(determinedSearchTerm);
	}

	/**
	 * Cross reference a Torrents search by a Google product search result
	 * 
	 * @param upc
     *      the UPC for the product search
	 * @return the Torrent search
	 */
	public static TorrentSearch crossReferenceTorrentsByUPC(String upc) {
		ProductSearch ps = ProductSearch.fromTitle(upc);
		determinedSearchTerm = determineSearchString(ps.getItems());
        return TorrentSearch.torrentSearchFromSearchTerm(determinedSearchTerm);
	}

    /**
     * Cross reference a Torrents and Requests search by a Google product search
     *
     * @param searchTerm
     *      the search term to use for the product search
     * @return a tuple containing the Torrent search (first) and the Requests search (second)
     */
    public static Tuple<TorrentSearch, RequestsSearch> crossReferenceTorrentsAndRequestsBySearchTerm(String searchTerm) {
        ProductSearch ps = ProductSearch.fromTitle(searchTerm);
        determinedSearchTerm = determineSearchString(ps.getItems());
        TorrentSearch t = TorrentSearch.torrentSearchFromSearchTerm(determinedSearchTerm);
        RequestsSearch r = RequestsSearch.requestSearchFromSearchTerm(determinedSearchTerm);
        return new Tuple<TorrentSearch, RequestsSearch>(t, r);
    }

	/**
	 * Cross reference a Torrents and Requests search by a Google product search
	 * 
	 * @param upc
	 *      the UPC for the product search
	 * @return a tuple containing the Torrent search (first) and the Requests search (second)
	 */
	public static Tuple<TorrentSearch, RequestsSearch> crossReferenceTorrentsAndRequestsByUPC(String upc) {
		ProductSearch ps = ProductSearch.fromTitle(upc);
		determinedSearchTerm = determineSearchString(ps.getItems());
		TorrentSearch t = TorrentSearch.torrentSearchFromSearchTerm(determinedSearchTerm);
		RequestsSearch r = RequestsSearch.requestSearchFromSearchTerm(determinedSearchTerm);
		return new Tuple<TorrentSearch, RequestsSearch>(t, r);
	}

	/**
	 * Determine search string.
     * TODO: check out http://www.upcdatabase.com perhaps for looking up barcodes?
	 * will this be ok with their TOS? We may need to ask permission
	 * @param items
	 *      the items
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
            for (Items itm : items){
				String title = itm.getProduct().getTitle().toLowerCase();
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
	 * @return the determined search term
	 */
	public static String getDeterminedSearchTerm() {
		return determinedSearchTerm;
	}
}
