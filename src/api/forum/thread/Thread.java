package api.forum.thread;

import api.son.MySon;
import api.soup.MySoup;
import api.util.CouldNotLoadException;

public class Thread {
	// TODO voting on polls
	private Response response;
	private String status;
	private transient static int id;
	private transient static int page;

	public static Thread threadFromIdAndPage(int id, int page) {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=forum&type=viewthread&threadid=" + id + "&page=" + page + "&auth=" + authkey;
		Thread thread = (Thread) MySon.toObject(url, Thread.class);
		Thread.id = id;
		Thread.page = page;

		return thread;
	}

	/**
	 * Should only be called if hasNextPage() returned true
	 * 
	 * @return
	 */
	public static Thread threadFromNextPage() {
		page += 1;
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=forum&type=viewforum&forumid=" + id + "&page=" + page + "&auth=" + authkey;
		Thread thread = (Thread) MySon.toObject(url, Thread.class);
		return thread;
	}

	/**
	 * Should only be called if hasPreviousPage() returned true
	 * 
	 * @return
	 */
	public static Thread threadFromPreviousPage() {
		page -= 1;
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=forum&type=viewforum&forumid=" + id + "&page=" + page + "&auth=" + authkey;
		Thread thread = (Thread) MySon.toObject(url, Thread.class);
		return thread;
	}

	public int getLastPage() {
		return response.getPages().intValue();
	}

	public boolean hasNextPage() {
		if ((response.getPages().intValue() - (response.getCurrentPage().intValue())) > 0)
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

	public String getUrl() {
		String url = "forums.php?action=viewthread&threadid=" + id + "&page=" + page;
		return url;
	}

	public void postReply(String reply) {
		try {
			MySoup.postReply(getUrl(), String.valueOf(id), reply);
		} catch (CouldNotLoadException e) {
			System.err.println("Couldnt't post reply");
		}
	}

	public Response getResponse() {
		return this.response;
	}

	public String getStatus() {
		return this.status;
	}

	@Override
	public String toString() {
		return "Thread [id = " + id + ", page = " + page + "  hasNextPage=" + hasNextPage() + ", getUrl=" + getUrl()
				+ ", getResponse=" + getResponse() + ", getStatus=" + getStatus() + "]";
	}

	public static int getId() {
		return id;
	}

	public static int getPage() {
		return page;
	}
}
