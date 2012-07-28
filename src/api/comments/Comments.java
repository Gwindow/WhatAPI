package api.comments;


public class Comments {
	private String addedTime;
	private String bbBody;
	private String body;
	private String editedTime;
	private Number editedUserId;
	private String editedUsername;
	private Number postId;
	private Userinfo userinfo;

	public String getAddedTime() {
		return this.addedTime;
	}

	public String getBbBody() {
		return this.bbBody;
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

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	@Override
	public String toString() {
		return "Comments [getAddedTime()=" + getAddedTime() + ", getBbBody()=" + getBbBody() + ", getBody()=" + getBody()
				+ ", getEditedTime()=" + getEditedTime() + ", getEditedUserId()=" + getEditedUserId() + ", getEditedUsername()="
				+ getEditedUsername() + ", getPostId()=" + getPostId() + ", getUserinfo()=" + getUserinfo() + "]";
	}
}
