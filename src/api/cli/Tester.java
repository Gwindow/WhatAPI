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
		MySoup.setSite("http://what.cd/");
		// api.forum.thread.Thread t = api.forum.thread.Thread.threadFromFirstPage(147222);
		// System.out.println(t.getResponse().getThreadTitle());
		// t.unsubscribe();
		Section s = Section.sectionFromFirstPage(17);
		for (int i = 0; i < s.getResponse().getThreads().size(); i++) {
			if (!s.getResponse().getThreads().get(i).isRead()) {
				System.out.println(s.getResponse().getThreads().get(i).getTitle());
				s.getResponse().getThreads().get(i).unsubscribe();

			}
		}
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
