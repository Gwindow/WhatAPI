package api.torrents.torrents;

import api.son.MySon;
import api.soup.MySoup;

/**
 * A standalone torrent request. contains information about the group the torrent
 * is in and the torrent itself
 */
public class Torrent {
	private String status;
	private String error;
	private Response response;

	public static Torrent fromId(int id){
		String url = "ajax.php?action=torrent&id=" + id + "&auth=" + MySoup.getAuthKey();
		return (Torrent)MySon.toObject(url, Torrent.class);
	}

	public boolean getStatus(){
		return status.equalsIgnoreCase("success");
	}

	public String getError(){
		return error;
	}

	public Group getGroup(){
		return response.group;
	}

	public Torrents getTorrent(){
		return response.torrent;
	}

	@Override
	public String toString(){
		return "Torrent [group=" + response.group + ", torrent=" + response.torrent + "]";
	}

	/**
	 * The API response returned for a single torrent
	 */
	private static class Response {
		/**
		 * Information about the group the torrent is in
		 */
		public Group group;
		/**
		 * The torrent itself
		 */
		public Torrents torrent;
	}
}
