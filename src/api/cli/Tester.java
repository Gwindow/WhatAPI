package api.cli;

import org.jsoup.Jsoup;

import api.forum.section.Section;
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
		Section s = Section.sectionFromFirstPage(2);
		for (int i = 0; i < s.getResponse().getThreads().size(); i++) {
			api.forum.thread.Thread t =
					api.forum.thread.Thread.threadFromFirstPage(s.getResponse().getThreads().get(i).getTopicId().intValue());
			System.out.println(s.getResponse().getThreads().get(i).getTitle());
			System.out.println(Jsoup.parse(s.getResponse().getThreads().get(i).getTitle()).text());
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
