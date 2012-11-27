package api.requests;

import com.google.gson.annotations.SerializedName;

/**
 * The Class Comment.
 * Stores information about a user's comment on a Request
 * 
 * @author Gwindow
 */
public class Comment {
	/** The time the comment was made */
	private String addedTime;
	
	/** The author's user id */
	private Number authorId;
	
	/** The author's avatar url. */
	private String avatar;
	
	/** The author's user class. */
	@SerializedName("class")
	private String userClass;
	
	/** The comment text */
	private String comment;
	
	/** If the user is a donor. */
	private boolean donor;
	
	/** The time the comment was edited. */
	private String editedTime;
	
	/** The editor's user id */
	private Number editedUserId;
	
	/** The editor's user name */
	private String editedUsername;
	
	/** If the author's account is enabled */
	private boolean enabled;
	
	/** The author's user name */
	private String name;
	
	/** The comment post id */
	private Number postId;
	
	/** If the author is warned */
	private boolean warned;

	/**
	 * Get the time the comment was added
	 * 
	 * @return the time the comment was added
	 */
	public String getAddedTime() {
		return addedTime;
	}

	/**
	 * Get the author's user id
	 * 
	 * @return the author's user id
	 */
	public Number getAuthorId() {
		return authorId;
	}

	/**
	 * Get the author's avatar URL
	 * 
	 * @return the avatar url
	 */
	public String getAvatar() {
		return avatar;
	}

	/**
	 * Get the author's user class
	 * 
	 * @return the user class
	 */
	public String getUserClass() {
		return userClass;
	}

	/**
	 * Get the comment text
	 * 
	 * @return the comment text
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Check if the author is a donor
	 * 
	 * @return True if the author is a donor
	 */
	public boolean isDonor() {
		return donor;
	}

	/**
	 * Get the time the comment was edited
	 * 
	 * @return the time the comment was edited
	 */
	public String getEditedTime() {
		return editedTime;
	}

	/**
	 * Get the editor's user id.
	 * 
	 * @return the editor's user id
	 */
	public Number getEditedUserId() {
		return editedUserId;
	}

	/**
	 * Get the editor's user name
	 * 
	 * @return the editor's user name
	 */
	public String getEditedUsername() {
		return editedUsername;
	}

	/**
	 * Check if the author's account is enabled
	 * 
	 * @return True if the account is enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Get the author's user name
	 * 
	 * @return the author's user name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the comment post id
	 * 
	 * @return the post id
	 */
	public Number getPostId() {
		return postId;
	}

	/**
	 * Check if the author has been warned
	 * 
	 * @return True if they've been warned
	 */
	public boolean isWarned() {
		return warned;
	}

	@Override
	public String toString() {
		return "Comment [getAddedTime=" + getAddedTime() + ", getAuthorId=" + getAuthorId() + ", getAvatar=" + getAvatar()
				+ ", getUserClass=" + getUserClass() + ", getComment=" + getComment() + ", isDonor=" + isDonor()
				+ ", getEditedTime=" + getEditedTime() + ", getEditedUserId=" + getEditedUserId() + ", getEditedUsername="
				+ getEditedUsername() + ", isEnabled=" + isEnabled() + ", getName=" + getName() + ", getPostId=" + getPostId()
				+ ", isWarned=" + isWarned() + "]";
	}
}
