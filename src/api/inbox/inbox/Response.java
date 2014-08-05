package api.inbox.inbox;

import java.util.List;

/**
 * Stores data returned by the API related to
 * viewing a user's inbox, ie. the list of messages
 * on the current page of the inbox
 * 
 * @author Gwindow
 */
public class Response {
	/** The current page being viewed */
	private Number currentPage;

	/** The number of pages in the inbox */
	private Number pages;

	/**
	 * The messages in the inbox
	 */
	private List<Message> messages;

	/**
	 * Get the number of unread messages
	 * 
	 * @return number of unread messages
	 */
	public int getUnread() {
		int counter = 0;
		for (Message m : messages) {
			if (m.isUnread()) {
				counter++;
			}
		}
		return counter;
	}

	/**
	 * Get the current page number being viewed
	 * 
	 * @return the current page number
	 */
	public Number getCurrentPage() {
		return currentPage;
	}

	/**
	 * Get the total number of pages in the inbox
	 *
	 * @return the total number of pages
	 */
	public Number getPages(){
		return pages;
	}

	/**
	 * Get the messages in the inbox
	 * 
	 * @return the messages
	 */
	public List<Message> getMessages() {
		return messages;
	}

	@Override
	public String toString(){
		return "Response [getUnread=" + getUnread() + ", getCurrentPage=" + getCurrentPage()
			+ ", getMessages=" + getMessages() + ", getPages=" + getPages() + "]";
	}
}
