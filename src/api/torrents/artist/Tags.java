


package api.torrents.artist;


/**
 * The Class Tags.
 * 
 * @author Gwindow
 */
public class Tags {
	
	/** The count. */
	private Number count;
	
	/** The name. */
	private String name;

	/**
	 * Gets the count.
	 * 
	 * @return the count
	 */
	public Number getCount() {
		return this.count;
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
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tags [getCount=" + getCount() + ", getName=" + getName() + "]";
	}
}
