/**
 * 
 */
package api.user;

import api.soup.MySoup;
import api.util.CouldNotLoadException;

/**
 * A private message
 * 
 * @author Tim
 */

public class PrivateMessage {
	private String id;
	private String subject;
	private String body;

	/**
	 * A new message
	 * 
	 * @param id
	 *            recipent's id
	 * @param subject
	 *            subject line
	 * @param body
	 *            body of the message
	 */
	public PrivateMessage(String id, String subject, String body) {
		this.id = id;
		this.subject = subject;
		this.body = body;
	}

	/**
	 * @param id
	 *            recipent's id
	 */
	public PrivateMessage(String id) {
		this.id = id;
	}

	/**
	 * Send the message
	 * 
	 * @throws CouldNotLoadException
	 */
	public void sendMessage() throws CouldNotLoadException {
		if ((subject.length() > 0) && (body.length() > 0)) {
			try {
				MySoup.sendPrivateMessage(id, subject, body);
			} catch (Exception e) {
				e.printStackTrace();
				throw new CouldNotLoadException(e.getMessage());
			}
		}
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Set the subject line of the message
	 * 
	 * @param s
	 *            subject line
	 */
	public void setSubject(String s) {
		subject = s;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * Set message body
	 * 
	 * @param s
	 *            body
	 */
	public void setBody(String s) {
		body = s;
	}

}
