package api.search.requests;

import api.son.MySon;
import api.soup.MySoup;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * The Class RequestsSearch.
 * For performing and interacting with the results of a Request search
 * 
 * @author Gwindow
 */
public class RequestsSearch {
	/** The API response. */
	private Response response;

	/** The response status. */
	private String status;

	/** The current page being viewed */
	private transient int page;

	/** The search term. */
	private transient String searchTerm;

	/** The search tags */
	private transient String tags;

	/**
	 * Get the first page of request search results for the term
	 * @param term the term to search for
	 * @return page 1 of the search results
	 */
	public static RequestsSearch search(String term){
		return search(term, "", 1);
	}

	/**
	 * Get a specific page of the requests search results for the term
	 * @param term the search term
	 * @return the desired page of the requests search
	 */
	public static RequestsSearch search(String term, int page){
		return search(term, "", 1);
	}

	/**
	 * Perform a Requests search from search term and tags and return the first page of results.
	 * Separate tags must be separated by commas. Site tags use periods to denote spaces, for example
	 * hip.hop and so tags should follow this convention as well
	 * Any existing whitespace will be replaced by commas
	 * @param term the term to search for
	 * @param tags search tags to use
	 * @return the torrent search results
	 */
	public static RequestsSearch search(String term, String tags){
		return search(term, tags, 1);
	}

	/**
	 * Perform a Requests search from search term and tags and return the desired page of results.
	 * Separate tags must be separated by commas. Site tags use periods to denote spaces, for example
	 * hip.hop and so tags should follow this convention as well
	 * Any existing whitespace will be replaced by commas
	 * @param term the term to search for
	 * @param tags search tags to use
	 * @param page page of the search results to get
	 * @return the torrent search results
	 */
	public static RequestsSearch search(String term, String tags, int page){
		String searchTerm;
		try {
			searchTerm = URLEncoder.encode(term, "UTF-8");
		}
		catch (UnsupportedEncodingException e){
			e.printStackTrace();
			return null;
		}
		String searchTags = tags.replace(" ", ",").replace(",", "&");
		String url = "ajax.php?action=requests&page=" + page
			+ "&search=" + searchTerm + "&tags=" + searchTags + "&auth=" + MySoup.getAuthKey();

		RequestsSearch r = (RequestsSearch)MySon.toObject(url, RequestsSearch.class);
		r.searchTerm = term;
		r.page = page;
		r.tags = tags;
		return r;
	}

	/**
	 * Check if a next page of results is available
	 * @return True if a next page is available
	 */
	public boolean hasNextPage(){
		return response.getCurrentPage().intValue() < response.getPages().intValue();
	}

	/**
	 * Get the next page of search results. Returns null if there is
	 * no next page
	 * @return the next page of search results
	 */
	public RequestsSearch nextPage(){
		return hasNextPage() ? search(searchTerm, tags, page + 1) : null;
	}

	/**
	 * Check if a previous page of results is available
	 * @return True if a previous page is available
	 */
	public boolean hasPreviousPage(){
		return response.getCurrentPage().intValue() > 1;
	}

	/**
	 * Get the previous page of search results. Returns null if there is
	 * no previous page
	 * @return the previous page of search results
	 */
	public RequestsSearch previousPage(){
		return hasPreviousPage() ? search(searchTerm, tags, page - 1) : null;
	}

	/**
	 * Get the current page number being viewed
	 * 
	 * @return the current page number
	 */
	public int getPage(){
		return page;
	}

	/**
	 * Get the API response
	 * 
	 * @return the API response
	 */
	public Response getResponse() {
		return response;
	}

	/**
	 * Get the response status
	 * 
	 * @return True if success
	 */
	public boolean getStatus() {
		return status.equalsIgnoreCase("success");
	}

	/**
	 * Get the search term used
	 * 
	 * @return the search term
	 */
	public String getSearchTerm(){
		return searchTerm;
	}

	/**
	 * Get the search tags used
	 * 
	 * @return the search tags
	 */
	public String getTags(){
		return tags;
	}

	@Override
	public String toString() {
		return "RequestsSearch [hasNextPage()=" + hasNextPage() + ", hasPreviousPage()=" + hasPreviousPage() + ", getResponse()="
				+ getResponse() + ", getStatus()=" + getStatus() + "]";
	}

}
