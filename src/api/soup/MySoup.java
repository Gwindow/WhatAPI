package api.soup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
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
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

import api.forum.forumsections.ForumSections;
import api.index.Index;
import api.util.CouldNotLoadException;
import api.util.Tuple;

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

	/** The can notifications. */
	private static boolean canNotifications = true;

	/** The forum sections. */
	private static ForumSections forumSections;

	/** The forum sections loaded. */
	private static boolean forumSectionsLoaded = false;

	/** The index. */
	private static Index index;

	/** The httpget. */
	private static HttpGet httpget;

	/** The response. */
	private static HttpResponse response;

	/** The entity. */
	private static HttpEntity entity;

	/** The httpost. */
	private static HttpPost httpost;

	private static boolean isSSLEnabled = true;

	private static String headerName = "name";
	private static String headerValue = "value";

	/**
	 * Set the url of the gazelle site. Nothing will work if this isn't called when first starting the program
	 * 
	 * @param s
	 *            url of the site following this format, http://what.cd/
	 */
	public static void setSite(String s) {
		if (!s.endsWith("/")) {
			s = s + "/";
		}
		if (isSSLEnabled) {
			if (!s.startsWith("https://")) {
				s = "https://" + s;
			}
		} else {
			if (!s.startsWith("http://")) {
				s = "http://" + s;
			}
		}
		SITE = s;
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
	 * Gets the http client.
	 * 
	 * @return the http client
	 */
	private static DefaultHttpClient getHttpClient() {
		DefaultHttpClient client = new DefaultHttpClient();
		ClientConnectionManager mgr = client.getConnectionManager();
		HttpParams params = client.getParams();
		client = new DefaultHttpClient(new ThreadSafeClientConnManager(params, mgr.getSchemeRegistry()), params);
		// HttpProtocolParams.setUserAgent(client.getParams(), "WhatAPI");
		return client;
	}

	private static HttpGet getHttpGet(String url) {
		HttpGet hg = new HttpGet(url);
		return hg;

	}

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
		if (forumSectionsLoaded == false) {
			forumSections = ForumSections.init();
			forumSectionsLoaded = true;
		}
		return forumSections;
	}

	/**
	 * Gets the forum sections.
	 * 
	 * @return the forum sections
	 */
	public static ForumSections getForumSections() {
		return forumSections;
	}

	/**
	 * Enable/Disable ssl.
	 */
	public static void setSSLEnabled(boolean b) {
		isSSLEnabled = b;
	}

	/**
	 * Checks if is sSL enabled.
	 * 
	 * @return true, if is sSL enabled
	 */
	public static boolean isSSLEnabled() {
		return isSSLEnabled;
	}

	/**
	 * Gets the auth key.
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
	 * Gets the session id.
	 * 
	 * @return the session id
	 */
	public static String getSessionId() {
		return cookies.get(0).getValue();
	}

	/**
	 * Gets the cookies.
	 * 
	 * @return the cookies
	 */
	public static List<Cookie> getCookies() {
		return cookies;
	}

	/**
	 * Checks if is logged in.
	 * 
	 * @return true, if is logged in
	 */
	public static boolean isLoggedIn() {
		if ((cookies != null) && !cookies.isEmpty())
			return true;
		else
			return false;
	}

	/**
	 * Gets the update link.
	 * 
	 * @param page
	 *            the page
	 * @return the update link
	 */
	public static String getUpdateLink(String page) {
		Document doc = null;
		try {
			doc = scrapeOther(page);
		} catch (CouldNotLoadException e) {
			e.printStackTrace();
		}
		return doc.getElementsByTag("b").text();
	}

	/**
	 * To quotable string.
	 * 
	 * @param html
	 *            the html
	 * @return the string
	 */
	public static String toQuotableString(String html) {
		return Jsoup.parse(html).text();
	}

	/**
	 * Login.
	 * 
	 * @param url
	 *            the url
	 * @param username
	 *            the username
	 * @param password
	 *            the password
	 * @throws CouldNotLoadException
	 *             the could not load exception
	 */
	public static void login(String url, String username, String password) throws CouldNotLoadException {
		url = SITE + url;
		try {

			httpget = getHttpGet(url);
			response = httpClient.execute(httpget);
			entity = response.getEntity();

			httpost = new HttpPost(url);
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("username", username));
			nvps.add(new BasicNameValuePair("password", password));

			httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));

			response = httpClient.execute(httpost);
			entity = response.getEntity();
			if (entity != null) {
				entity.consumeContent();
			}
			cookies = httpClient.getCookieStore().getCookies();

			loadIndex();

		} catch (Exception e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Could not login");
		}
	}

	/**
	 * Load index.
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
	 * Gets the index.
	 * 
	 * @return the index
	 */
	public static Index getIndex() {
		return index;
	}

	/**
	 * Post method.
	 * 
	 * @param url
	 *            the url
	 * @param list
	 *            the list
	 * @throws Exception
	 *             the exception
	 */
	public static void postMethod(String url, List<Tuple<String, String>> list) throws Exception {
		url = SITE + url;
		try {
			httpget = getHttpGet(url);

			httpost = new HttpPost(url);

			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			for (Tuple<String, String> t : list) {
				nvps.add(new BasicNameValuePair(t.getA(), t.getB()));
			}
			httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
			response = httpClient.execute(httpost);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Could not post data");
		}

	}

	/**
	 * Scrape.
	 * 
	 * @param url
	 *            the url
	 * @return the input stream
	 */
	public static String scrape(String url) {
		url = SITE + url;
		httpget = getHttpGet(url);
		response = null;
		try {
			response = httpClient.execute(httpget);
			entity = response.getEntity();
			// String s = Jsoup.parse(entity.getContent(), "utf-8", "").text();
			String s = EntityUtils.toString(entity, HTTP.USER_AGENT);
			// EntityUtils.consume(entity);
			// InputStream s = entity.getContent();
			// System.err.println("encoding " + entity.getContentEncoding());
			return s;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * Input stream to string.
	 * 
	 * @param is
	 *            the is
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
	 * Press link.
	 * 
	 * @param url
	 *            the url
	 */
	public static void pressLink(String url) {
		url = SITE + url;
		httpget = getHttpGet(url);
		response = null;
		try {
			response = httpClient.execute(httpget);
			response.getEntity().consumeContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Scrape other.
	 * 
	 * @param url
	 *            the url
	 * @return the document
	 * @throws CouldNotLoadException
	 *             the could not load exception
	 */
	public static Document scrapeOther(String url) throws CouldNotLoadException {
		httpget = getHttpGet(url);
		response = null;
		Document doc = null;
		try {
			response = httpClient.execute(httpget);
			doc = Jsoup.parse(inputStreamToString(response.getEntity().getContent()));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Could not load non what.cd page");
		} catch (IOException e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Could not load non what.cd page");
		}
		return doc;
	}

	/**
	 * Gets the user id.
	 * 
	 * @return the user id
	 */
	public static int getUserId() {
		return userId;
	}

	/**
	 * Gets the username.
	 * 
	 * @return the username
	 */
	public static String getUsername() {
		return username;
	}

	/**
	 * Sets the session id.
	 * 
	 * @param sessionId
	 *            the new session id
	 */
	public static void setSessionId(String sessionId) {
		Cookie cookie = new BasicClientCookie("", sessionId);
		CookieStore cs = new BasicCookieStore();
		cs.addCookie(cookie);
		httpClient.setCookieStore(cs);
		cookies = httpClient.getCookieStore().getCookies();
	}

	/**
	 * To plain text.
	 * 
	 * @param s
	 *            the s
	 * @return the string
	 */
	public static String toPlainText(String s) {
		s = Jsoup.parse(s.replaceAll("(?i)<br[^>]*>", "\n")).text();
		return s;
	}

	public static String clean(String s) {
		return Jsoup.clean(s, Whitelist.relaxed());
	}

	/**
	 * Can notifications.
	 * 
	 * @return true, if successful
	 */
	public static boolean canNotifications() {
		return canNotifications;
	}

}