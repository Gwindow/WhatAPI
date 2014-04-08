package api.torrents.torrents.comments;

import api.son.MySon;
import api.soup.MySoup;
import api.util.Tuple;

import java.util.ArrayList;
import java.util.List;

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

	private String error;

	/**
	 * The torrent group id we're viewing comments for
	 */
	private transient int groupId;

	/**
	 * Get the last page of comments for some torrent group, this mimics the
	 * site behavior of showing latest comments first.
	 *
	 * @param id id of torrent group to get comments
	 */
	public static TorrentComments fromId(int id){
		String url = "ajax.php?action=tcomments&id=" + id;
		TorrentComments tc = (TorrentComments)MySon.toObject(url, TorrentComments.class);
		tc.groupId = id;
		return tc;
	}

	/**
	 * Get the TorrentComments for some torrent from the torrent group ID
	 * and page number of the comments
	 *
	 * @param id   The TorrentGroup ID to get comments for
	 * @param page The page of comments to get
	 * @return The TorrentComments
	 */
	public static TorrentComments fromId(int id, int page){
		String url = "ajax.php?action=tcomments&id=" + id + "&page=" + page;
		TorrentComments tc = (TorrentComments)MySon.toObject(url, TorrentComments.class);
		tc.groupId = id;
		return tc;
	}

    /**
     * Post a comment on some torrent
     *
     * @param id The TorrentGroup id to post the comment on
     * @param body The body text of the comment to post
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
	 * Post a comment on the torrent group
	 *
	 * @param body Text of comment to post
	 */
	public void postComment(String body){
		postComment(groupId, body);
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
    public boolean getStatus(){
	    return status.equalsIgnoreCase("success");
    }

	public String getError(){
		return error;
	}

	/**
	 * Check if a next page of comments is available
	 */
	public boolean hasNextPage(){
		return response.getPage() != null && response.getPage().intValue() < response.getPages().intValue();
	}

	/**
	 * Get the next page of comments. Returns null if there is
	 * no next page
	 */
	public TorrentComments nextPage(){
		return hasNextPage() ? fromId(groupId, getPage() + 1) : null;
	}

	/**
	 * Check if a previous page of comments is available
	 */
	public boolean hasPreviousPage(){
		return response.getPage() != null && response.getPage().intValue() > 1;
	}

	/**
	 * Get the previous page of comments. Returns null if there is
	 * no previous page
	 */
	public TorrentComments previousPage(){
		return hasPreviousPage() ? fromId(groupId, getPage() - 1) : null;
	}

	/**
	 * Get the current page number being viewed
	 *
	 * @return the page
	 */
	public int getPage(){
		return response.getPage().intValue();
	}

	/**
	 * Get the total number of pages of comments
	 */
	public int getPages(){
		return response.getPages().intValue();
	}

	@Override
	public String toString() {
		return "TorrentComments [getResponse()=" + getResponse() + ", getStatus()=" + getStatus() + "]";
	}
}
