package api.top;

import api.son.MySon;
import api.soup.MySoup;

import java.util.List;

/**
 * The top torrents,tags,users.
 * 
 * @author Tim
 */
public class Top {
	/** The response. */
	private List<Response> response;

	/** The status. */
	private String status;

	private String error;

	/**
	 * Load the top torrents.
	 * 
	 * @param limit
	 *            how many to load, 10, 100, 250
	 * @return Top object containing the list
	 */
	public static Top initTopTorrents(int limit) {
		if (validLimit(limit)) {
			String authkey = MySoup.getAuthKey();
			String url = "ajax.php?action=top10&type=torrents&limit=" + limit + "&auth=" + authkey;
			return (Top) MySon.toObject(url, Top.class);
		} else {
			System.err.println("Limit " + limit + "is not invalid");
		}
		return null;
	}

	/**
	 * Load the top tags.
	 * 
	 * @param limit
	 *            how many to load, 10, 100, 250
	 * @return Top object containing the list
	 */
	public static Top initTopTags(int limit) {
		if (validLimit(limit)) {
			String authkey = MySoup.getAuthKey();
			String url = "ajax.php?action=top10&type=tags&limit=" + limit + "&auth=" + authkey;
			return (Top) MySon.toObject(url, Top.class);
		} else {
			System.err.println("Limit " + limit + "is not invalid");
		}
		return null;
	}

	/**
	 * Load the top users.
	 * 
	 * @param limit
	 *            how many to load, 10, 100, 250
	 * @return Top object containing the list
	 */
	public static Top initTopUsers(int limit) {
		if (validLimit(limit)) {
			String authkey = MySoup.getAuthKey();
			String url = "ajax.php?action=top10&type=users&limit=" + limit + "&auth=" + authkey;
			return (Top) MySon.toObject(url, Top.class);
		} else {
			System.err.println("Limit " + limit + "is not invalid");
		}
		return null;
	}

	/**
	 * Check if a valid limit.
	 * 
	 * @param limit
	 *            10, 100, 250
	 * @return true if limit is valid
	 */
	private static boolean validLimit(int limit) {
        return ((limit == 10) || (limit == 100) || (limit == 250));
	}

	/**
	 * Get a list of Sections.
	 * 
	 * @return list with Section objects
	 */
	public List<Response> getResponse() {
		return this.response;
	}

	/**
	 * Gets the status.
	 * 
	 * @return the status
	 */
	public boolean getStatus() {
        return status.equalsIgnoreCase("success");
	}

	public String getError(){
		return error;
	}

	/* (non-Javadoc)
		 *
		 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Top [response=" + response + ", status=" + status + "]";
	}
}
