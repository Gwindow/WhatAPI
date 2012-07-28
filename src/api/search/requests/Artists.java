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
	private Number id;

	/** The name. */
	private Number name;

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
	public Number getName() {
		return this.name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Artists [getId=" + getId() + ", getName=" + getName() + "]";
	}
}
