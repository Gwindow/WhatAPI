package api.son;

import api.soup.MySoup;
import api.util.CouldNotLoadException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.lang.reflect.Type;

/**
 * Convert JSON to a Java object.
 * Provides functionality for converting an API response from a URL
 * to the desired Object and returning it
 * 
 * @author Gwindow
 */
public class MySon {
	/** The Gson serializer/deserializer, using our custom string deserializer. */
	private final static Gson gson = new GsonBuilder().registerTypeAdapter(String.class,
            new MyStringDeserializer()).serializeNulls().create();

	/** If debugging is enabled. */
	private static boolean isDebugEnabled = false;

	/** The debug string. */
	private static String debugString;

	/**
	 * Convert the API response from some URL to an Object of some Type
     * and return the object
	 * 
	 * @param url
     *      the url to get the API response from
	 * @param t
	 *      the type of object to create
	 * @return the object
	 */
	public static Object toObject(String url, Type t) {
		long startTime = 0, endTime = 0;
		if (isDebugEnabled) {
			startTime = System.currentTimeMillis();
		}
		try {
			String string = MySoup.scrape(url);
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
     * Create an Object of some Type from a JSON string
     *
     * @param string
     *      the JSON formatted data as a string
     * @param t
     *      the type of Object to create
     * @return the created object
     */
	public static Object toObjectFromString(String string, Type t) {
		long startTime = 0, endTime = 0;
		if (isDebugEnabled) {
			startTime = System.currentTimeMillis();
		}
		try {
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
	 * Create an Object of some Type from a non-What.CD url response
	 * 
	 * @param url
	 *      url to get the JSON data from
	 * @param t
     *      type of object to return
	 * @return the created object
	 */
	public static Object toObjectOther(String url, Type t) {
		try {
			String json = MySoup.scrapeOther(url);
			return gson.fromJson(json, t);
		} catch (CouldNotLoadException e) {
			e.printStackTrace();
			System.err.println("Couldn't create json object " + t.toString());
			return null;
		}
	}

	/**
	 * Read JSON contents of a file into an object using GSON
	 * @param file the file to read
	 * @param t The type to create from the data
	 * @return the created object, or null if creation failed
	 */
	public static Object toObjectFromFile(File file, Type t){
		try {
			FileReader reader = new FileReader(file);
			return gson.fromJson(reader, t);
		}
		catch (FileNotFoundException e){
			System.err.println("Failed to find file " + file.getName());
			e.printStackTrace();
			return null;
		}
	}

    /**
     * Serialize an Object of some Type to a JSON formatted string
     *
     * @param o
     *      the object to serialize
     * @param t
     *      the type of object to serialize
     * @return the JSON formatted string
     */
	public static String toJson(Object o, Type t) {
		return gson.toJson(o, t);
	}

	/**
	 * Prints the stream from some reader
	 * 
	 * @param reader
	 *      the reader to get the stream from
	 */
	private void printStream(Reader reader) {
		char[] arr = new char[8 * 1024]; // 8K at a time
		StringBuilder builder = new StringBuilder();
		int numChars;

		try {
			while ((numChars = reader.read(arr, 0, arr.length)) > 0) {
                builder.append(arr, 0, numChars);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(builder.toString());
	}

	/**
	 * Check if debug is enabled
	 * 
	 * @return True if debug is enabled
	 */
	public static boolean isDebugEnabled() {
		return isDebugEnabled;
	}

	/**
	 * Set if debug is enabled or not
	 * 
	 * @param isDebugEnabled
	 *      the value to set
	 */
	public static void setDebugEnabled(boolean isDebugEnabled) {
		MySon.isDebugEnabled = isDebugEnabled;
	}

	/**
	 * Get the debug string
	 * 
	 * @return the debug string
	 */
	public static String getDebugString() {
		return debugString;
	}
}
