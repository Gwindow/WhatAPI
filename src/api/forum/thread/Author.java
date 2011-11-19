/**
 * @author Gwindow
 */
package api.forum.thread;

import java.util.List;

/**
 * The Class Author.
 */
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
	 * Checks if is artist.
	 * 
	 * @return the artist
	 */
	public boolean isArtist() {
		return artist;
	}

	/**
	 * Gets the author id.
	 * 
	 * @return the authorId
	 */
	public Number getAuthorId() {
		return authorId;
	}

	/**
	 * Gets the author name.
	 * 
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * Gets the avatar.
	 * 
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * Checks if is donor.
	 * 
	 * @return the donor
	 */
	public boolean isDonor() {
		return donor;
	}

	/**
	 * Checks if is enabled.
	 * 
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Gets the paranoia.
	 * 
	 * @return the paranoia
	 */
	public List<String> getParanoia() {
		return paranoia;
	}

	/**
	 * Gets the user title.
	 * 
	 * @return the userTitle
	 */
	public String getUserTitle() {
		return userTitle;
	}

	/**
	 * Checks if is warned.
	 * 
	 * @return the warned
	 */
	public boolean isWarned() {
		return warned;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Author [isArtist=" + isArtist() + ", getAuthorId=" + getAuthorId() + ", getAuthorName=" + getAuthorName()
				+ ", getAvatar=" + getAvatar() + ", isDonor=" + isDonor() + ", isEnabled=" + isEnabled() + ", getParanoia="
				+ getParanoia() + ", getUserTitle=" + getUserTitle() + ", isWarned=" + isWarned() + "]";
	}
}
