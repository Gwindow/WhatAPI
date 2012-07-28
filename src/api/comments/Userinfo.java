package api.comments;

public class Userinfo {
	private boolean artist;
	private Number authorId;
	private String authorName;
	private String avatar;
	private boolean donor;
	private boolean enabled;
	private String userTitle;
	private boolean warned;

	public boolean isArtist() {
		return this.artist;
	}

	public Number getAuthorId() {
		return this.authorId;
	}

	public String getAuthorName() {
		return this.authorName;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public boolean isDonor() {
		return this.donor;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public String getUserTitle() {
		return this.userTitle;
	}

	public boolean isWarned() {
		return this.warned;
	}

	@Override
	public String toString() {
		return "Userinfo [isArtist()=" + isArtist() + ", getAuthorId()=" + getAuthorId() + ", getAuthorName()=" + getAuthorName()
				+ ", getAvatar()=" + getAvatar() + ", isDonor()=" + isDonor() + ", isEnabled()=" + isEnabled()
				+ ", getUserTitle()=" + getUserTitle() + ", isWarned()=" + isWarned() + "]";
	}
}
