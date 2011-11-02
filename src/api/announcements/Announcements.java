package api.announcements;

import api.son.MySon;
import api.soup.MySoup;

public class Announcements {
	private Response response;
	private String status;

	public static Announcements init() {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=announcements&auth=" + authkey;
		Announcements a = (Announcements) MySon.toObject(url, Announcements.class);
		return a;
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
		return "Announcements [getResponse=" + getResponse() + ", getStatus=" + getStatus() + "]";
	}

}
