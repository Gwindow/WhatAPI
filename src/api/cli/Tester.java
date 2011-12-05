package api.cli;

import api.bookmarks.Bookmarks;
import api.index.Index;
import api.soup.MySoup;
import api.util.CouldNotLoadException;

/**
 * The Class Tester.
 * 
 * @author Gwindow
 */
public class Tester {

	/**
	 * Instantiates a new tester.
	 * 
	 * @throws CouldNotLoadException
	 *             the could not load exception
	 */
	public Tester() throws CouldNotLoadException {
		MySoup.setSite("http://127.0.0.1:8080/");
		MySoup.login("login.php", "gazelle", "123456");
		Index i = Index.init();
		System.out.println(i);
		System.out.println(Bookmarks.initArtistBookmarks());

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
