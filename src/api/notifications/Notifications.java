package api.notifications;

import api.son.MySon;
import api.soup.MySoup;

/**
 * The Class Notifications.
 * For interacting with the site API related to notifications
 *
 * @author Gwindow
 */
public class Notifications {
	/**
	 * The API response.
	 */
	private Response response;

	/**
	 * The response status
	 */
	private String status;

	private String error;

	/**
	 * The page being viewed
	 */
	private static transient int page;

	/**
	 * Get the Notifications on the first page
	 *
	 * @return Notifications from page 1
	 */
	public static Notifications notifications(){
		return notificationsFromPage(1);
	}

	/**
	 * Get the Notifications from some page
	 *
	 * @param page the page to get
	 * @return Notifications for the page
	 */
	public static Notifications notificationsFromPage(int page){
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=notifications&page=" + page + "&auth=" + authkey;
		Notifications n = (Notifications)MySon.toObject(url, Notifications.class);
		Notifications.page = page;
		return n;
	}

	/**
	 * Get the next page of Notifications
	 * Should only be called if hasNextPage() returned true.
	 *
	 * @return Notifications for the next page
	 */
	public static Notifications notificationsFromNextPage(){
		++page;
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=notifications&page=" + page + "&auth=" + authkey;
		return (Notifications)MySon.toObject(url, Notifications.class);
	}

	/**
	 * Get the previous page of Notifications
	 * Should only be called if hasPreviousPage() returned true.
	 *
	 * @return Notifications for the previous page
	 */
	public static Notifications notificationsFromPreviousPage(){
		--page;
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=notifications&page=" + page + "&auth=" + authkey;
		return (Notifications)MySon.toObject(url, Notifications.class);
	}

	/**
	 * Get the last page number of the notifications
	 *
	 * @return the last page number
	 */
	public int getLastPage(){
		return response.getPages().intValue();
	}

	/**
	 * Check if there is a next page of notifications available
	 *
	 * @return True if a next page is available
	 */
	public boolean hasNextPage(){
		return ((response.getPages().intValue() - response.getCurrentPages().intValue()) > 0);
	}

	/**
	 * Check if there is a previous page of notifications available
	 *
	 * @return True if a previous page is available
	 */
	public boolean hasPreviousPage(){
		return (response.getCurrentPages().intValue() != 1 || response.getCurrentPages().intValue() == 0);
	}

	/**
	 * Clear the notifications
	 */
	public void clearNotifications(){
		String authkey = MySoup.getAuthKey();
		String url = "torrents.php?action=notify_clear&auth=" + authkey;
		MySoup.pressLink(url);
		response.clear();
		System.out.println("Notifications cleared");
	}

	/**
	 * Get the API response
	 *
	 * @return the API response
	 */
	public Response getResponse(){
		return response;
	}

	/**
	 * Check the status of the response
	 *
	 * @return True if success
	 */
	public boolean getStatus(){
		return status.equalsIgnoreCase("success");
	}

	public String getError(){
		return error;
	}

	@Override
	public String toString(){
		return "Notifications [getLastPage=" + getLastPage() + ", hasNextPage=" + hasNextPage() + ", hasPreviousPage="
			+ hasPreviousPage() + ", getResponse=" + getResponse() + ", getStatus=" + getStatus() + "]";
	}

}
