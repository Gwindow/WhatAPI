package api.torrents.torrents;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class MusicInfo.
 * 
 * @author Gwindow
 * @since Jun 2, 2012 12:17:18 AM
 */
public class MusicInfo {
	
	/** The artists. */
	private List<Artists> artists;
	
	/** The composers. */
	private List<Composers> composers;
	
	/** The conductor. */
	private List<Conductor> conductor;
	
	/** The dj. */
	private List<DJ> dj;
	
	/** The producer. */
	private List<Producer> producer;
	
	/** The remixed by. */
	private List<RemixedBy> remixedBy;
	
	/** The with. */
	private List<With> with;

	/**
	 * Gets the artists.
	 * 
	 * @return the artists
	 */
	public List<Artists> getArtists() {
		return this.artists;
	}

	/**
	 * Gets the composers.
	 * 
	 * @return the composers
	 */
	public List<Composers> getComposers() {
		return this.composers;
	}

	/**
	 * Gets the conductor.
	 * 
	 * @return the conductor
	 */
	public List<Conductor> getConductor() {
		return this.conductor;
	}

	/**
	 * Gets the dj.
	 * 
	 * @return the dj
	 */
	public List<DJ> getDj() {
		return this.dj;
	}

	/**
	 * Gets the producer.
	 * 
	 * @return the producer
	 */
	public List<Producer> getProducer() {
		return this.producer;
	}

	/**
	 * Gets the remixed by.
	 * 
	 * @return the remixed by
	 */
	public List<RemixedBy> getRemixedBy() {
		return this.remixedBy;
	}

	/**
	 * Gets the with.
	 * 
	 * @return the with
	 */
	public List<With> getWith() {
		return this.with;
	}

	/**
	 * Get a list containing all the artists who appeared on the torrent group
	 *
	 * @return all the artists on the torrent group
	 */
	public List<Artist> getAllArtists(){
		List<Artist> allArtists = new ArrayList<Artist>();
		for (Artists a : artists){
			allArtists.add(new Artist(a.getId(), a.getName(), Artist.Type.ARTIST));
		}
		for (With w : with){
			allArtists.add(new Artist(w.getId(), w.getName(), Artist.Type.GUEST));
		}
		for (DJ d : dj){
			allArtists.add(new Artist(d.getId(), d.getName(), Artist.Type.DJ));
		}
		for (Producer p : producer){
			allArtists.add(new Artist(p.getId(), p.getName(), Artist.Type.PRODUCER));
		}
		for (RemixedBy r : remixedBy){
			allArtists.add(new Artist(r.getId(), r.getName(), Artist.Type.REMIXER));
		}
		for (Composers c : composers){
			allArtists.add(new Artist(c.getId(), c.getName(), Artist.Type.COMPOSER));
		}
		for (Conductor c : conductor){
			allArtists.add(new Artist(c.getId(), c.getName(), Artist.Type.CONDUCTOR));
		}
		return allArtists;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "MusicInfo [getArtists()=" + getArtists() + ", getComposers()=" + getComposers() + ", getConductor()="
				+ getConductor() + ", getDj()=" + getDj() + ", getProducer()=" + getProducer() + ", getRemixedBy()="
				+ getRemixedBy() + ", getWith()=" + getWith() + "]";
	}
}
