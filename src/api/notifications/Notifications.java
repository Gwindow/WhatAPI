package api.notifications;

import api.son.MySon;
import api.soup.MySoup;

public class Notifications {
	private Response response;
	private String status;
	private static transient int page;

	public static Notifications notificationsFromPage(int page) {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=notifications&page=" + page + "&auth=" + authkey;
		Notifications n = (Notifications) MySon.toObject(url, Notifications.class);
		Notifications.page = page;
		return n;
	}

	/**
	 * Should only be called if hasNextPage() returned true
	 * 
	 * @return
	 */
	public static Notifications notificationsFromNextPage() {
		page += 1;
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=notifications&page=" + page + "&auth=" + authkey;
		Notifications n = (Notifications) MySon.toObject(url, Notifications.class);
		return n;
	}

	/**
	 * Should only be called if hasPreviousPage() returned true
	 * 
	 * @return
	 */
	public static Notifications notificationsFromPreviousPage() {
		page -= 1;
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=notifications&page=" + page + "&auth=" + authkey;
		Notifications n = (Notifications) MySon.toObject(url, Notifications.class);
		return n;
	}

	public int getLastPage() {
		try {
			return response.getPages().intValue();
		} catch (Exception e) {
			return 0;
		}
	}

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

	public void clearNotifications() {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=notifications&auth=" + authkey + "$clear=1";
		MySoup.pressLink(url);
		response.clear();
	}

	public Response getResponse() {
		return this.response;
	}

	public boolean getStatus() {
		if (status.equalsIgnoreCase("success"))
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "Notifications [getLastPage=" + getLastPage() + ", hasNextPage=" + hasNextPage() + ", hasPreviousPage="
				+ hasPreviousPage() + ", getResponse=" + getResponse() + ", getStatus=" + getStatus() + "]";
	}

}
