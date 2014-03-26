package api.torrents.torrents;

import java.util.ArrayList;
import java.util.List;

/**
 * An edition and its associated torrents
 */
public class EditionTorrents {
	private Edition edition;
	/**
	 * The torrents for this edition
	 */
	private List<Torrents> torrents;

	/**
	 * Create an listing of torrents for some edition
	 * @param e edition to create for
	 */
	public EditionTorrents(Edition e){
		edition = e;
		torrents = new ArrayList<Torrents>();
	}

	public void addTorrent(Torrents t){
		torrents.add(t);
	}

	public List<Torrents> getTorrents(){
		return torrents;
	}

	public Edition getEdition(){
		return edition;
	}

	@Override
	public String toString(){
		return "EditionTorrents: [edition=" + edition + ", torrents=" + torrents + "]";
	}
}

