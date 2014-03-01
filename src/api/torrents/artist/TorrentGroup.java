package api.torrents.artist;

import api.requests.RemixedBy;
import api.torrents.torrents.*;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * The Class TorrentGroup.
 * 
 * @author Gwindow
 */
public class TorrentGroup {
	/** The group catalogue number. */
	private String groupCatalogueNumber;

	/** The group id. */
	private Number groupId;

	/** The group name. */
	private String groupName;

	/** The group record label. */
	private String groupRecordLabel;

	/** The image for the torrent group */
	private String wikiImage;

	/** The group vanity house. */
	private boolean groupVanityHouse;

	/** The group year. */
	private Number groupYear;

	/** The is bookmarked. */
	private boolean isBookmarked;

	/** The release type. */
	private Number releaseType;

	/** The tags. */
	private List<String> tags;

	/** The torrent. */
	private List<Torrent> torrent;

	/** Extended artist information */
	private ExtendedArtists extendedArtists;

	/**
	 * Gets the group catalogue number.
	 * 
	 * @return the group catalogue number
	 */
	public String getGroupCatalogueNumber() {
		return this.groupCatalogueNumber;
	}

	/**
	 * Gets the group id.
	 * 
	 * @return the group id
	 */
	public Number getGroupId() {
		return this.groupId;
	}

	/**
	 * Gets the group name.
	 * 
	 * @return the group name
	 */
	public String getGroupName() {
		return this.groupName;
	}

	/**
	 * Gets the group record label.
	 * 
	 * @return the group record label
	 */
	public String getGroupRecordLabel() {
		return this.groupRecordLabel;
	}

	/**
	 * Get the torrent group image
	 *
	 * @return torrent group image
	 */
	public String getWikiImage(){
		return wikiImage;
	}

	/**
	 * Checks if is group vanity house.
	 * 
	 * @return true, if is group vanity house
	 */
	public boolean isGroupVanityHouse() {
		return this.groupVanityHouse;
	}

	/**
	 * Gets the group year.
	 * 
	 * @return the group year
	 */
	public Number getGroupYear() {
		return this.groupYear;
	}

	/**
	 * Checks if is bookmarked.
	 * 
	 * @return true, if is bookmarked
	 */
	public boolean isBookmarked() {
		return this.isBookmarked;
	}

	/**
	 * Gets the release type.
	 * 
	 * @return the release type
	 */
	public String getReleaseType() {
		switch (releaseType.intValue()){
			case 1:
				return "Album";
			case 3:
				return "Soundtrack";
			case 5:
				return "EP";
			case 6:
				return "Anthology";
			case 7:
				return "Compilation";
			case 9:
				return "Single";
			case 11:
				return "Live Album";
			case 13:
				return "Remix";
			case 14:
				return "Bootleg";
			case 15:
				return "Interview";
			case 16:
				return "Mixtape";
			case 21:
				return "Unknown";
			default:
				return "API Error";
		}
	}

	/**
	 * Gets the tags.
	 * 
	 * @return the tags
	 */
	public List<String> getTags() {
		return this.tags;
	}

	/**
	 * Get the extended artist information
	 * @return extended artists
	 */
	public ExtendedArtists getExtendedArtists(){
		return extendedArtists;
	}

	/**
	 * Gets the torrents.
	 * 
	 * @return the torrents
	 */
	public List<Torrent> getTorrents() {
		return this.torrent;
	}

	@Override
	public String toString() {
		return "Torrentgroup [getGroupCatalogueNumber=" + getGroupCatalogueNumber() + ", getGroupId=" + getGroupId()
			+ ", getGroupName=" + getGroupName() + ", getGroupRecordLabel=" + getGroupRecordLabel()
			+ ", wikiImage=" + getWikiImage() + ", getGroupVanityHouse=" + isGroupVanityHouse() + ", getGroupYear=" + getGroupYear() + ", isBookmarked="
			+ isBookmarked() + ", getreleaseType.toString()=" + getReleaseType() + ", getTags=" + getTags() + ", extendedArtists=" + getExtendedArtists()
			+ ", getTorrents=" + getTorrents() + "]";
	}

	/**
	 * The API gives us information about all the extended artists from which we can infer this artists contribution
	 * ie. main, guest, dj, etc. but it doesn't make it easy on us. The classes below make an attempt to wrap up
	 * the puzzling extendedArtists portion of the response and make it more usable
	 */
	public class ExtendedArtists {
		/** Main artists */
		@SerializedName("1")
		public List<Artists> artists;

		/** Guest artists */
		@SerializedName("2")
		public List<With> with;

		@SerializedName("3")
		public List<RemixedBy> remixers;

		@SerializedName("4")
		public List<Composers> composers;

		@SerializedName("5")
		public List<Conductor> conductors;

		@SerializedName("6")
		public List<DJ> djs;

		@SerializedName("7")
		public List<Producer> producers;

		@Override
		public String toString(){
			return "Extended Artists: [Artists = " + artists
				+ ", Guests = " + with + ", Remixers = " + remixers
				+ ", Composers: = " + composers + ", Conductors = " + conductors
				+ ", DJs = " + djs + ", Producers = " + producers + "]";
		}
	}
}
