/**
 * @author Gwindow
 */
package api.inbox.inbox;

import java.util.List;

/**
 * The Class Response.
 */
public class Response {
	private Number currentPage;
	private List<Messages> messages;
	private Number pages;

	/**
	 * Gets the unread.
	 * 
	 * @return the unread
	 */
	public int getUnread() {
		int counter = 0;
		for (Messages m : messages) {
			if (m.isUnread() == true) {
				counter++;
			}
		}
		return counter;
	}

	/**
	 * Gets the current page.
	 * 
	 * @return the current page
	 */
	public Number getCurrentPage() {
		return this.currentPage;
	}

	/**
	 * Gets the messages.
	 * 
	 * @return the messages
	 */
	public List<Messages> getMessages() {
		return this.messages;
	}

	/**
	 * Gets the pages.
	 * 
	 * @return the pages
	 */
	public Number getPages() {
		return this.pages;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Response [getUnread=" + getUnread() + ", getCurrentPage=" + getCurrentPage() + ", getMessages=" + getMessages()
				+ ", getPages=" + getPages() + "]";
	}
}
