
package api.requests;

import com.google.gson.annotations.SerializedName;

/**
 * The Class Comments.
 * 
 * //TODO description
 * 
 * @author Gwindow
 */
public class Comments {
	
	/** The added time. */
	private String addedTime;
	
	/** The author id. */
	private Number authorId;
	
	/** The avatar. */
	private String avatar;
	
	/** The user class. */
	@SerializedName("class")
	private String userClass;
	
	/** The comment. */
	private String comment;
	
	/** The donor. */
	private boolean donor;
	
	/** The edited time. */
	private String editedTime;
	
	/** The edited user id. */
	private Number editedUserId;
	
	/** The edited username. */
	private String editedUsername;
	
	/** The enabled. */
	private boolean enabled;
	
	/** The name. */
	private String name;
	
	/** The post id. */
	private Number postId;
	
	/** The warned. */
	private boolean warned;

	/**
	 * Gets the added time.
	 * 
	 * @return the added time
	 */
	public String getAddedTime() {
		return this.addedTime;
	}

	/**
	 * Gets the author id.
	 * 
	 * @return the author id
	 */
	public Number getAuthorId() {
		return this.authorId;
	}

	/**
	 * Gets the avatar.
	 * 
	 * @return the avatar
	 */
	public String getAvatar() {
		return this.avatar;
	}

	/**
	 * Gets the user class.
	 * 
	 * @return the user class
	 */
	public String getUserClass() {
		return this.userClass;
	}

	/**
	 * Gets the comment.
	 * 
	 * @return the comment
	 */
	public String getComment() {
		return this.comment;
	}

	/**
	 * Gets the donor.
	 * 
	 * @return the donor
	 */
	public boolean getDonor() {
		return this.donor;
	}

	/**
	 * Gets the edited time.
	 * 
	 * @return the edited time
	 */
	public String getEditedTime() {
		return this.editedTime;
	}

	/**
	 * Gets the edited user id.
	 * 
	 * @return the edited user id
	 */
	public Number getEditedUserId() {
		return this.editedUserId;
	}

	/**
	 * Gets the edited username.
	 * 
	 * @return the edited username
	 */
	public String getEditedUsername() {
		return this.editedUsername;
	}

	/**
	 * Gets the enabled.
	 * 
	 * @return the enabled
	 */
	public boolean getEnabled() {
		return this.enabled;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the post id.
	 * 
	 * @return the post id
	 */
	public Number getPostId() {
		return this.postId;
	}

	/**
	 * Gets the warned.
	 * 
	 * @return the warned
	 */
	public boolean getWarned() {
		return this.warned;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Comments [getAddedTime=" + getAddedTime() + ", getAuthorId=" + getAuthorId() + ", getAvatar=" + getAvatar()
				+ ", getUserClass=" + getUserClass() + ", getComment=" + getComment() + ", getDonor=" + getDonor()
				+ ", getEditedTime=" + getEditedTime() + ", getEditedUserId=" + getEditedUserId() + ", getEditedUsername="
				+ getEditedUsername() + ", getEnabled=" + getEnabled() + ", getName=" + getName() + ", getPostId=" + getPostId()
				+ ", getWarned=" + getWarned() + "]";
	}
}
