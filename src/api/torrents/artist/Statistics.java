package api.torrents.artist;


public class Statistics {
	private Number numGroups;
	private Number numLeechers;
	private Number numSeeders;
	private Number numSnatches;
	private Number numTorrents;

	public Number getNumGroups() {
		return this.numGroups;
	}

	public Number getNumLeechers() {
		return this.numLeechers;
	}

	public Number getNumSeeders() {
		return this.numSeeders;
	}

	public Number getNumSnatches() {
		return this.numSnatches;
	}

	public Number getNumTorrents() {
		return this.numTorrents;
	}

	@Override
	public String toString() {
		return "Statistics [getNumGroups=" + getNumGroups() + ", getNumLeechers=" + getNumLeechers() + ", getNumSeeders="
				+ getNumSeeders() + ", getNumSnatches=" + getNumSnatches() + ", getNumTorrents=" + getNumTorrents() + "]";
	}
}
