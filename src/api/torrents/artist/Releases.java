package api.torrents.artist;

import api.torrents.ReleaseType;

import java.util.*;

/**
 * A listing of the artist's releases grouped by type/contribution
 * and sorted by release date
 */
public class Releases {
	private SortedMap<ReleaseType, SortedSet<TorrentGroup>> releases;

	/**
	 * Build the releases information for some artist
	 *
	 * @param artist artist to build information for
	 */
	public Releases(Artist artist){
		releases = new TreeMap<ReleaseType, SortedSet<TorrentGroup>>();
		List<TorrentGroup> torrents = artist.getResponse().getTorrentgroup();
		for (TorrentGroup group : torrents){
			if (group.getExtendedArtists() == null){
				if (!releases.containsKey(ReleaseType.UNKNOWN)){
					releases.put(ReleaseType.UNKNOWN, new TreeSet<TorrentGroup>());
				}
				releases.get(ReleaseType.UNKNOWN).add(group);
			}
			else {
				ReleaseType appearance = group.getExtendedArtists().getAppearance(artist.getId());
				if (appearance == ReleaseType.ARTIST || appearance == ReleaseType.DJ){
					ReleaseType type = group.getReleaseType();
					if (!releases.containsKey(type)){
						releases.put(type, new TreeSet<TorrentGroup>());
					}
					releases.get(type).add(group);
				}
				else {
					if (!releases.containsKey(appearance)){
						releases.put(appearance, new TreeSet<TorrentGroup>());
					}
					releases.get(appearance).add(group);
				}
			}
		}
	}

	public SortedMap<ReleaseType, SortedSet<TorrentGroup>> getReleases(){
		return releases;
	}

	/**
	 * Get a map of the sets flattened to arrays. This is needed for random access in
	 * the list view of albums. We do still keep the ReleaseTypes so we can identify
	 * the release types as some artists don't have certain releases
	 *
	 * @return A map of array lists made from the sets
	 */
	public SortedMap<ReleaseType, ArrayList<TorrentGroup>> flatten(){
		SortedMap<ReleaseType, ArrayList<TorrentGroup>> flat = new TreeMap<ReleaseType, ArrayList<TorrentGroup>>();
		for (Map.Entry<ReleaseType, SortedSet<TorrentGroup>> e : releases.entrySet()){
			flat.put(e.getKey(), new ArrayList<TorrentGroup>(e.getValue()));
		}
		return flat;
	}

	@Override
	public String toString(){
		return "Releases: [Releases=" + getReleases() + "]";
	}
}
