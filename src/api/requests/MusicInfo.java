package api.requests;

import java.util.List;

/**
 * The Class MusicInfo.
 * 
 * //TODO description
 * 
 * @author Gwindow
 */
public class MusicInfo {
	
	/** The artists. */
	private List<Artists> artists;
	
	/** The composers. */
	private List<Composers> composers;
	
	/** The conductor. */
	private List<Conductors> conductor;
	
	/** The dj. */
	private List<DJ> dj;
	
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
	public List<Conductors> getConductor() {
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

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "MusicInfo [getArtists=" + getArtists() + ", getComposers=" + getComposers() + ", getConductor=" + getConductor()
				+ ", getDj=" + getDj() + ", getRemixedBy=" + getRemixedBy() + ", getWith=" + getWith() + "]";
	}
}
