/*
 * 
 */
package api.torrents.torrents;

/**
 * The Class Artists.
 * 
 * @author Gwindow
 * @since Jun 2, 2012 12:17:18 AM
 */
public class Artists {
	
	/** The id. */
	private Number id;
	
	/** The name. */
	private String name;

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Number getId() {
		return this.id;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Artists [getId()=" + getId() + ", getName()=" + getName() + "]";
	}
}
