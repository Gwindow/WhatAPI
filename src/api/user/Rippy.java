/**
 * @author Gwindow
 */
package api.user;

import api.soup.MySoup;
import api.util.CouldNotLoadException;

/**
 * A Rippy to a user.
 * 
 * @author Tim
 */

public class Rippy {
	private int id;
	private String body;

	/**
	 * A new message.
	 * 
	 * @param id
	 *            recipent's id
	 * @param body
	 *            body of the message
	 */
	public Rippy(int id, String body) {
		this.id = id;
		this.body = body;
	}

	/**
	 * Instantiates a new rippy.
	 * 
	 * @param id
	 *            recipent's id
	 */
	public Rippy(int id) {
		this.id = id;
	}

	/**
	 * Send the rippy.
	 * 
	 * @throws CouldNotLoadException
	 *             the could not load exception
	 */
	public void sendRippy() throws CouldNotLoadException {
		if (body.length() > 0) {
			try {
				MySoup.sendRippy(String.valueOf(id), body);
			} catch (Exception e) {
				e.printStackTrace();
				throw new CouldNotLoadException(e.getMessage());
			}
		}
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the body.
	 * 
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * Set message body.
	 * 
	 * @param s
	 *            body
	 */
	public void setBody(String s) {
		body = s;
	}

}