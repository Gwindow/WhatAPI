



package api.torrents.artist;

/**
 * The Class SimilarArtists.
 * 
 * @author Gwindow
 */
public class SimilarArtists {
	
	/** The artist id. */
	private Number artistId;
	
	/** The name. */
	private String name;
	
	/** The score. */
	private Number score;
	
	/** The similar id. */
	private Number similarId;

	/**
	 * Gets the artist id.
	 * 
	 * @return the artist id
	 */
	public Number getArtistId() {
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
	public Number getScore() {
		return this.score;
	}

	/**
	 * Gets the similar id.
	 * 
	 * @return the similar id
	 */
	public Number getSimilarId() {
		return this.similarId;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "SimilarArtists [getArtistId=" + getArtistId() + ", getName=" + getName() + ", getScore=" + getScore()
				+ ", getSimilarId=" + getSimilarId() + "]";
	}
}
