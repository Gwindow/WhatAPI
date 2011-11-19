/**
 * @author Gwindow
 */
package api.index;

import api.son.MySon;

/**
 * The Class Index.
 */
public class Index {
	private Response response;
	private String status;

	/**
	 * Inits the.
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
		if (status.equalsIgnoreCase("success"))
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Index [response=" + response + ", status=" + status + ", getResponse=" + getResponse() + ", getStatus="
				+ getStatus() + ", getStatus" + getStatus() + "]";
	}
}
