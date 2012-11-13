package api.comments;

import java.util.ArrayList;
import java.util.List;

import api.son.MySon;
import api.soup.MySoup;
import api.util.Tuple;

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
        return status.equalsIgnoreCase("success");
	}

	@Override
	public String toString() {
		return "TorrentComments [getResponse()=" + getResponse() + ", getStatus()=" + getStatus() + "]";
	}

	public static void postComment(int id, String body) {
		if (body.length() > 0) {
			try {
				String url = "torrents.php?action=takeedit_post&groupid=" + id;
				List<Tuple<String, String>> list = new ArrayList<Tuple<String, String>>();
				list.add(new Tuple<String, String>("action", "reply"));
				list.add(new Tuple<String, String>("auth", MySoup.getAuthKey()));
				list.add(new Tuple<String, String>("groupid", String.valueOf(id)));
				list.add(new Tuple<String, String>("body", body));
				MySoup.postMethod(url, list);
				System.out.println("Reply posted");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
