package api.announcements;

import java.util.List;

public class Response {
	private List<AnnouncementsList> announcements;
	private List<BlogPosts> blogPosts;

	public List<AnnouncementsList> getAnnouncements() {
		return this.announcements;
	}

	public List<BlogPosts> getBlogPosts() {
		return this.blogPosts;
	}

	public int getNumberOfAnnouncements() {
		return announcements.size();
	}

	public int getNumberOfBlogPosts() {
		return blogPosts.size();
	}

	@Override
	public String toString() {
		return "Response [getAnnouncements=" + getAnnouncements() + ", getBlogPosts=" + getBlogPosts() + "]";
	}
}
