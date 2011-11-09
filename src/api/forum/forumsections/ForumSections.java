package api.forum.forumsections;

import java.util.ArrayList;
import java.util.List;

import api.son.MySon;
import api.soup.MySoup;

public class ForumSections {
	private Response response;
	private String status;
	private ArrayList<Forums> forumsList;

	public static ForumSections init() {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=forum&type=main&auth=" + authkey;
		ForumSections forumSections = (ForumSections) MySon.toObject(url, ForumSections.class);
		return forumSections;
	}

	public void loadForumsList() {
		forumsList = new ArrayList<Forums>();
		for (Categories c : response.getCategories()) {
			for (Forums f : c.getForums()) {
				forumsList.add(f);
			}
		}
	}

	public Response getResponse() {
		return this.response;
	}

	public boolean getStatus() {
		if (status.equalsIgnoreCase("success"))
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "ForumSections [getResponse=" + getResponse() + ", getStatus=" + getStatus() + "]";
	}

	public List<Forums> getForumsList() {
		return forumsList;
	}
}
