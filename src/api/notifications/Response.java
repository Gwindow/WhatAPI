package api.notifications;

import java.util.List;

public class Response {
	private Number currentPages;
	private Number numNew;
	private Number pages;
	private List<Results> results;

	public Number getCurrentPages() {
		return this.currentPages;
	}

	public Number getNumNew() {
		return this.numNew;
	}

	public Number getPages() {
		return this.pages;
	}

	public List<Results> getResults() {
		return this.results;
	}

	public void clear() {
		currentPages = 0;
		numNew = 0;
		pages = 0;
		results.clear();
	}

	@Override
	public String toString() {
		return "Response [getCurrentPages=" + getCurrentPages() + ", getNumNew=" + getNumNew() + ", getPages=" + getPages()
				+ ", getResults=" + getResults() + "]";
	}
}
