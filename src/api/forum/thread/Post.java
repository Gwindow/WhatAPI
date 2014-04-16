package api.forum.thread;

import api.comments.SimpleComment;
import api.soup.MySoup;

import java.util.Date;

/**
 * The Class Post.
 * Stores information about a forum post
 *
 * @author Gwindow
 */
public class Post implements SimpleComment {
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

	public String getBbBody(){
		return bbBody;
	}

	@Override
	public String getAuthor(){
		return author.getAuthorName();
	}

	@Override
	public int getAuthorId(){
		return author.getAuthorId().intValue();
	}

	@Override
	public String getAvatar(){
		return author.getAvatar();
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
	public String getBody(){
		return body;
	}

	@Override
	public void setBody(String s){
		body = s;
	}

	@Override
	public String getBBbody(){
		return bbBody;
	}

	@Override
	public String getQuote(){
		return "[quote=" + getAuthor() + "]" + bbBody + "[/quote]";
	}

	@Override
	public int getPostId(){
		return postId.intValue();
	}

	@Override
	public boolean isDonor(){
		return author.isDonor();
	}

	@Override
	public boolean isWarned(){
		return author.isWarned();
	}

	@Override
	public boolean isBanned(){
		return !author.isEnabled();
	}

	@Override
	public String toString() {
		return "Post [getBBBody()=" + bbBody + ", getAddedTime()=" + addedTime + ", getAuthor()=" + getAuthor()
			+ ", getBody()=" + getBody() + ", getEditedTime()=" + editedTime + ", getEditedUserId()="
			+ editedUserId + ", getEditedUsername()=" + editedUsername + ", getPostId()=" + getPostId()
			+ ", getQuotableBody()=" + getQuote() + "]";
	}
}
