/**
 * @author Gwindow
 */
package api.top;

import java.util.List;

/**
 * The section of the top list. For example "most uploaded", "most downloaded", etc...
 * 
 * @author Tim
 * 
 */
public class Section {
	private String caption;
	private Number limit;
	private List<Results> results;
	private String tag;

	/**
	 * Name of the section.
	 * 
	 * @return section name
	 */
	public String getCaption() {
		return this.caption;
	}

	/**
	 * The number of results displayed.
	 * 
	 * @return number of results
	 */
	public Number getLimit() {
		return this.limit;
	}

	/**
	 * List of Results.
	 * 
	 * @return List of Results
	 */
	public List<Results> getResults() {
		return this.results;
	}

	/**
	 * The tag of the section.
	 * 
	 * @return tag
	 */
	public String getTag() {
		return this.tag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Section [caption=" + caption + ", limit=" + limit + ", results=" + results + ", tag=" + tag + "]";
	}
}
