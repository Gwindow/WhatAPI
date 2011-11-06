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
import org.jsoup.nodes.Element;

import api.forum.forumsections.ForumSections;
import api.index.Index;
import api.util.CouldNotLoadException;
import api.util.RegexTools;

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
	private static String userId;
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

	public static String getSite() {
		return SITE;

	}

	private static DefaultHttpClient getHttpClient() {
		DefaultHttpClient client = new DefaultHttpClient();
		ClientConnectionManager mgr = client.getConnectionManager();
		HttpParams params = client.getParams();

		client = new DefaultHttpClient(new ThreadSafeClientConnManager(params, mgr.getSchemeRegistry()), params);

		return client;
	}

	/**
	 * Called statically from MySoup because forum section titles never change
	 */
	public static void loadForumSections() {
		if (forumSectionsLoaded == false) {
			forumSections = ForumSections.init();
			forumSectionsLoaded = true;
		}
	}

	public static void loadForumSections2() {
		if (forumSectionsLoaded == false) {
			forumSections = ForumSections.init();
			forumSectionsLoaded = true;
		}
	}

	public static ForumSections getForumSections2() {
		return forumSections;
	}

	public static ForumSections getForumSections() {
		return forumSections;
	}

	public static void enableSSL() {
		SSL = true;
	}

	public static boolean isSSLEnabled() {
		return SSL;
	}

	public static String getAuthKey() {
		return authey;
	}

	public static String getPassKey() {
		return passkey;
	}

	public static String getSessionId() {
		return cookies.get(0).getValue();
	}

	public static List<Cookie> getCookies() {
		return cookies;
	}

	public static boolean isLoggedIn() {
		if ((cookies != null) && !cookies.isEmpty())
			return true;
		else
			return false;
	}

	private static String linkToSSL(String link) {
		link = link.replace("http://", "https://ssl.");
		return link;
	}

	public static String getUpdateLink(String page) {
		Document doc = null;
		try {
			doc = scrapeOther(page);
		} catch (CouldNotLoadException e) {
			e.printStackTrace();
		}
		return doc.getElementsByTag("b").text();
	}

	public static String getUpdateVersion(String page) {
		Document doc = null;
		try {
			doc = scrapeOther(page);
		} catch (CouldNotLoadException e) {
			e.printStackTrace();
		}
		return doc.getElementsByTag("h1").text();
	}

	public static String toQuotableString(String html) {
		return Jsoup.parse(html).text();
	}

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

	public static void loadIndex() {
		i = Index.init();
		MySoup.username = i.getResponse().getUsername();
		MySoup.userId = i.getResponse().getId();
		MySoup.authey = i.getResponse().getAuthkey();
		MySoup.passkey = i.getResponse().getPasskey();
		if (!i.getResponse().getUserstats().getUserClass().equalsIgnoreCase("Member")
				&& !i.getResponse().getUserstats().getUserClass().equalsIgnoreCase("User")) {
			MySoup.canNotifications = true;
		}
	}

	public static Index getIndex() {
		return i;
	}

	public static void oldlogin(String url, String username, String password) throws CouldNotLoadException {
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
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Could not login");

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Could not login");

		} catch (IOException e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Could not login");

		}

		try {
			// get the authkey and userid
			Document scrape = scrape(index);
			String s =
					scrape.getElementById("header").getElementById("userinfo").getElementById("userinfo_username")
							.getElementById("nav_logout").getElementsByTag("a").get(0).toString();
			authey = regex.splitAuthKey(s);

			Element e = scrape.getElementById("userinfo").getElementById("userinfo_username").getElementsByTag("a").get(0);
			RegexTools regex = new RegexTools();
			String d = e.toString();
			userId = regex.split(d, "id=", "\" class");

			// load rss feed urls

		} catch (Exception e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Could parse authkey");
		}

	}

	public static void postReply(String url, String id, String reply) throws CouldNotLoadException {
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
			nvps.add(new BasicNameValuePair("action", "reply"));
			nvps.add(new BasicNameValuePair("auth", authey));
			nvps.add(new BasicNameValuePair("thread", id));
			nvps.add(new BasicNameValuePair("body", reply));

			httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
			response = httpClient.execute(httpost);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Could not post reply");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Could not post reply");
		} catch (IOException e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Could not post reply");
		}
	}

	public static void oldpostReply(String url, String reply) throws CouldNotLoadException {
		if (isSSLEnabled()) {
			url = linkToSSL(url);
		}

		String threadID = regex.splitThreadID(url);

		try {
			@SuppressWarnings("unused")
			HttpGet httpget = new HttpGet(url);
			@SuppressWarnings("unused")
			HttpResponse response;

			HttpPost httpost = new HttpPost(url);

			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("action", "reply"));
			nvps.add(new BasicNameValuePair("auth", authey));
			nvps.add(new BasicNameValuePair("thread", threadID));
			nvps.add(new BasicNameValuePair("body", reply));

			httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
			response = httpClient.execute(httpost);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Could not post reply");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Could not post reply");
		} catch (IOException e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Could not post reply");
		}
	}

	public static Document scrape(String url) throws CouldNotLoadException {
		url = SITE + url;
		if (isSSLEnabled()) {
			url = linkToSSL(url);
		}
		HttpConnectionParams.setConnectionTimeout(httpParams, 60000);
		HttpConnectionParams.setSoTimeout(httpParams, 60000);
		HttpGet httpget = new HttpGet(url);
		HttpResponse response = null;
		Document doc = null;
		try {
			response = httpClient.execute(httpget);
			doc = Jsoup.parse(inputStreamToString(response.getEntity().getContent()));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Could not load page");
		} catch (IllegalStateException e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Could not load page");
		} catch (IOException e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Could not load page");
		}
		return doc;
	}

	public static void newThread(String id, String title, String body) throws CouldNotLoadException {
		String url = SITE + "forums.php?action=new&forumid=" + id;
		if (isSSLEnabled()) {
			url = linkToSSL(url);
		}

		try {
			HttpGet httpget = new HttpGet(url);
			@SuppressWarnings("unused")
			HttpResponse response;
			response = httpClient.execute(httpget);
			HttpPost httpost = new HttpPost(url);

			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("action", "new"));
			nvps.add(new BasicNameValuePair("auth", authey));
			nvps.add(new BasicNameValuePair("forum", id));
			nvps.add(new BasicNameValuePair("title", title));
			nvps.add(new BasicNameValuePair("body", body));

			httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
			response = httpClient.execute(httpost);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Could not create new thread");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Could not create new thread");
		} catch (IOException e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Could not create new thread");
		}
	}

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

	public static void pressLink(String url) {
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
			// todo pretty this up
		}
	}

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

	public static String getUserId() {
		return userId;
	}

	public static String getUsername() {
		return username;
	}

	public static void setSessionId(String sessionId) {
		Cookie cookie = new BasicClientCookie("", sessionId);
		CookieStore cs = new BasicCookieStore();
		cs.addCookie(cookie);
		httpClient.setCookieStore(cs);
		cookies = httpClient.getCookieStore().getCookies();
	}

	public static String toPlainText(String s) {
		return Jsoup.parse(s).text();
	}

	/**
	 * Send private message
	 * 
	 * @param id
	 *            recipent's id
	 * @param subject
	 *            subject line
	 * @param body
	 *            body of message
	 * @throws CouldNotLoadException
	 */
	public static void sendPrivateMessage(String id, String subject, String body) throws CouldNotLoadException {
		String url = SITE + "inbox.php?action=compose&to=" + id;
		if (isSSLEnabled()) {
			url = linkToSSL(url);
		}

		try {
			HttpConnectionParams.setConnectionTimeout(httpParams, 60000);
			HttpConnectionParams.setSoTimeout(httpParams, 60000);

			HttpGet httpget = new HttpGet(url);
			HttpResponse response = httpClient.execute(httpget);
			HttpEntity entity = response.getEntity();

			HttpPost httpost = new HttpPost(url);
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("action", "takecompose"));
			nvps.add(new BasicNameValuePair("toid", id));
			nvps.add(new BasicNameValuePair("auth", authey));
			nvps.add(new BasicNameValuePair("subject", subject));
			nvps.add(new BasicNameValuePair("body", body));

			httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));

			response = httpClient.execute(httpost);
			entity = response.getEntity();
			if (entity != null) {
				entity.consumeContent();
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Could not send private message");
		}

	}

	/**
	 * Send rippy to user
	 * 
	 * @param id
	 *            recipent's id
	 * @param message
	 *            body of message
	 * @throws CouldNotLoadException
	 */
	public static void sendRippy(String id, String message) throws CouldNotLoadException {
		String url = SITE + "user.php?action=rippy&id=" + id;
		if (isSSLEnabled()) {
			url = linkToSSL(url);
		}

		try {
			HttpGet httpget = new HttpGet(url);
			@SuppressWarnings("unused")
			HttpResponse response;
			response = httpClient.execute(httpget);
			HttpPost httpost = new HttpPost(url);

			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("action", "rippy"));
			nvps.add(new BasicNameValuePair("auth", authey));
			nvps.add(new BasicNameValuePair("toid", id));
			nvps.add(new BasicNameValuePair("message", message));
			httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
			response = httpClient.execute(httpost);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CouldNotLoadException("Could not send rippy");
		}
	}

	/*
	 * public static void post(String url) { String url = SITE + "user.php?action=rippy&id=" + id; if (isSSLEnabled()) {
	 * url = linkToSSL(url); }
	 * 
	 * try { HttpGet httpget = new HttpGet(url);
	 * 
	 * @SuppressWarnings("unused") HttpResponse response; response = httpClient.execute(httpget); HttpPost httpost = new
	 * HttpPost(url);
	 * 
	 * List<NameValuePair> nvps = new ArrayList<NameValuePair>(); nvps.add(new BasicNameValuePair("action", "rippy"));
	 * nvps.add(new BasicNameValuePair("auth", authKey)); nvps.add(new BasicNameValuePair("toid", id)); nvps.add(new
	 * BasicNameValuePair("message", message)); httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8)); response
	 * = httpClient.execute(httpost); } catch (Exception e) { e.printStackTrace(); throw new
	 * CouldNotLoadException("Could not send rippy"); } }
	 */

	public static boolean canNotifications() {
		return canNotifications;
	}

}