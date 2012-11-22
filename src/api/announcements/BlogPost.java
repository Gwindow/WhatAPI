
package api.announcements;

/**
 * The Class BlogPost.
 * Contains information relevant to a BlogPost,
 * the author, id, date, body text, title and so on
 * 
 * @author Gwindow
 */
public class BlogPost {
	/** The author. */
	private String author;
	
	/** The blog id. */
	private Number blogId;
	
	/** The blog time. */
	private String blogTime;
	
	/** The body text. */
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
	 * Get the id of the blog post.
	 * 
	 * @return the id
	 */
	public Number getBlogId() {
		return this.blogId;
	}

	/**
	 * Get the time at which the blog post was created.
	 * 
	 * @return the time
	 */
	public String getBlogTime() {
		return this.blogTime;
	}

	/**
	 * Get the body of the blog post.
	 * 
	 * @return the body
	 */
	public String getBody() {
		return this.body;
	}

	/**
	 * Get the id of the thread associated with this blog post.
	 * 
	 * @return the id
	 */
	public Number getThreadId() {
		return threadId;
	}

	/**
	 * Get the title of the blog post.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	@Override
	public String toString() {
		return "BlogPost [getAuthor=" + getAuthor() + ", getBlogId=" + getBlogId() + ", getBlogTime=" + getBlogTime()
				+ ", getBody=" + getBody() + ", getThreadId=" + getThreadId() + ", getTitle=" + getTitle() + "]";
	}
}
