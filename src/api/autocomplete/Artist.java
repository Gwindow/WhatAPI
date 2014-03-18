package api.autocomplete;

import api.son.MySon;
import api.soup.MySoup;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * For getting auto completion suggestions for artist names from the API
 */
public class Artist {
	private String query;
	private List<Suggestion> suggestions;

	/**
	 * Get the possible artist name completions for the artist name
	 *
	 * @param name name to check completions for
	 * @return the completions for the name
	 */
	public static Artist completions(String name){
		String term;
		try {
			term = URLEncoder.encode(name, "UTF-8");
		}
		catch (UnsupportedEncodingException e){
			e.printStackTrace();
			return null;
		}
		String url = "artist.php?action=autocomplete&query=" + term
			+ "&auth=" + MySoup.getAuthKey();
		return (Artist)MySon.toObject(url, Artist.class);
	}

	public String getQuery(){
		return query;
	}

	public List<Suggestion> getSuggestions(){
		return suggestions;
	}

	public static class Suggestion {
		/**
		 * Value is the artist name suggestion and data is their id
		 */
		private String value, data;
		private Integer id;

		public String getName(){
			return value;
		}

		public Integer getId(){
			if (id == null){
				id = Integer.parseInt(data);
			}
			return id;
		}

		@Override
		public String toString(){
			return "Suggestion [value=" + value + ", data=" + data + "]";
		}
	}
}
