package api.cli;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import api.inbox.conversation.Conversation;
import api.soup.MySoup;
import api.util.CouldNotLoadException;

/**
 * The Class Tester.
 * 
 * @author Gwindow
 */
public class Tester {

	/**
	 * Instantiates a new tester.
	 * 
	 * @throws CouldNotLoadException
	 *             the could not load exception
	 */
	public Tester() throws CouldNotLoadException {
		MySoup.setSite("what.cd");
		/*
		 * RequestsSearch rs = RequestsSearch.requestSearchFromSearchTerm("chopin"); for (int i = 0; i <
		 * rs.getResponse().getResults().size(); i++) {
		 * System.out.println(rs.getResponse().getResults().get(i).getTitle()); }
		 */
		// Subscriptions s = Subscriptions.init();
		// for (int i = 0; i < s.getResponse().getThreads().size(); i++) {
		// System.out.println(s.getResponse().getThreads().get(i).getThreadTitle());
		// }
		Conversation c = Conversation.conversationFromId(3202632);
		System.err.println(split(c.getResponse().getMessages().get(0).getBody(), "alt=", "src"));
		System.out.println((c.getResponse().getMessages().get(0).getBody()));

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
