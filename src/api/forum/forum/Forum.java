package api.forum.forum;

import api.son.MySon;
import api.soup.MySoup;
import api.util.CouldNotLoadException;
import api.util.Tuple;

import java.util.ArrayList;
import java.util.List;

/**
 * For getting and using the API for viewing a forum
 *
 * @author Gwindow
 */
public class Forum {
	/**
	 * The API response data
	 */
	private Response response;

	/**
	 * The API response status and error message (if error occurred)
	 */
	private String status, error;

	/**
	 * The forum id
	 */
	private transient int id;

	/**
	 * The forum page number
	 */
	private transient int page;

	/**
	 * Get some page of a Forum from its forum id
	 */
	public static Forum forum(int id, int page){
		String url = "ajax.php?action=forum&type=viewforum&forumid=" + id
			+ "&page=" + page + "&auth=" + MySoup.getAuthKey();
		Forum section = (Forum)MySon.toObject(url, Forum.class);
		if (section != null){
			section.id = id;
			section.page = page;
		}
		return section;
	}

	/**
	 * Get the first page of a Forum from its forum id
	 */
	public static Forum forum(int id){
		return forum(id, 1);
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
	public Forum nextPage(){
		return hasNextPage() ? forum(id, page + 1) : null;
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
	public Forum previousPage(){
		return hasPreviousPage() ? forum(id, page - 1) : null;
	}

	/**
	 * Get the last page number
	 *
	 * @return the last page number
	 */
	public int getLastPage(){
		return response.getPages().intValue();
	}

	/**
	 * Get the API response.
	 *
	 * @return the response
	 */
	public Response getResponse(){
		return response;
	}

	/**
	 * Get the name of this forum
	 */
	public String getForumName(){
		return response.getForumName();
	}

	/**
	 * Get the list of specific rules threads for the forum
	 */
	public List<SpecificRules> getSpecificRules(){
		return response.getSpecificRules();
	}

	/**
	 * Get the threads in the forum
	 */
	public List<ForumThread> getThreads(){
		return response.getThreads();
	}

	/**
	 * Gets the status of the API request
	 *
	 * @return True if success
	 */
	public boolean getStatus(){
		return status.equalsIgnoreCase("success");
	}

	/**
	 * Get the error message for the error that occurred, null if no error
	 */
	public String getError(){
		return error;
	}

	/**
	 * Get the forum id.
	 */
	public int getId(){
		return id;
	}

	/**
	 * Gets the current page number
	 */
	public int getPage(){
		return page;
	}

	/**
	 * Get the total number of pages in the forum
	 */
	public int getPages(){
		return response.getPages().intValue();
	}

	/**
	 * Create a new thread in some forum with a given title
	 * and post body text
	 *
	 * @param id    the forum id to post the thread in
	 * @param title the title for the thread
	 * @param body  the body text of the post
	 * @return true if successful
	 */
	public static boolean createThread(int id, String title, String body){
		if (title.length() > 0 && body.length() > 0){
			try {
				String url = "forums.php?action=new&forumid=" + id;
				List<Tuple<String, String>> list = new ArrayList<Tuple<String, String>>();
				list.add(new Tuple<String, String>("action", "new"));
				list.add(new Tuple<String, String>("auth", MySoup.getAuthKey()));
				list.add(new Tuple<String, String>("forum", String.valueOf(id)));
				list.add(new Tuple<String, String>("title", title));
				list.add(new Tuple<String, String>("body", body));
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
	 * Create a new thread in this forum
	 *
	 * @return true if successful
	 */
	public boolean createThread(String title, String body){
		return createThread(id, title, body);
	}

	/**
	 * Subscribe to all unread threads.
	 * TODO: Add status return to subscribe call
	 *
	 * @return true if successful
	 */
	public boolean subscribeToAllUnread(){
		for (int i = 0; i < response.getThreads().size(); i++){
			if (!response.getThreads().get(i).isRead()){
				response.getThreads().get(i).subscribe();
			}
		}
		return true;
	}

	/**
	 * Get the number of unread threads.
	 *
	 * @return the number of unread threads
	 */
	public int getNumberOfUnread(){
		int counter = 0;
		for (ForumThread thread : response.getThreads()){
			if (!thread.isRead()){
				++counter;
			}
		}
		return counter;
	}

	/**
	 * Catch up with all subscribed posts
	 *
	 * @return true if successful
	 */
	public boolean catchUp(){
		return MySoup.pressLink("forums.php?action=catchup&forumid=" + id
			+ "&auth=" + MySoup.getAuthKey());
	}

	/**
	 * Subscribe to all unread threads and catch up
	 */
	public boolean subscribeToAllUnreadAndCatchUp(){
		return subscribeToAllUnread() && catchUp();
	}

	@Override
	public String toString(){
		return "Forum [id = " + id + ", page = " + page + ", hasNextPage="
			+ hasNextPage() + ", getResponse=" + getResponse() + ", getStatus=" + getStatus() + "]";
	}
}
