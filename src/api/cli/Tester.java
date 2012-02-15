package api.cli;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import api.util.CouldNotLoadException;
import api.util.Updater;

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
		// MySoup.setSite("what.cd");
		// TorrentSearch ts = TorrentSearch.torrent SearchFromSearchTerm("hello");
		// System.out.println(ts);
		// for (int i = 0; i < ts.getResponse().getResults().size(); i++) {
		// System.out.println(ts.getResponse().getResults().get(i).getGroupYear().toString());
		// }

		Updater updater = new Updater(UPDATE_SITE);
		System.out.println(updater.getDownloadLink());
		System.out.println(updater.getDoc());
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

	public String split(String string, String from, String to) {
		Pattern pattern = Pattern.compile(".*" + from + "(.*)" + to + ".*");
		Matcher matcher = pattern.matcher(string);
		if (matcher.matches())
			return matcher.group(1);
		return null;
	}

}
