package api.bookmarks;

import api.soup.MySoup;

/**
 * The Class Artist.
 * 
 * //TODO description
 * 
 * @author Gwindow
 */
public class Artist {
	// TODO enable/disable notifications for artist
	private Number artistId;
	private String artistName;

	/**
	 * Gets the artist id.
	 * 
	 * @return the artist id
	 */
	public Number getArtistId() {
		return this.artistId;
	}

	/**
	 * Gets the artist name.
	 * 
	 * @return the artist name
	 */
	public String getArtistName() {
		return this.artistName;
	}

	public void removeBookmark() {
		String authKey = MySoup.getAuthKey();
		MySoup.pressLink("bookmarks.php?action=remove&type=artist&auth=" + authKey + "&id=" + getArtistId().intValue());
		System.out.println("Removed bookmark");
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Artist [getArtistId=" + getArtistId() + ", getArtistName=" + getArtistName() + "]";
	}
}
