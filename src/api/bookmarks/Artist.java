package api.bookmarks;

/**
 * The Class Artist.
 * 
 * //TODO description
 * 
 * @author Gwindow
 */
public class Artist {
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

	@Override
	public String toString() {
		return "Artist [getArtistId=" + getArtistId() + ", getArtistName=" + getArtistName() + "]";
	}
}
