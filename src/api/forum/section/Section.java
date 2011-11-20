


package api.forum.section;

import api.son.MySon;
import api.soup.MySoup;
import api.util.CouldNotLoadException;

/**
 * The Class Section.
 * 
 * @author Gwindow
 */
public class Section {
	private Response response;
	private String status;
	private transient static int id;
	private transient static int page;

	/**
	 * Section from id and page.
	 * 
	 * @param id
	 *            the id
	 * @param page
	 *            the page
	 * @return the section
	 */
	public static Section sectionFromIdAndPage(int id, int page) {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=forum&type=viewforum&forumid=" + id + "&page=" + page + "&auth=" + authkey;
		Section section = (Section) MySon.toObject(url, Section.class);
		Section.id = id;
		Section.page = page;
		return section;
	}

	/**
	 * Should only be called if hasNextPage() returned true.
	 * 
	 * @return the section
	 */
	public static Section sectionFromNextPage() {
		page += 1;
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=forum&type=viewforum&forumid=" + id + "&page=" + page + "&auth=" + authkey;
		Section section = (Section) MySon.toObject(url, Section.class);
		return section;
	}

	/**
	 * Should only be called if hasPreviousPage() returned true.
	 * 
	 * @return the section
	 */
	public static Section sectionFromPreviousPage() {
		page -= 1;
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=forum&type=viewforum&forumid=" + id + "&page=" + page + "&auth=" + authkey;
		Section section = (Section) MySon.toObject(url, Section.class);
		return section;
	}

	/**
	 * Gets the last page.
	 * 
	 * @return the last page
	 */
	public int getLastPage() {
		return response.getPages().intValue();
	}

	/**
	 * Checks for next page.
	 * 
	 * @return true, if successful
	 */
	public boolean hasNextPage() {
		try {
			if ((response.getPages().intValue() - response.getCurrentPage().intValue()) > 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Checks for previous page.
	 * 
	 * @return true, if successful
	 */
	public boolean hasPreviousPage() {
		try {
			if (((response.getCurrentPage().intValue()) != 1) || ((response.getCurrentPage().intValue()) == 0))
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
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

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public static int getId() {
		return id;
	}

	/**
	 * Gets the page.
	 * 
	 * @return the page
	 */
	public static int getPage() {
		return page;
	}

	/**
	 * Creates the new thread.
	 * 
	 * @param title
	 *            the title
	 * @param body
	 *            the body
	 */
	public void createNewThread(String title, String body) {
		try {
			MySoup.newThread(String.valueOf(id), title, body);
		} catch (CouldNotLoadException e) {
			System.err.println("Could not create thread");
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Section [id = " + id + ", page = " + page + ", hasNextPage=" + hasNextPage() + ", getResponse=" + getResponse()
				+ ", getStatus=" + getStatus() + "]";
	}
}
