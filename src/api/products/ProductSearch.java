
package api.products;

import api.son.MySon;
import api.soup.MySoup;
import com.google.gson.annotations.SerializedName;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthException;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

/**
 * Use this class to look up product UPCs using the Semantics3 API
 * Be sure to set your credentials prior to use or an IllegalStateException will be thrown
 */
public class ProductSearch {
	/**
	 * Semantics3 products testing and production API endpoints
	 */
	private static final String PRODUCTION = "https://api.semantics3.com/v1/products?q=",
		TESTING = "https://api.semantics3.com/test/v1/products?q=";
	/**
	 * API authentication key, secret and OAuth consumer
	 */
	private static String key, secret;
	private OAuthConsumer consumer;
	/**
	 * If we should hit the production API or the testing api
	 */
	private static boolean testing;

	/**
	 * Set the api key and secret to be used for authentication. This must be done
	 * prior to making any API calls
	 *
	 * @param k API key
	 * @param s API secret
	 */
	public static void setCredentials(String k, String s, boolean t){
		key = k;
		secret = s;
		testing = t;
	}

	/**
	 * Load a product search for some UPC
	 *
	 * @return the products returned by the API or null if loading failed
	 * @throws java.lang.IllegalStateException if api key & secret have not been set
	 */
	public static List<Product> fromUPC(String upc) throws IllegalStateException{
		if (key == null || secret == null){
			throw new IllegalStateException("Must set API key and secret prior to use");
		}
		ProductSearch search = new ProductSearch();
		HttpURLConnection connection = null;
		try {
			String request = testing ? TESTING : PRODUCTION;
			request += URLEncoder.encode("{\"upc\":\"" + upc + "\"}", "UTF-8");
			URL url = new URL(request);
			connection = (HttpURLConnection)url.openConnection();
			connection.setRequestProperty("User-Agent", MySoup.getUserAgent());
			//Use basic header auth for testing
			if (testing){
				connection.setRequestProperty("api_key", key);
			}
			else {
				search.consumer.sign(connection);
			}
			connection.connect();
			BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
			SemanticsResponse response = (SemanticsResponse)MySon.toObject(in, SemanticsResponse.class);
			in.close();
			return response != null ? response.getResults() : null;
		}
		catch (UnsupportedEncodingException e){
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		}
		catch (OAuthException e){
			e.printStackTrace();
		}
		finally {
			if (connection != null){
				connection.disconnect();
			}
		}
		return null;
	}

	private ProductSearch(){
		consumer = new DefaultOAuthConsumer(key, secret);
		consumer.setTokenWithSecret("", "");
	}

	/**
	 * We don't need to expose some of the top level fields of the response to the user, just the
	 * list of products returned
	 */
	private static class SemanticsResponse {
		@SerializedName("total_results_count")
		private Integer totalResultsCount;
		private Integer offset, results_count;
		private String code;
		private List<Product> results;

		public Integer getTotalResultsCount(){
			return totalResultsCount;
		}

		public Integer getOffset(){
			return offset;
		}

		public Integer getResults_count(){
			return results_count;
		}

		public String getCode(){
			return code;
		}

		public List<Product> getResults(){
			return results;
		}
	}
}
