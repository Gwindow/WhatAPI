package api.search.crossreference;

import api.products.Items;
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
import java.util.*;

/**
 * CrossReference is used to perform Torrent/Request searches
 * based on information received from Google Product search or
 * for UPC searching uses MusicBrainz with a fallback to Google Products
 *
 * @author Gwindow
 */
public class CrossReference {
    /** The determined search term. */
    private static String determinedSearchTerm;

    /**
     * Cross reference a Requests search by a Google product search result
     *
     * @param searchTerm
     *      the search term for the product search
     * @return the Requests search
     */
    public static RequestsSearch crossReferenceRequestsBySearchTerm(String searchTerm) {
        ProductSearch ps = ProductSearch.fromTitle(searchTerm);
        determinedSearchTerm = determineSearchString(ps.getItems());
        if (determinedSearchTerm.equals("")) {
            return null;
        }
        return RequestsSearch.requestSearchFromSearchTerm(determinedSearchTerm);
    }

    /**
     * Cross reference a Requests search by a Google product search result
     *
     * @param upc
     *      the UPC for the product search
     * @return the Requests search
     */
    public static RequestsSearch crossReferenceRequestsByUPC(String upc) {
        determinedSearchTerm = determineSearchStringByUPC(upc);
        if (determinedSearchTerm.equals("")) {
            return null;
        }
        return RequestsSearch.requestSearchFromSearchTerm(determinedSearchTerm);
    }

    /**
     * Cross reference a Torrents search by a Google product search result
     *
     * @param searchTerm
     *      the search term for the product search
     * @return the Torrent search
     */
    public static TorrentSearch crossReferenceTorrentsBySearchTerm(String searchTerm) {
        ProductSearch ps = ProductSearch.fromTitle(searchTerm);
        determinedSearchTerm = determineSearchString(ps.getItems());
        if (determinedSearchTerm.equals("")) {
            return null;
        }
        return TorrentSearch.torrentSearchFromSearchTerm(determinedSearchTerm);
    }

    /**
     * Cross reference a Torrents search by a Google product search result
     *
     * @param upc
     *      the UPC for the product search
     * @return the Torrent search
     */
    public static TorrentSearch crossReferenceTorrentsByUPC(String upc) {
        determinedSearchTerm = determineSearchStringByUPC(upc);
        if (determinedSearchTerm.equals("")) {
            return null;
        }
        return TorrentSearch.torrentSearchFromSearchTerm(determinedSearchTerm);
    }

    /**
     * Cross reference a Torrents and Requests search by a Google product search
     *
     * @param searchTerm
     *      the search term to use for the product search
     * @return a tuple containing the Torrent search (first) and the Requests search (second)
     */
    public static Tuple<TorrentSearch, RequestsSearch> crossReferenceTorrentsAndRequestsBySearchTerm(String searchTerm) {
        ProductSearch ps = ProductSearch.fromTitle(searchTerm);
        determinedSearchTerm = determineSearchString(ps.getItems());
        if (determinedSearchTerm.equals("")) {
            return null;
        }
        TorrentSearch t = TorrentSearch.torrentSearchFromSearchTerm(determinedSearchTerm);
        RequestsSearch r = RequestsSearch.requestSearchFromSearchTerm(determinedSearchTerm);
        return new Tuple<TorrentSearch, RequestsSearch>(t, r);
    }

    /**
     * Cross reference a Torrents and Requests search by a Google product search
     *
     * @param upc
     *      the UPC for the product search
     * @return a tuple containing the Torrent search (first) and the Requests search (second)
     */
    public static Tuple<TorrentSearch, RequestsSearch> crossReferenceTorrentsAndRequestsByUPC(String upc) {
        determinedSearchTerm = determineSearchStringByUPC(upc);
        if (determinedSearchTerm.equals("")) {
            return null;
        }
        TorrentSearch t = TorrentSearch.torrentSearchFromSearchTerm(determinedSearchTerm);
        RequestsSearch r = RequestsSearch.requestSearchFromSearchTerm(determinedSearchTerm);
        return new Tuple<TorrentSearch, RequestsSearch>(t, r);
    }

    /**
     * Determine search string from upc. First tries MusicBrainz then GoogleProducts
     *
     * @param upc
     * 		the associated upc
     * @return the string
     */
    public static String determineSearchStringByUPC(String upc) {
        String ss = determineSearchStringByMusicBrainz(upc);
        if (ss.equals("")) {
            ProductSearch ps = ProductSearch.fromTitle(upc);
            ss = determineSearchStringByGoogle(ps.getItems(), upc);
        }
        return ss;
    }

    /**
     * queries MusicBrainz
     *
     * @return SearchString
     * 			if fails ""
     */

    public static String determineSearchStringByMusicBrainz(String upc) {
        try {
            String response = MySoup.scrapeOther("http://www.musicbrainz.org/ws/2/release/?limit=1&query=barcode:"+ upc);
            SAXParserFactory spfac = SAXParserFactory.newInstance();
            SAXParser sp = spfac.newSAXParser();
            MusicBrainzParser handler = new MusicBrainzParser();
            sp.parse(new InputSource(new StringReader(response)), handler);
            return handler.searchString;
            //TODO: On error should we just throw something and then catch it to show a toast?
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (CouldNotLoadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "";
    }

    /*
     *	Constructs a SearchString from a Google Product query and the associated upc
     *
     *	Each result is first cleaned, then split up at " ". Each occurrence of a word is counted and all words who appears at least items-1
     *  times are added to the search string. Additionally the function tries to find the artist name, if found the words are counted
     *  to give them more weight.
     *
     */
    public static String determineSearchStringByGoogle(List<Items> items, String upc) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        String[] keywords;
        String s = "";
        String tmp, author;

        if (items != null) {
            for (Items i : items) {
                tmp = i.getProduct().getTitle().toLowerCase();
                author = determineAuthor(tmp);
                //System.out.println("Entry " + tmp + " Author: " + author);
                if (author != null) {
                    author = cleanString(author, upc);
                    keywords = author.split("\\s+");
                    for(String e : keywords) {
                        if (!map.containsKey(e)){
                            map.put(e, items.size());
                        } else {
                            map.put(e, map.get(e)+items.size());
                        }
                    }
                }

                tmp = cleanString(tmp, upc);
                keywords = tmp.split("\\s+");

                for(String e : keywords) {
                    if (!map.containsKey(e)){
                        map.put(e, 1);
                    } else {
                        map.put(e, map.get(e)+1);
                    }
                }

            }

        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() >= items.size() - 1) {
                s += entry.getKey() + " ";
            }
        }

        return s;
    }

    /**
     * Helper for determineSearchStrinByGoogleProducts
     *
     * Tries to find the artists by looking for the two common patterns "artists - title" and "artist : "
     */
    public static String determineAuthor(String s) {
        Integer i;

        for(i = 2; i < s.length()-1; i++){
            if( s.charAt(i) == '-' && s.charAt(i-1)== ' ' && s.charAt(i+1) == ' ') {
                return s.substring(0, i);
            }

            if( s.charAt(i) == ':' && s.charAt(i+1) == ' ') {
                return s.substring(0, i);
            }

        }

        return null;
    }

    /**
     * Helper for determineSearchStringByGoogleProducts
     */
    public static String cleanString(String s, String upc) {
        s = s.replace(',', ' ');
        s = s.replace('-', ' ');
        s = s.replace(':', ' ');
        s = s.replaceAll("new", "");
        s = s.replaceAll("used", "");
        s = s.replaceAll("cd","");
        s = s.replaceAll("dvd","");
        s = s.replaceAll("\\(.*\\)", "");
        s = s.replaceAll("\\[.*\\]", "");
        s = s.replaceAll("audio", "");
        s = s.replaceAll(upc, "");

        return s;
    }

    /**
     * Determine search string. This is the old version and still used for simple
     *
     * @param items
     *      the items
     * @return the string
     */
    public static String determineSearchString(List<Items> items) {
        StringTokenizer tokenizer;
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<String> combinations = new ArrayList<String>();
        String shortestString = "";
        int length = 0;
        if (items == null) {
            return "";
        }
        for (int i = 0; i < items.size(); i++) {
            if (i == 0) {
                length = items.get(i).getProduct().getTitle().length();
                shortestString = items.get(i).getProduct().getTitle();
            } else {
                if (items.get(i).getProduct().getTitle().length() < length) {
                    length = items.get(i).getProduct().getTitle().length();
                    shortestString = items.get(i).getProduct().getTitle();
                }
            }
        }
        tokenizer = new StringTokenizer(shortestString);
        while (tokenizer.hasMoreTokens()) {
            String s = tokenizer.nextToken();
            words.add(s);
        }

        for (int i = 0; i < words.size(); i++) {
            String s = "";
            for (int j = 0; j <= i; j++) {
                if (j != 0) {
                    s += " " + words.get(j);
                } else {
                    s += words.get(j);
                }
            }
            combinations.add(s);
        }

        int k = 0;
        for (int i = 0; i < combinations.size(); i++) {
            for (Items itm : items){
                String title = itm.getProduct().getTitle().toLowerCase();
                String phrase = combinations.get(i).toLowerCase();
                if (title.contains(phrase)) {
                    k = i;
                }
            }
        }

        return combinations.get(k);
    }

    /**
     * Gets the determined search term.
     *
     * @return the determined search term
     */
    public static String getDeterminedSearchTerm() {
        return determinedSearchTerm;
    }
}
