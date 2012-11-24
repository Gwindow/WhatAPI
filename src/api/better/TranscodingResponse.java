package api.better;

/**
 * The Class TranscodingResponse
 * Stores the information for the responses returned to us
 * via the Transcoding better API request. Similar to
 * the SINGLE Response, except that artist name is a string
 * and we have 3 extra bools for missing 320/V0/V2
 *
 * @author Twinklebear
 */
public class TranscodingResponse {
    /** The artist name */
    private String artist;

    /** The download url. */
    private String downloadUrl;

    /** The group id. */
    private Number groupId;

    /** The torrent id. */
    private Number torrentId;

    /** The group name. */
    private String groupName;

    /** The group year. */
    private Number groupYear;

    /** If the torrent is missing a 320 torrent */
    private boolean missing320;

    /** If the torrent is missing a V0 torrent */
    private boolean missingV0;

    /** If the torrent is missing a V2 torrent */
    private boolean missingV2;

    /**
     * Get the artist name
     *
     * @return the artist name
     */
    public String getArtist() {
        return this.artist;
    }

    /**
     * Gets the download url.
     *
     * @return the download url
     */
    public String getDownloadUrl() {
        return this.downloadUrl;
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
     * Gets the group year.
     *
     * @return the group year
     */
    public Number getGroupYear() {
        return this.groupYear;
    }

    /**
     * Gets the torrent id.
     *
     * @return the torrent id
     */
    public Number getTorrentId() {
        return this.torrentId;
    }

    /**
     * Check if the torrent group is missing a 320 torrent
     * Only valid if the Better API request was TRANSCODE*
     *
     * @return missing320 (True/False)
     */
    public boolean isMissing320() {
        return this.missing320;
    }

    /**
     * Check if the torrent group is missing a V0 torrent
     * Only valid if the Better API request was TRANSCODE*
     *
     * @return missingV0 (True/False)
     */
    public boolean isMissingV0() {
        return this.missingV0;
    }

    /**
     * Check if the torrent group is missing a V2 torrent
     * Only valid if the Better API request was TRANSCODE*
     *
     * @return missingV2 (True/False)
     */
    public boolean isMissingV2() {
        return this.missingV2;
    }

    @Override
    public String toString() {
        return "Response [getArtist=" + getArtist() + ", getDownloadUrl=" + getDownloadUrl() + ", getGroupId=" + getGroupId()
                + ", getGroupName=" + getGroupName() + ", getGroupYear=" + getGroupYear() + ", getTorrentId=" + getTorrentId()
                + ", isMissing320=" + isMissing320() + ", isMissingV0=" + isMissingV0() + ", isMissingV2=" + isMissingV2() + "]";
    }
}
