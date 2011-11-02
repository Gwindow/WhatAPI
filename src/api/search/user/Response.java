package api.search.user;

import java.util.List;

public class Response {
	private Number currentPage;
	private Number pages;
	private List<Results> results;

	public Number getCurrentPage() {
		return this.currentPage;
	}

	public Number getPages() {
		return this.pages;
	}

	public List<Results> getResults() {
		return this.results;
	}

	@Override
	public String toString() {
		return "Response [getCurrentPage=" + getCurrentPage() + ", getPages=" + getPages() + ", getResults=" + getResults() + "]";
	}
}
