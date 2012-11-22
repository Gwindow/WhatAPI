
package api.announcements;

import java.util.List;

/**
 * The Class Response.
 * This is the actual information returned to us from
 * the API request.
 * Contains the lists of announcements and blog posts
 * 
 * @author Gwindow
 */
public class Response {
	/** The list of announcements. */
	private List<Announcement> announcements;
	
	/** The list of blog posts. */
	private List<BlogPost> blogPosts;

	/**
	 * Get the list of announcements.
	 * 
	 * @return the announcements list
	 */
	public List<Announcement> getAnnouncements() {
		return this.announcements;
	}

	/**
	 * Get the list of blog posts.
	 * 
	 * @return the blog posts list
	 */
	public List<BlogPost> getBlogPosts() {
		return this.blogPosts;
	}

	/**
	 * Get number of announcements.
	 * 
	 * @return the number of announcements
	 */
	public int getNumberOfAnnouncements() {
		return announcements.size();
	}

	/**
	 * Get number of blog posts.
	 * 
	 * @return the number of blog posts
	 */
	public int getNumberOfBlogPosts() {
		return blogPosts.size();
	}

	@Override
	public String toString() {
		return "Response [getAnnouncements=" + getAnnouncements() + ", getBlogPosts=" + getBlogPosts() + "]";
	}
}
