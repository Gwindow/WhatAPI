package api.search.torrents;

/**
 * @author Gwindow
 * @since Jun 10, 2012 1:39:28 PM
 */
public class Artists {
	private Number id;
	private String name;
	private Number aliasid;

	/**
	 * @return the id
	 */
	public Number getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the aliasid
	 */
	public Number getAliasid() {
		return aliasid;
	}

	@Override
	public String toString() {
		return "Artists [getId()=" + getId() + ", getName()=" + getName() + ", getAliasid()=" + getAliasid() + "]";
	}
}
