package api.search.torrents;

/**
 * The class Artist
 * Stores data about an artist as returned to us
 * in a TorrentSearch
 *
 * @author Gwindow
 */
public class Artist {
    /** The artist id */
	private Number id;

    /** The artist name */
	private String name;

    /** The artist alias id TODO: What is this? */
	private Number aliasid;

	/**
     * Get the artist id
     *
	 * @return the artist id
	 */
	public Number getId() {
		return id;
	}

	/**
     * Get the artist name
     *
	 * @return the artist name
	 */
	public String getName() {
		return name;
	}

	/**
     * Get the artist alias id
     *
	 * @return the artist alias id
	 */
	public Number getAliasid() {
		return aliasid;
	}

	@Override
	public String toString() {
		return "Artist [getId()=" + getId() + ", getName()=" + getName() + ", getAliasid()=" + getAliasid() + "]";
	}
}
