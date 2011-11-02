package api.announcements;


public class BlogPosts {
	private String author;
	private String blogId;
	private String blogTime;
	private String body;
	private String threadId;
	private String title;

	public String getAuthor() {
		return this.author;
	}

	public String getBlogId() {
		return this.blogId;
	}

	public String getBlogTime() {
		return this.blogTime;
	}

	public String getBody() {
		return this.body;
	}

	public String getThreadId() {
		return this.threadId;
	}

	public String getTitle() {
		return this.title;
	}

	@Override
	public String toString() {
		return "BlogPosts [getAuthor=" + getAuthor() + ", getBlogId=" + getBlogId() + ", getBlogTime=" + getBlogTime()
				+ ", getBody=" + getBody() + ", getThreadId=" + getThreadId() + ", getTitle=" + getTitle() + "]";
	}
}
