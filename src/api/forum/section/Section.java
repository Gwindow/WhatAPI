package api.forum.section;

import api.son.MySon;
import api.soup.MySoup;
import api.util.CouldNotLoadException;

public class Section {
	private Response response;
	private String status;
	private transient static int id;
	private transient static int page;

	public static Section sectionFromIdAndPage(int id, int page) {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=forum&type=viewforum&forumid=" + id + "&page=" + page + "&auth=" + authkey;
		Section section = (Section) MySon.toObject(url, Section.class);
		Section.id = id;
		Section.page = page;
		return section;
	}

	/**
	 * Should only be called if hasNextPage() returned true
	 * 
	 * @return
	 */
	public static Section sectionFromNextPage() {
		page += 1;
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=forum&type=viewforum&forumid=" + id + "&page=" + page + "&auth=" + authkey;
		Section section = (Section) MySon.toObject(url, Section.class);
		return section;
	}

	/**
	 * Should only be called if hasPreviousPage() returned true
	 * 
	 * @return
	 */
	public static Section sectionFromPreviousPage() {
		page -= 1;
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=forum&type=viewforum&forumid=" + id + "&page=" + page + "&auth=" + authkey;
		Section section = (Section) MySon.toObject(url, Section.class);
		return section;
	}

	public int getLastPage() {
		return response.getPages().intValue();
	}

	public boolean hasNextPage() {
		if ((response.getPages().intValue() - response.getCurrentPage().intValue()) > 0)
			return true;
		else
			return false;
	}

	public boolean hasPreviousPage() {
		if (((response.getCurrentPage().intValue()) != 1) || ((response.getCurrentPage().intValue()) == 0))
			return true;
		else
			return false;
	}

	public Response getResponse() {
		return this.response;
	}

	public boolean getStatus() {
		if (status.equalsIgnoreCase("success"))
			return true;
		return false;
	}

	public static int getId() {
		return id;
	}

	public static int getPage() {
		return page;
	}

	public void createNewThread(String title, String body) {
		try {
			MySoup.newThread(String.valueOf(id), title, body);
		} catch (CouldNotLoadException e) {
			System.err.println("Could not create thread");
		}
	}

	@Override
	public String toString() {
		return "Section [id = " + id + ", page = " + page + ", hasNextPage=" + hasNextPage() + ", getResponse=" + getResponse()
				+ ", getStatus=" + getStatus() + "]";
	}
}
