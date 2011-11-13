package api.cli;

import api.soup.MySoup;
import api.torrents.torrents.Torrents;
import api.util.CouldNotLoadException;

public class Tester {
	public Tester() throws CouldNotLoadException {
		MySoup.setSite("http://what.cd/");
		MySoup.login("login.php", "Gwindow", "t2ustUdE");
		System.out.println(Torrents.torrentsFromId(72031284));
	}

	public static void main(String[] args) throws CouldNotLoadException {
		new Tester();
	}
}
