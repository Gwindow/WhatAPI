package api.cli;

import api.util.CouldNotLoadException;

public class Tester {
	public Tester() throws CouldNotLoadException {

		// MySoup.setSite("http://127.0.0.1:8080/");
		// MySoup.login("login.php", "gazelle", "123456");

		// ForumSections fs = ForumSections.init();
		// Section s = Section.sectionFromIdAndPage(1, 1);
		// System.out.println(s);
		// System.out.println(s.getResponse().getThreads());
	}

	public static void main(String[] args) throws CouldNotLoadException {
		new Tester();
	}
}
