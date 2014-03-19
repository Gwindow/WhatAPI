package api.autocomplete;

import api.son.MySon;
import api.soup.MySoup;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * For getting autocompletion suggestions for torrent tags from the API
 */
public class Tag {
	private String query;
	List<Suggestion> suggestions;

	/**
	 * Get the possible tag completions for the tag
	 *
	 * @param tag tag to get completions for
	 * @return the possible completions for the tag
	 */
	public static Tag completions(String tag){
		String term;
		try {
			term = URLEncoder.encode(tag, "UTF-8");
		}
		catch (UnsupportedEncodingException e){
			e.printStackTrace();
			return null;
		}
		String url = "torrents.php?action=autocomplete_tags&query=" + term
			+ "&auth=" + MySoup.getAuthKey();
		return (Tag)MySon.toObject(url, Tag.class);
	}

	public String getQuery(){
		return query;
	}

	public List<Suggestion> getSuggestions(){
		return suggestions;
	}

	public static class Suggestion {
		private String value;

		public String getValue(){
			return value;
		}

		@Override
		public String toString(){
			return "Suggestion [value=" + value + "]";
		}
	}
}
