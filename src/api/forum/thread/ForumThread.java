package api.forum.thread;

import api.son.MySon;
import api.soup.MySoup;
import api.util.CouldNotLoadException;
import api.util.Tuple;

import java.util.ArrayList;
import java.util.List;

/**
 * For getting API response and working with information
 * for viewing a forum thread
 *
 * @author Gwindow
 */
public class ForumThread {
	/**
	 * The API response
	 */
	private Response response;

	/**
	 * The status of the API response and error if an error occurred
	 */
	private String status, error;

	/**
	 * The thread id
	 */
	private transient int id;

	/**
	 * The page of the thread being viewed.
	 */
	private transient int page;

	/**
	 * Get some page of a forum thread
	 *
	 * @param id the thread id
	 * @param page page of to view
	 */
	public static ForumThread thread(int id, int page){
		String url = "ajax.php?action=forum&type=viewthread&threadid=" + id
			+ "&page=" + page + "&auth=" + MySoup.getAuthKey();
		ForumThread thread = (ForumThread)MySon.toObject(url, ForumThread.class);
		if (thread != null){
			thread.id = id;
			thread.page = page;
		}
		return thread;
	}

	/**
	 * Get the first page of a forum thread
	 *
	 * @param id   the thread id
	 */
	public static ForumThread thread(int id){
		return thread(id, 1);
	}

	/**
	 * Get the forum thread viewing the page containing the post
	 *
	 * @param id     the thread id
	 * @param postId the post id of the post to view
	 */
	public static ForumThread threadAtPost(int id, int postId){
		String url = "ajax.php?action=forum&type=viewthread&threadid=" + id
			+ "&postid=" + postId + "&auth=" + MySoup.getAuthKey();
		ForumThread thread = (ForumThread)MySon.toObject(url, ForumThread.class);
		if (thread != null && thread.getStatus()){
			thread.id = id;
			thread.page = thread.getResponse().getCurrentPage().intValue();
		}
		return thread;
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
	public ForumThread nextPage(){
		return hasNextPage() ? thread(id, page + 1) : null;
	}

	/**
	 * Check if a previous page of results is available
	 *
	 * @return True if a previous page is available
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
	public ForumThread previousPage(){
		return hasPreviousPage() ? thread(id, page - 1) : null;
	}

	/**
	 * Get the thread URL
	 *
	 * @return the thread URL
	 */
	public String getUrl(){
		return "forums.php?action=viewthread&threadid=" + id + "&page=" + page;
	}

	/**
	 * Post a reply to a thread
	 *
	 * @param id        thread id of the thread to post too
	 * @param body      the body text of the post to make
	 * @param subscribe if we want to subscribe to thread as well
	 * @return true if successful
	 */
	public static boolean postReply(int id, String body, boolean subscribe){
		if (body.length() > 0){
			try {
				String url = "forums.php?action=new&forumid=" + id;
				List<Tuple<String, String>> list = new ArrayList<Tuple<String, String>>();
				list.add(new Tuple<String, String>("action", "reply"));
				list.add(new Tuple<String, String>("auth", MySoup.getAuthKey()));
				list.add(new Tuple<String, String>("thread", String.valueOf(id)));
				list.add(new Tuple<String, String>("body", body));
				if (subscribe){
					list.add(new Tuple<String, String>("subscribe", "checked"));
				}
				MySoup.postMethod(url, list);
			}
			catch (CouldNotLoadException e){
				e.printStackTrace();
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * Post a reply to this thread
	 *
	 * @param body      body text to post
	 * @param subscribe if we should subscribe to the thread
	 * @return true if successful
	 */
	public boolean postReply(String body, boolean subscribe){
		return postReply(id, body, subscribe);
	}

	/**
	 * Subscribe to the ForumThread
	 *
	 * @return true if successful
	 */
	public boolean subscribe(){
		return getResponse().isSubscribed()
			|| MySoup.pressLink("userhistory.php?action=thread_subscribe&topicid=" + id + "&auth=" + MySoup.getAuthKey());
	}

	/**
	 * Unsubscribe from the ForumThread
	 *
	 * @return true if successful
	 */
	public boolean unsubscribe(){
		return !getResponse().isSubscribed()
			|| MySoup.pressLink("userhistory.php?action=thread_subscribe&topicid=" + id + "&auth=" + MySoup.getAuthKey());
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
	 * Get the status of the API response
	 *
	 * @return True if successful
	 */
	public boolean getStatus(){
		return status.equalsIgnoreCase("success");
	}

	public String getError(){
		return error;
	}

	/**
	 * Get the thread id
	 *
	 * @return the thread id
	 */
	public int getId(){
		return id;
	}

	/**
	 * Get the page number being viewed
	 *
	 * @return the page number
	 */
	public int getPage(){
		return page;
	}

	/**
	 * Get the number of pages
	 */
	public int getPages(){
		return response.getPages().intValue();
	}

	@Override
	public String toString(){
		return "ForumThread [id=" + id + ", page=" + page + "  hasNextPage=" + hasNextPage()
			+ ", hasPreviousPage=" + hasPreviousPage() + ", getUrl=" + getUrl()
			+ ", getResponse=" + getResponse() + ", getStatus=" + getStatus() + "]";
	}
}
