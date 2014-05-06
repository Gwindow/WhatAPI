package api.notifications;

import api.son.MySon;
import api.soup.MySoup;

/**
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
	 * The response status and possible error message
	 */
	private String status, error;

	/**
	 * The page being viewed
	 */
	private transient int page;

	/**
	 * Get the first page of notifications
	 */
	public static Notifications notifications(){
		return page(1);
	}

	/**
	 * Get some page of notifications
	 */
	public static Notifications page(int page){
		String url = "ajax.php?action=notifications&page=" + page + "&auth=" + MySoup.getAuthKey();
		Notifications n = (Notifications)MySon.toObject(url, Notifications.class);
		if (n != null){
			n.page = page;
		}
		return n;
	}

	/**
	 * Check if a next page of results is available
	 *
	 * @return True if a next page is available
	 */
	public boolean hasNextPage(){
		return response.getCurrentPage() != null && response.getCurrentPage().intValue() < response.getPages().intValue();
	}

	/**
	 * Get the next page of search results. Returns null if there is
	 * no next page
	 *
	 * @return the next page of search results
	 */
	public Notifications nextPage(){
		return hasNextPage() ? page(page + 1) : null;
	}

	/**
	 * Check if a previous page of results is available
	 *
	 * @return true if a previous page is available
	 */
	public boolean hasPreviousPage(){
		return response.getCurrentPage() != null && response.getCurrentPage().intValue() > 1;
	}

	/**
	 * Get the previous page of search results. Returns null if there is
	 * no previous page
	 *
	 * @return the previous page of search results
	 */
	public Notifications previousPage(){
		return hasPreviousPage() ? page(page - 1) : null;
	}

	/**
	 * Clear the notifications
	 */
	public void clearNotifications(){
		String url = "torrents.php?action=notify_clear&auth=" + MySoup.getAuthKey();
		MySoup.pressLink(url);
		response.clear();
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
	 * Get the page number being viewed
	 */
	public int getPage(){
		return page;
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
		return "Notifications [hasNextPage=" + hasNextPage() + ", hasPreviousPage=" + hasPreviousPage()
			+ ", getResponse=" + getResponse() + ", getStatus=" + getStatus() + "]";
	}
}
