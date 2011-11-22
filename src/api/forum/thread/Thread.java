package api.forum.thread;

import java.util.ArrayList;
import java.util.List;

import api.son.MySon;
import api.soup.MySoup;
import api.util.CouldNotLoadException;
import api.util.Tuple;

/**
 * The Class Thread.
 * 
 * @author Gwindow
 */
public class Thread {
	// TODO voting on polls
	private Response response;
	private String status;
	private transient static int id;
	private transient static int page;

	/**
	 * Thread from id and page.
	 * 
	 * @param id
	 *            the id
	 * @param page
	 *            the page
	 * @return the thread
	 */
	public static Thread threadFromIdAndPage(int id, int page) {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=forum&type=viewthread&threadid=" + id + "&page=" + page + "&auth=" + authkey;
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
	public static Thread threadFromIdAndPostId(int id, int postId) {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=forum&type=viewthread&threadid=" + id + "&postid" + postId + "&auth=" + authkey;
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
	public static Thread threadFromFirstPage(int id) {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=forum&type=viewthread&threadid=" + id + "&page=" + 1 + "&auth=" + authkey;
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
	public static Thread threadFromLastPage(int id) {
		String authkey = MySoup.getAuthKey();
		// get the number of pages
		String url = "ajax.php?action=forum&type=viewthread&threadid=" + id + "&page=" + 1 + "&auth=" + authkey;
		Thread thread = (Thread) MySon.toObject(url, Thread.class);
		// create thread from last page
		url = "ajax.php?action=forum&type=viewthread&threadid=" + id + "&page=" + thread.getLastPage() + "&auth=" + authkey;
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
	public static Thread threadFromNextPage() {
		page += 1;
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=forum&type=viewforum&forumid=" + id + "&page=" + page + "&auth=" + authkey;
		Thread thread = (Thread) MySon.toObject(url, Thread.class);
		return thread;
	}

	/**
	 * Should only be called if hasPreviousPage() returned true.
	 * 
	 * @return the thread
	 */
	public static Thread threadFromPreviousPage() {
		page -= 1;
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=forum&type=viewforum&forumid=" + id + "&page=" + page + "&auth=" + authkey;
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

	/**
	 * Post reply.
	 * 
	 * @param body
	 *            the body
	 */
	public void postReply(String body) {
		if (body.length() > 0) {
			try {
				String url = "forums.php?action=new&forumid=" + id;
				List<Tuple<String, String>> list = new ArrayList<Tuple<String, String>>();
				list.add(new Tuple<String, String>("action", "reply"));
				list.add(new Tuple<String, String>("auth", MySoup.getAuthKey()));
				list.add(new Tuple<String, String>("thread", String.valueOf(id)));
				list.add(new Tuple<String, String>("body", body));
				MySoup.postMethod(url, list);
				System.out.println("Reply posted");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Subscribe to thread
	 */
	public void subscribe() {
		if (!getResponse().isSubscribed()) {
			try {
				MySoup.pressLink("userhistory.php?action=thread_subscribe&topicid=" + id + "&auth=" + MySoup.getAuthKey());
				System.out.println("Subscribed");
			} catch (CouldNotLoadException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Already subscribed");
		}

	}

	/**
	 * unsubscribe to thread
	 */
	public void unsubscribe() {
		if (getResponse().isSubscribed()) {
			try {
				MySoup.pressLink("userhistory.php?action=thread_subscribe&topicid=" + id + "&auth=" + MySoup.getAuthKey());
				System.out.println("Unsubscribed");
			} catch (CouldNotLoadException e) {
				e.printStackTrace();
			}
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
		if (status.equalsIgnoreCase("success"))
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
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
}
