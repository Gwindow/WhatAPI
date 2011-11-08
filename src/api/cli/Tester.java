package api.cli;

import api.forum.section.Section;
import api.soup.MySoup;
import api.util.CouldNotLoadException;

public class Tester {
	public Tester() throws CouldNotLoadException {

		MySoup.setSite("http://127.0.0.1:8080/");
		MySoup.login("login.php", "tester", "123456");

		Section s = Section.sectionFromIdAndPage(3, 1);
		System.out.println(s);
		// System.out.println(s.getResponse().getThreads());
	}

	public static void main(String[] args) throws CouldNotLoadException {
		new Tester();
	}
}
