package api.forum.section;

import java.util.List;

public class Response {
	private Number currentPage;
	private String forumName;
	private Number pages;
	private List<String> specificRules;
	private List<Threads> threads;

	public Number getCurrentPage() {
		return (currentPage);
	}

	public String getForumName() {
		return this.forumName;
	}

	public Number getPages() {
		return this.pages;
	}

	public List<String> getSpecificRules() {
		return this.specificRules;
	}

	public List<Threads> getThreads() {
		return this.threads;
	}

	@Override
	public String toString() {
		return "Response [getCurrentPage=" + getCurrentPage() + ", getForumName=" + getForumName() + ", getPages=" + getPages()
				+ ", getSpecificRules=" + getSpecificRules() + ", getThreads=" + getThreads() + "]";
	}
}
