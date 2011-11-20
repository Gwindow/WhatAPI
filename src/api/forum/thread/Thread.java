


package api.forum.thread;

import api.son.MySon;
import api.soup.MySoup;
import api.util.CouldNotLoadException;

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
	 * @param reply
	 *            the reply
	 */
	public void postReply(String reply) {
		try {
			MySoup.postReply(getUrl(), String.valueOf(id), reply);
		} catch (CouldNotLoadException e) {
			System.err.println("Couldnt't post reply");
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
