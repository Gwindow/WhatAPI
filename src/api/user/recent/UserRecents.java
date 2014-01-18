package api.user.recent;

import api.son.MySon;
import api.soup.MySoup;

import java.util.List;

/**
 * Get information about the user's recent snatches and uploads
 * using the action=user_recents endpoint
 */
public class UserRecents {
	/** The actual response */
	private Response response;
	/** The status of the api request */
	private String status;

	/**
	 * Load the list of recent uploads and snatches for the user using the default
	 * limit of 15 per list
	 * @param user The user id to load for
	 * @return UserRecents for the user
	 */
	public static UserRecents recentsForUser(int user){
		return recentsForUser(user, 15);
	}

	/**
	 * Load the list of recent uploads and snatches for the user using some desired limit
	 * @param user The user id to load for
	 * @param limit Max number of results to return for each list
	 * @return UserRecents for the user
	 */
	public static UserRecents recentsForUser(int user, int limit){
		String url = "ajax.php?action=user_recents&userid=" + user + "&limit=" + limit
			+ "&auth=" + MySoup.getAuthKey();
		UserRecents recent = (UserRecents)MySon.toObject(url, UserRecents.class);
		return recent;
	}

	/**
	 * Get the list of recently snatched torrents
	 * @return list of recent snatches
	 */
	public List<RecentTorrent> getSnatches(){
		return response.snatches;
	}

	/**
	 * Get the list of recently uploaded torrents
	 * @return list of recent uploads
	 */
	public List<RecentTorrent> getUploads(){
		return response.uploads;
	}

	/**
	 * Check if the UserRecents loaded properly
	 */
	public boolean getStatus(){
		return status.equalsIgnoreCase("success");
	}

	/**
	 * We need this class to be filled by GSON with the actual
	 * API response information we care about
	 */
	private class Response {
		public List<RecentTorrent> snatches, uploads;
	}
}
