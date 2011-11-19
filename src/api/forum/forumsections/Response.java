/**
 * @author Gwindow
 */
package api.forum.forumsections;

import java.util.List;

/**
 * The Class Response.
 */
public class Response {
	private List<Categories> categories;

	/**
	 * Gets the categories.
	 * 
	 * @return the categories
	 */
	public List<Categories> getCategories() {
		return this.categories;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Response [getCategories=" + getCategories() + "]";
	}
}
