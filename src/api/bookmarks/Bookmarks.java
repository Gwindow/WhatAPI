package api.bookmarks;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.List;

import api.son.MySon;
import api.soup.MySoup;
import api.util.Tuple;

public class Bookmarks {
	private Response response;
	private String status;

	public static Bookmarks init() {
		String authkey = MySoup.getAuthKey();
		String url = "ajax.php?action=bookmarks&auth=&auth=" + authkey;
		Bookmarks bookmarks = (Bookmarks) MySon.toObject(url, Bookmarks.class);
		return bookmarks;
	}

	public Response getResponse() {
		return this.response;
	}

	/**
	 * Get the status of the request
	 * 
	 * @return true if success
	 */
	public boolean getStatus() {
		if (status.equalsIgnoreCase("success"))
			return true;
		return false;
	}

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

	private void downloadTorrent(String url, String path, String name) throws IOException {
		URL u;
		u = new URL(url);
		ReadableByteChannel rbc = Channels.newChannel(u.openStream());
		FileOutputStream fos = new FileOutputStream(path + name + ".torrent");
		fos.getChannel().transferFrom(rbc, 0, 1 << 24);
		System.out.println("Downloaded " + name + " to " + path);
	}

	@Override
	public String toString() {
		return "Bookmarks [getResponse=" + getResponse() + ", getStatus=" + getStatus() + "]";
	}
}
