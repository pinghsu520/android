package com.example.newssearch;

//https://newsapi.org/v2/everything?sortBy=publishedAt&q=bitcoin&from=2019-10-19&apiKey=530a5c059857443595116cf3702a1463
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import android.os.Bundle;

import com.example.newssearch.R;


//https://androstock.com/tutorials/create-a-news-app-on-android-android-studio.html

//api key: 530a5c059857443595116cf3702a1463
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//        start gFrag = new start();
//        gFrag.setContainerActivity(this);
//
//
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//
//        transaction.add(R.id.good_or_bad_layout, gFrag);
//        transaction.addToBackStack(null);
//        transaction.commit();
//
//    }
//}
public class MainActivity extends AppCompatActivity {

    String API_KEY = "8190df9eb51445228e397e4185311a66"; // ### YOUE NEWS API HERE ###
    String NEWS_SOURCE = "techcrunch"; // Other news source code at: https://newsapi.org/sources
    ListView listNews;
    ProgressBar loader;

    ArrayList<HashMap<String, String>> dataList = new ArrayList<>();
    static final String KEY_AUTHOR = "author";
    static final String KEY_TITLE = "title";
    static final String KEY_DESCRIPTION = "description";
    static final String KEY_URL = "url";
    static final String KEY_URLTOIMAGE = "urlToImage";
    static final String KEY_PUBLISHEDAT = "publishedAt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        start gFrag = new start();
//        gFrag.setContainerActivity(this);
//
//
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//
//        transaction.add(R.id.blah, gFrag);
//        transaction.addToBackStack(null);
//        transaction.commit();
//


        listNews = findViewById(R.id.listNews);
        loader = findViewById(R.id.loader);
        listNews.setEmptyView(loader);


        DownloadNews newsTask = new DownloadNews();
        newsTask.execute();


    }


    class DownloadNews extends AsyncTask<String, Void, String> {
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

                try {
                    JSONObject jsonResponse = new JSONObject(xml);
                    JSONArray jsonArray = jsonResponse.optJSONArray("articles");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        HashMap<String, String> map = new HashMap<>();
                        map.put(KEY_AUTHOR, jsonObject.optString(KEY_AUTHOR));
                        map.put(KEY_TITLE, jsonObject.optString(KEY_TITLE));
                        map.put(KEY_DESCRIPTION, jsonObject.optString(KEY_DESCRIPTION));
                        map.put(KEY_URL, jsonObject.optString(KEY_URL));
                        map.put(KEY_URLTOIMAGE, jsonObject.optString(KEY_URLTOIMAGE));
                        map.put(KEY_PUBLISHEDAT, jsonObject.optString(KEY_PUBLISHEDAT));
                        dataList.add(map);
                    }
                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), "Unexpected error", Toast.LENGTH_SHORT).show();
                }

                ListNewsAdapter adapter = new ListNewsAdapter(MainActivity.this, dataList);
                listNews.setAdapter(adapter);

                listNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        Intent i = new Intent(MainActivity.this, DetailsActivity.class);
                        i.putExtra("url", dataList.get(+position).get(KEY_URL));
                        startActivity(i);
                    }
                });

            } else {
                Toast.makeText(getApplicationContext(), "No news found", Toast.LENGTH_SHORT).show();
            }
        }
    }

}