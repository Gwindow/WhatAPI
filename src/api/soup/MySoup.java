package api.soup;

import api.index.Index;
import api.util.CouldNotLoadException;
import api.util.Tuple;
import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.*;
import java.util.List;

/**
 * Provides interaction with the site and external sites if desired
 * User must set site prior to usage
 *
 * @author Gwindow
 */
public class MySoup {
	/**
	 * The main site to make requests too
	 */
	private static String site;
	/**
	 * The user agent to set in connections
	 */
	private static String userAgent;
	/**
	 * The cookie manager used to save/load user cookies
	 */
	private static CookieManager cookieManager;
	/**
	 * The site index.
	 */
	private static Index index;
	private static boolean sslEnabled = true;
	private static boolean notificationsEnabled = true;

	/**
	 * Set the url of the gazelle site. An IllegalState exception will be thrown if any
	 * site requests are made prior to the site being set. SSL enabling defaults to true
	 * so https will be used in this case
	 *
	 * @param url url of the site following this format, http://website.com/
	 */
	public static void setSite(String url){
		site = url;
		if (!site.endsWith("/")){
			site += "/";
		}
		if (sslEnabled){
			if (!site.startsWith("https://")){
				site = "https://" + site;
			}
		}
		else {
			if (!site.startsWith("http://")){
				site = "http://" + site;
			}
		}
		cookieManager = new CookieManager();
		CookieHandler.setDefault(cookieManager);
	}

	/**
	 * Set the url of the gazelle site. An IllegalState exception will be thrown if any
	 * site requests are made prior to the site being set
	 *
	 * @param url url of the site following this format, http://website.com/
	 * @param ssl if ssl should be enabled
	 */
	public static void setSite(String url, boolean ssl){
		sslEnabled = ssl;
		setSite(url);
	}

	/**
	 * Use this factory method to get a properly configured HttpURLConnection for
	 * connecting to the desired url
	 *
	 * @return a configured HttpURLConnection
	 */
	private static HttpURLConnection newHttpConnection(URL url){
		try {
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestProperty("User-Agent", userAgent);
			return connection;
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Login to the site
	 *
	 * @param url        the url extension to submit the login information to, ie. login.php. the
	 *                   request will be made to site + url, eg http://website.com/login.php
	 * @param username   username to login with
	 * @param password   password to login with
	 * @param keepLogged if we want the cookie to not expire
	 * @throws api.util.CouldNotLoadException thrown if we fail to login
	 * @throws java.lang.IllegalStateException if the site was not set prior to calling the function
	 */
	public static void login(String url, String username, String password, Boolean keepLogged) throws CouldNotLoadException, IllegalStateException{
		if (site == null){
			throw new IllegalStateException("Must call MySoup.setSite before use");
		}
		HttpURLConnection connection = null;
		try {
			connection = newHttpConnection(new URL(site + url));
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			String params = "username=" + username + "&password=" + password;
			if (keepLogged){
				params += "&keeplogged=1";
			}
			connection.setFixedLengthStreamingMode(params.length());

			OutputStream out = new BufferedOutputStream(connection.getOutputStream());
			OutputStreamWriter writer = new OutputStreamWriter(out);
			writer.write(params);
			writer.flush();

			//Receive our cookies for this session
			List<HttpCookie> cookies = HttpCookie.parse(connection.getHeaderField("Set-Cookie"));
			URI uri = new URI(site);
			for (HttpCookie c : cookies){
				cookieManager.getCookieStore().add(uri, c);
			}
		}
		catch (Exception e){
			e.printStackTrace();
			throw new CouldNotLoadException("Could not login");
		}
		finally {
			if (connection != null){
				connection.disconnect();
			}
		}
		loadIndex();
	}

	/**
	 * Perform a POST to some site url with the desired list of parameters
	 *
	 * @param url  the url to submit to, the site will be prepended to it to form
	 *             the final url, eg: http://site.com/url
	 * @param params the list of parameters to send
	 * @throws api.util.CouldNotLoadException if we fail to execute the post method
	 * @throws java.lang.IllegalStateException if the site was not set prior to calling this method
	 */
	public static void postMethod(String url, List<Tuple<String, String>> params) throws CouldNotLoadException, IllegalStateException{
		if (site == null){
			throw new IllegalStateException("Must call MySoup.setSite before use");
		}
		HttpURLConnection connection = null;
		try {
			connection = newHttpConnection(new URL(site + url));
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setChunkedStreamingMode(0);

			OutputStream out = new BufferedOutputStream(connection.getOutputStream());
			OutputStreamWriter writer = new OutputStreamWriter(out);
			//Debugging only
			String urlParams = buildParams(params);
			System.out.println("Params: " + urlParams);
			writer.write(urlParams);
			writer.flush();
		}
		catch (Exception e){
			e.printStackTrace();
			throw new CouldNotLoadException("Could not login");
		}
		finally {
			if (connection != null){
				connection.disconnect();
			}
		}
	}

	/**
	 * Build the POST method parameters string for some list of parameters
	 * @param params params to encode for a POST method
	 * @return the parameters as a string
	 */
	private static String buildParams(List<Tuple<String, String>> params){
		StringBuilder result = new StringBuilder();
		try {
			result.append(URLEncoder.encode(params.get(0).getA(), "UTF-8"));
			result.append("=");
			result.append(URLEncoder.encode(params.get(0).getB(), "UTF-8"));
			for (int i = 1; i < params.size(); ++i){
				result.append("&");
				result.append(URLEncoder.encode(params.get(i).getA(), "UTF-8"));
				result.append("=");
				result.append(URLEncoder.encode(params.get(i).getB(), "UTF-8"));
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return result.toString();
	}

	/**
	 * Perform a GET request on the path site + url
	 *
	 * @param url the url extension to get
	 * @return the response data as a string
	 * @throws api.util.CouldNotLoadException if we fail to load the page
	 * @throws java.lang.IllegalStateException if the site was not set prior to calling this method
	 */
	public static String scrape(String url) throws CouldNotLoadException, IllegalStateException{
		if (site == null){
			throw new IllegalStateException("Must call MySoup.setSite before use");
		}
		String response = null;
		HttpURLConnection connection = null;
		try {
			connection = newHttpConnection(new URL(site + url));
			connection.setRequestProperty("User-Agent", userAgent);
			BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
			response = IOUtils.toString(in, "UTF-8");
			in.close();
		}
		catch (Exception e){
			e.printStackTrace();
			throw new CouldNotLoadException("Could not load: " + url);
		}
		finally {
			if (connection != null){
				connection.disconnect();
			}
		}
		return response;
	}

	/**
	 * Perform a GET request on some other website
	 *
	 * @param url the url to get
	 * @return the response data as a string
	 * @throws api.util.CouldNotLoadException if we fail to load the page
	 */
	public static String scrapeOther(String url) throws CouldNotLoadException{
		String response = null;
		HttpURLConnection connection = null;
		try {
			connection = newHttpConnection(new URL(url));
			connection.setRequestProperty("User-Agent", userAgent);
			BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
			response = IOUtils.toString(in, "UTF-8");
			in.close();
		}
		catch (Exception e){
			e.printStackTrace();
			throw new CouldNotLoadException("Could not load: " + url);
		}
		finally {
			if (connection != null){
				connection.disconnect();
			}
		}
		return response;
	}

	/**
	 * Simulate a simple link press on the site, that returns no JSON data.
	 *
	 * @param url the url to click, will be appended to the site url, eg: http://site.com/url
	 * @return true if response ok, false if failed
	 */
	public static boolean pressLink(String url){
		if (site == null){
			throw new IllegalStateException("Must call MySoup.setSite before use");
		}
		HttpURLConnection connection = null;
		try {
			connection = newHttpConnection(new URL(site + url));
			connection.setRequestProperty("User-Agent", userAgent);
			return connection.getResponseCode() == 200;
		}
		catch (ProtocolException e){
			//When we're setting notifications we're given a circular redirect back, this throws
			//an error, but it means we succeeded to set notifications
			if (url.contains("action=notify")){
				return true;
			}
			e.printStackTrace();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally {
			if (connection != null){
				connection.disconnect();
			}
		}
		return false;
	}


	/**
	 * Logout of the site, clears the user info and cookies
	 */
	public static void logout(String url){
		pressLink(site + url);
	}

	/**
	 * Load the user information index
	 */
	public static void loadIndex(){
		index = Index.init();
		if (!index.getResponse().getUserstats().getUserClass().equalsIgnoreCase("Member")
			&& !index.getResponse().getUserstats().getUserClass().equalsIgnoreCase("User")){
			MySoup.notificationsEnabled = true;
		}
	}

	public static String getSite(){
		return site;
	}

	public static String getUserAgent(){
		return userAgent;
	}

	public static void setUserAgent(String userAgent){
		MySoup.userAgent = userAgent;
	}

	public static List<HttpCookie> getCookies(){
		return cookieManager.getCookieStore().getCookies();
	}

	public static boolean isSslEnabled(){
		return sslEnabled;
	}

	public static boolean isNotificationsEnabled(){
		return notificationsEnabled;
	}

	public static Index getIndex(){
		return index;
	}

	public static String getAuthKey(){
		return index != null ? index.getResponse().getAuthkey() : null;
	}

	public static String getPassKey(){
		return index != null ? index.getResponse().getAuthkey() : null;
	}

	public static boolean isLoggedIn(){
		return index != null;
	}

	public static int getUserId(){
		return index != null ? index.getResponse().getId().intValue() : -1;
	}

	public static String getUsername(){
		return index != null ? index.getResponse().getUsername() : null;
	}
}