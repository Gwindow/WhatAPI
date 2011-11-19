package api.forum.thread;

import org.jsoup.Jsoup;

public class Posts {
	private String addedTime;
	private Author author;
	private String body;
	private String editedTime;
	private Number editedUserId;
	private String editedUsername;
	private Number postId;

	public String getAddedTime() {
		return this.addedTime;
	}

	public Author getAuthor() {
		return this.author;
	}

	public String getBody() {
		return this.body;
	}

	public String getEditedTime() {
		return this.editedTime;
	}

	public Number getEditedUserId() {
		return this.editedUserId;
	}

	public String getEditedUsername() {
		return this.editedUsername;
	}

	public Number getPostId() {
		return this.postId;
	}

	public String getQuotableBody() {
		return "[quote=" + author.getAuthorName() + "]" + Jsoup.parse(body).text() + "[/quote]";

	}

	@Override
	public String toString() {
		return "Posts [getAddedTime=" + getAddedTime() + ", getAuthor=" + getAuthor() + ", getBody=" + getBody()
				+ ", getEditedTime=" + getEditedTime() + ", getEditedUserId=" + getEditedUserId() + ", getEditedUsername="
				+ getEditedUsername() + ", getPostId=" + getPostId() + "]";
	}
}
