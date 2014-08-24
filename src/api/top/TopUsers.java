package api.top;

import api.son.MySon;
import api.soup.MySoup;

import java.util.List;

/**
 * For interacting with the top users API
 */
public class TopUsers {
	/**
	 * The list of top torrents in the response
	 */
	private List<Response<User>> response;

	/**
	 * Status and error for the API request. Error will
	 * be null if no error occurred
	 */
	private String status, error;

	/**
	 * Load the top 10 users for the various categories on the site
	 *
	 * @return the top 10 users
	 */
	public static TopUsers top(){
		return top(10);
	}

	/**
	 * Load some number of top users. Only certain limits are valid,
	 * eg. 10, 100. If an invalid limit is passed you'll get the top 10
	 *
	 * @param limit number of users we want
	 * @return the top users
	 */
	public static TopUsers top(int limit){
		String url = "ajax.php?action=top10&type=users&limit=" + limit
			+ "&auth=" + MySoup.getAuthKey();
		return (TopUsers)MySon.toObject(url, TopUsers.class);
	}

	public List<Response<User>> getResponse(){
		return response;
	}

	public String getStatus(){
		return status;
	}

	public String getError(){
		return error;
	}

	@Override
	public String toString(){
		return "TopTorrents [ status = " + status + ", error = " + error
			+ ", response = " + response + " ]";
	}
}
