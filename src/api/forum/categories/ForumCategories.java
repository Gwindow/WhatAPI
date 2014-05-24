package api.forum.categories;

import api.son.MySon;
import api.soup.MySoup;

/**
 * The Class ForumCategories.
 * For getting and using the API related to
 * viewing the forum section page.
 *
 * @author Gwindow
 */
public class ForumCategories {
	/**
	 * The API response, contains the data we want.
	 */
	private Response response;

	/**
	 * The status of the API request.
	 */
	private String status;

	private String error;

	/** The forum list.
	 * TODO: Is this used for anything? The forum list looks to be
	 * stored under Category, which is contained in the response.
	 */
	//private ArrayList<Forum> forumsList;

	/**
	 * Get the ForumCategories from the site and return them
	 * as an instance of the class
	 *
	 * @return the forum sections
	 */
	public static ForumCategories init(){
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=forum&type=main&auth=" + authkey;
		return (ForumCategories)MySon.toObject(url, ForumCategories.class);
	}

	/**
	 * Load forums list from the response's categories section
	 * into the class member forumsList.
	 */
	/*
	public void loadForumsList() {
		forumsList = new ArrayList<Forum>();
		for (Category c : response.getCategories()) {
			for (Forum f : c.getForums()) {
				forumsList.add(f);
			}
		}
	}
	*/

	/**
	 * Get the API response
	 *
	 * @return the response
	 */
	public Response getResponse(){
		return this.response;
	}

	/**
	 * Get the status of the API request
	 *
	 * @return True if success
	 */
	public boolean getStatus(){
		return this.status.equalsIgnoreCase("success");
	}

	public String getError(){
		return error;
	}

	/*
    public List<Forum> getForumsList() {
        return forumsList;
    }
    */

	@Override
	public String toString(){
		return "ForumCategories [getResponse=" + getResponse() + ", getStatus=" + getStatus() + "]";
	}
}
