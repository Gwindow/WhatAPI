package api.inbox.inbox;

import api.son.MySon;
import api.soup.MySoup;

public class Inbox {
	private Response response;
	private String status;
	private static int page;

	public static Inbox inboxFromPage(int page) {
		String authkey = MySoup.getAuthKey();
		Inbox.page = page;
		String url = "ajax.php?action=inbox&page=" + page + "&auth=" + authkey;
		Inbox inbox = (Inbox) MySon.toObject(url, Inbox.class);
		return inbox;
	}

	/**
	 * Should only be called if hasNextPage() returned true
	 * 
	 * @return
	 */
	public static Inbox inboxFromNextPage() {
		page += 1;
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=inbox&page=" + page + "&auth=" + authkey;
		Inbox inbox = (Inbox) MySon.toObject(url, Inbox.class);
		return inbox;
	}

	/**
	 * Should only be called if hasPreviousPage() returned true
	 * 
	 * @return
	 */
	public static Inbox inboxFromPreviousPage() {
		page -= 1;
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=inbox&page=" + page + "&auth=" + authkey;
		Inbox inbox = (Inbox) MySon.toObject(url, Inbox.class);
		return inbox;
	}

	public Response getResponse() {
		return this.response;
	}

	public boolean getStatus() {
		if (status.equalsIgnoreCase("success"))
			return true;
		return false;
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
		if ((((response.getCurrentPage().intValue()) != 1) || ((response.getCurrentPage().intValue()) != 0)))
			return true;
		else
			return false;
	}

	/**
	 * @return the page
	 */
	public static int getPage() {
		return page;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Inbox [getResponse()=" + getResponse() + ", getStatus()=" + getStatus() + ", getLastPage()=" + getLastPage()
				+ ", hasNextPage()=" + hasNextPage() + ", hasPreviousPage()=" + hasPreviousPage() + "]";
	}

}
