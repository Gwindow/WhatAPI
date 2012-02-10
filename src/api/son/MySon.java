package api.son;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;

import org.jsoup.Jsoup;

import api.soup.MySoup;
import api.util.CouldNotLoadException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

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
	private final static Gson gson = new GsonBuilder().registerTypeAdapter(String.class, new MyStringDeserializer())
			.serializeNulls().create();

	// /** The reader. */
	// private static Reader reader;

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
			String string = MySoup.scrape(url);
			// reader = new InputStreamReader(MySoup.scrape(url), "UTF-8");
			Object o = gson.fromJson(string, t);
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

	private static class MyStringDeserializer implements JsonDeserializer<Object> {
		@Override
		public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
			String s = Jsoup.parse(json.getAsJsonPrimitive().getAsString()).text();
			return s;

		}
	}
}
