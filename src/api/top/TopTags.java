package api.top;

import api.son.MySon;
import api.soup.MySoup;

import java.util.List;

/**
 * For interacting with the top tags API
 */
public class TopTags {
	/**
	 * The list of top torrents in the response
	 */
	private List<Response<Tag>> response;

	/**
	 * Status and error for the API request. Error will
	 * be null if no error occurred
	 */
	private String status, error;

	/**
	 * Load the top 10 tags
	 *
	 * @return the top 10 tags
	 */
	public static TopTags top(){
		return top(10);
	}

	/**
	 * Load some number of top tags. Only certain limits are valid,
	 * eg. 10, 100. If an invalid limit is passed you'll get the top 10
	 *
	 * @param limit number of tags we want
	 * @return the top tags
	 */
	public static TopTags top(int limit){
		String url = "ajax.php?action=top10&type=tags&limit=" + limit
			+ "&auth=" + MySoup.getAuthKey();
		return (TopTags)MySon.toObject(url, TopTags.class);
	}

	public List<Response<Tag>> getResponse(){
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
		return "TopTags [ status = " + status + ", error = " + error
			+ ", response = " + response + " ]";
	}
}
