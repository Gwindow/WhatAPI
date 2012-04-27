package api.cli;

import java.io.IOException;

import api.soup.MySoup;
import api.util.CouldNotLoadException;
import api.whatstatus.WhatStatus;

/**
 * The Class Tester.
 * 
 * @author Gwindow
 */
public class Tester {

	/** The Constant UPDATE_SITE. */
	private static final String UPDATE_SITE = "http://gwindow.github.com/WhatAndroid/index.html";

	/**
	 * Instantiates a new tester.
	 * 
	 * @throws CouldNotLoadException
	 *             the could not load exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public Tester() throws CouldNotLoadException, IOException {
		MySoup.setSite("ssl.what.cd");
		System.out.println(WhatStatus.init());
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 * @throws CouldNotLoadException
	 *             the could not load exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws CouldNotLoadException, IOException {
		new Tester();

	}

}
