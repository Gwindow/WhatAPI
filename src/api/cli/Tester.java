package api.cli;

import java.io.IOException;

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
	 * @throws IOException
	 */
	public Tester() throws CouldNotLoadException, IOException {
		MySoup.setSite("ssl.what.cd");

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 * @throws CouldNotLoadException
	 *             the could not load exception
	 * @throws IOException
	 */
	public static void main(String[] args) throws CouldNotLoadException, IOException {
		new Tester();

	}

}
