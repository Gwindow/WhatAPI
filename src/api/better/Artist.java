
package api.better;

/**
 * The Class Artist.
 * 
 * //TODO description
 * 
 * @author Gwindow
 */
public class Artist {

	/** The alias id. */
	private Number aliasId;

	/** The id. */
	private Number id;

	/** The name. */
	private String name;

	/**
	 * Gets the alias id.
	 * 
	 * @return the alias id
	 */
	public Number getAliasId() {
		return this.aliasId;
	}

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
		return "Artist [getAliasId=" + getAliasId() + ", getId=" + getId() + ", getName=" + getName() + "]";
	}
}
