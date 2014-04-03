package api.comments;

import java.util.Date;

/**
 * A cleaner interface for interacting with user comments from the API
 * each comment has the same minimal amount of information the app wants
 * but all structured differently, this cleans it up
 */
public interface SimpleComment {
	/**
	 * Get the author of the post
	 */
	public String getAuthor();

	/**
	 * Get the author's id
	 */
	public int getAuthorId();

	/**
	 * Get the author's avatar url
	 */
	public String getAvatar();

	/**
	 * Get the time the comment was posted
	 */
	public Date getTimePosted();

	/**
	 * Get the editor's name if the post was edited
	 */
	public String getEditor();

	/**
	 * Get the id of the editor if the post was edited
	 */
	public int getEditorId();

	/**
	 * Get the time the post was edited, if it was
	 */
	public Date getTimeEdited();

	/**
	 * Get the body html text of the post
	 */
	public String getBody();

	/**
	 * Get the post body as a quote
	 */
	public String getQuote();

	/**
	 * Get the post id
	 */
	public int getPostId();

	/**
	 * True if the author is a donor
	 */
	public boolean isDonor();

	/**
	 * True if the author is warned
	 */
	public boolean isWarned();

	/**
	 * True if the author is banned
	 */
	public boolean isBanned();
}
