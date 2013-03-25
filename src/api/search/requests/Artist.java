package api.search.requests;

/**
 * The Class Artist.
 * Stores information about an artist
 *
 * @author Gwindow
 */
public class Artist {
    /** The artist id */
    private Number id;

    /** The artist name */
    private String name;

    /**
     * Get the artist id
     *
     * @return the id
     */
    public Number getId() {
        return id;
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
