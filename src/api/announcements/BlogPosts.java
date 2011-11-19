/**
 * @author Gwindow
 */
package api.announcements;

/**
 * The Class BlogPosts.
 */
public class BlogPosts {
	private String author;
	private Number blogId;
	private String blogTime;
	private String body;
	private Number threadId;
	private String title;

	/**
	 * Get the author of the blog post.
	 * 
	 * @return the author
	 */
	public String getAuthor() {
		return this.author;
	}

	/**
	 * The id of the blog post.
	 * 
	 * @return the id
	 */
	public Number getBlogId() {
		return this.blogId;
	}

	/**
	 * The time at which the blog post was created.
	 * 
	 * @return the time
	 */
	public String getBlogTime() {
		return this.blogTime;
	}

	/**
	 * The body of the blog post.
	 * 
	 * @return the body
	 */
	public String getBody() {
		return this.body;
	}

	/**
	 * The id of the thread associated with this blog post.
	 * 
	 * @return the id
	 */
	public Number getThreadId() {
		return threadId;
	}

	/**
	 * The title of the blog post.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BlogPosts [getAuthor=" + getAuthor() + ", getBlogId=" + getBlogId() + ", getBlogTime=" + getBlogTime()
				+ ", getBody=" + getBody() + ", getThreadId=" + getThreadId() + ", getTitle=" + getTitle() + "]";
	}
}
