package api.bookmarks;

import api.soup.MySoup;

/**
 * The Class Artist.
 * The information received from the API about a bookmarked artist
 * 
 * @author Gwindow
 */
public class Artist {
	/** The artist id. */
	private Number artistId;
	
	/** The artist name. */
	private String artistName;

	/**
	 * Get the artist id.
	 * 
	 * @return the artist id
	 */
	public Number getArtistId() {
		return this.artistId;
	}

	/**
	 * Get the artist name.
	 * 
	 * @return the artist name
	 */
	public String getArtistName() {
		return this.artistName;
	}

    /**
	 * Remove the bookmark.
	 */
	public void removeBookmark() {
		String authKey = MySoup.getAuthKey();
		MySoup.pressLink("bookmarks.php?action=remove&type=artist&auth=" + authKey + "&id=" + getArtistId().intValue());
		System.out.println("Removed bookmark");
	}

	@Override
	public String toString() {
		return "Artist [getArtistId=" + getArtistId() + ", getArtistName=" + getArtistName() + "]";
	}
}
