package api.comments;

import java.util.ArrayList;
import java.util.List;

import api.son.MySon;
import api.soup.MySoup;
import api.util.Tuple;

/**
 * The class TorrentComments
 * For getting and using the API related to reading
 * and posting TorrentComments
 *
 * @author Gwindow
 */
public class TorrentComments {
    /** The API response, contains the data we want */
	private Response response;

    /** The status of the API response */
	private String status;

    /**
     * Get the TorrentComments for some torrent from the torrent group ID
     * and page number of the comments
     *
     * @param id
     *      The TorrentGroup ID to get comments for
     * @param page
     *      The page of comments to get
     * @return The TorrentComments
     */
	public static TorrentComments fromIdAndPage(int id, int page) {
		String url = "ajax.php?action=tcomments&id=" + id + "&page=" + page;
		return (TorrentComments) MySon.toObject(url, TorrentComments.class);
	}

    /**
     * Post a comment on some torrent
     * @param id
     *      The TorrentGroup id to post the comment on
     * @param body
     *      The body text of the comment to post
     */
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

    /**
     * Get the API response
     *
     * @return the API response
     */
	public Response getResponse() {
		return this.response;
	}

    /**
     * Get the status of the API request
     *
     * @return True if the request was successful
     */
	public boolean getStatus() {
        return this.status.equalsIgnoreCase("success");
	}

	@Override
	public String toString() {
		return "TorrentComments [getResponse()=" + getResponse() + ", getStatus()=" + getStatus() + "]";
	}
}
