/**
 * @author Gwindow
 */
package api.forum.forumsections;

import java.util.ArrayList;
import java.util.List;

import api.son.MySon;
import api.soup.MySoup;

/**
 * The Class ForumSections.
 */
public class ForumSections {
	private Response response;
	private String status;
	private ArrayList<Forums> forumsList;

	/**
	 * Inits the.
	 * 
	 * @return the forum sections
	 */
	public static ForumSections init() {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=forum&type=main&auth=" + authkey;
		ForumSections forumSections = (ForumSections) MySon.toObject(url, ForumSections.class);
		return forumSections;
	}

	/**
	 * Load forums list.
	 */
	public void loadForumsList() {
		forumsList = new ArrayList<Forums>();
		for (Categories c : response.getCategories()) {
			for (Forums f : c.getForums()) {
				forumsList.add(f);
			}
		}
	}

	/**
	 * Gets the response.
	 * 
	 * @return the response
	 */
	public Response getResponse() {
		return this.response;
	}

	/**
	 * Gets the status.
	 * 
	 * @return the status
	 */
	public boolean getStatus() {
		if (status.equalsIgnoreCase("success"))
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ForumSections [getResponse=" + getResponse() + ", getStatus=" + getStatus() + "]";
	}

	/**
	 * Gets the forums list.
	 * 
	 * @return the forums list
	 */
	public List<Forums> getForumsList() {
		return forumsList;
	}
}
