package api.search.torrents;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import api.son.MySon;
import api.soup.MySoup;

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
	private transient static int page;

	/** The search term. */
	private transient static String searchTerm;

	/** The search tags. */
	private transient static String tags;

	/**
	 * Perform a Torrent search from a search term.
	 * 
	 * @param searchTerm
	 *      the search term
	 * @return the Torrent search
	 */
	public static TorrentSearch torrentSearchFromSearchTerm(String searchTerm) {
		return torrentSearchFromSearchTerm(searchTerm, 1);
	}

	/**
	 * Get the next page of the existing Torrent search from term
	 * 
	 * @return the next page of the Torrent search
	 */
	public static TorrentSearch torrentSearchFromSearchTermNextPage() {
		return torrentSearchFromSearchTerm(searchTerm, page + 1);
	}

	/**
	 * Get the previous page of the existing Torrent search from term
	 * 
	 * @return the previous page of the Torrent search
	 */
	public static TorrentSearch torrentSearchFromSearchTermPreviousPage() {
		return torrentSearchFromSearchTerm(searchTerm, page - 1);
	}

	/**
	 * Perform a Torrent search from a search term and tags
	 * 
	 * @param searchTerm
	 *      the search term
	 * @param tags
	 *      the search tags
	 * @return the Torrent search
	 */
	public static TorrentSearch torrentSearchFromSearchTermAndTags(String searchTerm, String tags) {
		return torrentSearchFromSearchTermAndTags(searchTerm, tags, 1);
	}

	/**
	 * Get the next page of the existing Torrent search from term and tags
	 * 
	 * @return the next page of the Torrent search
	 */
	public static TorrentSearch torrentSearchFromSearchTermAndTagsNextPage() {
		return torrentSearchFromSearchTermAndTags(searchTerm, tags, page + 1);
	}

	/**
	 * Get the previous page of the existing Torrent search from term and tags
	 * 
	 * @return the previous page of the Torrent search
	 */
	public static TorrentSearch torrentSearchFromSearchTermAndTagsPreviousPage() {
		return torrentSearchFromSearchTermAndTags(searchTerm, tags, page - 1);
	}

	/**
	 * Perform a torrent search from some search term and return the desired page of results
	 * 
	 * @param searchTerm
	 *      the search term
	 * @param page
	 *      the page of results to get
	 * @return the Torrent search
	 */
	public static TorrentSearch torrentSearchFromSearchTerm(String searchTerm, int page) {
		if (searchTerm != null) {
			try {
				searchTerm = URLEncoder.encode(searchTerm, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			System.err.println(searchTerm);
			TorrentSearch.searchTerm = searchTerm;
			TorrentSearch.page = page;
			String authkey = MySoup.getAuthKey();
			String url = "ajax.php?action=browse&searchstr=" + searchTerm
                    + "&page=" + page + "&auth=" + authkey;
			return (TorrentSearch) MySon.toObject(url, TorrentSearch.class);
		}
        else
			return null;
	}

	/**
	 * Perform a Torrent search from search term and tags and return the desired page of results.
     * Separate tags must be separated by commas, while whitespace should be replaced by periods.
     * For example, hip.hop,pop,indie
	 * 
	 * @param searchTerm
	 *      the search term
	 * @param tags
	 *      the search tags
	 * @param page
	 *      the page of results to get
	 * @return the Torrent search
	 */
	public static TorrentSearch torrentSearchFromSearchTermAndTags(String searchTerm, String tags, int page) {
		if (searchTerm != null) {
			try {
				searchTerm = URLEncoder.encode(searchTerm, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			TorrentSearch.searchTerm = searchTerm;
			TorrentSearch.page = page;
			String authkey = MySoup.getAuthKey();
			TorrentSearch.tags = tags;
			tags = tags.replace(",", "&");
			String url = "ajax.php?action=browse&searchstr=" + searchTerm
                    + "&taglist=" + tags + "&page=" + page + "&auth=" + authkey;
			return (TorrentSearch) MySon.toObject(url, TorrentSearch.class);
		}
        else
			return null;
	}

	/**
	 * Check if a next page of results is available
	 * 
	 * @return True if a next page is available
	 */
	public boolean hasNextPage() {
		try {
			return ((response.getPages().intValue() - response.getCurrentPage().intValue()) > 0);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Check if a previous page of results is available
	 * 
	 * @return True if a previous page is available
	 */
	public boolean hasPreviousPage() {
		try {
			return (response.getCurrentPage().intValue() != 1 || response.getCurrentPage().intValue() == 0);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Get the current page number being viewed
	 * 
	 * @return the page
	 */
	public static int getPage() {
		return page;
	}

	/**
	 * Get the API response
	 * 
	 * @return the response
	 */
	public Response getResponse() {
		return this.response;
	}

	/**
	 * Get the status of the API response
	 * 
	 * @return the status
	 */
	public boolean getStatus() {
        return this.status.equalsIgnoreCase("success");
	}

	/**
	 * Get the search term
	 * 
	 * @return the search term
	 */
	public static String getSearchTerm() {
		return searchTerm;
	}

	/**
	 * Get the search tags
	 * 
	 * @return the search tags
	 */
	public static String getTags() {
		return tags;
	}

	@Override
	public String toString() {
		return "TorrentSearch [hasNextPage()=" + hasNextPage() + ", hasPreviousPage()=" + hasPreviousPage() + ", getResponse()="
				+ getResponse() + ", getStatus()=" + getStatus() + "]";
	}

}
