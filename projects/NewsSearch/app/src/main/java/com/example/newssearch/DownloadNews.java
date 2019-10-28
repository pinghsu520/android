package com.example.newssearch;

import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

class DownloadNews extends AsyncTask<String, Void, String> {
    ArrayList<HashMap<String, String>> dataList = new ArrayList<>();
    static final String KEY_AUTHOR = "author";
    static final String KEY_TITLE = "title";
    static final String KEY_DESCRIPTION = "description";
    static final String KEY_URL = "url";
    static final String KEY_URLTOIMAGE = "urlToImage";
    static final String KEY_PUBLISHEDAT = "publishedAt";
    ListView listNews;
    @Override
    protected void onPreExecute() { super.onPreExecute(); }

    protected String doInBackground(String... args) {
//            String xml = Function.excuteGet("https://newsapi.org/v1/articles?source=" + NEWS_SOURCE + "&sortBy=top&apiKey=" + API_KEY);
        String xml = Function.excuteGet("https://newsapi.org/v2/everything?sortBy=publishedAt&q=tesla&from=2019-10-19&apiKey=530a5c059857443595116cf3702a1463");
        return xml;
    }

    @Override
    protected void onPostExecute(String xml) {

        if (xml.length() > 10) { // Just checking if not empty


            JSONObject jsonResponse = null;
            try {
                jsonResponse = new JSONObject(xml);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray jsonArray = jsonResponse.optJSONArray("articles");

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = jsonArray.getJSONObject(i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    HashMap<String, String> map = new HashMap<>();
                    map.put(KEY_AUTHOR, jsonObject.optString(KEY_AUTHOR));
                    map.put(KEY_TITLE, jsonObject.optString(KEY_TITLE));
                    map.put(KEY_DESCRIPTION, jsonObject.optString(KEY_DESCRIPTION));
                    map.put(KEY_URL, jsonObject.optString(KEY_URL));
                    map.put(KEY_URLTOIMAGE, jsonObject.optString(KEY_URLTOIMAGE));
                    map.put(KEY_PUBLISHEDAT, jsonObject.optString(KEY_PUBLISHEDAT));
                    dataList.add(map);
                }

//            ListNewsAdapter adapter = new ListNewsAdapter(DownloadNews.this, dataList);
//            listNews.setAdapter(adapter);
//
//            listNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                public void onItemClick(AdapterView<?> parent, View view,
//                                        int position, long id) {
//                    Intent i = new Intent(MainActivity.this, DetailsActivity.class);
//                    i.putExtra("url", dataList.get(+position).get(KEY_URL));
//                    startActivity(i);
//                }
//            });

        }
    }
}