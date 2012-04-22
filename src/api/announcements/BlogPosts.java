



package api.announcements;

/**
 * The Class BlogPosts.
 * 
 * @author Gwindow
 */
public class BlogPosts {
	
	/** The author. */
	private String author;
	
	/** The blog id. */
	private Number blogId;
	
	/** The blog time. */
	private String blogTime;
	
	/** The body. */
	private String body;
	
	/** The thread id. */
	private Number threadId;
	
	/** The title. */
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
