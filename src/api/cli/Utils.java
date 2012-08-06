package api.cli;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Class Utils.
 * 
 * @author Gwindow
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
	public static void printDoubleIndentw(Object object) {
		System.out.println("\t \t" + object);
	}

	public static String toHumanReadableSize(long bytes) {
		boolean si = false;
		int unit = si ? 1000 : 1024;
		if (bytes < unit)
			return bytes + " B";
		int exp = (int) (Math.log(bytes) / Math.log(unit));
		String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1) + ""; // + (si ? "" : "i");
		return String.format("%.2f %sB", bytes / Math.pow(unit, exp), pre);
	}
}
