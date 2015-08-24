package api.collage;

import api.torrents.torrents.MusicInfo;

import java.util.Arrays;
import java.util.List;

/**
 * Holds information about a torrent group in the collage.
 * The structure is just slightly different from other areas and
 * it seems simpler to just add another data container
 * Note: For collage torrent groups we don't currently store the information about
 * all the torrents in the group since I don't plan to show this in the app and it's
 * just a huge amount of data.
 */
public class TorrentGroup {
	/**
	 * The API sends us the id of the group as a string for some reason
	 */
	private String id;
	/**
	 * The torrent group name
	 */
	private String name;
	/**
	 * Year the album or such was released
	 */
	private String year;
	/**
	 * ID of the category this album is in
	 */
	private String categoryId;
	/**
	 * Record label the album or such was released on
	 */
	private String recordLabel;
	/**
	 * Catalogue number of this release
	 */
	private String catalogueNumber;
	/**
	 * String indicating if the album is vanity house?
	 * Seems to be "0" if not vanity house, what will it be if it is?
	 */
	private String vanityHouse;
	/**
	 * String containing the tags for the torrent separated by spaces
	 */
	private String tagList;
	/**
	 * Tags parsed into a list from the tagList string of tags
	 */
	private List<String> tags;
	/**
	 * Release type of the release
	 */
	private String releaseType;
	/**
	 * URL for the album art for this release as an HTML escaped string
	 */
	private String wikiImage;
	/**
	 * Information about artists on this release
	 */
	private MusicInfo musicInfo;

	public Integer getId() {
		return Integer.parseInt(id);
	}

	public String getName() {
		return name;
	}

	public String getYear() {
		return year;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public String getRecordLabel() {
		return recordLabel;
	}

	public String getCatalogueNumber() {
		return catalogueNumber;
	}

	public String getVanityHouse() {
		return vanityHouse;
	}

	public String getTagList() {
		return tagList;
	}

	public List<String> getTags() {
		if (tags == null) {
			tags = Arrays.asList(tagList.split(" "));
		}
		return tags;
	}

	public String getReleaseType() {
		return releaseType;
	}

	public String getWikiImage() {
		return wikiImage;
	}

	public MusicInfo getMusicInfo() {
		return musicInfo;
	}

	@Override
	public String toString() {
		return "collage.TorrentGroup [ id = " + id + ", name = " + name + ", year = " + year + ", categoryId = " + categoryId
				+ ", recordLabel = " + recordLabel + ", catalogueNumber = " + catalogueNumber + ", vanityHouse = "
				+ vanityHouse + ", tagList = " + tagList + ", releaseType = " + releaseType + ", wikiImage = " + wikiImage
				+ " musicInfo = " + musicInfo + " ]\n";
	}
}
