package api.cli;

import twitter4j.TwitterException;
import api.util.CouldNotLoadException;
import api.whatstatus.Status2;

public class Tester {
	public Tester() throws CouldNotLoadException {

		Status2 ws = new Status2();
		try {
			System.out.println(ws.getTweets());
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// MySoup.setSite("http://127.0.0.1:8080/");
		// MySoup.login("login.php", "tester", "123456");
		// ProductSearch p = ProductSearch.ProductSearchFromUPC("0047875332478");
		// System.out.println(p.getItems().get(0).getProduct().getTitle());
	}

	public static void main(String[] args) throws CouldNotLoadException {
		new Tester();
	}
}
