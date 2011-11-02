package api.forum.thread;

public class Posts {
	private String addedTime;
	private Author author;
	private String body;
	private String editedTime;
	private String editedUserId;
	private String editedUsername;
	private String postId;

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

	public String getEditedUserId() {
		return this.editedUserId;
	}

	public String getEditedUsername() {
		return this.editedUsername;
	}

	public String getPostId() {
		return this.postId;
	}

	@Override
	public String toString() {
		return "Posts [getAddedTime=" + getAddedTime() + ", getAuthor=" + getAuthor() + ", getBody=" + getBody()
				+ ", getEditedTime=" + getEditedTime() + ", getEditedUserId=" + getEditedUserId() + ", getEditedUsername="
				+ getEditedUsername() + ", getPostId=" + getPostId() + "]";
	}
}
