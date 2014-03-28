package api.user.recent;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * A recently uploaded or downloaded torrent
 */
public class RecentTorrent {
	/** The torrent group id */
	@SerializedName("ID")
	private int id;
	/** The album name */
	@SerializedName("Name")
	private String name;
	/** The URL to the torrent image (album art) */
	@SerializedName("WikiImage")
	private String wikiImage;
	/**
	 * The artist info from the API
	 */
	List<ArtistInfo> artists;

	/**
	 * Get the torrent group id
	 * @return Torrent group id
	 */
	public int getId(){
		return id;
	}

	/**
	 * Get the album name
	 * @return album name
	 */
	public String getName(){
		return name;
	}

	/**
	 * Get the URL for the album art
	 * @return album art URL
	 */
	public String getWikiImage(){
		return wikiImage;
	}


	/**
	 * Get the main artist for the album
	 *
	 * @return album artist
	 */
	public List<RecentArtist> getArtists(){
		return artists.get(0).getArtists();
	}

	@Override
	public String toString(){
		return "RecentTorrent: [id=" + id + ", name=" + name
			+ ", artist=" + getArtists() + ", wikiImage=" + wikiImage + "]";
	}

	/**
	 * Class to handle the strange API response for artist information here
	 * look at the API response if you're curious why this is the way it is
	 */
	private class ArtistInfo {
		@SerializedName("1")
		private List<RecentArtist> artists;

		/**
		 * There's only ever one entry in this list, so that's what we return
		 */
		public List<RecentArtist> getArtists(){
			return artists;
		}
	}
}
