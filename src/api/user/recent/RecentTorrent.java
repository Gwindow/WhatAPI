package api.user.recent;

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
	 * The artists field is being ignored for now b/c the response
	 * is very strange. TODO: Perhaps later
	 */

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

	@Override
	public String toString(){
		return "ID: " + ID + ", Album Name: " + Name + " Image URL: " + WikiImage;
	}
}
