
package api.requests;

/**
 * The Class DJ.
 * Store information about an artist who was a DJ on some media
 * 
 * @author Gwindow
 */
public class DJ {
	/** The artist id. */
	private Number id;
	
	/** The artist name. */
	private String name;

	/**
	 * Get the artist id.
	 * 
	 * @return the id
	 */
	public Number getId() {
		return id;
	}

	/**
	 * Get the artist name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "DJ [getId=" + getId() + ", getName=" + getName() + "]";
	}
}