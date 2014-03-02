package api.torrents.artist;

import api.torrents.ReleaseType;
import api.torrents.torrents.Artists;
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
	 * Get the release type.
	 * 
	 * @return the release type
	 */
	public ReleaseType getReleaseType(){
		switch (releaseType.intValue()){
			case 1:
				return ReleaseType.ALBUM;
			case 3:
				return ReleaseType.SOUNDTRACK;
			case 5:
				return ReleaseType.EP;
			case 6:
				return ReleaseType.ANTHOLOGY;
			case 7:
				return ReleaseType.COMPILATION;
			case 8:
				return ReleaseType.DJ_MIX;
			case 9:
				return ReleaseType.SINGLE;
			case 11:
				return ReleaseType.LIVE_ALBUM;
			case 13:
				return ReleaseType.REMIX;
			case 14:
				return ReleaseType.BOOTLEG;
			case 15:
				return ReleaseType.INTERVIEW;
			case 16:
				return ReleaseType.MIXTAPE;
			case 22:
				return ReleaseType.CONCERT_RECORDING;
			default:
				return ReleaseType.UNKNOWN;
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
		public List<Artists> guest;

		@SerializedName("3")
		public List<Artists> remixers;

		@SerializedName("4")
		public List<Artists> composers;

		@SerializedName("5")
		public List<Artists> conductors;

		@SerializedName("6")
		public List<Artists> djs;

		@SerializedName("7")
		public List<Artists> producers;

		/**
		 * Find the type of appearance some artist made on this recording
		 * I'm not sure if there's much we can do to make this nicer due to how
		 * the api is currently structured. Fortunately all these lists will
		 * be reasonably short so it shouldn't be too bad
		 *
		 * @param id artist id to find
		 * @return type of appearance made by artist
		 */
		public Releases.Appearance getAppearance(int id){
			if (artists != null){
				for (Artists a : artists){
					if (id == a.getId().intValue()){
						return Releases.Appearance.ARTIST;
					}
				}
			}
			if (guest != null){
				for (Artists w : guest){
					if (id == w.getId().intValue()){
						return Releases.Appearance.GUEST;
					}
				}
			}
			if (remixers != null){
				for (Artists r : remixers){
					if (id == r.getId().intValue()){
						return Releases.Appearance.REMIXED;
					}
				}
			}
			if (composers != null){
				for (Artists c : composers){
					if (id == c.getId().intValue()){
						return Releases.Appearance.COMPOSER;
					}
				}
			}
			if (conductors != null){
				for (Artists c : conductors){
					if (id == c.getId().intValue()){
						return Releases.Appearance.CONDUCTOR;
					}
				}
			}
			if (djs != null){
				for (Artists d : djs){
					if (id == d.getId().intValue()){
						return Releases.Appearance.DJ;
					}
				}
			}
			if (producers != null){
				for (Artists p : producers){
					if (id == p.getId().intValue()){
						return Releases.Appearance.PRODUCER;
					}
				}
			}
			return Releases.Appearance.NONE;
		}

		@Override
		public String toString(){
			return "Extended Artists: [Artists = " + artists
				+ ", Guests = " + guest + ", Remixers = " + remixers
				+ ", Composers: = " + composers + ", Conductors = " + conductors
				+ ", DJs = " + djs + ", Producers = " + producers + "]";
		}
	}
}
