package api.torrents.torrents;

import java.util.List;

public class Response {
	private TorrentGroup group;
	private List<Torrent> torrents;

	public TorrentGroup getGroup() {
		return this.group;
	}

	public List<Torrent> getTorrents() {
		return this.torrents;
	}

	@Override
	public String toString() {
		return "Response [getGroup=" + getGroup() + ", getTorrents=" + getTorrents() + "]";
	}

}
