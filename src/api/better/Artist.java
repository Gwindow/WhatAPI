package api.better;

/**
 * The Class Artist.
 * Contains Artist information as returned to us
 * in the Better API response
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
	 * Get the alias id.
	 * 
	 * @return the alias id
	 */
	public Number getAliasId() {
		return this.aliasId;
	}

	/**
	 * Get the id.
	 * 
	 * @return the id
	 */
	public Number getId() {
		return this.id;
	}

	/**
	 * Get the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "Artist [getAliasId=" + getAliasId() + ", getId=" + getId() + ", getName=" + getName() + "]";
	}
}
