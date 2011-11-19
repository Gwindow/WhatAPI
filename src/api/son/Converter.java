/**
 * @author Gwindow
 */
package api.son;

/**
 * The Class Converter.
 */
public class Converter {

	/**
	 * Parses the int.
	 * 
	 * @param string
	 *            the string
	 * @return the int
	 */
	public static int parseInt(String string) {
		try {
			return Integer.parseInt(string);
		} catch (NumberFormatException e) {
			return 1;
		}
	}

	/**
	 * Parses the string.
	 * 
	 * @param string
	 *            the string
	 * @return the string
	 */
	public static String parseString(String string) {
		if (string == null)
			return "null";
		return string;
	}

	/**
	 * Parses the boolean.
	 * 
	 * @param bool
	 *            the bool
	 * @return true, if successful
	 */
	public static boolean parseBoolean(Boolean bool) {
		if (bool == null)
			return false;
		return bool;
	}

}
