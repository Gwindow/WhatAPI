package api.search.torrents;

public class Torrents {
	private boolean canUseToken;
	private Number editionId;
	private String encoding;
	private Number fileCount;
	private String format;
	private boolean hasCue;
	private boolean hasLog;
	private boolean isFreeleech;
	private boolean isNeutralLeech;
	private boolean isPersonalFreeleech;
	private Number leechers;
	private Number logScore;
	private String media;
	private String remasterCatalogueNumber;
	private String remasterTitle;
	private Number remasterYear;
	private boolean remastered;
	private boolean scene;
	private Number seeders;
	private Number size;
	private Number snatches;
	private String time;
	private Number torrentId;
	private boolean vanityHouse;

	public boolean getCanUseToken() {
		return this.canUseToken;
	}

	public Number getEditionId() {
		return this.editionId;
	}

	public String getEncoding() {
		return this.encoding;
	}

	public Number getFileCount() {
		return this.fileCount;
	}

	public String getFormat() {
		return this.format;
	}

	public boolean getHasCue() {
		return this.hasCue;
	}

	public boolean getHasLog() {
		return this.hasLog;
	}

	public boolean getIsFreeleech() {
		return this.isFreeleech;
	}

	public boolean getIsNeutralLeech() {
		return this.isNeutralLeech;
	}

	public boolean getIsPersonalFreeleech() {
		return this.isPersonalFreeleech;
	}

	public Number getLeechers() {
		return this.leechers;
	}

	public Number getLogScore() {
		return this.logScore;
	}

	public String getMedia() {
		return this.media;
	}

	public String getRemasterCatalogueNumber() {
		return this.remasterCatalogueNumber;
	}

	public String getRemasterTitle() {
		return this.remasterTitle;
	}

	public Number getRemasterYear() {
		return this.remasterYear;
	}

	public boolean getRemastered() {
		return this.remastered;
	}

	public boolean getScene() {
		return this.scene;
	}

	public Number getSeeders() {
		return this.seeders;
	}

	public Number getSize() {
		return this.size;
	}

	public Number getSnatches() {
		return this.snatches;
	}

	public String getTime() {
		return this.time;
	}

	public Number getTorrentId() {
		return this.torrentId;
	}

	public boolean getVanityHouse() {
		return this.vanityHouse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Torrents [getCanUseToken()=" + getCanUseToken() + ", getEditionId()=" + getEditionId() + ", getEncoding()="
				+ getEncoding() + ", getFileCount()=" + getFileCount() + ", getFormat()=" + getFormat() + ", getHasCue()="
				+ getHasCue() + ", getHasLog()=" + getHasLog() + ", getIsFreeleech()=" + getIsFreeleech()
				+ ", getIsNeutralLeech()=" + getIsNeutralLeech() + ", getIsPersonalFreeleech()=" + getIsPersonalFreeleech()
				+ ", getLeechers()=" + getLeechers() + ", getLogScore()=" + getLogScore() + ", getMedia()=" + getMedia()
				+ ", getRemasterCatalogueNumber()=" + getRemasterCatalogueNumber() + ", getRemasterTitle()=" + getRemasterTitle()
				+ ", getRemasterYear()=" + getRemasterYear() + ", getRemastered()=" + getRemastered() + ", getScene()="
				+ getScene() + ", getSeeders()=" + getSeeders() + ", getSize()=" + getSize() + ", getSnatches()=" + getSnatches()
				+ ", getTime()=" + getTime() + ", getTorrentId()=" + getTorrentId() + ", getVanityHouse()=" + getVanityHouse()
				+ "]";
	}
}
