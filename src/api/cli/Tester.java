/**
 * @author Gwindow
 */
package api.cli;

import api.soup.MySoup;
import api.torrents.torrents.Torrents;
import api.util.CouldNotLoadException;

/**
 * The Class Tester.
 */
public class Tester {
	
	/**
	 * Instantiates a new tester.
	 * 
	 * @throws CouldNotLoadException
	 *             the could not load exception
	 */
	public Tester() throws CouldNotLoadException {
		MySoup.setSite("http://what.cd/");
		MySoup.login("login.php", "Gwindow", "t2ustUdE");
		System.out.println(Torrents.torrentsFromId(72031284));
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 * @throws CouldNotLoadException
	 *             the could not load exception
	 */
	public static void main(String[] args) throws CouldNotLoadException {
		new Tester();
	}
}
