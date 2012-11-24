package api.comments;

/**
 * The class Userinfo
 * Stores data about a comment poster's user information
 *
 * @author Gwindow
 */
public class Userinfo {
    /** The user id of the poster */
	private Number authorId;

    /** The user name of the poster */
	private String authorName;

    /** If the poster is an artist */
    private boolean artist;

    /** URL to the poster's avatar */
	private String avatar;

    /** TODO What is userTitle? */
    private String userTitle;

    /** If the poster is a donor */
	private boolean donor;

    /** If the poster's account is enabled */
	private boolean enabled;

    /** IF the poster has been warned */
    private boolean warned;

    /**
     * Get the poster's user id
     *
     * @return the poster's user id
     */
	public Number getAuthorId() {
		return this.authorId;
	}

    /**
     * Get the poster's user name
     *
     * @return the poster's user name
     */
	public String getAuthorName() {
		return this.authorName;
	}

    /**
     * Get the URL for the poster's avatar
     *
     * @return the avatar URL
     */
	public String getAvatar() {
		return this.avatar;
	}

    /**
     * Get the poster's user title
     *
     * @return the poster's user title
     */
    public String getUserTitle() {
        return this.userTitle;
    }

    /**
     * Check if the poster is an artist
     *
     * @return True if the poster is an artist
     */
    public boolean isArtist() {
        return this.artist;
    }

    /**
     * Check if the poster is a donor
     *
     * @return True if the poster is a donor
     */
	public boolean isDonor() {
		return this.donor;
	}

    /**
     * Check if the poster's account is enabled
     *
     * @return True if the poster's account is enabled
     */
	public boolean isEnabled() {
		return this.enabled;
	}

    /**
     * Check if the poster has received a warning
     *
     * @return True if the poster has received a warning
     */
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
