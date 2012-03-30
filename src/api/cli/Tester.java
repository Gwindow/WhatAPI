package api.cli;

import api.soup.MySoup;
import api.top.Top;
import api.util.CouldNotLoadException;

/**
 * The Class Tester.
 * 
 * @author Gwindow
 */
public class Tester {

	private final static String UPDATE_SITE = "https://raw.github.com/Gwindow/WhatAndroid/gh-pages/index.html";

	/**
	 * Instantiates a new tester.
	 * 
	 * @throws CouldNotLoadException
	 *             the could not load exception
	 */
	public Tester() throws CouldNotLoadException {
		MySoup.setSite("ssl.what.cd");
		Top top = Top.initTopTags(250);
		for (int i = 0; i < top.getResponse().size(); i++) {
			for (int j = 0; j < top.getResponse().get(0).getResults().size(); j++) {
				String tag = (top.getResponse().get(0).getResults().get(j).getName());
				System.out.println("tags[\"" + tag + "\"] = true;");
			}
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
