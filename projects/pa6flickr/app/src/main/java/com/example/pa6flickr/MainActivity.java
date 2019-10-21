package com.example.pa6flickr;


import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;



import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    public String newsBaseUrl = "https://newsapi.org/v2/everything?from=2019-10-2&sortBy=publishedAt&apiKey=8c65d51e99dc4355a4f8ab15d60f4a76&q=";
    public String searchUrlComponent = "nintendo";
    public String tiobeUrl = "http://benjdd.com/courses/cs317/fall-2019/files/tiobe.json";

    public static MainActivity itself = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itself = this;
        new DownloadTask().execute();
    }

    private class DownloadTask extends AsyncTask<Object, Void, JSONObject>  {

        @Override
        protected JSONObject doInBackground(Object[] objects) {
            try {

                String json = "";
                String line;

                URL url = new URL(tiobeUrl);

                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                while ((line = in.readLine()) != null) {
                    System.out.println("JSON LINE " + line);
                    json += line;
                }
                in.close();

                JSONObject jsonObject = new JSONObject(json);
                return jsonObject;
            } catch (Exception e) { e.printStackTrace(); }

            return null;
        }

        @Override
        protected void onPostExecute(JSONObject json) {

            try {
                LinearLayout linearLayout = MainActivity.itself.findViewById(R.id.outer_layout);
                String title = json.getString("ranking_type") + " - " +
                        json.getString("ranking_date");
                ((TextView) MainActivity.itself.findViewById(R.id.title)).setText(title);

                JSONArray rankings = json.getJSONArray("rankings");

                for (int i = 0; i < rankings.length(); i++) {
                    TextView textView = new TextView(MainActivity.itself);
                    String language = rankings.getJSONObject(i).getString("language");
                    String percent = rankings.getJSONObject(i).getString("percent");
                }

            } catch (Exception e) { e.printStackTrace(); }
        }
    }
}