package api.top;

import java.util.List;

/**
 * The section of the top list. For example "most uploaded", "most downloaded", etc...
 * 
 * @author Tim
 * 
 */
public class Response<T> {
	/** The caption. */
	private String caption;
	
	/** The limit. */
	private Number limit;
	
	/** The results. */
	private List<T> results;
	
	/** The tag. */
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
	public List<T> getResults(){
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

	@Override
	public String toString() {
		return "Response [caption=" + caption + ", limit=" + limit + ", results=" + results + ", tag=" + tag + "]";
	}
}
