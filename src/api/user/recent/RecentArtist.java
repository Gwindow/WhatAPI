package api.user.recent;

/**
 * Holds information about the artist of a recently downloaded album
 */
public class RecentArtist {
	/**
	 * The API gives us back a string so we parse it and cache the result for id/aliasid
	 */
	private String id;
	/**
	 * Do we even need the aliasID? What is it?
	 */
	private int artistID = -1;
	private String name;

	/**
	 * Get the artist id
	 *
	 * @return artist id
	 */
	public int getID(){
		if (artistID == -1){
			artistID = Integer.parseInt(id);
		}
		return artistID;
	}

	/**
	 * Get the artist name
	 *
	 * @return artist name
	 */
	public String getName(){
		return name;
	}

	@Override
	public String toString(){
		return "RecentArtist: [name=" + name + ", id=" + getID() + "]";
	}
}
