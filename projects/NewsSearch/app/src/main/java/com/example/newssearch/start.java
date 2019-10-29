package com.example.newssearch;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newssearch.MainActivity;
import com.example.newssearch.R;



import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class start extends Fragment {
    String API_KEY = "8190df9eb51445228e397e4185311a66"; // ### YOUE NEWS API HERE ###
    String NEWS_SOURCE = "techcrunch";
    ArrayList<HashMap<String, String>> dataList = new ArrayList<>();
    static String KEY_AUTHOR = "author";
    static String KEY_TITLE = "title";
    static String KEY_DESCRIPTION = "description";
    String KEY_URL = "url";
    String KEY_URLTOIMAGE = "urlToImage";
    static String KEY_PUBLISHEDAT = "publishedAt";
    ListView listNews;
    ProgressBar loader;

    private Activity containerActivity = null;
    private View inflatedView = null;

    private ListView contactsListView;
    ArrayAdapter<String> contactsAdapter = null;
    private ArrayList<String> contacts = new ArrayList<String>();

    public start() { }

    public void setContainerActivity(Activity containerActivity) {
        this.containerActivity = containerActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        // file that ocntains listview
        inflatedView = inflater.inflate(R.layout.fragment_start, container, false);

        return inflatedView;
    }

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);

        // WHERE THE CODE STARTS


//        loader = findViewById(R.id.loader);
//        listNews.setEmptyView(loader);


        com.example.newssearch.DownloadNews newsTask = new com.example.newssearch.DownloadNews();
        newsTask.execute();

        setupContactsAdapter();
    }

    @Override
    public void onResume() {
        super.onResume();

    }



    private void setupContactsAdapter() {
        // R.id.listNews- list of news
        System.out.println("FIRST");
        contactsListView =
                (ListView)containerActivity.findViewById(R.id.listNews
                );
        // R.layout. = xml file that is the row
        // R. id =textview in row
        System.out.println("SECOND");
        contactsAdapter = new
                ArrayAdapter<String>(containerActivity, R.layout.list_row,
                R.id.title, contacts);
        System.out.println("third");
        contactsListView.setAdapter(contactsAdapter);
//        MainActivity.DownloadNews newsTask = new MainActivity.DownloadNews();
//        newsTask.execute();
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


                ListNewsAdapter adapter = new ListNewsAdapter(getActivity(), dataList);
                listNews.setAdapter(adapter);

                listNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        Intent i = new Intent(getActivity(), DetailsActivity.class);
                        i.putExtra("url", dataList.get(+position).get(KEY_URL));
                        startActivity(i);
                    }
                });

            }
        }
    }


}
