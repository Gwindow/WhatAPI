package api.forum.thread;

import java.util.ArrayList;
import java.util.List;

import api.son.MySon;
import api.soup.MySoup;
import api.util.Tuple;

/**
 * The Class Thread.
 * For getting API response and working with information for viewing
 * a specific forum thread
 *
 * @author Gwindow
 */
public class Thread {
	// TODO voting on polls
	/** The API response */
	private Response response;

	/** The status of the API response */
	private String status;

	/** The thread id */
	private transient static int id;

	/** The page of the thread being viewed. */
	private transient static int page;

	/** The posts per page to view */
	private transient static int pp = 25;

	/** If we're override the posts per page value */
	private transient static boolean overridePostsPerPage = false;

	/**
	 * Set the posts per page to view, default number is 25.
	 * 
	 * @param postsPerPage
	 *            the posts per page
	 */
	public static void setPostsPerPage(int postsPerPage) {
		Thread.pp = postsPerPage;
	}

	/**
	 * Get the posts per page to view
	 * 
	 * @return the posts per page to view
	 */
	public static int getPostsPerPage() {
		return pp;
	}

    /**
     * Get a Thread and begin viewing at the first page
     *
     * @param id
     *            the thread id
     * @return the Thread
     */
    public static Thread fromFirstPage(int id) {
        String authkey = MySoup.getAuthKey();
        String url;
        if (!overridePostsPerPage)
            url = "ajax.php?action=forum&type=viewthread&threadid=" + id + "&page=" + 1 + "&auth=" + authkey;
        else
            url = "ajax.php?action=forum&type=viewthread&threadid=" + id + "&page=" + 1 + "&pp=" + pp + "&auth=" + authkey;

        Thread thread = (Thread) MySon.toObject(url, Thread.class);
        Thread.id = id;
        Thread.page = 1;
        return thread;
    }

	/**
	 * Get a Thread from its thread id and begin viewing at a desired page
	 * 
	 * @param id
	 *            the thread id
	 * @param page
	 *            the page to view
	 * @return the Thread
	 */
	public static Thread fromIdAndPage(int id, int page) {
		String authkey = MySoup.getAuthKey();
		String url;
		if (!overridePostsPerPage)
			url = "ajax.php?action=forum&type=viewthread&threadid=" + id + "&page=" + page + "&auth=" + authkey;
		else
			url = "ajax.php?action=forum&type=viewthread&threadid=" + id + "&page=" + page + "&pp=" + pp + "&auth=" + authkey;

		Thread thread = (Thread) MySon.toObject(url, Thread.class);
		Thread.id = id;
		Thread.page = page;
		return thread;
	}

    /**
     * Get a Thread and begin viewing at its last page
     * Warning: This method is slow since it needs to access the thread twice, once to get max
     * number of pages and once to create the Thread object from the last page
     *
     * @param id
     *            the thread id
     * @return the Thread
     */
    public static Thread fromLastPage(int id) {
        String authkey = MySoup.getAuthKey();
        String url;
        // get the number of pages
        if (!overridePostsPerPage)
            url = "ajax.php?action=forum&type=viewthread&threadid=" + id + "&page=" + 1 + "&auth=" + authkey;
        else
            url = "ajax.php?action=forum&type=viewthread&threadid=" + id + "&page=" + 1 + "&pp=" + pp + "&auth=" + authkey;

        Thread thread = (Thread) MySon.toObject(url, Thread.class);

        // create thread from last page
        if (!overridePostsPerPage)
            url = "ajax.php?action=forum&type=viewthread&threadid=" + id + "&page=" + thread.getLastPage() + "&auth=" + authkey;
        else
            url = "ajax.php?action=forum&type=viewthread&threadid=" + id + "&page=" + thread.getLastPage() + "&pp=" + pp
                + "&auth=" + authkey;

        thread = (Thread) MySon.toObject(url, Thread.class);
        Thread.id = id;
        Thread.page = thread.getLastPage();
        return thread;
    }

	/**
	 * Get a Thread from its thread id and being viewing at some post
	 * 
	 * @param id
	 *            the thread id
	 * @param postId
	 *            the post id of the post to view
	 * @return the Thread
	 */
	public static Thread fromIdAndPostId(int id, int postId) {
		String authkey = MySoup.getAuthKey();
		String url;
		if (!overridePostsPerPage)
			url = "ajax.php?action=forum&type=viewthread&threadid=" + id + "&postid=" + postId + "&auth=" + authkey;
		else
			url = "ajax.php?action=forum&type=viewthread&threadid=" + id + "&postid=" + postId + "&pp=" + pp + "&auth=" + authkey;

		Thread thread = (Thread) MySon.toObject(url, Thread.class);
		Thread.id = id;
		Thread.page = thread.getResponse().getCurrentPage().intValue();
		return thread;
	}

	/**
     * Get a Thread from the next page of the current Thread
	 * Should only be called if hasNextPage() returned true.
	 * 
	 * @return the Thread for the next page
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
     * Get a Thread from the previous page of the current Thread
	 * Should only be called if hasPreviousPage() returned true.
	 * 
	 * @return the Thread for the previous page
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
	 * Get the last page number
	 * 
	 * @return the last page number
	 */
	public int getLastPage() {
		return response.getPages().intValue();
	}

	/**
	 * Check if the Thread has a next page
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
	 * Check if the Thread has a previous page
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
	 * Get the thread URL
	 * 
	 * @return the thread URL
	 */
	public String getUrl() {
		return "forums.php?action=viewthread&threadid=" + id + "&page=" + page;
	}

    /**
     * Post a reply to a thread
     *
     * @param id
     *      thread id of the thread to post too
     * @param body
     *      the body text of the post to make
     * @param subscribe
     *      if we want to subscribe to thread as well (T/F)
     */
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
	 * Subscribe to the Thread
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
	 * Unsubscribe from the Thread
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
	 * Get the API response
	 * 
	 * @return the API response
	 */
	public Response getResponse() {
		return this.response;
	}

	/**
	 * Get the status of the API response
	 * 
	 * @return True if successful
	 */
	public boolean getStatus() {
        return this.status.equalsIgnoreCase("success");
	}

    /**
     * Get the thread id
     *
     * @return the thread id
     */
    public static int getId() {
        return id;
    }

    /**
     * Get the page number being viewed
     *
     * @return the page number
     */
    public static int getPage() {
        return page;
    }

    /**
     * Check if the posts per page value is being overridden
     *
     * @return True if it's being overridden
     */
    public static boolean isOverridePostsPerPage() {
        return overridePostsPerPage;
    }

    /**
     * Set whether or not the posts per page value is being overridden
     *
     * @param overridePostsPerPage
     *            the value to set for overridePostsPerPage
     */
    public static void setOverridePostsPerPage(boolean overridePostsPerPage) {
        Thread.overridePostsPerPage = overridePostsPerPage;
    }

	@Override
	public String toString() {
		return "Thread [id = " + id + ", page = " + page + "  hasNextPage=" + hasNextPage() + ", getUrl=" + getUrl()
				+ ", getResponse=" + getResponse() + ", getStatus=" + getStatus() + "]";
	}



}
