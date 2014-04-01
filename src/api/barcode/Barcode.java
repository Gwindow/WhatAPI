package api.barcode;

import api.search.crossreference.CrossReference;

/**
 * Stores information about a barcode's UPC, the determined
 * search strings for it and if we've searched the site for it yet
 */
public class Barcode {
	//The upc for this barcode
	private String upc;
	//The search terms determined from looking up the barcode on MusicBrainz & Google products
	private String searchTerms;

	public Barcode(){

	}

	/**
	 * Create the barcode for some upc
	 *
	 * @param upc the barcode's upc
	 */
	public Barcode(String upc){
		this.upc = upc;
	}

	/**
	 * Search MusicBrainz and Google products (only if MB turns up nothing)
	 * for information about the search terms (ideally the artist and album name)
	 * we should use when searching the site to see if this item is on there
	 */
	public void determineSearchTerms(){
		searchTerms = CrossReference.termsFromUpc(upc);
	}

	public String getUpc(){
		return upc;
	}

	public String getSearchTerms(){
		return searchTerms;
	}

	public void setSearchTerms(String terms){
		searchTerms = terms;
	}

	public boolean hasSearchTerms(){
		return (searchTerms != null && !searchTerms.isEmpty());
	}

	@Override
	public String toString(){
		return "UPC: " + getUpc() + (hasSearchTerms() ? ", Terms: " + getSearchTerms() : "");
	}
}
