
package api.cli;

import api.soup.MySoup;
import api.util.CouldNotLoadException;

/**
 * The Class WhatCLI.
 * 
 * @author Gwindow
 */
public class WhatCLI extends CLI {

	/**
	 * Instantiates a new what cli.
	 */
	public WhatCLI() {
		MySoup.setSite("ssl.what.cd");
		try {
			MySoup.login("", "", "");
			System.out.println("logged in");
			System.out.println(MySoup.getAuthKey());
		} catch (CouldNotLoadException e) {
			System.out.println("login failed");
			e.printStackTrace();
		}
		this.init("/home/tim/workspace/WhatAPI/bin/");
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		new WhatCLI();
	}
}
