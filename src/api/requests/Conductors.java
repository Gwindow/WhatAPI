
package api.requests;

/**
 * The Class Conductors.
 * 
 * //TODO description
 * 
 * @author Gwindow
 */
public class Conductors {
	
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

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Conductors [getId=" + getId() + ", getName=" + getName() + "]";
	}
}
