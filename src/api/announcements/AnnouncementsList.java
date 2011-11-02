package api.announcements;

public class AnnouncementsList {
	private String body;
	private String newsId;
	private String newsTime;
	private String title;

	public String getBody() {
		return this.body;
	}

	public String getNewsId() {
		return this.newsId;
	}

	public String getNewsTime() {
		return this.newsTime;
	}

	public String getTitle() {
		return this.title;
	}

	@Override
	public String toString() {
		return "AnnouncementsList [getBody=" + getBody() + ", getNewsId=" + getNewsId() + ", getNewsTime=" + getNewsTime()
				+ ", getTitle=" + getTitle() + "]";
	}
}
