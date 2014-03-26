package api.torrents.torrents;

/**
 * Some album/torrent's edition information
 */
public class Edition {
	/**
	 * The catalogue number of this edition
	 */
	private String catalogueNumber;
	/**
	 * The record label that put out this remastering
	 */
	private String recordLabel;
	/**
	 * The unique title assigned to this remaster (deluxe/Japanese edition, etc)
	 */
	private String title;
	/**
	 * The year the remaster was released
	 */
	private Number year;
	/**
	 * Media the edition was released on
	 */
	private String media;
	/**
	 * If it's actually a remaster. Will only be false for the original release
	 */
	private boolean remastered;

	/**
	 * Create the edition information for some torrent in a group. The group is required
	 * becuase in the case of an original release (non-remastered torrent) the actual
	 * edition information is stored in the group instead of on the torrent
	 *
	 * @param t torrent to get edition information from
	 * @param g group to get original release information from
	 */
	public Edition(Torrents t, Group g){
		if (t.isRemastered()){
			fromRemastered(t);
		}
		else {
			fromOriginal(t, g);
		}
	}

	public boolean equals(Edition e){
		return remastered == e.remastered && getEdition().equalsIgnoreCase(e.getEdition());
	}

	/**
	 * Build the edition information from a remastered torrent
	 */
	private void fromRemastered(Torrents t){
		catalogueNumber = t.getRemasterCatalogueNumber();
		recordLabel = t.getRemasterRecordLabel();
		title = t.getRemasterTitle();
		year = t.getRemasterYear();
		remastered = t.isRemastered();
		media = t.getMedia();
	}

	/**
	 * Build the edition information for an original release torrent
	 * in this case we need the group to get the original release info from
	 */
	private void fromOriginal(Torrents t, Group g){
		catalogueNumber = g.getCatalogueNumber();
		recordLabel = g.getRecordLabel();
		title = "Original Release";
		year = g.getYear();
		remastered = false;
		media = t.getMedia();
	}

	/**
	 * Get the pretty printed edition information. Formatting is done the same as the site
	 *
	 * @return the remaster
	 */
	public String getEdition(){
		String ed = year + " - ";
		if (!recordLabel.isEmpty()){
			ed += recordLabel + " / ";
		}
		if (!title.isEmpty()){
			ed += title + " / ";
		}
		if (!catalogueNumber.isEmpty()){
			ed += catalogueNumber + " / ";
		}
		if (!media.isEmpty()){
			ed += media;
		}
		return ed;
	}

	@Override
	public String toString(){
		return "Edition: [" + getEdition() + "]";
	}
}
