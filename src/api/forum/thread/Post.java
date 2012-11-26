package api.forum.thread;

/**
 * The Class Post.
 * Stores information about a forum post
 *
 * @author Gwindow
 */
public class Post {
	/** The time the post was made */
	private String addedTime;

	/** The post author */
	private Author author;

	/** The body of the post */
	private String body;

    /** The bulletin board formatted body of the post, for quoting */
    private String bbBody;

	/** The time the post was edited */
	private String editedTime;

	/** The user id of the post editor */
	private Number editedUserId;

	/** The user name of the post editor */
	private String editedUsername;

	/** The post id. */
	private Number postId;

	/**
	 * Get the time the post was made
	 * 
	 * @return the time the post was made
	 */
	public String getAddedTime() {
		return this.addedTime;
	}

	/**
	 * Get the post author
	 * 
	 * @return the post author
	 */
	public Author getAuthor() {
		return this.author;
	}

	/**
	 * Get the post body
	 * 
	 * @return the body
	 */
	public String getBody() {
		return this.body;
	}

    /**
     * Get the bulletin board formatted body of the post, for quoting
     *
     * @return the bulletin board formatted body
     */
    public String getBBBody() {
        return this.bbBody.replace("\r", "");
    }

	/**
	 * Get the time the post was edited
	 * 
	 * @return the time the post was edited
	 */
	public String getEditedTime() {
		return this.editedTime;
	}

	/**
	 * Get the user id of the editor
	 * 
	 * @return the editor's user id
	 */
	public Number getEditedUserId() {
		return this.editedUserId;
	}

	/**
	 * Get the user name of the editor
	 * 
	 * @return the editor's username
	 */
	public String getEditedUsername() {
		return this.editedUsername;
	}

	/**
	 * Get the post id.
	 * 
	 * @return the post id
	 */
	public Number getPostId() {
		return this.postId;
	}

	/**
	 * Get the post body as a bulletin board quote,
     * ie. [quote=author name]bbBody[/quote]
	 * 
	 * @return the quoted post
	 */
	public String getQuotableBody() {
		return "[quote=" + author.getAuthorName() + "]" + getBBBody() + "[/quote]";
	}

	@Override
	public String toString() {
		return "Post [getBBBody()=" + getBBBody() + ", getAddedTime()=" + getAddedTime() + ", getAuthor()=" + getAuthor()
				+ ", getBody()=" + getBody() + ", getEditedTime()=" + getEditedTime() + ", getEditedUserId()="
				+ getEditedUserId() + ", getEditedUsername()=" + getEditedUsername() + ", getPostId()=" + getPostId()
				+ ", getQuotableBody()=" + getQuotableBody() + "]";
	}
}
