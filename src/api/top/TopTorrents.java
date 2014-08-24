package api.top;

import api.son.MySon;
import api.soup.MySoup;

import java.util.List;

/**
 * For interacting with the top torrents api
 */
public class TopTorrents {
	/**
	 * The list of top torrents in the response
	 */
	private List<Response<Torrent>> response;

	/**
	 * Status and error for the API request. Error will
	 * be null if no error occurred
	 */
	private String status, error;

	/**
	 * Load the top 10 torrents for the various categories on the site
	 *
	 * @return the top 10 torrents
	 */
	public static TopTorrents top(){
		return top(10);
	}

	/**
	 * Load some number of top torrents. Only certain limits are valid,
	 * eg. 10, 100. If an invalid limit is passed you'll get the top 10
	 *
	 * @param limit number of torrents we want
	 * @return the top torrents
	 */
	public static TopTorrents top(int limit){
		String url = "ajax.php?action=top10&type=torrents&limit=" + limit
			+ "&auth=" + MySoup.getAuthKey();
		return (TopTorrents)MySon.toObject(url, TopTorrents.class);
	}

	public List<Response<Torrent>> getResponse(){
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
