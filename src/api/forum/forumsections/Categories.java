/**
 * @author Gwindow
 */
package api.forum.forumsections;

import java.util.List;

/**
 * The Class Categories.
 */
public class Categories {
	private Number categoryID;
	private String categoryName;
	private List<Forums> forums;

	/**
	 * Gets the category id.
	 * 
	 * @return the category id
	 */
	public Number getCategoryID() {
		return this.categoryID;
	}

	/**
	 * Gets the category name.
	 * 
	 * @return the category name
	 */
	public String getCategoryName() {
		return this.categoryName;
	}

	/**
	 * Gets the forums.
	 * 
	 * @return the forums
	 */
	public List<Forums> getForums() {
		return this.forums;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Categories [getCategoryID=" + getCategoryID() + ", getCategoryName=" + getCategoryName() + ", getForums="
				+ getForums() + "]";
	}
}
