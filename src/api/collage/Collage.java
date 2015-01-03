package api.collage;

import api.son.MySon;
import api.soup.MySoup;

/**
 * Collage that can be loaded from the collage id on the site
 */
public class Collage {
	/**
	 * Status of loading this collage
	 */
	private String status;
	/**
	 * Error that occurred loading the collage, null if no error
	 */
	private String error;
	/**
	 * The id of the collage being loaded
	 */
	private transient int id;
	/**
	 * Response containing information about the collage returned by the API
	 */
	private Response response;

	/**
	 * Load a collage by its id
	 *
	 * @param id id of collage to load
	 * @return the loaded collage. Note: returns null if we couldn't reach the site
	 * may return non-null with a failed loaded collage, check status
	 */
	public static Collage fromId(int id) {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=collage&id=" + id + "&auth=" + authkey;
		Collage collage = (Collage) MySon.toObject(url, Collage.class);
		if (collage != null) {
			collage.id = id;
		}
		return collage;
	}

	/**
	 * Get the response containing the collage information
	 *
	 * @return response
	 */
	public Response getResponse() {
		return response;
	}

	/**
	 * Get the status of the request.
	 *
	 * @return true if success
	 */
	public boolean getStatus() {
		return status.equalsIgnoreCase("success");
	}

	/**
	 * Get any error string returned by the API
	 *
	 * @return the error string, or null if none
	 */
	public String getError() {
		return error;
	}

	/**
	 * Get the collage id
	 *
	 * @return collage id
	 */
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Collage [ status = " + status + ", response = " + response + " ]";
	}
}
