package api.barcode;

import api.products.Product;
import api.products.ProductSearch;
import api.search.crossreference.CrossReference;

import java.util.Date;
import java.util.List;

/**
 * Stores information about a barcode's UPC, the determined
 * search strings for it and if we've searched the site for it yet
 */
public class Barcode {
	private String upc;
	/**
	 * Looked up search terms (and optionally tags from Semantics) or set by the user
	 * and an optional user label for the barcode
	 */
	private String searchTerms, searchTags, userLabel;
	/**
	 * Date the barcode was added/scanned by the user
	 */
	private Date added;

	public Barcode(){
	}

	/**
	 * Create the barcode for some upc
	 */
	public Barcode(String upc, Date added){
		this.upc = upc;
		this.added = added;
		searchTerms = "";
		searchTags = "";
		userLabel = "";
	}

	public Barcode(String upc, Date added, String terms, String tags, String label){
		this.upc = upc;
		this.added = added;
		searchTerms = terms;
		searchTags = tags;
		userLabel = label;
	}

	public void loadSearchTerms(){
		searchTerms = CrossReference.termsFromUpc(upc);
	}

	public void loadSearchTags(){
		//There's only really one result for UPC lookups
		List<Product> results = ProductSearch.fromUPC(upc);
		if (results != null && !results.isEmpty()){
			searchTags = results.get(0).getSiteTags();
		}
		else {
			searchTags = "";
		}
	}

	public String getUpc(){
		return upc;
	}

	public Date getAdded(){
		return added;
	}

	public String getSearchTerms(){
		return searchTerms;
	}

	public void setSearchTerms(String searchTerms){
		this.searchTerms = searchTerms;
	}

	public String getSearchTags(){
		return searchTags;
	}

	public void setSearchTags(String searchTags){
		this.searchTags = searchTags;
	}

	public String getUserLabel(){
		return userLabel;
	}

	public void setUserLabel(String userLabel){
		this.userLabel = userLabel;
	}

	@Override
	public String toString(){
		return "Barcode [upc=" + upc + ", searchTerms=" + searchTerms + ", searchTags=" + searchTags
			+ ", userLabel=" + userLabel + ", added=" + added + "]";
	}
}
