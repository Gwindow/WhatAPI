
package api.index;

import api.son.MySon;

/**
 * The Class Index.
 * 
 * @author Gwindow
 */
public class Index {
	
	/** The response. */
	private Response response;
	
	/** The status. */
	private String status;

	/**
	 * Inits the index.
	 * 
	 * @return the index
	 */
	public static Index init() {
		String url = "ajax.php?action=index";
		Index index = (Index) MySon.toObject(url, Index.class);
		return index;
	}

	/**
	 * Gets the response.
	 * 
	 * @return the response
	 */
	public Response getResponse() {
		return response;
	}

	/**
	 * Get the status of the request.
	 * 
	 * @return the status
	 */
	public boolean getStatus() {
        return status.equalsIgnoreCase("success");
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Index [response=" + response + ", status=" + status + ", getResponse=" + getResponse() + ", getStatus="
				+ getStatus() + "]";
	}
}
