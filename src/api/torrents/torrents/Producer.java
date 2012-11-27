package api.torrents.torrents;

/**
 * The Class Producer.
 * 
 * @author Gwindow
 * @since Jun 2, 2012 12:17:19 AM
 */
public class Producer{

    /** The id. */
    private Number id;

    /** The name. */
    private String name;

    /**
    * Gets the id.
    *
    * @return the id
    */
    public Number getId(){
        return this.id;
    }

    /**
    * Sets the id.
    *
    * @param id
    *            the new id
    */
    public void setId(Number id){
        this.id = id;
    }

    /**
    * Gets the name.
    *
    * @return the name
    */
    public String getName(){
        return this.name;
    }

    /**
    * Sets the name.
    *
    * @param name
    *            the new name
    */
    public void setName(String name){
        this.name = name;
    }
}
