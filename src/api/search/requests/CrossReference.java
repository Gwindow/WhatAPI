package api.search.requests;

import api.products.ProductSearch;

public class CrossReference {
	public static Object searchOnSiteByTitle(String title) {
		// TODO return
		return null;
	}

	public static ProductSearch searchOnGoogleByTitle(String title) {
		return ProductSearch.productSearchFromTitle(title);
	}

	public static Object searchOnSiteByUPC(String upc) {
		// TODO return
		return null;
	}

	public static ProductSearch searchOnGoogleByUPC(String upc) {
		return ProductSearch.productSearchFromUPC(upc);
	}
}
