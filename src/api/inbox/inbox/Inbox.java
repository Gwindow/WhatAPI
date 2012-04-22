
package api.inbox.inbox;

import api.son.MySon;
import api.soup.MySoup;

/**
 * The Class Inbox.
 * 
 * @author Gwindow
 */
public class Inbox {

	/** The response. */
	private Response response;

	/** The status. */
	private String status;

	/** The page. */
	private static int page;

	/**
	 * Loads the first page of the inbox.
	 * 
	 * @return the inbox
	 */
	public static Inbox init() {
		return inboxFromPage(1);
	}

	/**
	 * Inbox from page.
	 * 
	 * @param page
	 *            the page
	 * @return the inbox
	 */
	public static Inbox inboxFromPage(int page) {
		String authkey = MySoup.getAuthKey();
		Inbox.page = page;
		String url = "ajax.php?action=inbox&page=" + page + "&auth=" + authkey;
		Inbox inbox = (Inbox) MySon.toObject(url, Inbox.class);
		return inbox;
	}

	/**
	 * Should only be called if hasNextPage() returned true.
	 * 
	 * @return the inbox
	 */
	public static Inbox inboxFromNextPage() {
		page += 1;
		return inboxFromPage(page);
	}

	/**
	 * Should only be called if hasPreviousPage() returned true.
	 * 
	 * @return the inbox
	 */
	public static Inbox inboxFromPreviousPage() {
		page -= 1;
		return inboxFromPage(page);
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
	 * Gets the last page.
	 * 
	 * @return the last page
	 */
	public int getLastPage() {
		try {
			return response.getPages().intValue();
		} catch (Exception e) {
			return 1;
		}
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
			if ((((response.getCurrentPage().intValue()) != 1) || ((response.getCurrentPage().intValue()) == 0)))
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Gets the page.
	 * 
	 * @return the page
	 */
	public static int getPage() {
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Inbox [getResponse()=" + getResponse() + ", getStatus()=" + getStatus() + ", getLastPage()=" + getLastPage()
				+ ", hasNextPage()=" + hasNextPage() + ", hasPreviousPage()=" + hasPreviousPage() + "]";
	}

}
