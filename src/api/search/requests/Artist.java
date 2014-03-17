package api.search.requests;

/**
 * The Class Artist.
 * Stores information about an artist
 *
 * @author Gwindow
 */
public class Artist {
    /** The artist id */
    private String id;
	private Number nid;

	/** The artist name */
    private String name;

    /**
     * Get the artist id
     *
     * @return the id
     */
    public Number getId() {
	    if (nid == null){
		    nid = Integer.parseInt(id);
	    }
	    return nid;
    }

    /**
     * Get the artist name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Artist [getId=" + getId() + ", getName=" + getName() + "]";
    }
}
