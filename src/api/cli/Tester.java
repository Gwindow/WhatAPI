package api.cli;

import api.bookmarks.Bookmarks;
import api.soup.MySoup;
import api.util.CouldNotLoadException;

public class Tester {
	public Tester() throws CouldNotLoadException {

		// MySoup.setSite("http://127.0.0.1:8080/");
		// MySoup.login("login.php", "gazelle", "123456");

		MySoup.setSite("http://what.cd/");
		Bookmarks b = Bookmarks.init();
		System.out.println(b);
		// System.out.println(MySoup.getIndex());
		// ForumSections f = ForumSections.init();
		// System.out.println(f);
		// Inbox inbox = Inbox.inboxFromPage(1);
		// System.out.println(inbox);
		// Section s = Section.sectionFromIdAndPage(20, 2);
		// System.out.println(s);

	}

	public static void main(String[] args) throws CouldNotLoadException {
		new Tester();
	}
}
