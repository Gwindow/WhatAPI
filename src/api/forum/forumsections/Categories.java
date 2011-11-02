package api.forum.forumsections;

import java.util.List;

public class Categories {
	private String categoryID;
	private String categoryName;
	private List<Forums> forums;

	public String getCategoryID() {
		return this.categoryID;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public List<Forums> getForums() {
		return this.forums;
	}

	@Override
	public String toString() {
		return "Categories [getCategoryID=" + getCategoryID() + ", getCategoryName=" + getCategoryName() + ", getForums="
				+ getForums() + "]";
	}
}
