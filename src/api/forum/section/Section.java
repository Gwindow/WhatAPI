
package api.forum.section;

import java.util.ArrayList;
import java.util.List;

import api.son.MySon;
import api.soup.MySoup;
import api.util.Tuple;

/**
 * The Class Section.
 * 
 * @author Gwindow
 */
public class Section {

	/** The response. */
	private Response response;

	/** The status. */
	private String status;

	/** The id. */
	private transient static int id;

	/** The page. */
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
	 * Section from first page.
	 * 
	 * @param id
	 *            the id
	 * @return the section
	 */
	public static Section sectionFromFirstPage(int id) {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=forum&type=viewforum&forumid=" + id + "&page=" + 1 + "&auth=" + authkey;
		Section section = (Section) MySon.toObject(url, Section.class);
		Section.id = id;
		Section.page = 1;
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
	 * @param id
	 *            the id
	 * @param title
	 *            the title
	 * @param body
	 *            the body
	 */
	public static void createNewThread(int id, String title, String body) {
		if ((title.length() > 0) && (body.length() > 0)) {
			try {
				String url = "forums.php?action=new&forumid=" + id;
				List<Tuple<String, String>> list = new ArrayList<Tuple<String, String>>();
				list.add(new Tuple<String, String>("action", "new"));
				list.add(new Tuple<String, String>("auth", MySoup.getAuthKey()));
				list.add(new Tuple<String, String>("forum", String.valueOf(id)));
				list.add(new Tuple<String, String>("title", title));
				list.add(new Tuple<String, String>("body", body));
				MySoup.postMethod(url, list);
				System.out.println("Thread created");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Subscribe to all unread threads.
	 */
	public void subscribeToAllUnreadThreads() {
		for (int i = 0; i < response.getThreads().size(); i++) {
			if (!response.getThreads().get(i).isRead()) {
				response.getThreads().get(i).subscribe();
			}
		}
	}

	/**
	 * Gets the number of unread threads.
	 * 
	 * @return the number of unread threads
	 */
	public int getNumberOfUnreadThreads() {
		int counter = 0;
		for (int i = 0; i < response.getThreads().size(); i++) {
			if (!response.getThreads().get(i).isRead()) {
				counter++;
			}
		}
		return counter;
	}

	/**
	 * Catch up.
	 */
	public void catchUp() {
		try {
			MySoup.pressLink("forums.php?action=catchup&forumid=" + id + "&auth=" + MySoup.getAuthKey());
			System.out.println("Caught up");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Subscribe to all unread threads and catch up.
	 */
	public void subscribeToAllUnreadThreadsAndCatchUp() {
		subscribeToAllUnreadThreads();
		catchUp();
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Section [id = " + id + ", page = " + page + ", hasNextPage=" + hasNextPage() + ", getResponse=" + getResponse()
				+ ", getStatus=" + getStatus() + "]";
	}

}
