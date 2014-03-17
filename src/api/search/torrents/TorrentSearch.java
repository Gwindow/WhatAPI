package api.search.torrents;

import api.son.MySon;
import api.soup.MySoup;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * The Class TorrentsSearch.
 * For use in interacting with the API for performing torrent searches
 * 
 * @author Gwindow
 */
public class TorrentSearch {
	/** The API response. */
	private Response response;

	/** The response status. */
	private String status;

	/** The current page being viewed */
	private transient int page;

	/** The search term. */
	private transient String searchTerm;

	/** The search tags. */
	private transient String tags;

	/**
	 * Get the first page of torrent search results for the term
	 * @param term the term to search for
	 * @return page 1 of the search results
	 */
	public static TorrentSearch searchForTerm(String term){
		return searchForTerm(term, 1);
	}

	/**
	 * Perform a torrent search for some term and request a specific page of the results
	 * @param term the term to search for
	 * @param page page of the search results to get
	 * @return the page of results for a torrent search for the term
	 */
	public static TorrentSearch searchForTerm(String term, int page){
		String searchTerm;
		try {
			searchTerm = URLEncoder.encode(term, "UTF-8");
		}
		catch (UnsupportedEncodingException e){
			e.printStackTrace();
			return null;
		}
		String url = "ajax.php?action=browse&searchstr=" + searchTerm
			+ "&page=" + page + "&auth=" + MySoup.getAuthKey();

		TorrentSearch t = (TorrentSearch)MySon.toObject(url, TorrentSearch.class);
		t.searchTerm = term;
		t.page = page;
		t.tags = "";
		return t;
	}

	/**
	 * Perform a Torrent search from search term and tags and return the first page of results.
	 * Separate tags must be separated by commas. Site tags use periods to denote spaces, for example
	 * hip.hop and so tags should follow this convention as well
	 * Any existing whitespace will be replaced by commas
	 * @param term the term to search for
	 * @param tags search tags to use
	 * @return the torrent search results
	 */
	public static TorrentSearch searchForTerm(String term, String tags){
		return searchForTerm(term, tags, 1);
	}

	/**
	 * Perform a Torrent search from search term and tags and return the desired page of results.
	 * Separate tags must be separated by commas. Site tags use periods to denote spaces, for example
	 * hip.hop and so tags should follow this convention as well
	 * Any existing whitespace will be replaced by commas
	 * @param term the term to search for
	 * @param tags search tags to use
	 * @param page page of the search results to get
	 * @return the torrent search results
	 */
	public static TorrentSearch searchForTerm(String term, String tags, int page){
		String searchTerm;
		try {
			searchTerm = URLEncoder.encode(term, "UTF-8");
		}
		catch (UnsupportedEncodingException e){
			e.printStackTrace();
			return null;
		}
		String searchTags = tags.replace(" ", ",").replace(",", "&");
		String url = "ajax.php?action=browse&searchstr=" + searchTerm
			+ "&taglist=" + searchTags + "&page=" + page + "&auth=" + MySoup.getAuthKey();

		TorrentSearch t = (TorrentSearch)MySon.toObject(url, TorrentSearch.class);
		t.searchTerm = term;
		t.page = page;
		t.tags = tags;
		return t;
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
	public TorrentSearch getNextPage(){
		return hasNextPage() ? searchForTerm(searchTerm, tags, page + 1)
			: null;
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
	public TorrentSearch getPreviousPage(){
		return hasPreviousPage() ? searchForTerm(searchTerm, tags, page - 1)
			: null;
	}

	/**
	 * Get the current page number being viewed
	 * @return the page
	 */
	public int getPage(){
		return page;
	}

	/**
	 * Get the API response
	 * @return the response
	 */
	public Response getResponse() {
		return response;
	}

	/**
	 * Get the status of the API response
	 * @return the status
	 */
	public boolean getStatus() {
		return status.equalsIgnoreCase("success");
	}

	/**
	 * Get the search term
	 * @return the search term
	 */
	public String getSearchTerm(){
		return searchTerm;
	}

	/**
	 * Get the search tags
	 * @return the search tags
	 */
	public String getTags(){
		return tags;
	}

	@Override
	public String toString() {
		return "TorrentSearch [hasNextPage()=" + hasNextPage() + ", hasPreviousPage()=" + hasPreviousPage() + ", getResponse()="
				+ getResponse() + ", getStatus()=" + getStatus() + "]";
	}
}
