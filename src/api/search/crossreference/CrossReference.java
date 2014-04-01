package api.search.crossreference;

import api.products.Product;
import api.products.ProductSearch;
import api.search.requests.RequestsSearch;
import api.search.torrents.TorrentSearch;
import api.soup.MySoup;
import api.util.CouldNotLoadException;
import api.util.Tuple;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

/**
 * Perform Torrent and/or Request searches based on terms determined from looking
 * up a UPC. The UPC is first checked against MusicBrainz and then Semantics3 if
 * MusicBrainz doesn't have it
 */
public class CrossReference {
	/**
	 * Run a requests search using the search terms determined for the UPC
	 */
	public static RequestsSearch requestsByUpc(String upc){
		String term = termsFromUpc(upc);
		return !term.isEmpty() ? RequestsSearch.search(term) : null;
	}

	/**
	 * Run a torrent search using the search terms determined for the UPC
	 */
	public static TorrentSearch torrentsByUpc(String upc){
		String term = termsFromUpc(upc);
		return !term.isEmpty() ? TorrentSearch.search(term) : null;
	}

	/**
	 * Run a torrent and request search for using the terms determined for the UPC
	 *
	 * @return a tuple containing both searches { torrent search, requests search }
	 */
	public static Tuple<TorrentSearch, RequestsSearch> torrentsAndRequestsByUpc(String upc){
		String term = termsFromUpc(upc);
		if (term.isEmpty()){
			return null;
		}
		return new Tuple<TorrentSearch, RequestsSearch>(TorrentSearch.search(term), RequestsSearch.search(term));
	}

	/**
	 * Determine search terms for some UPC. First tries MusicBrainz and falls back
	 * to Semantics3 if we MusicBrainz doesn't have anything
	 */
	public static String termsFromUpc(String upc){
		String term = termsFromMusicBrainz(upc);
		if (term.isEmpty()){
			System.out.println("Semantics3 Fallback");
			List<Product> products = ProductSearch.fromUPC(upc);
			//We really only get one product back for UPC searches
			if (!products.isEmpty()){
				term = products.get(0).getName();
			}
		}
		return term;
	}

	/**
	 * Query MusicBrainz for terms for some UPC
	 */
	public static String termsFromMusicBrainz(String upc){
		try {
			String response = MySoup.scrapeOther("http://www.musicbrainz.org/ws/2/release/?limit=1&query=barcode:" + upc);
			SAXParserFactory spfac = SAXParserFactory.newInstance();
			SAXParser sp = spfac.newSAXParser();
			MusicBrainzParser handler = new MusicBrainzParser();
			sp.parse(new InputSource(new StringReader(response)), handler);
			return handler.searchString;
		}
		catch (SAXException e){
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		}
		catch (CouldNotLoadException e){
			e.printStackTrace();
		}
		catch (ParserConfigurationException e){
			e.printStackTrace();
		}
		return "";
	}
}
