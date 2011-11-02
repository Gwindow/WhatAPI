package api.inbox.inbox;

import java.util.List;

public class Response {
	private Number currentPage;
	private List<Messages> messages;
	private Number pages;

	public int getUnread() {
		int counter = 0;
		for (Messages m : messages) {
			if (m.isUnread() == true) {
				counter++;
			}
		}
		return counter;
	}

	public Number getCurrentPage() {
		return this.currentPage;
	}

	public List<Messages> getMessages() {
		return this.messages;
	}

	public Number getPages() {
		return this.pages;
	}

	@Override
	public String toString() {
		return "Response [getUnread=" + getUnread() + ", getCurrentPage=" + getCurrentPage() + ", getMessages=" + getMessages()
				+ ", getPages=" + getPages() + "]";
	}
}
