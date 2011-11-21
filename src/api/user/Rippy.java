package api.user;

import java.util.ArrayList;
import java.util.List;

import api.soup.MySoup;
import api.util.Tuple;

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
	 */
	public void sendRippy() {
		if (body.length() > 0) {
			try {
				String url = "user.php?action=rippy&id=" + id;
				List<Tuple<String, String>> list = new ArrayList<Tuple<String, String>>();
				list.add(new Tuple<String, String>("action", "takecompose"));
				list.add(new Tuple<String, String>("toid", String.valueOf(id)));
				list.add(new Tuple<String, String>("auth", MySoup.getAuthKey()));
				list.add(new Tuple<String, String>("body", body));
				MySoup.postMethod(url, list);
				System.out.println("Rippy sent");
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