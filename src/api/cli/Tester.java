package api.cli;

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
		api.forum.thread.Thread t = api.forum.thread.Thread.threadFromIdAndPostId(148487, 3782816);
		for (int i = 0; i < t.getResponse().getPosts().size(); i++) {
			System.out.println(t.getResponse().getPosts().get(i).getAuthor().getAuthorName());
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
