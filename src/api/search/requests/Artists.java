
package api.search.requests;

/**
 * The Class Artists.
 * 
 * //TODO description
 * 
 * @author Gwindow
 */
public class Artists {

	/** The id. */
	private String id;

	/** The name. */
	private String name;

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public String getId() {
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
		return "Artists [getId=" + getId() + ", getName=" + getName() + "]";
	}
}
