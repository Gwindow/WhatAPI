package api.requests;

import api.torrents.torrents.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class MusicInfo.
 * Stores data about the musicians who contributed to/recorded
 * the requested media
 *
 * @author Gwindow
 */
public class MusicInfo {
	/**
	 * The artists.
	 */
	private List<Artists> artists;

	/**
	 * The composers.
	 */
	private List<Composers> composers;

	/**
	 * The conductors.
	 */
	private List<Conductor> conductor;

	/**
	 * The djs.
	 */
	private List<DJ> dj;

	/**
	 * Artist who remixed the media.
	 */
	private List<RemixedBy> remixedBy;

	/**
	 * Other artists who were recorded with
	 */
	private List<With> with;

	private List<Producer> producer;

	/**
	 * Get the artists.
	 *
	 * @return the artists
	 */
	public List<Artists> getArtists(){
		return artists;
	}

	/**
	 * Get the composers.
	 *
	 * @return the composers
	 */
	public List<Composers> getComposers(){
		return composers;
	}

	/**
	 * Get the conductors.
	 *
	 * @return the conductor.
	 */
	public List<Conductor> getConductor(){
		return conductor;
	}

	/**
	 * Get the djs
	 *
	 * @return the dj
	 */
	public List<DJ> getDj(){
		return dj;
	}

	/**
	 * Get the artists who remixed the media
	 *
	 * @return the remixers
	 */
	public List<RemixedBy> getRemixedBy(){
		return remixedBy;
	}

	/**
	 * Get the other artists who were recorded with
	 *
	 * @return the other artists who were recorded with
	 */
	public List<With> getWith(){
		return with;
	}

	public List<Producer> getProducer(){
		return producer;
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

	@Override
	public String toString(){
		return "MusicInfo [getArtists=" + getArtists() + ", getComposers=" + getComposers() + ", getConductor=" + getConductor()
			+ ", getDj=" + getDj() + ", getRemixedBy=" + getRemixedBy() + ", getWith=" + getWith() + "]";
	}
}
