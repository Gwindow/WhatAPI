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
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import api.forum.forumsections.ForumSections;
import api.index.Index;
import api.util.CouldNotLoadException;
import api.util.RegexTools;
import api.util.Tuple;

/**
 * The Class MySoup.
 * 
 * @author Gwindow
 */
public class MySoup {
	private static DefaultHttpClient httpClient = getHttpClient();
	private static boolean SSL;
	private static String authey;
	private static String passkey;
	private static List<Cookie> cookies;
	private static CookieStore cookieStore = new BasicCookieStore();
	private static HttpContext localContext = new BasicHttpContext();
	private static RegexTools regex = new RegexTools();
	private static HttpParams httpParams = httpClient.getParams();
	private static String username;
	private static int userId;
	private static String SITE;
	private static boolean canNotifications = true;
	private static ForumSections forumSections;
	private static boolean forumSectionsLoaded = false;
	private static Index i;

	/**
	 * Set the url of the gazelle site. Nothing will work if this isn't called when first starting the program
	 * 
	 * @param s
	 *            url of the site following this format, http://what.cd/ don't forget the slash at the end
	 */
	public static void setSite(String s) {
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

		return client;
	}

	/**
	 * Called statically from MySoup because forum section titles never change.
	 */
	public static void loadForumSections() {
		if (forumSectionsLoaded == false) {
			forumSections = ForumSections.init();
			forumSectionsLoaded = true;
		}
	}

	/**
	 * Load forum sections2.
	 */
	public static void loadForumSections2() {
		if (forumSectionsLoaded == false) {
			forumSections = ForumSections.init();
			forumSectionsLoaded = true;
		}
	}

	/**
	 * Gets the forum sections2.
	 * 
	 * @return the forum sections2
	 */
	public static ForumSections getForumSections2() {
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
	 * Enable ssl.
	 */
	public static void enableSSL() {
		SSL = true;
	}

	/**
	 * Checks if is sSL enabled.
	 * 
	 * @return true, if is sSL enabled
	 */
	public static boolean isSSLEnabled() {
		return SSL;
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
	 * Link to ssl.
	 * 
	 * @param link
	 *            the link
	 * @return the string
	 */
	private static String linkToSSL(String link) {
		link = link.replace("http://", "https://ssl.");
		return link;
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
	 * Gets the update version.
	 * 
	 * @param page
	 *            the page
	 * @return the update version
	 */
	public static String getUpdateVersion(String page) {
		Document doc = null;
		try {
			doc = scrapeOther(page);
		} catch (CouldNotLoadException e) {
			e.printStackTrace();
		}
		return doc.getElementsByTag("h1").text();
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
		String index = "index.php";
		url = SITE + url;
		if (isSSLEnabled()) {
			url = linkToSSL(url);
			index = linkToSSL(index);
		}
		try {
			HttpConnectionParams.setConnectionTimeout(httpParams, 60000);
			HttpConnectionParams.setSoTimeout(httpParams, 60000);

			HttpGet httpget = new HttpGet(url);
			HttpResponse response = httpClient.execute(httpget);
			HttpEntity entity = response.getEntity();

			HttpPost httpost = new HttpPost(url);
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
		i = Index.init();
		MySoup.username = i.getResponse().getUsername();
		MySoup.userId = i.getResponse().getId().intValue();
		MySoup.authey = i.getResponse().getAuthkey();
		MySoup.passkey = i.getResponse().getPasskey();
		if (!i.getResponse().getUserstats().getUserClass().equalsIgnoreCase("Member")
				&& !i.getResponse().getUserstats().getUserClass().equalsIgnoreCase("User")) {
			MySoup.canNotifications = true;
		}
	}

	/**
	 * Gets the index.
	 * 
	 * @return the index
	 */
	public static Index getIndex() {
		return i;
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
		if (isSSLEnabled()) {
			url = linkToSSL(url);
		}
		try {
			@SuppressWarnings("unused")
			HttpGet httpget = new HttpGet(url);
			@SuppressWarnings("unused")
			HttpResponse response;

			HttpPost httpost = new HttpPost(url);

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
	public static InputStream scrape(String url) {
		url = SITE + url;
		if (isSSLEnabled()) {
			url = linkToSSL(url);
		}
		HttpConnectionParams.setConnectionTimeout(httpParams, 60000);
		HttpConnectionParams.setSoTimeout(httpParams, 60000);
		HttpGet httpget = new HttpGet(url);
		HttpResponse response = null;
		try {
			response = httpClient.execute(httpget);
			return response.getEntity().getContent();
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
	 * @throws CouldNotLoadException
	 */
	public static void pressLink(String url) throws CouldNotLoadException {
		url = SITE + url;
		if (isSSLEnabled()) {
			url = linkToSSL(url);
		}
		HttpConnectionParams.setConnectionTimeout(httpParams, 60000);
		HttpConnectionParams.setSoTimeout(httpParams, 60000);
		HttpGet httpget = new HttpGet(url);
		HttpResponse response = null;
		try {
			response = httpClient.execute(httpget);
			response.getEntity().getContent();
		} catch (Exception e) {
			throw new CouldNotLoadException("Could not press link");
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
		HttpGet httpget = new HttpGet(url);
		HttpResponse response = null;
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
		return Jsoup.parse(s).text();
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