package api.cli;

import api.inbox.inbox.Inbox;
import api.soup.MySoup;
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
		MySoup.setSite("what.cd");
		Inbox inbox = Inbox.init();
		for (int i = 0; i < inbox.getResponse().getMessages().size(); i++) {
			System.out.println(inbox.getResponse().getMessages().get(i));
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
