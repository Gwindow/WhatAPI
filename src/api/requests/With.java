
package api.requests;

/**
 * The Class With.
 * An artist who was performed with on some media recording
 * 
 * @author Gwindow
 */
public class With {
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
		return "With [getId=" + getId() + ", getName=" + getName() + "]";
	}
}
