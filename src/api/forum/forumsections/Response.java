package api.forum.forumsections;

import java.util.List;

public class Response {
	private List<Categories> categories;

	public List<Categories> getCategories() {
		return this.categories;
	}

	@Override
	public String toString() {
		return "Response [getCategories=" + getCategories() + "]";
	}
}
