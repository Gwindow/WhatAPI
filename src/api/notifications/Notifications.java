package api.notifications;

import api.son.MySon;
import api.soup.MySoup;

/**
 * The Class Notifications.
 * 
 * @author Gwindow
 */
public class Notifications {
	private Response response;
	private String status;
	private static transient int page;

	/**
	 * Notifications from page.
	 * 
	 * @param page
	 *            the page
	 * @return the notifications
	 */
	public static Notifications notificationsFromPage(int page) {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=notifications&page=" + page + "&auth=" + authkey;
		Notifications n = (Notifications) MySon.toObject(url, Notifications.class);
		Notifications.page = page;
		return n;
	}

	/**
	 * Should only be called if hasNextPage() returned true.
	 * 
	 * @return the notifications
	 */
	public static Notifications notificationsFromNextPage() {
		page += 1;
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=notifications&page=" + page + "&auth=" + authkey;
		Notifications n = (Notifications) MySon.toObject(url, Notifications.class);
		return n;
	}

	/**
	 * Should only be called if hasPreviousPage() returned true.
	 * 
	 * @return the notifications
	 */
	public static Notifications notificationsFromPreviousPage() {
		page -= 1;
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=notifications&page=" + page + "&auth=" + authkey;
		Notifications n = (Notifications) MySon.toObject(url, Notifications.class);
		return n;
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
			return 0;
		}
	}

	/**
	 * Checks for next page.
	 * 
	 * @return true, if successful
	 */
	public boolean hasNextPage() {
		try {
			if ((response.getPages().intValue() - response.getCurrentPages().intValue()) > 0)
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
			if (((response.getCurrentPages().intValue()) != 1) || ((response.getCurrentPages().intValue()) == 0))
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Clear notifications.
	 */
	public void clearNotifications() {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=notifications&auth=" + authkey + "$clear=1";
		MySoup.pressLink(url);
		response.clear();
		System.out.println("Notifications cleared");
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
		return "Notifications [getLastPage=" + getLastPage() + ", hasNextPage=" + hasNextPage() + ", hasPreviousPage="
				+ hasPreviousPage() + ", getResponse=" + getResponse() + ", getStatus=" + getStatus() + "]";
	}

}
