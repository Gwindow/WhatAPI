package api.cli;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
	public static String split(String string, String from, String to) {
		Pattern pattern = Pattern.compile(".*" + from + "(.*)" + to + ".*");
		Matcher matcher = pattern.matcher(string);
		if (matcher.matches())
			return matcher.group(1);
		return null;
	}

	public static void print(Object object) {
		System.out.println(object);
	}

	public static void printSingleIndent(Object object) {
		System.out.println("\t" + object);
	}

	public static void printDoubleIndent(Object object) {
		System.out.println("\t \t" + object);
	}
}
