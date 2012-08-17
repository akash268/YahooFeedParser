package com.example.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * NetworkUtils : Utility to handle all network calls
 */
public class NetworkUtils {
	
	public static String URL="http://rss.news.yahoo.com/rss/entertainment";
	public static int CONNECTION_TIMEOUT = 60 * 1000; // 1 minute
	private Context networkUtilsContext;
	

	

	public NetworkUtils() {
	}

	public NetworkUtils(Context networkUtilsContext) {
		this.networkUtilsContext = networkUtilsContext;
	}

	/**
	 * This method is used to fetch images from network.
	 * 
	 * @param url
	 *            of image
	 * @return {@link InputStream} to image data retrieved null if no data found
	 * @throws IOException 
	 */
	public InputStream fetchFeed() throws IOException {		
		InputStream is=null;
		try {
			DefaultHttpClient client = new DefaultHttpClient();
	    	HttpHost proxy = new HttpHost("10.0.2.2", 8191); 
	    	client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
	    	HttpGet get=new HttpGet(URL);
	    	Logging.i( "Hitting URL: "+URL);
			is=client.execute(get).getEntity().getContent();
		} catch (Exception e) {
			if(e!=null){
				e.printStackTrace();
			}
			Logging.e( "Exception: "+e.getMessage());
			return null;
		}
		return is;
	}

	
	

	

}
