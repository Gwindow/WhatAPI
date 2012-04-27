package api.son;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;

import api.soup.MySoup;
import api.util.CouldNotLoadException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Convert JSON to a Java object.
 * 
 * @author Gwindow
 */
public class MySon {
	// private static GsonBuilder builder = new GsonBuilder().registerTypeAdapter(Integer.class, new StringConverter());
	// private static Gson gson = builder.create();

	// TODO is serializeNulls needed?
	// TODO disable html escaping?
	/** The Constant gson. */
	private final static Gson gson = new GsonBuilder().registerTypeAdapter(String.class, new MyStringDeserializer())
			.serializeNulls().create();

	// /** The reader. */
	// private static Reader reader;
	/** The is debug enabled. */
	private static boolean isDebugEnabled = false;

	/** The debug string. */
	private static String debugString;

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
		long startTime = 0, endTime = 0;
		if (isDebugEnabled) {
			startTime = System.currentTimeMillis();
		}
		try {
			String string = MySoup.scrape(url);
			// reader = new InputStreamReader(MySoup.scrape(url), "UTF-8");
			Object o = gson.fromJson(string, t);
			if (isDebugEnabled) {
				endTime = System.currentTimeMillis();
				float totalTime = (endTime - startTime) / 1000f;
				debugString = "Load Time: " + String.valueOf(totalTime) + "\n\n" + o.toString();
			}
			return o;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Couldn't create json object " + t.toString());
			return null;
		}
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
			json = MySoup.scrapeOther(url);
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
	 * Checks if is debug enabled.
	 * 
	 * @return the isDebugEnabled
	 */
	public static boolean isDebugEnabled() {
		return isDebugEnabled;
	}

	/**
	 * Sets the debug enabled.
	 * 
	 * @param isDebugEnabled
	 *            the isDebugEnabled to set
	 */
	public static void setDebugEnabled(boolean isDebugEnabled) {
		MySon.isDebugEnabled = isDebugEnabled;
	}

	/**
	 * Gets the debug string.
	 * 
	 * @return the debugString
	 */
	public static String getDebugString() {
		return debugString;
	}

}
