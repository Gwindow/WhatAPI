/**
 * @author Gwindow
 */
package api.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * All the methods needed to assist in splitting strings from html.
 * 
 * @author Tim
 */
// <a href="forums.php?action=viewthread&amp;threadid=71&amp;page=95#post3358125"></a>
public class RegexTools {

	/**
	 * Split album year.
	 * 
	 * @param string
	 *            the string
	 * @return the string
	 */
	public String splitAlbumYear(String string) {
		Pattern intsOnly = Pattern.compile("\\[\\d+\\]");
		Matcher makeMatch = intsOnly.matcher(string);
		makeMatch.find();
		String inputInt = makeMatch.group();
		inputInt = inputInt.replace("[", "");
		inputInt = inputInt.replace("]", "");
		return inputInt;
	}

	/**
	 * Split artist image url.
	 * 
	 * @param string
	 *            the string
	 * @return the string
	 */
	public String splitArtistImageUrl(String string) {
		Pattern pattern = Pattern.compile(".*src=\"(.*)\" alt.*");
		Matcher matcher = pattern.matcher(string);
		if (matcher.matches()) {
			String s = matcher.group(1);
			return s;
		}
		return null;
	}

	/**
	 * Split album url.
	 * 
	 * @param string
	 *            the string
	 * @return the string
	 */
	public String splitAlbumUrl(String string) {
		Pattern pattern = Pattern.compile(".*<a href=\"(.*)\" title.*");
		Matcher matcher = pattern.matcher(string);
		if (matcher.matches()) {
			String s = matcher.group(1);
			s = s.replace("amp;", "");
			s = "http://what.cd/" + s;
			return s;
		}
		return null;
	}

	/**
	 * Split album id.
	 * 
	 * @param string
	 *            the string
	 * @return the string
	 */
	public String splitAlbumId(String string) {
		Pattern pattern = Pattern.compile(".*id=(.*)\" title.*");
		Matcher matcher = pattern.matcher(string);
		if (matcher.matches()) {
			String s = matcher.group(1);
			return s;
		}
		return null;
	}

	/**
	 * Split artist id.
	 * 
	 * @param string
	 *            the string
	 * @return the string
	 */
	public String splitArtistId(String string) {
		Pattern pattern = Pattern.compile(".*id=(.*)\">.*");
		Matcher matcher = pattern.matcher(string);
		if (matcher.matches()) {
			String s = matcher.group(1);
			return s;
		}
		return null;
	}

	/**
	 * Split artist url.
	 * 
	 * @param string
	 *            the string
	 * @return the string
	 */
	public String splitArtistUrl(String string) {
		Pattern pattern = Pattern.compile(".*<a href=\"(.*)\">.*");
		Matcher matcher = pattern.matcher(string);
		if (matcher.matches()) {
			String s = matcher.group(1);
			s = s.replace("amp;", "");
			s = "http://what.cd/" + s;
			return s;
		}
		return null;
	}

	/**
	 * Split artist url2.
	 * 
	 * @param string
	 *            the string
	 * @return the string
	 */
	public String splitArtistUrl2(String string) {
		Pattern pattern = Pattern.compile(".*<a href=\"(.*)\" style.*");
		Matcher matcher = pattern.matcher(string);
		if (matcher.matches()) {
			String s = matcher.group(1);
			s = s.replace("amp;", "");
			s = "http://what.cd/" + s;
			return s;
		}
		return null;
	}

	/**
	 * Split the id of the format.
	 * 
	 * @param string
	 *            the string
	 * @return format id
	 */
	public String splitFormatId(String string) {
		Pattern pattern = Pattern.compile(".*torrentid=(.*)\">.*");
		Matcher matcher = pattern.matcher(string);
		if (matcher.matches()) {
			String s = matcher.group(1);
			return s;
		}
		return null;
	}

	/**
	 * Split the url of the format.
	 * 
	 * @param string
	 *            the string
	 * @return format id
	 */
	public String splitFormatUrl(String string) {
		Pattern pattern = Pattern.compile(".*<a href=\"(.*)\">.*");
		Matcher matcher = pattern.matcher(string);
		if (matcher.matches()) {
			String s = matcher.group(1);
			s = s.replace("amp;", "");
			s = "http://what.cd/" + s;
			return s;
		}
		return null;
	}

	/**
	 * Split the download link of the format.
	 * 
	 * @param string
	 *            the string
	 * @return format id
	 */
	public String splitFormatDownloadLink(String string) {
		Pattern pattern = Pattern.compile(".*<a href=\"(.*)\" title.*");
		Matcher matcher = pattern.matcher(string);
		if (matcher.matches()) {
			String s = matcher.group(1);
			s = s.replace("amp;", "");
			s = "http://what.cd/" + s;
			return s;
		}
		return null;
	}

	/**
	 * Split the url of a thread in a section.
	 * 
	 * @param string
	 *            the string
	 * @return url of thread
	 */
	public String splitThreadUrl(String string) {
		Pattern pattern = Pattern.compile(".*<a href=\"(.*)\" title.*");
		Matcher matcher = pattern.matcher(string);
		if (matcher.matches()) {
			String s = matcher.group(1);
			s = s.replace("amp;", "");
			s = "http://what.cd/" + s;
			return s;
		}
		return null;
	}

	/**
	 * Split the url of a section.
	 * 
	 * @param string
	 *            the string
	 * @return url of section
	 */
	public String splitSectionUrl(String string) {
		Pattern pattern = Pattern.compile(".*<a href=\"(.*)\" title.*");
		Matcher matcher = pattern.matcher(string);
		if (matcher.matches()) {
			String s = matcher.group(1);
			s = s.replace("amp;", "");
			s = "http://what.cd/" + s;
			return s;
		}
		return null;
	}

	/**
	 * Split the title of a section.
	 * 
	 * @param string
	 *            the string
	 * @return tile of section
	 */
	public String splitSectionTitle(String string) {
		Pattern pattern = Pattern.compile(".*>(.*)</a>.*");
		Matcher matcher = pattern.matcher(string);
		if (matcher.matches())
			return matcher.group(1);
		return null;
	}

	/**
	 * Split the last read url of a thread in a section.
	 * 
	 * @param string
	 *            the string
	 * @return url of thread
	 */
	public String splitLastReadThreadUrl(String string) {
		Pattern pattern = Pattern.compile(".*<a href=\"(.*)\".*");
		Matcher matcher = pattern.matcher(string);
		if (matcher.matches()) {
			String s = matcher.group(1);
			s = s.replace("amp;", "");
			s = "http://what.cd/" + s;
			return s;
		}
		return null;
	}

	/**
	 * Split the user in a section.
	 * 
	 * @param string
	 *            the string
	 * @return user name
	 */
	public String splitUser(String string) {
		Pattern pattern = Pattern.compile(".*>(.*)</a>.*");
		Matcher matcher = pattern.matcher(string);
		if (matcher.matches())
			return matcher.group(1);
		return null;
	}

	/**
	 * Split a string.
	 * 
	 * @param string
	 *            String to split
	 * @param from
	 *            staring at which substring
	 * @param to
	 *            ending at which substring
	 * @return the split string
	 */
	public String split(String string, String from, String to) {
		Pattern pattern = Pattern.compile(".*" + from + "(.*)" + to + ".*");
		Matcher matcher = pattern.matcher(string);
		if (matcher.matches())
			return matcher.group(1);
		return null;
	}

	/**
	 * Splits title of a thread.
	 * 
	 * @param string
	 *            the string
	 * @return title of thread
	 */
	public String splitTitle(String string) {
		Pattern pattern = Pattern.compile(".*title=\"(.*)\">.*");
		Matcher matcher = pattern.matcher(string);
		if (matcher.matches()) {
			String s = matcher.group(1);
			s = s.replace("&quot;", "");
			return s;
		}
		return null;
	}

	/**
	 * Gets the poster's name and id.
	 * 
	 * @param string
	 *            the string
	 * @return name and id
	 */
	public String[] splitPoster(String string) {
		String[] toReturn = new String[2];
		Pattern pattern1 = Pattern.compile(".*\">(.*)</a>.*");
		Matcher matcher1 = pattern1.matcher(string);
		if (matcher1.matches()) {
			;
			toReturn[0] = matcher1.group(1);
		}
		Pattern pattern2 = Pattern.compile(".*id=(.*)\">.*");
		Matcher matcher2 = pattern2.matcher(string);
		if (matcher2.matches()) {
			toReturn[1] = matcher2.group(1);
		}
		return toReturn;

	}

	/**
	 * Splits the profile text of a user.
	 * 
	 * @param string
	 *            the string
	 * @return profile text
	 */
	public String splitProfileText(String string) {
		Pattern pattern = Pattern.compile(".*<div class=\"pad\">(.*)</div>.*", Pattern.DOTALL);
		Matcher matcher = pattern.matcher(string);
		if (matcher.matches()) {
			String s = matcher.group(1);
			s = s.replace("&quot;", "");
			return s;
		}
		return null;
	}

	/**
	 * Gets the post body.
	 * 
	 * @param string
	 *            the string
	 * @return the post body
	 */
	public String splitPostBody(String string) {
		Pattern pattern = Pattern.compile(".*<div id=\"content.*\">\n(.*)</div>.*", Pattern.DOTALL);
		Matcher matcher = pattern.matcher(string);
		if (matcher.matches())
			return matcher.group(1);
		return null;
	}

	/**
	 * Splits the avatar.
	 * 
	 * @param string
	 *            the string
	 * @return the avatar url
	 */
	public String splitAvatar(String string) {
		Pattern pattern = Pattern.compile(".*<img src=\"(.*)\" width=.*", Pattern.DOTALL);
		Matcher matcher = pattern.matcher(string);
		if (matcher.matches()) {
			System.out.println(matcher.group(1));
			return matcher.group(1);
		}
		return "FAILED";
	}

	/**
	 * Split thread id.
	 * 
	 * @param url
	 *            the url
	 * @return the string
	 */
	public String splitThreadID(String url) {
		Pattern pattern = Pattern.compile(".*&threadid=(.*)&.*");
		Matcher matcher = pattern.matcher(url);
		if (matcher.matches())
			return matcher.group(1);
		else {
			pattern = Pattern.compile(".*&threadid=(.*).*");
			matcher = pattern.matcher(url);
			if (matcher.matches())
				return matcher.group(1);
		}
		return null;
	}

	/**
	 * Split auth key.
	 * 
	 * @param url
	 *            the url
	 * @return the string
	 */
	public String splitAuthKey(String url) {
		Pattern pattern = Pattern.compile(".*auth=(.*)\">.*");
		Matcher matcher = pattern.matcher(url);
		if (matcher.matches())
			return matcher.group(1);
		return null;
	}

	// TODO fix
	/**
	 * Split user id.
	 * 
	 * @param url
	 *            the url
	 * @return the string
	 */
	public String splitUserID(String url) {
		Pattern pattern = Pattern.compile(".*<li id=\"nav_userinfo\"><a href=\"user.php?id(.*)\".*");
		Matcher matcher = pattern.matcher(url);
		if (matcher.matches())
			return matcher.group(1);
		return null;
	}

	/**
	 * Split album year2.
	 * 
	 * @param string
	 *            the string
	 * @return the string
	 */
	public String splitAlbumYear2(String string) {
		Pattern pattern = Pattern.compile(".*<strong>(.*) - .*");
		Matcher matcher = pattern.matcher(string);
		if (matcher.matches()) {
			String s = matcher.group(1);
			s = s.substring(0, 4);
			return s;
		}
		return null;
	}
}
