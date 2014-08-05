package api.torrents.artist;


import java.util.Comparator;

/**
 * The Class Tags.
 *
 * @author Gwindow
 */
public class Tags {
	public static class TagComparator implements Comparator<Tags> {
		@Override
		public int compare(Tags a, Tags b){
			return a.count.intValue() < b.count.intValue() ? -1
				: a.count.intValue() > b.count.intValue() ? 1 : 0;
		}
	}

	/**
	 * The count.
	 */
	private Number count;

	/**
	 * The name.
	 */
	private String name;

	/**
	 * Gets the count.
	 *
	 * @return the count
	 */
	public Number getCount(){
		return this.count;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName(){
		return this.name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return getName();
	}
}
