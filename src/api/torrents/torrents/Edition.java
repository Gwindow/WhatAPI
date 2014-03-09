package api.torrents.torrents;

import java.util.ArrayList;
import java.util.List;

/**
 * Information about an album edition, or remaster as they're
 * called by the API
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
	 * The torrents for this edition
	 */
	private List<Torrents> torrents;

	/**
	 * Set the edition information based on the torrent passed
	 * Note: t won't be added to the torrents list
	 *
	 * @param t torrent to copy edition information from
	 */
	public Edition(Torrents t){
		catalogueNumber = t.getRemasterCatalogueNumber();
		recordLabel = t.getRemasterRecordLabel();
		title = t.getRemasterTitle();
		year = t.getRemasterYear();
		remastered = t.isRemastered();
		media = t.getMedia();
		torrents = new ArrayList<Torrents>();
	}

	/**
	 * Set the edition information based on the torrent group passed
	 * this should be used for non-remastered/original release torrents since
	 * the release information is on the torrent group instead of the torrent
	 * No torrents from g will be added to the list
	 *
	 * @param g group to get edition information from
	 */
	public Edition(Group g){
		catalogueNumber = g.getCatalogueNumber();
		recordLabel = g.getRecordLabel();
		title = "Original Release";
		year = g.getYear();
		remastered = false;
		torrents = new ArrayList<Torrents>();
		//The Original Release holds the media information on the Torrent though, so we
		//need to wait til a torrent is added to figure this out
		media = null;
	}

	/**
	 * Check if this torrent is the same edition as some other one
	 *
	 * @param t other torrent to compare
	 * @return true if the torrents are part of the same edition of the album
	 */
	public boolean sameEdition(Torrents t){
		return remastered == t.isRemastered() && getEdition().equals(t.getRemaster());
	}

	/**
	 * Add a torrent to this edition
	 *
	 * @param t torrent to add
	 */
	public void addTorrent(Torrents t){
		if (media == null){
			media = t.getMedia();
		}
		torrents.add(t);
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

	public String getRecordLabel(){
		return recordLabel;
	}

	public String getTitle(){
		return title;
	}

	public String getCatalogueNumber(){
		return catalogueNumber;
	}

	public Number getYear(){
		return year;
	}

	public boolean isRemastered(){
		return remastered;
	}

	public List<Torrents> getTorrents(){
		return torrents;
	}

	@Override
	public String toString(){
		return "Edition: " + getEdition();
	}
}

