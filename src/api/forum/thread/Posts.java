package api.forum.thread;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

/**
 * The Class Posts.
 * 
 * @author Gwindow
 */
public class Posts {

	/** The added time. */
	private String addedTime;

	/** The author. */
	private Author author;

	/** The body. */
	private String body;

	/** The edited time. */
	private String editedTime;

	/** The edited user id. */
	private Number editedUserId;

	/** The edited username. */
	private String editedUsername;

	/** The post id. */
	private Number postId;

	private String bbBody;

	/**
	 * @return the bbBody
	 */
	public String getBBBody() {
		return bbBody;
	}

	/**
	 * Gets the added time.
	 * 
	 * @return the added time
	 */
	public String getAddedTime() {
		return this.addedTime;
	}

	/**
	 * Gets the author.
	 * 
	 * @return the author
	 */
	public Author getAuthor() {
		return this.author;
	}

	/**
	 * Gets the body.
	 * 
	 * @return the body
	 */
	public String getBody() {
		return this.body;
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
	 * Gets the post id.
	 * 
	 * @return the post id
	 */
	public Number getPostId() {
		return this.postId;
	}

	/**
	 * Gets the quotable body.
	 * 
	 * @return the quotable body
	 */
	public String getQuotableBody() {
		return "[quote=" + author.getAuthorName() + "]" + Jsoup.clean(getBBBody(), Whitelist.basic()) + "[/quote]";

	}

	@Override
	public String toString() {
		return "Posts [getBBBody()=" + getBBBody() + ", getAddedTime()=" + getAddedTime() + ", getAuthor()=" + getAuthor()
				+ ", getBody()=" + getBody() + ", getEditedTime()=" + getEditedTime() + ", getEditedUserId()="
				+ getEditedUserId() + ", getEditedUsername()=" + getEditedUsername() + ", getPostId()=" + getPostId()
				+ ", getQuotableBody()=" + getQuotableBody() + "]";
	}
}
