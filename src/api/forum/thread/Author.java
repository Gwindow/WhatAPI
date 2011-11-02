package api.forum.thread;

import java.util.List;

public class Author {
	private String artist;
	private String authorId;
	private String authorName;
	private String avatar;
	private String donor;
	private boolean enabled;
	private List<String> paranoia;
	private String userTitle;
	private String warned;

	public boolean isArtist() {
		if (artist.equalsIgnoreCase("0"))
			return false;
		else
			return true;
	}

	public String getAuthorId() {
		return this.authorId;
	}

	public String getAuthorName() {
		return this.authorName;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public boolean isDonor() {
		if (donor.equalsIgnoreCase("0"))
			return false;
		else
			return true;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public List<String> getParanoia() {
		return this.paranoia;
	}

	public String getUserTitle() {
		return this.userTitle;
	}

	public boolean isWarned() {
		if (warned.equalsIgnoreCase("0000-00-00 00:00:00"))
			return false;
		else
			return true;
	}

	@Override
	public String toString() {
		return "Author [isArtist=" + isArtist() + ", getAuthorId=" + getAuthorId() + ", getAuthorName=" + getAuthorName()
				+ ", getAvatar=" + getAvatar() + ", isDonor=" + isDonor() + ", isEnabled=" + isEnabled() + ", getParanoia="
				+ getParanoia() + ", getUserTitle=" + getUserTitle() + ", isWarned=" + isWarned() + "]";
	}
}
