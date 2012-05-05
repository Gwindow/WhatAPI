package api.cli;

import java.io.IOException;

import api.soup.MySoup;
import api.util.CouldNotLoadException;

/**
 * The Class Tester.
 * 
 * @author Gwindow
 */
public class Tester {

	private static final String SITE = "";
	private static final boolean SSL = false;

	private static final String USERNAME = "gazelle";
	private static final String PASSWORD = "123456";

	/**
	 * Instantiates a new tester.
	 * 
	 * @throws CouldNotLoadException
	 *             the could not load exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public Tester() throws CouldNotLoadException, IOException {
		MySoup.setSite(SITE, SSL);
		MySoup.login("login.php", USERNAME, PASSWORD);

		System.out.println(MySoup.getIndex());
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 * @throws CouldNotLoadException
	 *             the could not load exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws CouldNotLoadException, IOException {
		new Tester();

	}

}
