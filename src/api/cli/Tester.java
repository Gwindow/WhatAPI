package api.cli;

import api.forum.section.Section;
import api.soup.MySoup;
import api.util.CouldNotLoadException;

public class Tester {
	public Tester() throws CouldNotLoadException {

		MySoup.setSite("http://what.cd/");
		MySoup.login("login.php", "Gwindow", "t2ustUdE");

		// ForumSections fs = ForumSections.init();
		Section s = Section.sectionFromIdAndPage(7, 1);
		System.out.println(s);
		// System.out.println(s.getResponse().getThreads());
	}

	public static void main(String[] args) throws CouldNotLoadException {
		new Tester();
	}
}
