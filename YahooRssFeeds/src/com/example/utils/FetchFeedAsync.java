package com.example.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import android.os.AsyncTask;

public class FetchFeedAsync extends AsyncTask<String, Void, InputStream>{

	@Override
	protected InputStream doInBackground(String... params) {
		try {
			return new NetworkUtils().fetchFeed();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	protected void onPostExecute(InputStream result) {
		
			try {
				Logging.i("content: "+IOUtils.toString(result));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
