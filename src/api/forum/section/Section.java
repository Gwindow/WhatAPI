package api.forum.section;

import java.util.ArrayList;
import java.util.List;

import api.son.MySon;
import api.soup.MySoup;
import api.util.Tuple;

/**
 * The Class Section.
 * For getting and using the API for viewing a forum
 * 
 * @author Gwindow
 */
public class Section {
	/** The API response data */
	private Response response;

	/** The API response status */
	private String status;

	/** The forum id */
	private transient static int id;

	/** The forum page number */
	private transient static int page;

	/**
	 * Get a Section from its forum id and page #
	 * 
	 * @param id
	 *            the forum id
	 * @param page
	 *            the page number
	 * @return the section
	 */
	public static Section fromIdAndPage(int id, int page) {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=forum&type=viewforum&forumid=" + id + "&page=" + page + "&auth=" + authkey;
		Section section = (Section) MySon.toObject(url, Section.class);
		Section.id = id;
		Section.page = page;
		return section;
	}

    /**
     * Get a section from it's id and the first page
     *
     * @param id
     *            the forum id
     * @return the section
     */
    public static Section fromFirstPage(int id) {
        String authkey = MySoup.getAuthKey();
        String url = "ajax.php?action=forum&type=viewforum&forumid=" + id + "&page=" + 1 + "&auth=" + authkey;
        Section section = (Section) MySon.toObject(url, Section.class);
        Section.id = id;
        Section.page = 1;
        return section;
    }

	/**
     * Get a section from the next page of the current section
	 * Should only be called if hasNextPage() returned true.
	 * 
	 * @return the section
	 */
	public static Section fromNextPage() {
		++page;
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=forum&type=viewforum&forumid=" + id + "&page=" + page + "&auth=" + authkey;
		return (Section) MySon.toObject(url, Section.class);
	}

	/**
     * Get a section from the previous page of the current section
	 * Should only be called if hasPreviousPage() returned true.
	 * 
	 * @return the section
	 */
	public static Section fromPreviousPage() {
		--page;
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=forum&type=viewforum&forumid=" + id + "&page=" + page + "&auth=" + authkey;
		return (Section) MySon.toObject(url, Section.class);
	}

	/**
	 * Get the last page number
	 * 
	 * @return the last page number
	 */
	public int getLastPage() {
		return response.getPages().intValue();
	}

	/**
	 * Check if there is a next page available
	 * 
	 * @return True if a next page exists
	 */
	public boolean hasNextPage() {
		try {
            return ((response.getPages().intValue() - response.getCurrentPage().intValue()) > 0);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Check if there is a previous page available
	 * 
	 * @return True if a previous page exists
	 */
	public boolean hasPreviousPage() {
		try {
			return (response.getCurrentPage().intValue() != 1 || response.getCurrentPage().intValue() == 0);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Get the API response.
	 * 
	 * @return the response
	 */
	public Response getResponse() {
		return this.response;
	}

	/**
	 * Gets the status of the API request
	 * 
	 * @return True if success
	 */
	public boolean getStatus() {
        return this.status.equalsIgnoreCase("success");
	}

	/**
	 * Get the forum id.
	 * 
	 * @return the forum id
	 */
	public static int getId() {
		return id;
	}

	/**
	 * Gets the current page number
	 * 
	 * @return current page number
	 */
	public static int getPage() {
		return page;
	}

	/**
	 * Create a new thread in some forum with a given title
     * and post body text
	 * 
	 * @param id
	 *            the forum id to post the thread in
	 * @param title
	 *            the title for the thread
	 * @param body
	 *            the body text of the post
	 */
	public static void createNewThread(int id, String title, String body) {
		if (title.length() > 0 && body.length() > 0) {
			try {
				String url = "forums.php?action=new&forumid=" + id;
				List<Tuple<String, String>> list = new ArrayList<Tuple<String, String>>();
				list.add(new Tuple<String, String>("action", "new"));
				list.add(new Tuple<String, String>("auth", MySoup.getAuthKey()));
				list.add(new Tuple<String, String>("forum", String.valueOf(id)));
				list.add(new Tuple<String, String>("title", title));
				list.add(new Tuple<String, String>("body", body));
				MySoup.postMethod(url, list);
				System.out.println("ForumThread created");
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
	 * Get the number of unread threads.
	 * 
	 * @return the number of unread threads
	 */
	public int getNumberOfUnreadThreads() {
		int counter = 0;
        for (ForumThread thread : response.getThreads()){
            if (thread.isRead())
                ++counter;
        }
		return counter;
	}

	/**
	 * Catch up with all subscribed posts
	 */
	public void catchUp() {
		try {
			MySoup.pressLink("forums.php?action=catchup&forumid=" + id + "&auth=" + MySoup.getAuthKey());
			System.out.println("Caught up");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Subscribe to all unread threads and catch up
	 */
	public void subscribeToAllUnreadThreadsAndCatchUp() {
		subscribeToAllUnreadThreads();
		catchUp();
	}

	@Override
	public String toString() {
		return "Section [id = " + id + ", page = " + page + ", hasNextPage=" + hasNextPage() + ", getResponse=" + getResponse()
				+ ", getStatus=" + getStatus() + "]";
	}

}
