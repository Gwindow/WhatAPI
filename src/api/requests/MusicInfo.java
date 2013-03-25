package api.requests;

import java.util.List;

/**
 * The Class MusicInfo.
 * Stores data about the musicians who contributed to/recorded
 * the requested media
 * 
 * @author Gwindow
 */
public class MusicInfo {
	/** The artists. */
	private List<Artist> artists;
	
	/** The composers. */
	private List<Composer> composers;
	
	/** The conductors. */
	private List<Conductor> conductor;
	
	/** The djs. */
	private List<DJ> dj;
	
	/** Artist who remixed the media. */
	private List<RemixedBy> remixedBy;
	
	/** Other artists who were recorded with */
	private List<With> with;

	/**
	 * Get the artists.
	 * 
	 * @return the artists
	 */
	public List<Artist> getArtists() {
		return artists;
	}

	/**
	 * Get the composers.
	 * 
	 * @return the composers
	 */
	public List<Composer> getComposers() {
		return composers;
	}

	/**
	 * Get the conductors.
	 * 
	 * @return the conductor.
	 */
	public List<Conductor> getConductor() {
		return conductor;
	}

	/**
	 * Get the djs
	 * 
	 * @return the dj
	 */
	public List<DJ> getDj() {
		return dj;
	}

	/**
	 * Get the artists who remixed the media
	 * 
	 * @return the remixers
	 */
	public List<RemixedBy> getRemixedBy() {
		return remixedBy;
	}

	/**
	 * Get the other artists who were recorded with
	 * 
	 * @return the other artists who were recorded with
	 */
	public List<With> getWith() {
		return with;
	}

	@Override
	public String toString() {
		return "MusicInfo [getArtists=" + getArtists() + ", getComposers=" + getComposers() + ", getConductor=" + getConductor()
				+ ", getDj=" + getDj() + ", getRemixedBy=" + getRemixedBy() + ", getWith=" + getWith() + "]";
	}
}
