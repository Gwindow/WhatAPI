
package api.forum.thread;

/**
 * The Class Author.
 * 
 * @author Gwindow
 */
public class Author {
	
	/** The artist. */
	private boolean artist;
	
	/** The author id. */
	private Number authorId;
	
	/** The author name. */
	private String authorName;
	
	/** The avatar. */
	private String avatar;
	
	/** The donor. */
	private boolean donor;
	
	/** The enabled. */
	private boolean enabled;
	// TODO paranoi crashes for some reason
	// private List<String> paranoia;
	/** The user title. */
	private String userTitle;
	// TODO investigate warned in php
	/** The warned. */
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
	/* public List<String> getParanoia() { return paranoia; } */

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
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Author [isArtist=" + isArtist() + ", getAuthorId=" + getAuthorId() + ", getAuthorName=" + getAuthorName()
				+ ", getAvatar=" + getAvatar() + ", isDonor=" + isDonor() + ", isEnabled=" + isEnabled() + ", getParanoia="
				+ /* getParanoia() + */", getUserTitle=" + getUserTitle() + ", isWarned=" + isWarned() + "]";
	}
}
