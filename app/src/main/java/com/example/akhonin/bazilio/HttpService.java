package com.example.akhonin.bazilio;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;


public class HttpService extends Activity {
        private static final String TAG = MainActivity.class.getSimpleName();

        //private String api = "http://192.168.10.6/api/";
        private String api = "http://193.151.246.240/api/";
        JSONObject header = new JSONObject();

        protected String sendGetRequest(String url) throws ExecutionException, InterruptedException {
           String test = new DownloadTask().execute(api + url).get();
            return test;
        }

        private class DownloadTask extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params) {
                //do your request in here so that you don't interrupt the UI thread
                try {
                    return downloadContent(params[0]);
                } catch (IOException e) {
                    System.out.print("================"+String.valueOf(e));
                    return String.valueOf(401);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }

        private String downloadContent(String myurl) throws IOException, JSONException {
            InputStream is = null;
            int length = 500;

            try {
                URL url = new URL(myurl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("GET");
                if(header.length()!=0) {
                    System.out.print(header.get("method"));
                    System.out.print(header.get("hash"));
                    conn.setRequestProperty(header.get("method").toString(), header.get("hash").toString());
                }
                conn.setDoInput(true);
                conn.connect();
                int response = conn.getResponseCode();
                Log.d(TAG, "The response is: " + response);
                is = conn.getInputStream();

                // Convert the InputStream into a string
                String contentAsString = convertInputStreamToString(is, length);
                return contentAsString;
            } finally {
                if (is != null) {
                    is.close();
                }
            }
        }

        public String convertInputStreamToString(InputStream stream, int length) throws IOException, UnsupportedEncodingException {
            Reader reader = null;
            reader = new InputStreamReader(stream, "UTF-8");
            char[] buffer = new char[length];
            reader.read(buffer);
            return new String(buffer);
        }
    }