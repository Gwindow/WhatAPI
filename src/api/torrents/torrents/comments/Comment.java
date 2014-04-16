package api.torrents.torrents.comments;

import api.comments.SimpleComment;
import api.soup.MySoup;

import java.util.Date;

/**
 * The class SimpleComment
 * Describes a single user's comment on a torrent
 *
 * @author Gwindow
 */
public class Comment implements SimpleComment {
	/**
	 * The time the comment was posted
	 */
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
	 * Get the user info of the commenter
	 *
	 * @return the commenter's user info
	 */
	public Userinfo getUserinfo(){
		return this.userinfo;
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
	public String getAuthor(){
		return userinfo.getAuthorName();
	}

	@Override
	public int getAuthorId(){
		return userinfo.getAuthorId().intValue();
	}

	@Override
	public String getAvatar(){
		return userinfo.getAvatar();
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
	public boolean isDonor(){
		return userinfo.isDonor();
	}

	@Override
	public boolean isWarned(){
		return userinfo.isWarned();
	}

	@Override
	public boolean isBanned(){
		return !userinfo.isEnabled();
	}

	@Override
	public String toString(){
		return "Comment [getAddedTime()=" + addedTime + ", getBbBody()=" + getBBbody() + ", getBody()=" + getBody()
			+ ", getEditedTime()=" + editedTime + ", getEditedUserId()=" + getEditorId() + ", getEditedUsername()="
			+ getEditor() + ", getPostId()=" + getPostId() + ", getUserinfo()=" + getUserinfo() + "]";
	}
}
