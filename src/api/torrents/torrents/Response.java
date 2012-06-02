/*
 * 
 */
package api.torrents.torrents;

import java.util.List;

/**
 * The Class Response.
 * 
 * @author Gwindow
 * @since Jun 2, 2012 12:17:18 AM
 */
public class Response {

	/** The group. */
	private Group group;

	/** The torrents. */
	private List<Torrents> torrents;

	/**
	 * Gets the group.
	 * 
	 * @return the group
	 */
	public Group getGroup() {
		return this.group;
	}

	/**
	 * Gets the torrents.
	 * 
	 * @return the torrents
	 */
	public List<Torrents> getTorrents() {
		return this.torrents;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Response [getGroup()=" + getGroup() + ", getTorrents()=" + getTorrents() + "]";
	}
}
