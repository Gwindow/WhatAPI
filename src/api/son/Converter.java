package api.son;

public class Converter {

	public static int parseInt(String string) {
		try {
			return Integer.parseInt(string);
		} catch (NumberFormatException e) {
			return 1;
		}
	}

	public static String parseString(String string) {
		if (string == null)
			return "null";
		return string;
	}

	public static boolean parseBoolean(Boolean bool) {
		if (bool == null)
			return false;
		return bool;
	}

}
