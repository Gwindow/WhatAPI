/**
 * @author Gwindow
 */
package api.torrents.artist;

/**
 * The Class SimilarArtists.
 */
public class SimilarArtists {
	private String artistId;
	private String name;
	private String score;
	private String similarId;

	/**
	 * Gets the artist id.
	 * 
	 * @return the artist id
	 */
	public String getArtistId() {
		return this.artistId;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the score.
	 * 
	 * @return the score
	 */
	public String getScore() {
		return this.score;
	}

	/**
	 * Gets the similar id.
	 * 
	 * @return the similar id
	 */
	public String getSimilarId() {
		return this.similarId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SimilarArtists [getArtistId=" + getArtistId() + ", getName=" + getName() + ", getScore=" + getScore()
				+ ", getSimilarId=" + getSimilarId() + "]";
	}
}
