package api.better;

import api.son.MySon;
import api.soup.MySoup;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.List;

/**
 * The Class BetterTranscode
 * For requesting and storing data from the better API
 * request for torrents that need 320/V0/V2/ALL transcodes
 * from their FLAC
 *
 * @author Twinklebear
 */
public class BetterTranscode {
    /**
     * The API response, a list of all the torrents
     * that can be improved
     */
    private List<TranscodingResponse> response;

    /** The API response status */
    private String status;

    /**
     * Init BetterTranscode: Get the list of torrents to be transcoded
     * from better
     *
     * @param betterType
     *            the of transcoding to request
     * @return an instance of Better containing the result of the request
     */
    public static BetterTranscode init(final BetterType betterType) {
        String authkey = MySoup.getAuthKey();
        String type = resolveBetterType(betterType);
        String url = "ajax.php?action=better&method=" + type + "&auth=" + authkey;
        return (BetterTranscode) MySon.toObject(url, BetterTranscode.class);
    }

    /**
     * Resolve the BetterType enum to the corresponding
     * method=? string for the API request
     * because we're required to have a default, even though no other values are
     * possible, the default returns SINGLE
     *
     * @param type
     *      The BetterType enum corresponding to the type we want
     * @return the string corresponding to the desired better method, along with
     *      any extra fields if needed
     */
    private static String resolveBetterType(final BetterType type){
        switch (type){
            case TRANSCODEV0:
                return "transcode&type=0";
            case TRANSCODEV2:
                return "transcode&type=1";
            case TRANSCODE320:
                return "transcode&type=2";
            case TRANSCODEALL:
                return "transcode&type=3";
            default:
                return "transcode&type=0";
        }
    }

    /**
     * Download all torrents that could be improved listed in
     * the Better response
     *
     * @param downloadLocation
     *            the download location
     */
    public void downloadAll(String downloadLocation) {
        for (final TranscodingResponse r : response) {
            String url = MySoup.getSite() + r.getDownloadUrl();
            String name = r.getGroupName() + " [" + r.getGroupYear().toString() + "]";
            try {
                downloadTorrent(url, downloadLocation, name);
            } catch (IOException e) {
                System.err.println("Could not download file");
            }
        }
    }

    /**
     * Download a torrent
     *
     * @param url
     *            the url to download from
     * @param path
     *            the path to save to
     * @param name
     *            the name of the file to save to
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void downloadTorrent(String url, String path, String name) throws IOException {
        URL u;
        u = new URL(url);
        ReadableByteChannel rbc = Channels.newChannel(u.openStream());
        FileOutputStream fos = new FileOutputStream(path + name + ".torrent");
        fos.getChannel().transferFrom(rbc, 0, 1 << 24);
        System.out.println("Downloaded " + name + " to " + path);
    }

    /**
     * Gets the API response
     *
     * @return the response
     */
    public List<TranscodingResponse> getResponse() {
        return this.response;
    }

    /**
     * Gets the status, True if success, False otherwise
     *
     * @return the status
     */
    public boolean getStatus() {
        return status.equalsIgnoreCase("success");
    }

    @Override
    public String toString() {
        return "Better [getResponse=" + getResponse() + ", getStatus=" + getStatus() + "]";
    }
}
