package api.notifications;

import java.util.List;

/**
 * The Class Response.
 * Stores the data returned to us by the API about the
 * user's notifications
 * 
 * @author Gwindow
 */
public class Response {
	/** The current page being viewed */
	private Number currentPages;

    /** The number of pages of notifications */
    private Number pages;

	/** The number of new notifications */
	private Number numNew;

	/** The torrents we're being notified about. */
	private List<Torrent> results;

	/**
	 * Get the current page number being viewed
	 * 
	 * @return the current page number
	 */
	public Number getCurrentPages() {
		return currentPages;
	}

    /**
     * Get the total number of pages of notifications
     *
     * @return the number of pages of notifications
     */
    public Number getPages() {
        return pages;
    }

	/**
	 * Get the number of new notifications
	 * 
	 * @return number of new notifications
	 */
	public Number getNumNew() {
		return numNew;
	}

	/**
	 * Get the list of torrents we're being notified about
	 * 
	 * @return the torrents
	 */
	public List<Torrent> getResults() {
		return results;
	}

	/**
	 * Clear the notifications
	 */
	public void clear() {
		currentPages = 0;
		numNew = 0;
		pages = 0;
		if (results != null && !results.isEmpty()) {
			results.clear();
		}
	}

	@Override
	public String toString() {
		return "Response [getCurrentPages=" + getCurrentPages() + ", getNumNew=" + getNumNew() + ", getPages=" + getPages()
				+ ", getResults=" + getResults() + "]";
	}
}
