package api.son;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;

import api.soup.MySoup;
import api.util.CouldNotLoadException;

import com.google.gson.Gson;

/**
 * Convert JSON to a Java object.
 * 
 */
public class MySon {
	// private static GsonBuilder builder = new GsonBuilder().registerTypeAdapter(Integer.class, new StringConverter());
	// private static Gson gson = builder.create();

	// TODO is serializeNulls needed?
	// private final static Gson gson = new GsonBuilder().serializeNulls().create();
	private final static Gson gson = new Gson();
	private static Reader reader;

	/**
	 * To object.
	 * 
	 * @param url
	 *            the url
	 * @param t
	 *            the t
	 * @return the object
	 */
	public static Object toObject(String url, Type t) {
		try {
			reader = new InputStreamReader(MySoup.scrape(url));
			Object o = gson.fromJson(reader, t);
			return o;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Couldn't create json object " + t.toString());
			return null;
		}
	}

	/**
	 * Prints the stream.
	 * 
	 * @param reader
	 *            the reader
	 */
	@SuppressWarnings("unused")
	private void printStream(Reader reader) {
		char[] arr = new char[8 * 1024]; // 8K at a time
		StringBuffer buf = new StringBuffer();
		int numChars;

		try {
			while ((numChars = reader.read(arr, 0, arr.length)) > 0) {
				buf.append(arr, 0, numChars);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(buf.toString());
	}

	/**
	 * Create a java object from a json page.
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
	 * Create a java object from a json string.
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
