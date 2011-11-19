/**
 * @author Gwindow
 */
package api.announcements;

/**
 * Contains the lists of announcements and blog posts
 */
import java.util.List;

/**
 * The Class Response.
 */
public class Response {
	private List<AnnouncementsList> announcements;
	private List<BlogPosts> blogPosts;

	/**
	 * Get the list of announcements.
	 * 
	 * @return the announcements list
	 */
	public List<AnnouncementsList> getAnnouncements() {
		return this.announcements;
	}

	/**
	 * Get the list of blog posts.
	 * 
	 * @return the blog posts list
	 */
	public List<BlogPosts> getBlogPosts() {
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Response [getAnnouncements=" + getAnnouncements() + ", getBlogPosts=" + getBlogPosts() + "]";
	}
}
