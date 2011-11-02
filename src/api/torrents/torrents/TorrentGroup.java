package api.torrents.torrents;

public class TorrentGroup {
	private String CatalogueNumber;
	private String CategoryID;
	private String ID;
	private String Name;
	private String RecordLabel;
	private String ReleaseType;
	private String Time;
	private String VanityHouse;
	private String WikiBody;
	private String WikiImage;
	private String Year;
	private boolean hasBookmarked;

	public String getCatalogueNumber() {
		return this.CatalogueNumber;
	}

	public String getCategoryID() {
		return this.CategoryID;
	}

	public String getID() {
		return this.ID;
	}

	public String getName() {
		return this.Name;
	}

	public String getRecordLabel() {
		return this.RecordLabel;
	}

	public boolean isBookmarked() {
		return this.hasBookmarked;
	}

	public String getReleaseType() {
		if (ReleaseType.equalsIgnoreCase("1"))
			return "Album";
		else if (ReleaseType.equalsIgnoreCase("3"))
			return "Soundtrack";
		else if (ReleaseType.equalsIgnoreCase("5"))
			return "EP";
		else if (ReleaseType.equalsIgnoreCase("6"))
			return "Anthology";
		else if (ReleaseType.equalsIgnoreCase("7"))
			return "Compilation";
		else if (ReleaseType.equalsIgnoreCase("9"))
			return "Single";
		else if (ReleaseType.equalsIgnoreCase("11"))
			return "Live Album";
		else if (ReleaseType.equalsIgnoreCase("13"))
			return "Remix";
		else if (ReleaseType.equalsIgnoreCase("14"))
			return "Bootleg";
		else if (ReleaseType.equalsIgnoreCase("15"))
			return "Interview";
		else if (ReleaseType.equalsIgnoreCase("16"))
			return "Mixtape";
		else if (ReleaseType.equalsIgnoreCase("21"))
			return "Unknown";
		else
			return "API Error";

	}

	public String getTime() {
		return this.Time;
	}

	public boolean isVanityHouse() {
		if (VanityHouse.equals("1"))
			return true;
		return false;
	}

	public String getWikiBody() {
		return this.WikiBody;
	}

	public String getWikiImage() {
		return this.WikiImage;
	}

	public String getYear() {
		return this.Year;
	}

	@Override
	public String toString() {
		return "TorrentGroup [getCatalogueNumber=" + getCatalogueNumber() + ", getCategoryID=" + getCategoryID() + ", getID="
				+ getID() + ", getName=" + getName() + ", getRecordLabel=" + getRecordLabel() + ", isBookmarked="
				+ isBookmarked() + ", getReleaseType=" + getReleaseType() + ", getTime=" + getTime() + ", isVanityHouse="
				+ isVanityHouse() + ", getWikiBody=" + getWikiBody() + ", getWikiImage=" + getWikiImage() + ", getYear="
				+ getYear() + "]";
	}

}
