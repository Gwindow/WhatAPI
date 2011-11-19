/**
 * @author Gwindow
 */
package api.cli;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Class Utils.
 */
public class Utils {
	
	/**
	 * Split.
	 * 
	 * @param string
	 *            the string
	 * @param from
	 *            the from
	 * @param to
	 *            the to
	 * @return the string
	 */
	public static String split(String string, String from, String to) {
		Pattern pattern = Pattern.compile(".*" + from + "(.*)" + to + ".*");
		Matcher matcher = pattern.matcher(string);
		if (matcher.matches())
			return matcher.group(1);
		return null;
	}

	/**
	 * Prints the.
	 * 
	 * @param object
	 *            the object
	 */
	public static void print(Object object) {
		System.out.println(object);
	}

	/**
	 * Prints the single indent.
	 * 
	 * @param object
	 *            the object
	 */
	public static void printSingleIndent(Object object) {
		System.out.println("\t" + object);
	}

	/**
	 * Prints the double indent.
	 * 
	 * @param object
	 *            the object
	 */
	public static void printDoubleIndent(Object object) {
		System.out.println("\t \t" + object);
	}
}
