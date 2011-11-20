


package api.torrents.torrents;

import java.util.List;

/**
 * The Class Response.
 * 
 * @author Gwindow
 */
public class Response {
	private Group group;
	private List<Torrent> torrents;

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
	public List<Torrent> getTorrents() {
		return this.torrents;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Response [getGroup=" + getGroup() + ", getTorrents=" + getTorrents() + "]";
	}

}
