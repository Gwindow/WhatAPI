package api.requests;

import api.comments.SimpleComment;
import api.soup.MySoup;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * The Class SimpleComment.
 * Stores information about a user's comment on a Request
 *
 * @author Gwindow
 */
public class Comment implements SimpleComment {
	/**
	 * The time the comment was made
	 */
	private String addedTime;

	/**
	 * The author's user id
	 */
	private Number authorId;

	/**
	 * The author's avatar url.
	 */
	private String avatar;

	/**
	 * The author's user class.
	 */
	@SerializedName("class")
	private String userClass;

	/**
	 * The comment text
	 */
	private String comment;

	/**
	 * If the user is a donor.
	 */
	private boolean donor;

	/**
	 * The time the comment was edited.
	 */
	private String editedTime;

	/**
	 * The editor's user id
	 */
	private Number editedUserId;

	/**
	 * The editor's user name
	 */
	private String editedUsername;

	/**
	 * If the author's account is enabled
	 */
	private boolean enabled;

	/**
	 * The author's user name
	 */
	private String name;

	/**
	 * The comment post id
	 */
	private Number postId;

	/**
	 * If the author is warned
	 */
	private boolean warned;

	public String getUserClass(){
		return userClass;
	}

	@Override
	public String getAuthor(){
		return name;
	}

	@Override
	public int getAuthorId(){
		return authorId.intValue();
	}

	@Override
	public String getAvatar(){
		return avatar;
	}

	@Override
	public Date getTimePosted(){
		return MySoup.parseDate(addedTime);
	}

	@Override
	public String getEditor(){
		return editedUsername;
	}

	@Override
	public int getEditorId(){
		return editedUserId.intValue();
	}

	@Override
	public Date getTimeEdited(){
		return MySoup.parseDate(editedTime);
	}

	@Override
	public String getBBbody(){
		//We don't get this field from the api for request comments
		return null;
	}

	@Override
	public String getBody(){
		return comment;
	}

	@Override
	public String getQuote(){
		return "[quote=" + name + "]" + comment + "[/quote]";
	}

	@Override
	public int getPostId(){
		return postId.intValue();
	}

	public boolean isDonor(){
		return donor;
	}

	public boolean isWarned(){
		return warned;
	}

	public boolean isBanned(){
		return !enabled;
	}

	public void setBody(String body){
		comment = body;
	}

	@Override
	public String toString(){
		return "Comment [getAddedTime=" + addedTime + ", getAuthorId=" + getAuthorId() + ", getAvatar=" + getAvatar()
			+ ", getUserClass=" + userClass + ", getComment=" + comment + ", isDonor=" + isDonor()
			+ ", getEditedTime=" + editedTime + ", getEditedUserId=" + editedUserId + ", getEditedUsername="
			+ editedUsername + ", isEnabled=" + enabled + ", getName=" + name + ", getPostId=" + getPostId()
			+ ", isWarned=" + isWarned() + "]";
	}
}
