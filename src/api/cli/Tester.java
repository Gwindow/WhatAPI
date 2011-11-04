package api.cli;

import api.products.ProductSearch;
import api.soup.MySoup;
import api.util.CouldNotLoadException;

public class Tester {
	public Tester() throws CouldNotLoadException {

		MySoup.setSite("http://127.0.0.1:8080/");
		MySoup.login("login.php", "tester", "123456");
		ProductSearch p = ProductSearch.ProductSearchFromUPC("0047875332478");
		System.out.println(p.getItems().get(0).getProduct().getTitle());
	}

	public static void main(String[] args) throws CouldNotLoadException {
		new Tester();
	}
}
