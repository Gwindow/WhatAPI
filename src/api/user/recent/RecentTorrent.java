package api.user.recent;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * A recently uploaded or downloaded torrent
 */
public class RecentTorrent {
	/** The torrent group id */
	private int ID;
	/** The album name */
	private String Name;
	/** The URL to the torrent image (album art) */
	private String WikiImage;
	/**
	 * The artist info from the API
	 */
	List<ArtistInfo> artists;

	/**
	 * Get the torrent group id
	 * @return Torrent group id
	 */
	public int getID(){
		return ID;
	}

	/**
	 * Get the album name
	 * @return album name
	 */
	public String getName(){
		return Name;
	}

	/**
	 * Get the URL for the album art
	 * @return album art URL
	 */
	public String getWikiImage(){
		return WikiImage;
	}


	/**
	 * Get the main artist for the album
	 *
	 * @return album artist
	 */
	public RecentArtist getArtist(){
		return artists.get(0).getArtist();
	}

	@Override
	public String toString(){
		return "ID: " + ID + ", Album Name: " + Name
			+ ", Artist: " + getArtist() + ", Image URL: " + WikiImage;
	}

	/**
	 * Class to handle the strange API response for artist information here
	 * look at the API response if you're curious why this is the way it is
	 */
	private class ArtistInfo {
		@SerializedName("1")
		private List<RecentArtist> artist;

		/**
		 * There's only ever one entry in this list, so that's what we return
		 */
		public RecentArtist getArtist(){
			return artist.get(0);
		}
	}
}
