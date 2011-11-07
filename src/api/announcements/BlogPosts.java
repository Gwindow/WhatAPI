package api.announcements;

public class BlogPosts {
	private String author;
	private String blogId;
	private String blogTime;
	private String body;
	private String threadId;
	private String title;

	/**
	 * Get the author of the blog post
	 * 
	 * @return the author
	 */
	public String getAuthor() {
		return this.author;
	}

	/**
	 * The id of the blog post
	 * 
	 * @return the id
	 */
	public String getBlogId() {
		return this.blogId;
	}

	/**
	 * The time at which the blog post was created
	 * 
	 * @return the time
	 */
	public String getBlogTime() {
		return this.blogTime;
	}

	/**
	 * The body of the blog post
	 * 
	 * @return the body
	 */
	public String getBody() {
		return this.body;
	}

	/**
	 * The id of the thread associated with this blog post
	 * 
	 * @return the id
	 */
	public int getThreadId() {
		return Integer.parseInt(threadId);
	}

	/**
	 * The title of the blog post
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	@Override
	public String toString() {
		return "BlogPosts [getAuthor=" + getAuthor() + ", getBlogId=" + getBlogId() + ", getBlogTime=" + getBlogTime()
				+ ", getBody=" + getBody() + ", getThreadId=" + getThreadId() + ", getTitle=" + getTitle() + "]";
	}
}
