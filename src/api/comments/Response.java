package api.comments;

import java.util.List;

public class Response {
	private List<Comments> comments;
	private Number page;
	private Number pages;

	public List<Comments> getComments() {
		return this.comments;
	}

	public Number getPage() {
		return this.page;
	}

	public Number getPages() {
		return this.pages;
	}

	@Override
	public String toString() {
		return "Response [getComments()=" + getComments() + ", getPage()=" + getPage() + ", getPages()=" + getPages() + "]";
	}
}
