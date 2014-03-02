package api.torrents.artist;

import api.torrents.ReleaseType;

import java.util.*;

/**
 * A listing of the artist's releases grouped by type/contribution
 * and sorted by release date
 */
public class Releases {
	/**
	 * Releases where the artist is one of the main artists
	 */
	private SortedMap<ReleaseType, SortedSet<TorrentGroup>> releases;

	/**
	 * Types of appearances the artist has made
	 */
	public enum Appearance {
		ARTIST, GUEST, COMPOSER, CONDUCTOR, DJ, REMIXED, PRODUCER, NONE
	}

	/**
	 * Other releases the artist has appeared on
	 */
	private SortedMap<Appearance, SortedSet<TorrentGroup>> appearances;

	/**
	 * Build the releases information for some artist
	 *
	 * @param artist artist to build information for
	 */
	public Releases(Artist artist){
		List<TorrentGroup> torrents = artist.getResponse().getTorrentgroup();
		for (TorrentGroup group : torrents){
			Appearance type = group.getExtendedArtists().getAppearance(artist.getId());
			switch (type){
				case ARTIST:
					//DJ is an odd case in that we also count DJs as a main artist
				case DJ:
					addRelease(group);
					break;
				case NONE:
					//If somehow we got an album that we didn't appear on, ignore it
					break;
				default:
					addAppearance(group, type);
			}
		}
	}

	/**
	 * Add a release the artist has appeared on as a main artist
	 *
	 * @param group torrent group to add
	 */
	private void addRelease(TorrentGroup group){
		if (releases == null){
			releases = new TreeMap<ReleaseType, SortedSet<TorrentGroup>>();
		}
		ReleaseType type = group.getReleaseType();
		if (!releases.containsKey(type)){
			releases.put(type, new TreeSet<TorrentGroup>(new TorrentGroupComparator()));
		}
		releases.get(type).add(group);
	}

	/**
	 * Add a release the artist has appeared on but not as a main artist
	 *
	 * @param group torrent group to add
	 * @param type  the type of appearance made
	 */
	private void addAppearance(TorrentGroup group, Appearance type){
		if (appearances == null){
			appearances = new TreeMap<Appearance, SortedSet<TorrentGroup>>();
		}
		if (!appearances.containsKey(type)){
			appearances.put(type, new TreeSet<TorrentGroup>(new TorrentGroupComparator()));
		}
		appearances.get(type).add(group);
	}

	/**
	 * Sorting order for torrent groups (aka descending chronologically) so most
	 * recent album is first.
	 */
	private class TorrentGroupComparator implements Comparator<TorrentGroup> {
		/**
		 * @return -1 if o1.Year < o2.Year
		 * 0 if o1.Year == o2.Year
		 * 1 if o1.year > o2.Year
		 */
		@Override
		public int compare(TorrentGroup o1, TorrentGroup o2){
			int year1 = o1.getGroupYear().intValue();
			int year2 = o2.getGroupYear().intValue();
			if (year1 != year2){
				return year1 < year2 ? 1 : -1;
			}
			return o2.getGroupName().compareTo(o1.getGroupName());
		}
	}

	public SortedMap<ReleaseType, SortedSet<TorrentGroup>> getReleases(){
		return releases;
	}

	public SortedMap<Appearance, SortedSet<TorrentGroup>> getAppearances(){
		return appearances;
	}

	@Override
	public String toString(){
		return "Releases: [Releases=" + getReleases() + ", Appearances=" + getAppearances() + "]";
	}
}
