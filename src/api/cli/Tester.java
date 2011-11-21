package api.cli;

import api.forum.section.Section;
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
		// User u = User.userFromId(5);
		Section s = Section.sectionFromIdAndPage(2, 1);
		s.createNewThread("this is a very important thread", "with a very important body");
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
