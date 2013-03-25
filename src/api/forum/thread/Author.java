package api.forum.thread;

/**
 * The Class Author.
 * Stores information about a forum post author
 * 
 * @author Gwindow
 */
public class Author {
	/** The author's user id. */
	private Number authorId;

	/** The author user name. */
	private String authorName;

	/** The URL for the author's avatar. */
	private String avatar;

    /**
     * A list of the various fields that are restricted on the
     * user's profile based on their Paranoia settings. A + at the end
     * of an entry denotes very restricted.
     */
    // private List<String> paranoia;
    /** The extra text some users get as additional user title */
    private String userTitle;

    /** If the author is an artist */
    private boolean artist;

	/** If the author is a donor */
	private boolean donor;

	/** If the author's account is enabled */
	private boolean enabled;

    /** If the user has received a warning */
    private boolean warned;

	/**
	 * Get the author's user id
	 * 
	 * @return the author's user id
	 */
	public Number getAuthorId() {
		return this.authorId;
	}

	/**
	 * Get the author's user name
	 * 
	 * @return the authorName
	 */
	public String getAuthorName() {
		return this.authorName;
	}

	/**
	 * Get the URL for the author's avatar
	 * 
	 * @return the avatar URL
	 */
	public String getAvatar() {
		return this.avatar;
	}

	/**
	 * Get the list of restricted profile fields resulting from
     * the user's paranoia setting
	 * 
	 * @return the list of restricted fields
	 */
	/* public List<String> getParanoia() { return paranoia; } */

	/**
	 * Get the user title
	 * 
	 * @return the user title
	 */
	public String getUserTitle() {
		return this.userTitle;
	}

    /**
     * Check if the author is an artist
     *
     * @return True if the author is an artist
     */
    public boolean isArtist() {
        return this.artist;
    }

    /**
     * Check if the author is a donor
     *
     * @return True if the author is a donor
     */
    public boolean isDonor() {
        return this.donor;
    }

    /**
     * Check if the author's account is enabled
     *
     * @return True if the author's account is enabled
     */
    public boolean isEnabled() {
        return this.enabled;
    }

	/**
	 * Check if the author has received a warning
	 * 
	 * @return True if the author has been warned
	 */
	public boolean isWarned() {
		return this.warned;
	}

	@Override
	public String toString() {
		return "Author [isArtist=" + isArtist() + ", getAuthorId=" + getAuthorId() + ", getAuthorName=" + getAuthorName()
				+ ", getAvatar=" + getAvatar() + ", isDonor=" + isDonor() + ", isEnabled=" + isEnabled() + ", getParanoia="
				+ /* getParanoia() + */", getUserTitle=" + getUserTitle() + ", isWarned=" + isWarned() + "]";
	}
}
