package api.torrents.torrents;

/**
 * The Class Composers.
 * 
 * //TODO description
 * 
 * @author Gwindow
 */
public class Composers {
	
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
		return "Composers [getId=" + getId() + ", getName=" + getName() + "]";
	}
}
