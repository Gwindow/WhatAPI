/*
 * 
 */
package api.torrents.torrents;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;

import api.son.MySon;
import api.soup.MySoup;
import api.util.Tuple;

/**
 * The Class Torrents.
 * 
 * @author Gwindow
 */
public class TorrentGroup {

	/** The response. */
	private Response response;

	/** The status. */
	private String status;

	/** The id. */
	private static transient int id;

	/**
	 * create the Torrents.
	 * 
	 * @param id
	 *            the id of the torrent group
	 * @return Torrents
	 */
	public static TorrentGroup torrentGroupFromId(int id) {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=torrentgroup&id=" + id + "&auth=" + authkey;
		TorrentGroup torrents = (TorrentGroup) MySon.toObject(url, TorrentGroup.class);
		TorrentGroup.id = id;
		return torrents;
	}

	/**
	 * the id of the torrent group.
	 * 
	 * @return the torrent group id
	 */
	public static int getId() {
		return id;
	}

	/**
	 * Checks for free leech.
	 * 
	 * @return true, if successful
	 */
	public boolean hasFreeLeech() {
		for (int i = 0; i < getResponse().getTorrents().size(); i++) {
			if (getResponse().getTorrents().get(i).isFreeTorrent())
				return true;
		}
		return false;
	}

	/**
	 * Get the response containing the torrentgroup information.
	 * 
	 * @return response
	 */
	public Response getResponse() {
		return this.response;
	}

	/**
	 * Adds the bookmark.
	 * 
	 * @return the status
	 */
	public boolean addBookmark() {
        String authKey = MySoup.getAuthKey();
        if (!response.getGroup().isBookmarked()){
            boolean success = MySoup.pressLink("bookmarks.php?action=add&type=torrent&auth=" + authKey + "&id=" + id);
            if (success){
                response.getGroup().setBookmarked(true);
                return true;
            }
            return false;
        }
        //If it's already bookmarked, just say we succeeded
        return true;
    }
	 /**
	 * Removes the bookmark.
	 */
	public boolean removeBookmark() {
        String authKey = MySoup.getAuthKey();
        if (response.getGroup().isBookmarked()){
            boolean success = MySoup.pressLink("bookmarks.php?action=remove&type=torrent&auth=" + authKey + "&id=" + id);
            if (success){
                response.getGroup().setBookmarked(false);
                return true;
            }
            else
                return false;
        }
        //If it's already not bookmarked, just say we succeeded
        return true;
    }

	/**
	 * Get the status of the request.
	 * 
	 * @return true if success
	 */
	public boolean getStatus() {
        return status.equalsIgnoreCase("success");
	}

	/**
	 * Gets the download links list.
	 * 
	 * @return the download links list
	 */
	public List<Tuple<String, String>> getDownloadLinksList() {
		List<Tuple<String, String>> list = new ArrayList<Tuple<String, String>>();
		for (Torrents t : response.getTorrents()) {
			String name = t.getFilePath();
			if (t.getFilePath().equalsIgnoreCase("") || t.getFilePath().equals(null)) {
				name = response.getGroup().getName() + " - " + response.getGroup().getYear()
                        + " (" + t.getMediaFormatEncoding() + ")";
			}
			list.add(new Tuple<String, String>(t.getDownloadLink(), name));
		}
		return list;
	}

	/**
	 * Gets the download links list for.
	 * 
	 * @param formatList
	 *            the format list
	 * @return the download links list for
	 */
	public List<Tuple<String, String>> getDownloadLinksListFor(String[] formatList) {
		List<Tuple<String, String>> list = new ArrayList<Tuple<String, String>>();
		for (Torrents t : response.getTorrents()) {
			for (int i = 0; i < formatList.length; i++) {
				if (formatList[i].equalsIgnoreCase(t.getFormat())) {
					String name = t.getFilePath();
					if (t.getFilePath().equalsIgnoreCase("") || t.getFilePath().equals(null)) {
						name =
								response.getGroup().getName() + " - " + response.getGroup().getYear() + " ("
										+ t.getMediaFormatEncoding() + ")";
					}
					list.add(new Tuple<String, String>(t.getDownloadLink(), name));
				}
			}
		}
		return list;
	}

	/**
	 * Gets the download links list except.
	 * 
	 * @param formatList
	 *            the format list
	 * @return the download links list except
	 */
	public List<Tuple<String, String>> getDownloadLinksListExcept(String[] formatList) {
		List<Tuple<String, String>> list = new ArrayList<Tuple<String, String>>();
		for (Torrents t : response.getTorrents()) {
			for (int i = 0; i < formatList.length; i++) {
				if (!formatList[i].equalsIgnoreCase(t.getFormat())) {
					String name = t.getFilePath();
					if (t.getFilePath().equalsIgnoreCase("") || t.getFilePath().equals(null)) {
						name =
								response.getGroup().getName() + " - " + response.getGroup().getYear() + " ("
										+ t.getMediaFormatEncoding() + ")";
					}
					list.add(new Tuple<String, String>(t.getDownloadLink(), name));
				}
			}
		}
		return list;
	}

	/**
	 * Download list.
	 * 
	 * @param list
	 *            the list
	 * @param path
	 *            the path
	 */
	public void downloadList(List<Tuple<String, String>> list, String path) {
		for (Tuple<String, String> t : list) {
			try {
				downloadTorrent(t.getA(), path, t.getB());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
	 * Gets the spotify url.
	 * 
	 * @return the spotify url
	 */
	public String getSpotifyUrl() {
		try {
			return "spotify:" + URLEncoder.encode(getResponse().getGroup().getName(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.err.println("Could not encode url");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Gets the last fm url.
	 * 
	 * @return the last fm url
	 */
	public String getLastFMUrl() {
		String s;
		try {
			s = "http://www.last.fm/search?q=" + URLEncoder.encode(getResponse().getGroup().getName(), "UTF-8") + "&type=album";
		} catch (UnsupportedEncodingException e) {
			s = "http://www.last.fm/";
			e.printStackTrace();
		}
		return s;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Torrents [id =" + id + ", response=" + response + ", status=" + status + "]";
	}
}
