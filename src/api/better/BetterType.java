
package api.better;

/**
 * The Enum BetterType.
 * The enum values are used in picking the type for
 * the better.php request
 * The type that each corresponds to is listed as a comment
 * 
 * @author Gwindow
 */
public enum BetterType {
    /** Torrents with FLAC but missing a V0 */
    TRANSCODEV0,

    /** Torrents with FLAC but missing a V2 */
    TRANSCODEV2,

    /** Torrents with FLAC but missing a 320 */
    TRANSCODE320,

    /** Torrents with FLAC but missing all 3 mp3 transcodes */
    TRANSCODEALL,

    /**
     * Torrents you've downloaded that can be transcoded
     * Not currently implemented on the site, we get back no response.
     */
    //SNATCH,

    /**
     * Torrents you've uploaded that can be transcoded
     * Not currently implemented on the site, we get back no response.
     */
    //UPLOAD,

    /**
     * Torrents marked as very bad or no tags
     * Not currently implemented on the site, we get back no response.
     */
    //TAGS,

    /**
     * Torrents marked as having bad or no folder names
     * Not currently implemented on the site, we get back no response.
     */
    //FOLDERNAMES,

    /**
     * Torrents marked as having bad file names
     * Not currently implemented on the site, we get back no response.
     */
    //FILENAMES,

	/** Single seeded FLAC torrents */
	SINGLE,

    /**
     * Torrents labeled Various Artists needing proper artist ids
     * This is currently not implemented on the site, we get back failure status
     */
    //VARIOUSARTISTS,

    /**
     * Torrents with their year as 1982 with media type CD
     * This is currently not implemented on the site, we get back failure status
     */
    //CLEANUP
}