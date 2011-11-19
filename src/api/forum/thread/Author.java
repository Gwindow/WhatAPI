package api.forum.thread;

import java.util.List;

public class Author {
	private boolean artist;
	private Number authorId;
	private String authorName;
	private String avatar;
	private boolean donor;
	private boolean enabled;
	private List<String> paranoia;
	private String userTitle;
	// TODO investigate warned in php
	private boolean warned;

	/**
	 * @return the artist
	 */
	public boolean isArtist() {
		return artist;
	}

	/**
	 * @return the authorId
	 */
	public Number getAuthorId() {
		return authorId;
	}

	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * @return the donor
	 */
	public boolean isDonor() {
		return donor;
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @return the paranoia
	 */
	public List<String> getParanoia() {
		return paranoia;
	}

	/**
	 * @return the userTitle
	 */
	public String getUserTitle() {
		return userTitle;
	}

	/**
	 * @return the warned
	 */
	public boolean isWarned() {
		return warned;
	}

	@Override
	public String toString() {
		return "Author [isArtist=" + isArtist() + ", getAuthorId=" + getAuthorId() + ", getAuthorName=" + getAuthorName()
				+ ", getAvatar=" + getAvatar() + ", isDonor=" + isDonor() + ", isEnabled=" + isEnabled() + ", getParanoia="
				+ getParanoia() + ", getUserTitle=" + getUserTitle() + ", isWarned=" + isWarned() + "]";
	}
}
