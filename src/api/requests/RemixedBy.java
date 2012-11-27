package api.requests;

/**
 * The Class RemixedBy.
 * Stores information about an artist who remixed some media
 * 
 * @author Gwindow
 */
public class RemixedBy {
	/** The artist id. */
	private Number id;
	
	/** The artist name. */
	private String name;

	/**
	 * Get the artist id
	 * 
	 * @return the id
	 */
	public Number getId() {
		return id;
	}

	/**
	 * Get the artist name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "RemixedBy [getId=" + getId() + ", getName=" + getName() + "]";
	}
}