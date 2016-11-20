package com.example.akhonin.bazilio;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.annotation.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class HttpService extends Activity {


    private String ApiUrl = "http://192.168.10.6/api";
    public StringBuilder response;


    public void sendGetRequest() {
            //new GetClass().execute();
        String p = executePost();
        System.out.println(p);
    }

    @Nullable
    public static String executePost() {
        HttpURLConnection connection = null;

        try {
            URL url = new URL("http://192.168.10.6/api/UserTypes");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setDoOutput(true);
            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private class GetClass extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            try {
                URL url = new URL("http://192.168.10.6/api/UserTypes");

                HttpURLConnection connection = (HttpURLConnection)url.openConnection();
               // String urlParameters = "fizz=buzz";
                connection.setRequestMethod("GET");
               // connection.setRequestProperty("USER-AGENT", "Mozilla/5.0");
                //connection.setRequestProperty("ACCEPT-LANGUAGE", "en-US,en;0.5");
                int responseCode = connection.getResponseCode();
               // System.out.println("\nSending 'GET' request to URL : " + url);
               // System.out.println("Post parameters : " + urlParameters);
               // System.out.println("Response Code : " + responseCode);

                final StringBuilder output = new StringBuilder("Request URL " + url);
                //output.append(System.getProperty("line.separator") + "Request Parameters " + urlParameters);
              //  output.append(System.getProperty("line.separator")  + "Response Code " + responseCode);
              //  output.append(System.getProperty("line.separator")  + "Type " + "GET");
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = "";
                StringBuilder responseOutput = new StringBuilder();
                while((line = br.readLine()) != null ) {
                    responseOutput.append(line);
                }
                br.close();

                output.append(System.getProperty("line.separator") + "Response " + System.getProperty("line.separator") + System.getProperty("line.separator") + responseOutput.toString());

                HttpService.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        System.out.println(output);
                        response = output;
                    }
                });

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }

    }
}