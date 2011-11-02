package api.cli;

import api.soup.MySoup;
import api.util.CouldNotLoadException;

public class WhatCLI extends CLI {
	public WhatCLI() {
		MySoup.setSite("http://127.0.0.1:8080/");
		try {
			MySoup.login("login.php", "gazelle", "123456");
			System.out.println("logged in");
			System.out.println(MySoup.getAuthKey());
		} catch (CouldNotLoadException e) {
			System.out.println("login failed");
			e.printStackTrace();
		}
		this.init("/home/tim/workspace/api-testing/bin/");
	}

	public static void main(String[] args) {
		new WhatCLI();
	}
}
