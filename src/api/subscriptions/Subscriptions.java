package api.subscriptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import api.son.MySon;
import api.soup.MySoup;

public class Subscriptions {
	private Response response;
	private String status;

	public static Subscriptions init() {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=subscriptions&auth=" + authkey;
		Subscriptions subscriptions = (Subscriptions) MySon.toObject(url, Subscriptions.class);
		return subscriptions;
	}

	public Response getResponse() {
		return this.response;
	}

	public String getStatus() {
		return this.status;
	}

	// TODO needs to be tested
	/**
	 * Dont call me just yet!
	 * 
	 * @return
	 */
	public HashMap<String, Threads> sortThreadsBySection() {
		HashMap<String, Threads> map = new HashMap<String, Threads>();
		for (Threads t : response.getThreads()) {
			map.put(t.getForumName(), t);
		}
		ArrayList<String> sortedKeys = new ArrayList<String>(map.keySet());
		Collections.sort(sortedKeys);
		return map;
	}

	@Override
	public String toString() {
		return "Subscriptions [getResponse=" + getResponse() + ", getStatus=" + getStatus() + "]";
	}
}
