package api.better;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.List;

import api.son.MySon;
import api.soup.MySoup;

/**
 * The Class Better
 * For getting the information from better.php
 * through the API. Currently this class can only
 * handle the response returned for Single seeded FLAC
 * 
 * @author Gwindow
 */
public class Better {
    /**
     * The API response, a list of all the torrents
     * that can be improved
     */
	private List<Response> response;

	/** The API response status */
	private String status;

    /**
     * Init BetterSingle: Get the list of single seeded FLAC torrents
     * from better.php
     *
     * @param betterType
     *      The type of better response to get. Currently only supports SINGLE
     *      for Transcoding use BetterTranscode
     *
     * @return an instance of Better containing the result of the request
     */
	public static Better init(final BetterType betterType) {
		String authkey = MySoup.getAuthKey();
        //Only compatible with SINGLE atm
		//String type = resolveBetterType(betterType);
		String url = "ajax.php?action=better&method=" + "single" + "&auth=" + authkey;
		return (Better) MySon.toObject(url, Better.class);
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
    /*
    protected static String resolveBetterType(final BetterType type){
        switch (type){
            case TRANSCODEV0:
                return "transcode&type=0";
            case TRANSCODEV2:
                return "transcode&type=1";
            case TRANSCODE320:
                return "transcode&type=2";
            case TRANSCODEALL:
                return "transcode&type=3";
            case SNATCH:
                return "snatch";
            case UPLOAD:
                return "upload";
            case TAGS:
                return "tags&filter=all";
            case FOLDERNAMES:
                return "folders";
            case FILENAMES:
                return "files";
            case SINGLE:
                return "single";
            case VARIOUSARTISTS:
                return "va";
            case CLEANUP:
                return "cleanup";
            default:
                return "single";
        }
    }
    */

	/**
	 * Download all torrents that could be improved listed in
     * the Better response
	 * 
	 * @param downloadLocation
	 *            the download location
	 */
	public void downloadAll(String downloadLocation) {
		for (final Response r : response) {
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
	public List<Response> getResponse() {
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
