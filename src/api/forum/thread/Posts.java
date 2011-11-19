/**
 * @author Gwindow
 */
package api.forum.thread;

import org.jsoup.Jsoup;

/**
 * The Class Posts.
 */
public class Posts {
	private String addedTime;
	private Author author;
	private String body;
	private String editedTime;
	private Number editedUserId;
	private String editedUsername;
	private Number postId;

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
		return "[quote=" + author.getAuthorName() + "]" + Jsoup.parse(body).text() + "[/quote]";

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Posts [getAddedTime=" + getAddedTime() + ", getAuthor=" + getAuthor() + ", getBody=" + getBody()
				+ ", getEditedTime=" + getEditedTime() + ", getEditedUserId=" + getEditedUserId() + ", getEditedUsername="
				+ getEditedUsername() + ", getPostId=" + getPostId() + "]";
	}
}
