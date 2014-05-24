package api.forum.categories;

import api.son.MySon;
import api.soup.MySoup;

import java.util.List;

/**
 * For getting and using the API related to viewing the forum forum page.
 *
 * @author Gwindow
 */
public class ForumCategories {
	/**
	 * The API response, contains the data we want.
	 */
	private Response response;

	/**
	 * The status of the API request and error message, if any
	 */
	private String status, error;

	/**
	 * Get the ForumCategories from the site and return them
	 * as an instance of the class
	 *
	 * @return the forum sections
	 */
	public static ForumCategories init(){
		String url = "ajax.php?action=forum&type=main&auth=" + MySoup.getAuthKey();
		return (ForumCategories)MySon.toObject(url, ForumCategories.class);
	}

	/**
	 * Get the API response
	 *
	 * @return the response
	 */
	public Response getResponse(){
		return response;
	}

	/**
	 * Get the list of forum categories
	 */
	public List<Category> getCategories(){
		return response.getCategories();
	}

	/**
	 * Get the status of the API request
	 *
	 * @return True if success
	 */
	public boolean getStatus(){
		return status.equalsIgnoreCase("success");
	}

	public String getError(){
		return error;
	}

	@Override
	public String toString(){
		return "ForumCategories [getResponse=" + getResponse() + ", getStatus=" + getStatus() + "]";
	}
}
