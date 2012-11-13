package api.forum.thread;

import java.util.ArrayList;
import java.util.List;

import api.son.MySon;
import api.soup.MySoup;
import api.util.Tuple;

/**
 * The Class Thread.
 * 
 * @author Gwindow
 */
public class Thread {
	// TODO voting on polls
	/** The response. */
	private Response response;

	/** The status. */
	private String status;

	/** The id. */
	private transient static int id;

	/** The page. */
	private transient static int page;

	/** The pp. */
	private transient static int pp = 25;

	/** The override posts per page. */
	private transient static boolean overridePostsPerPage = false;

	/**
	 * Sets the posts per page, default number is 25.
	 * 
	 * @param postsPerPage
	 *            the posts per page
	 */
	public static void setPostsPerPage(int postsPerPage) {
		Thread.pp = postsPerPage;
	}

	/**
	 * Gets the posts per page, default is 25.
	 * 
	 * @return the posts per page
	 */
	public static int getPostsPerPage() {
		return pp;
	}

	/**
	 * Thread from id and page.
	 * 
	 * @param id
	 *            the id
	 * @param page
	 *            the page
	 * @return the thread
	 */
	public static Thread fromIdAndPage(int id, int page) {
		String authkey = MySoup.getAuthKey();
		String url;
		if (!overridePostsPerPage) {
			url = "ajax.php?action=forum&type=viewthread&threadid=" + id + "&page=" + page + "&auth=" + authkey;
		} else {
			url = "ajax.php?action=forum&type=viewthread&threadid=" + id + "&page=" + page + "&pp=" + pp + "&auth=" + authkey;
		}

		Thread thread = (Thread) MySon.toObject(url, Thread.class);
		Thread.id = id;
		Thread.page = page;

		return thread;
	}

	/**
	 * Thread from id and post id.
	 * 
	 * @param id
	 *            the id
	 * @param postId
	 *            the post id
	 * @return the thread
	 */
	public static Thread fromIdAndPostId(int id, int postId) {
		String authkey = MySoup.getAuthKey();
		String url;
		if (!overridePostsPerPage) {
			url = "ajax.php?action=forum&type=viewthread&threadid=" + id + "&postid=" + postId + "&auth=" + authkey;
		} else {
			url = "ajax.php?action=forum&type=viewthread&threadid=" + id + "&postid=" + postId + "&pp=" + pp + "&auth=" + authkey;
		}

		Thread thread = (Thread) MySon.toObject(url, Thread.class);
		Thread.id = id;
		Thread.page = thread.getResponse().getCurrentPage().intValue();
		return thread;
	}

	/**
	 * Thread from first page.
	 * 
	 * @param id
	 *            the id
	 * @return the thread
	 */
	public static Thread fromFirstPage(int id) {
		String authkey = MySoup.getAuthKey();
		String url;
		if (!overridePostsPerPage) {
			url = "ajax.php?action=forum&type=viewthread&threadid=" + id + "&page=" + 1 + "&auth=" + authkey;
		} else {
			url = "ajax.php?action=forum&type=viewthread&threadid=" + id + "&page=" + 1 + "&pp=" + pp + "&auth=" + authkey;
		}
		Thread thread = (Thread) MySon.toObject(url, Thread.class);
		Thread.id = id;
		Thread.page = 1;
		return thread;
	}

	/**
	 * Thread from last page. Note: This method is slow since it needs to access the thread twice, once to get max
	 * number of pages and once to create the Thread object from the last page
	 * 
	 * @param id
	 *            the id
	 * @return the thread
	 */
	public static Thread fromLastPage(int id) {
		String authkey = MySoup.getAuthKey();
		String url;
		// get the number of pages
		if (!overridePostsPerPage) {
			url = "ajax.php?action=forum&type=viewthread&threadid=" + id + "&page=" + 1 + "&auth=" + authkey;
		} else {
			url = "ajax.php?action=forum&type=viewthread&threadid=" + id + "&page=" + 1 + "&pp=" + pp + "&auth=" + authkey;
		}
		Thread thread = (Thread) MySon.toObject(url, Thread.class);
		// create thread from last page
		if (!overridePostsPerPage) {

			url = "ajax.php?action=forum&type=viewthread&threadid=" + id + "&page=" + thread.getLastPage() + "&auth=" + authkey;
		} else {
			url =
					"ajax.php?action=forum&type=viewthread&threadid=" + id + "&page=" + thread.getLastPage() + "&pp=" + pp
							+ "&auth=" + authkey;
		}
		thread = (Thread) MySon.toObject(url, Thread.class);
		Thread.id = id;
		Thread.page = thread.getLastPage();
		return thread;
	}

	/**
	 * Should only be called if hasNextPage() returned true.
	 * 
	 * @return the thread
	 */
	public static Thread fromNextPage() {
		page += 1;
		String authkey = MySoup.getAuthKey();
		String url;
		if (!overridePostsPerPage) {
			url = "ajax.php?action=forum&type=viewthread&threadid=" + id + "&page=" + page + "&auth=" + authkey;
		} else {
			url = "ajax.php?action=forum&type=viewthread&threadid=" + id + "&page=" + page + "&pp=" + pp + "&auth=" + authkey;
		}
		Thread thread = (Thread) MySon.toObject(url, Thread.class);
		return thread;
	}

	/**
	 * Should only be called if hasPreviousPage() returned true.
	 * 
	 * @return the thread
	 */
	public static Thread fromPreviousPage() {
		page -= 1;
		String authkey = MySoup.getAuthKey();
		String url;
		if (!overridePostsPerPage) {
			url = "ajax.php?action=forum&type=viewthread&threadid=" + id + "&page=" + page + "&auth=" + authkey;
		} else {
			url = "ajax.php?action=forum&type=viewthread&threadid=" + id + "&page=" + page + "&pp=" + pp + "&auth=" + authkey;
		}
		Thread thread = (Thread) MySon.toObject(url, Thread.class);
		return thread;
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
			if ((response.getPages().intValue() - (response.getCurrentPage().intValue())) > 0)
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
	 * Gets the url.
	 * 
	 * @return the url
	 */
	public String getUrl() {
		String url = "forums.php?action=viewthread&threadid=" + id + "&page=" + page;
		return url;
	}

	public static void postReply(int id, String body, boolean subscribe) {
		if (body.length() > 0) {
			try {
				String url = "forums.php?action=new&forumid=" + id;
				List<Tuple<String, String>> list = new ArrayList<Tuple<String, String>>();
				list.add(new Tuple<String, String>("action", "reply"));
				list.add(new Tuple<String, String>("auth", MySoup.getAuthKey()));
				list.add(new Tuple<String, String>("thread", String.valueOf(id)));
				list.add(new Tuple<String, String>("body", body));
				if (subscribe) {
					list.add(new Tuple<String, String>("subscribe", "checked"));
				}
				MySoup.postMethod(url, list);
				System.out.println("Reply posted");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Subscribe to thread.
	 */
	public void subscribe() {
		if (!getResponse().isSubscribed()) {
			MySoup.pressLink("userhistory.php?action=thread_subscribe&topicid=" + id + "&auth=" + MySoup.getAuthKey());
			System.out.println("Subscribed");
		} else {
			System.out.println("Already subscribed");
		}

	}

	/**
	 * unsubscribe to thread.
	 */
	public void unsubscribe() {
		if (getResponse().isSubscribed()) {
			MySoup.pressLink("userhistory.php?action=thread_subscribe&topicid=" + id + "&auth=" + MySoup.getAuthKey());
			System.out.println("Unsubscribed");
		} else {
			System.out.println("Already unsubscribed");
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
        return status.equalsIgnoreCase("success");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Thread [id = " + id + ", page = " + page + "  hasNextPage=" + hasNextPage() + ", getUrl=" + getUrl()
				+ ", getResponse=" + getResponse() + ", getStatus=" + getStatus() + "]";
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
	 * Checks if is override posts per page.
	 * 
	 * @return the overridePostsPerPage
	 */
	public static boolean isOverridePostsPerPage() {
		return overridePostsPerPage;
	}

	/**
	 * This must be set to true for custom posts per page.
	 * 
	 * @param overridePostsPerPage
	 *            the new override posts per page
	 */
	public static void setOverridePostsPerPage(boolean overridePostsPerPage) {
		Thread.overridePostsPerPage = overridePostsPerPage;
	}

}
