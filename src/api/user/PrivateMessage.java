package api.user;

import java.util.ArrayList;
import java.util.List;

import api.soup.MySoup;
import api.util.Tuple;

/**
 * The Class PrivateMessage.
 * 
 * //TODO description
 * 
 * @author Gwindow
 */
public class PrivateMessage {
	private int id;
	private String subject;
	private String body;

	/**
	 * A new message.
	 * 
	 * @param id
	 *            recipent's id
	 * @param subject
	 *            subject line
	 * @param body
	 *            body of the message
	 */
	public PrivateMessage(int id, String subject, String body) {
		this.id = id;
		this.subject = subject;
		this.body = body;
	}

	/**
	 * Instantiates a new private message.
	 * 
	 * @param id
	 *            recipent's id
	 */
	public PrivateMessage(int id) {
		this.id = id;
	}

	/**
	 * Send the message.
	 * 
	 */
	public void sendMessage() {
		if ((subject.length() > 0) && (body.length() > 0)) {
			try {
				String url = "inbox.php?action=compose&to=" + id;
				List<Tuple<String, String>> list = new ArrayList<Tuple<String, String>>();
				list.add(new Tuple<String, String>("action", "takecompose"));
				list.add(new Tuple<String, String>("toid", String.valueOf(id)));
				list.add(new Tuple<String, String>("auth", MySoup.getAuthKey()));
				list.add(new Tuple<String, String>("subject", subject));
				list.add(new Tuple<String, String>("body", body));
				MySoup.postMethod(url, list);
				System.out.println("Message sent");
			} catch (Exception e) {
				e.printStackTrace();
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
	 * Gets the subject.
	 * 
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Set the subject line of the message.
	 * 
	 * @param s
	 *            subject line
	 */
	public void setSubject(String s) {
		subject = s;
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
