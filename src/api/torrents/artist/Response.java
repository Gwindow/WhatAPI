package api.torrents.artist;

import java.util.List;

public class Response {
	private String body;
	private boolean hasBookmarked;
	private String id;
	private String image;
	private String name;
	private boolean notificationsEnabled;
	private List<Requests> requests;
	private List<SimilarArtists> similarArtists;
	private Statistics statistics;
	private List<Tags> tags;
	private List<TorrentGroup> torrentgroup;
	private String vanityHouse;

	public String getBody() {
		return this.body;
	}

	public boolean isBookmarked() {
		return this.hasBookmarked;
	}

	public String getId() {
		return this.id;
	}

	public String getImage() {
		return this.image;
	}

	public String getName() {
		return this.name;
	}

	public boolean isNotificationsEnabled() {
		return this.notificationsEnabled;
	}

	public List<Requests> getRequests() {
		return this.requests;
	}

	public List<SimilarArtists> getSimilarArtists() {
		return this.similarArtists;
	}

	public Statistics getStatistics() {
		return this.statistics;
	}

	public List<Tags> getTags() {
		return this.tags;
	}

	public List<TorrentGroup> getTorrentgroup() {
		return this.torrentgroup;
	}

	public String getVanityHouse() {
		if (vanityHouse == null) {
			return "0";
		}
		return this.vanityHouse;

	}

	@Override
	public String toString() {
		return "Response [getBody=" + getBody() + ", isBookmarked=" + isBookmarked() + ", getId=" + getId() + ", getImage="
				+ getImage() + ", getName=" + getName() + ", isNotificationsEnabled=" + isNotificationsEnabled()
				+ ", getRequests=" + getRequests() + ", getSimilarArtists=" + getSimilarArtists() + ", getStatistics="
				+ getStatistics() + ", getTags=" + getTags() + ", getTorrentgroup=" + getTorrentgroup() + ", getVanityHouse="
				+ getVanityHouse() + "]";
	}
}
