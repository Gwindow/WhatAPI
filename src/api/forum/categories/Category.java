package api.forum.categories;

import java.util.List;

/**
 * The Class Category.
 * Stores information about the category and the forums
 * within it
 *
 * @author Gwindow
 */
public class Category {
	/**
	 * The category id.
	 */
	private Number categoryID;

	/**
	 * The category name.
	 */
	private String categoryName;

	/**
	 * The forums in the category
	 */
	private List<Forum> forums;

	/**
	 * Get the category id.
	 *
	 * @return the category id
	 */
	public Number getCategoryID(){
		return this.categoryID;
	}

	/**
	 * Get the category name.
	 *
	 * @return the category name
	 */
	public String getCategoryName(){
		return this.categoryName;
	}

	/**
	 * Get the forums in the category
	 *
	 * @return the forums
	 */
	public List<Forum> getForums(){
		return this.forums;
	}

	@Override
	public String toString(){
		return "Category [getCategoryID=" + getCategoryID() + ", getCategoryName=" + getCategoryName() + ", getForums="
			+ getForums() + "]";
	}
}
