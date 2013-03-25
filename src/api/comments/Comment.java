package api.comments;

/**
 * The class Comment
 * Describes a single user's comment on a torrent
 *
 * @author Gwindow
 */
public class Comment {
    /** The time the comment was posted */
	private String addedTime;

    /**
     * The body of the comment with bulletin board symbols shown
     * such as [quote=blah]stuff[/quote]
     * instead of the html symbols that produce the formatting
     */
	private String bbBody;

    /** The comment body */
	private String body;

    /** The time the comment was edited */
	private String editedTime;

    /** The user id of the person who edited it */
	private Number editedUserId;

    /** The username of the person who edited it */
	private String editedUsername;

    /** The post id of the comment */
	private Number postId;

    /** The user info of the comment poster */
	private Userinfo userinfo;

    /**
     * Get the time the comment was added
     *
     * @return the time the comment was added
     */
	public String getAddedTime() {
		return this.addedTime;
	}

    /**
     * Get the bulletin board formatted body of the comment
     *
     * @return the bulletin board body
     */
	public String getBbBody() {
		return this.bbBody;
	}

    /**
     * Get the body of the comment
     *
     * @return the body of the comment
     */
	public String getBody() {
		return this.body;
	}

	/**
	 * Get the body text of the comment for use in a quote
	 * 
	 * @return the quoted body
	 */
	public String getQuotableBody() {
		return "[quote=" + userinfo.getAuthorName() + "]" + getBbBody() + "[/quote]";
	}

    /**
     * Get the time the comment was edited
     *
     * @return the edit time of the comment
     */
	public String getEditedTime() {
		return this.editedTime;
	}

    /**
     * Get the user id of the person who edited the comment
     *
     * @return user id of the comment editor
     */
	public Number getEditedUserId() {
		return this.editedUserId;
	}

    /**
     * Get the user name of the person who edited the comment
     *
     * @return the username of the comment editor
     */
	public String getEditedUsername() {
		return this.editedUsername;
	}

    /**
     * Get the post id of the comment
     *
     * @return the post id
     */
	public Number getPostId() {
		return this.postId;
	}

    /**
     * Get the user info of the commenter
     *
     * @return the commenter's user info
     */
	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	@Override
	public String toString() {
		return "Comment [getAddedTime()=" + getAddedTime() + ", getBbBody()=" + getBbBody() + ", getBody()=" + getBody()
				+ ", getEditedTime()=" + getEditedTime() + ", getEditedUserId()=" + getEditedUserId() + ", getEditedUsername()="
				+ getEditedUsername() + ", getPostId()=" + getPostId() + ", getUserinfo()=" + getUserinfo() + "]";
	}
}
