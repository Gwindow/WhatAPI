package api.parser;

public class RssItem {
	private String title, description, link, id;
	private String directLink, date, creator;
	private String parent;

	public RssItem() {
	}

	public RssItem(String parent, String id, String title, String description, String link) {
		this.setParent(parent);
		this.id = id;
		this.title = title;
		this.description = description;
		this.link = link;
	}

	/**
	 * @return The title of the post.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return The description of the post.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return The link to the content.
	 */
	public String getLink() {
		return link;
	}

	/**
	 * This is null for news posts.
	 * 
	 * @return The link to directly download the torrent.
	 */
	public String getDirectLink() {
		return directLink;
	}

	/**
	 * @return Unique news post ID or torrent ID.
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return The date it the item was published to the RSS feed.
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @return The uploader if a torrent, "What.CD Staff" if a news post.
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	protected void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	protected void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param link
	 *            the link to set
	 */
	protected void setLink(String link) {
		this.link = link;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	protected void setId(String id) {
		this.id = id;
	}

	/**
	 * @param directLink
	 *            the directLink to set
	 */
	protected void setDirectLink(String directLink) {
		this.directLink = directLink;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	protected void setDate(String date) {
		this.date = date;
	}

	/**
	 * @param creator
	 *            the creator to set
	 */
	protected void setCreator(String creator) {
		this.creator = creator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RssItem [title=" + title + ", description=" + description + ", link=" + link + ", id=" + id + ", directLink="
				+ directLink + ", date=" + date + ", creator=" + creator + ", parent=" + parent + "]";
	}

	protected String getParent() {
		return parent;
	}

	protected void setParent(String parent) {
		this.parent = parent;
	}
}
