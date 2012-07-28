package api.comments;

import api.son.MySon;

public class TorrentComments {
	private Response response;
	private String status;

	public static TorrentComments fromIdAndPage(int id, int page) {
		String url = "ajax.php?action=tcomments&id=" + id + "&page=" + page;
		return (TorrentComments) MySon.toObject(url, TorrentComments.class);
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
		return "TorrentComments [getResponse()=" + getResponse() + ", getStatus()=" + getStatus() + "]";
	}
}
