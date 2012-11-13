
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
		return fromPage(1);
	}

	/**
	 * Inbox from page.
	 * 
	 * @param page
	 *            the page
	 * @return the inbox
	 */
	public static Inbox fromPage(int page) {
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
	public static Inbox fromNextPage() {
		++page;
		return fromPage(page);
	}

	/**
	 * Should only be called if hasPreviousPage() returned true.
	 * 
	 * @return the inbox
	 */
	public static Inbox fromPreviousPage() {
		--page;
		return fromPage(page);
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

	/**
	 * Gets the last page.
	 * 
	 * @return the last page
	 */
	public int getLastPage() {
        //What throws?
        return response.getPages().intValue();
        /*
		try {
			return response.getPages().intValue();
		} catch (Exception e) {
			return 1;
		}
		*/
	}

	/**
	 * Checks for next page.
	 * 
	 * @return true, if successful
	 */
	public boolean hasNextPage() {
        //What throws?
        return ((response.getPages().intValue() - (response.getCurrentPage().intValue())) > 0);
        /*
		try {
			return ((response.getPages().intValue() - (response.getCurrentPage().intValue())) > 0);
		} catch (Exception e) {
            System.out.println("Inbox.hasNextPage exception: " + e.g);
			return false;
		}
		*/
	}

	/**
	 * Checks for previous page.
	 * 
	 * @return true, if successful
	 */
	public boolean hasPreviousPage() {
        //What throws?
        return ((response.getCurrentPage().intValue() != 1) || (response.getCurrentPage().intValue() == 0));
        /*
		try {
			return ((response.getCurrentPage().intValue()) != 1) || ((response.getCurrentPage().intValue()) == 0);
		} catch (Exception e) {
			return false;
		}
		*/
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
