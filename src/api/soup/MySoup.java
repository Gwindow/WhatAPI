package api.soup;

import api.forum.forumsections.ForumSections;
import api.index.Index;
import api.util.CouldNotLoadException;
import api.util.Tuple;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CircularRedirectException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class MySoup.
 * 
 * @author Gwindow
 */
public class MySoup {
	/** The http client. */
	private static DefaultHttpClient httpClient = getHttpClient();

	/** The authey. */
	private static String authey;

	/** The passkey. */
	private static String passkey;

	/** The cookies. */
	private static List<Cookie> cookies;

	/** The http params. */
	private static HttpParams httpParams = httpClient.getParams();

	/** The username. */
	private static String username;

	/** The user id. */
	private static int userId;

	/** The SITE. */
	private static String SITE;

	/** If the user is able to use notifications. */
	private static boolean canNotifications = true;

	/** The forum sections. */
	private static ForumSections forumSections;

	/** If the forum sections have been loaded. */
	private static boolean forumSectionsLoaded = false;

	/** The index. */
	private static Index index;

	/** The httpget. */
	private static HttpGet httpGet;

	/** The response. */
	private static HttpResponse response;

	/** The entity. */
	private static HttpEntity entity;

	/** The httpost. */
	private static HttpPost httpPost;

	/** If ssl is enabled. */
	private static boolean isSSLEnabled = true;

	/** The header name. */
	private static String headerName = "name";

	/** The header value. */
	private static String headerValue = "value";

	/**
	 * Set the url of the gazelle site. Nothing will work if this isn't called when first starting the program
	 * 
	 * @param url
	 *            url of the site following this format, http://what.cd/
	 */
	public static void setSite(String url) {
		if (!url.endsWith("/")) {
			url = url + "/";
		}
		if (isSSLEnabled) {
			if (!url.startsWith("https://")) {
				url = "https://" + url;
			}
		} else {
			if (!url.startsWith("http://")) {
				url = "http://" + url;
			}
		}
		SITE = url;
	}

	public static void setSite(String url, boolean ssl) {
		isSSLEnabled = ssl;
		setSite(url);
	}

	/**
	 * Gets the site.
	 * 
	 * @return the site
	 */
	public static String getSite() {
		return SITE;

	}

	/**
	 * Get the http client.
	 * 
	 * @return the http client
	 */
	private static DefaultHttpClient getHttpClient() {
		DefaultHttpClient client = new DefaultHttpClient();
		ClientConnectionManager mgr = client.getConnectionManager();
		HttpParams params = client.getParams();
        //Yes it's deprecated, no we can't change it. Using PoolingClientConnectionManager crashes on Android
		client = new DefaultHttpClient(new ThreadSafeClientConnManager(params, mgr.getSchemeRegistry()), params);
		// HttpProtocolParams.setUserAgent(client.getParams(), "WhatAPI");
		return client;
	}

	/**
	 * Get the HttpGet for a url
     * TODO is this function necessary? It's equivalent to new HttpGet(url)
	 * 
	 * @param url
	 *      the url to get for
	 * @return the http get
	 */
	private static HttpGet getHttpGet(String url) {
		return new HttpGet(url);
	}

	/**
	 * Sets the header.
     * TODO what is header for?
	 * 
	 * @param name
	 *      the name
	 * @param value
     *      the value
	 */
	private static void setHeader(String name, String value) {
		headerName = name;
		headerValue = value;
	}

	/**
	 * Called statically from MySoup because forum section titles never change.
	 * 
	 * @return the forum sections
	 */
	public static ForumSections loadForumSections() {
		if (!forumSectionsLoaded) {
			forumSections = ForumSections.init();
			forumSectionsLoaded = true;
		}
		return forumSections;
	}

	/**
	 * Get the forum sections.
	 * 
	 * @return the forum sections
	 */
	public static ForumSections getForumSections() {
		return forumSections;
	}

	/**
	 * Enable/Disable ssl.
	 * 
	 * @param b
	 *      the new SSL enabled
	 */
	public static void setSSL(boolean b) {
		isSSLEnabled = b;
	}

	/**
	 * Check if is SSL enabled.
	 * 
	 * @return True if SSL is enabled
	 */
	public static boolean isSSLEnabled() {
		return isSSLEnabled;
	}

	/**
	 * Get the auth key.
	 * 
	 * @return the auth key
	 */
	public static String getAuthKey() {
		return authey;
	}

	/**
	 * Gets the pass key.
	 * 
	 * @return the pass key
	 */
	public static String getPassKey() {
		return passkey;
	}

	/**
	 * Get the session id.
	 * 
	 * @return the session id
	 */
	public static String getSessionId() {
		return cookies.get(0).getValue();
	}

	/**
	 * Get the cookies.
	 * 
	 * @return the cookies
	 */
	public static List<Cookie> getCookies() {
		return cookies;
	}

	/**
	 * Check if we're logged in
	 * 
	 * @return True if we're logged in
	 */
	public static boolean isLoggedIn() {
        return (cookies != null && !cookies.isEmpty());
	}

	/**
	 * Convert some html string to quotable text
	 * 
	 * @param html
	 *      the html string to parse
	 * @return the string
	 */
	public static String toQuotableString(String html) {
		return Jsoup.parse(html).text();
	}

	/**
	 * Login to a site
	 * 
	 * @param url
	 *      the url extension to submit the login information to, ie. login.php
     *      the site url will be pre-pended to the url
	 * @param username
     *      the username to login with
	 * @param password
	 *      the password to login with
	 * @throws CouldNotLoadException
     *      thrown if we fail to login
	 */
	public static void login(String url, String username, String password) throws CouldNotLoadException {
		url = SITE + url;
		try {
			httpGet = getHttpGet(url);
			response = httpClient.execute(httpGet);
			entity = response.getEntity();

			httpPost = new HttpPost(url);
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("username", username));
			nvps.add(new BasicNameValuePair("password", password));

			httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));

			response = httpClient.execute(httpPost);
			entity = response.getEntity();
			if (entity != null)
                entity.consumeContent();
			cookies = httpClient.getCookieStore().getCookies();
			loadIndex();
		} catch (Exception e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Could not login");
		}
	}

	/**
	 * Load the user information index
	 */
	public static void loadIndex() {
		index = Index.init();
		MySoup.username = index.getResponse().getUsername();
		MySoup.userId = index.getResponse().getId().intValue();
		MySoup.authey = index.getResponse().getAuthkey();
		MySoup.passkey = index.getResponse().getPasskey();
		if (!index.getResponse().getUserstats().getUserClass().equalsIgnoreCase("Member")
				&& !index.getResponse().getUserstats().getUserClass().equalsIgnoreCase("User")) {
			MySoup.canNotifications = true;
		}
	}

	/**
	 * Get the user index
	 * 
	 * @return the index
	 */
	public static Index getIndex() {
		return index;
	}

	/**
	 * Perform an HttpPost method to some what.cd url with some list parameters
	 * 
	 * @param url
	 *      the url to submit to, of the form blah.php? and the site url will be
     *      pre-prended to it
	 * @param list
	 *      the list of parameters
	 * @throws Exception
	 *      if we fail to execute the post method
	 */
	public static void postMethod(String url, List<Tuple<String, String>> list) throws Exception {
		url = SITE + url;
		try {
			httpGet = getHttpGet(url);
			httpPost = new HttpPost(url);
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			for (Tuple<String, String> t : list) {
				nvps.add(new BasicNameValuePair(t.getA(), t.getB()));
			}
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
			response = httpClient.execute(httpPost);
			// TODO investigate
            //Investigate what issue?
			// EntityUtils.consume(response.getEntity());
			// response.getEntity().consumeContent();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Could not post data");
		}
	}

	/**
	 * Perform an HttpGet on some site url to get some data from it
	 * 
	 * @param url
	 *      the url to scrape, of the form blah.php? and the site url will
     *      be pre-prended to it
	 * @return the string of data received in response
	 */
	public static String scrape(String url) {
		url = SITE + url;
		httpGet = getHttpGet(url);
		response = null;
		try {
			response = httpClient.execute(httpGet);
			entity = response.getEntity();
			// String s = Jsoup.parse(entity.getContent(), "utf-8", "").text();
            //Using HTTP.USER_AGENT crashes, UnupportedCharsetException on desktop (not in app for some reason)
			String s = EntityUtils.toString(entity, HTTP.UTF_8);
            entity.consumeContent();
            return s;
			// EntityUtils.consume(entity);
			// InputStream s = entity.getContent();
			// System.err.println("encoding " + entity.getContentEncoding());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Read an input stream into a string
	 * 
	 * @param is
	 *      the input stream
	 * @return the string
	 */
	private static String inputStreamToString(InputStream is) {
		String line = "";
		StringBuilder total = new StringBuilder();
		BufferedReader rd = new BufferedReader(new InputStreamReader(is));

		// Read response until the end
		try {
			while ((line = rd.readLine()) != null) {
				total.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return total.toString();
	}

	/**
	 * Simulate a simple link press on the site, that returns no JSON data.
	 * 
	 * @param url
	 *      the url to click
     * @return
     *      true if response ok, false if failed
	 */
	public static boolean pressLink(String url) {
		url = SITE + url;
		httpGet = getHttpGet(url);
		response = null;
        boolean success = false;
		try {
			response = httpClient.execute(httpGet);
            success = (response.getStatusLine().getStatusCode() == 200);
		}
        catch (ClientProtocolException e){
            //Exception specific to receiving the circular redirect when changing notifications
            if (e.getCause() instanceof CircularRedirectException){
                //Double check we we're changing notifications
                if (url.contains("notify"))
                    success = true;
                else
                    e.printStackTrace();
            }
            else
                e.printStackTrace();
        }
        catch (Exception e) {
			e.printStackTrace();
            System.out.println("pressLink error: " + e.getMessage());
            success = false;
		}
        finally {
            //Clean up
            try {
                if (response != null && response.getEntity() != null)
                    response.getEntity().consumeContent();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return success;
	}

    /**
     * Perform an HttpGet on some non-site url and get the string data returned b it
     *
     * @param url
     *      the url to get data from
     * @return the response data as a string
     * @throws CouldNotLoadException
     *      if we fail to load the page
     */
	public static String scrapeOther(String url) throws CouldNotLoadException {
		httpGet = getHttpGet(url);
		response = null;
		try {
			response = httpClient.execute(httpGet);
			entity = response.getEntity();
			String s = EntityUtils.toString(entity);
            entity.consumeContent();
            return s;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Could not load page");
		}
	}

	/**
	 * Get the user id.
	 * 
	 * @return the user id
	 */
	public static int getUserId() {
		return userId;
	}

	/**
	 * Get the username.
	 * 
	 * @return the username
	 */
	public static String getUsername() {
		return username;
	}

	/**
	 * Set the session id.
	 * 
	 * @param sessionId
     *      the new session id
	 */
	public static void setSessionId(String sessionId) {
		Cookie cookie = new BasicClientCookie("", sessionId);
		CookieStore cs = new BasicCookieStore();
		cs.addCookie(cookie);
		httpClient.setCookieStore(cs);
		cookies = httpClient.getCookieStore().getCookies();
	}

	/**
	 * Convert a string to plain text
	 * 
	 * @param s
	 *      the string to convert
	 * @return the converted string
	 */
	public static String toPlainText(String s) {
		s = Jsoup.parse(s.replaceAll("(?i)<br[^>]*>", "\n")).text();
		return s;
	}

	/**
	 * Clean some string of unsafe html characters
	 * 
	 * @param s
	 *      the string to clean
	 * @return the cleaned string
	 */
	public static String clean(String s) {
		return Jsoup.clean(s, Whitelist.relaxed());
	}

	/**
	 * Check if the user can read torrent notifications
	 * 
	 * @return True if the user can read torrent notifications
	 */
	public static boolean canNotifications() {
		return canNotifications;
	}

}