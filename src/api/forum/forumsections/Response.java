package api.forum.forumsections;

import java.util.List;

/**
 * The Class Response.
 * Stores information about the ForumSection API
 * response data
 * 
 * @author Gwindow
 */
public class Response {
	/** The categories of forums, such as Site, Community, etc. */
	private List<Category> categories;

	/**
	 * Get the categories.
	 * 
	 * @return the categories
	 */
	public List<Category> getCategories() {
		return this.categories;
	}

	@Override
	public String toString() {
		return "Response [getCategories=" + getCategories() + "]";
	}
}
