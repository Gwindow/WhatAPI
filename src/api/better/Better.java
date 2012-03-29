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
 * The Class Better.
 * 
 * //TODO description
 * 
 * @author Gwindow
 */
public class Better {

	/** The response. */
	private List<Response> response;

	/** The status. */
	private String status;

	/**
	 * The Enum BetterTypes.
	 * 
	 * //TODO description
	 * 
	 * @author Gwindow
	 */
	public enum BetterTypes {

		/** The SINGLE. */
		SINGLE;
	}

	/**
	 * Inits Better.
	 * 
	 * @param types
	 *            the types
	 * @return the better
	 */
	public static Better init(final BetterTypes types) {
		String authkey = MySoup.getAuthKey();
		String type = null;
		switch (types) {
		case SINGLE:
			type = "single";
		}
		String url = "ajax.php?action=better&method=" + type + "&auth=" + authkey;
		Better better = (Better) MySon.toObject(url, Better.class);
		return better;
	}

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
	 * Download torrent.
	 * 
	 * @param url
	 *            the url
	 * @param path
	 *            the path
	 * @param name
	 *            the name
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
	 * Gets the response.
	 * 
	 * @return the response
	 */
	public List<Response> getResponse() {
		return this.response;
	}

	/**
	 * Gets the status.
	 * 
	 * @return the status
	 */
	public boolean getStatus() {
		if (status.equalsIgnoreCase("success"))
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Better [getResponse=" + getResponse() + ", getStatus=" + getStatus() + "]";
	}
}
