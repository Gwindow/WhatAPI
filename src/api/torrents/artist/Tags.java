/**
 * @author Gwindow
 */
package api.torrents.artist;


/**
 * The Class Tags.
 */
public class Tags {
	private Number count;
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
