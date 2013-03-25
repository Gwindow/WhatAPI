package api.torrents.torrents;

/**
 * The Class With.
 * 
 * //TODO description
 * 
 * @author Gwindow
 */
public class With {
	
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

	@Override
	public String toString() {
		return "With [getId=" + getId() + ", getName=" + getName() + "]";
	}
}
