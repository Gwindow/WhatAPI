package api.requests;

/**
 * The Class Conductor.
 * Describes a Conductor
 * 
 * @author Gwindow
 */
public class Conductor {
	/** The conductor's artist id. */
	private Number id;
	
	/** The conductor's name */
	private String name;

	/**
	 * Get the conductor's artist id
	 * 
	 * @return the artist id
	 */
	public Number getId() {
		return id;
	}

	/**
	 * Get the conductor's name
	 * 
	 * @return the conductor's name
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Conductor [getId=" + getId() + ", getName=" + getName() + "]";
	}
}
