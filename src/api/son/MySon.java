package api.son;

import java.lang.reflect.Type;

import api.soup.MySoup;
import api.util.CouldNotLoadException;

import com.google.gson.Gson;

/**
 * Convert JSON to a Java object
 * 
 * @author Tim
 * 
 */
public class MySon {
	private static Gson gson = new Gson();

	/**
	 * Create a java object from a json page
	 * 
	 * @param url
	 *            url of the json page
	 * @param t
	 *            type of object to return
	 * @return object of type t
	 */
	public static Object toObject(String url, Type t) {
		String json = null;
		try {
			json = MySoup.scrape(url).text();
			Object o = gson.fromJson(json, t);
			return o;
		} catch (CouldNotLoadException e) {
			e.printStackTrace();
			System.err.println("Couldn't create json object " + t.toString());
			return null;
		}
	}

	/**
	 * Create a java object from a json page
	 * 
	 * @param url
	 *            url of the json page
	 * @param t
	 *            type of object to return
	 * @return object of type t
	 */
	public static Object toObjectOther(String url, Type t) {
		String json = null;
		try {
			json = MySoup.scrapeOther(url).text();
			Object o = gson.fromJson(json, t);
			return o;
		} catch (CouldNotLoadException e) {
			e.printStackTrace();
			System.err.println("Couldn't create json object " + t.toString());
			return null;
		}
	}

	/**
	 * Create a java object from a json string
	 * 
	 * @param json
	 *            json string
	 * @param t
	 *            type of object to create
	 * @return object of type t
	 */
	public static Object toObjectFromString(String json, Type t) {
		Object o = gson.fromJson(json, t);
		return o;
	}
}
