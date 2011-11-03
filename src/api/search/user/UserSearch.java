package api.search.user;

import api.son.MySon;
import api.soup.MySoup;

public class UserSearch {
	private Response response;
	private String status;
	private transient static int page;
	private transient static String searchTerm;

	public static UserSearch userSearchFromSearchTerm(String searchTerm) {
		if (searchTerm.trim().length() > 0) {
			UserSearch.searchTerm = searchTerm;
			page = 1;
			String authkey = MySoup.getAuthKey();
			String url = "ajax.php?action=usersearch&page=" + page + "&search=" + searchTerm + "&auth=" + authkey;
			UserSearch userSearch = (UserSearch) MySon.toObject(url, UserSearch.class);
			return userSearch;
		} else
			return null;
	}

	public static UserSearch userSearchFromSearchTermAndPage(String searchTerm, int page) {
		if (searchTerm.trim().length() > 0) {
			UserSearch.searchTerm = searchTerm;
			UserSearch.page = page;
			String authkey = MySoup.getAuthKey();
			String url = "ajax.php?action=usersearch&page=" + page + "&search=" + searchTerm + "&auth=" + authkey;
			UserSearch userSearch = (UserSearch) MySon.toObject(url, UserSearch.class);
			return userSearch;
		} else
			return null;
	}

	public static UserSearch userSearchFromNextPage() {
		page += 1;
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=usersearch&page=" + page + "&search=" + searchTerm + "&auth=" + authkey;
		UserSearch userSearch = (UserSearch) MySon.toObject(url, UserSearch.class);
		return userSearch;
	}

	public static UserSearch userSearchFromPreviousPage() {
		page -= 1;
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=usersearch&page=" + page + "&search=" + searchTerm + "&auth=" + authkey;
		UserSearch userSearch = (UserSearch) MySon.toObject(url, UserSearch.class);
		return userSearch;
	}

	public Response getResponse() {
		return this.response;
	}

	public boolean getStatus() {
		if (status.equalsIgnoreCase("success"))
			return true;
		return false;
	}

	public boolean hasNextPage() {
		if (((response.getPages().intValue() - (response.getCurrentPage().intValue())) > 0))
			return true;
		else
			return false;
	}

	public boolean hasPreviousPage() {
		if ((((response.getCurrentPage().intValue()) != 1) || ((response.getCurrentPage().intValue()) == 0)))
			return true;
		else
			return false;
	}

	public static int getPage() {
		return page;
	}

	public static String getSearchTerm() {
		return searchTerm;
	}

	@Override
	public String toString() {
		return "UserSearch [getResponse=" + getResponse() + ", getStatus=" + getStatus() + ", hasNextPage=" + hasNextPage()
				+ ", hasPreviousPage=" + hasPreviousPage() + "]";
	}
}
