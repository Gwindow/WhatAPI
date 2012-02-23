package api.search.requests;

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

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Response [getCurrentPage=" + getCurrentPage() + ", getPages=" + getPages() + ", getResults=" + getResults() + "]";
	}
}
