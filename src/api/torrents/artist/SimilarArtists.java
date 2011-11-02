package api.torrents.artist;

public class SimilarArtists {
	private String artistId;
	private String name;
	private String score;
	private String similarId;

	public String getArtistId() {
		return this.artistId;
	}

	public String getName() {
		return this.name;
	}

	public String getScore() {
		return this.score;
	}

	public String getSimilarId() {
		return this.similarId;
	}

	@Override
	public String toString() {
		return "SimilarArtists [getArtistId=" + getArtistId() + ", getName=" + getName() + ", getScore=" + getScore()
				+ ", getSimilarId=" + getSimilarId() + "]";
	}
}
