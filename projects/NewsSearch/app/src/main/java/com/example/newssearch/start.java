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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The purpose of this class is to start the first fragment that displays a button, a textview, an
 * editView, and a listview. The fragment calls on AsyncTask and uses an adapter to modify the
 * listView. The listView displays the author and also the publisher of the website to the user and
 * that is implemented with a ScrollView.
 *
 */
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
    TextView outer;
    private Activity containerActivity = null;
    private View inflatedView = null;

    private ListView contactsListView;
    ArrayAdapter<String> contactsAdapter = null;
    ArrayList<String> contacts = new ArrayList<String>();

    String publicXML="https://newsapi.org/v2/everything?sortBy=publishedAt&q=arizona&from=2019-10-19&apiKey=530a5c059857443595116cf3702a1463";
    Button button;
    public start() { }

    public void setContainerActivity(Activity containerActivity) {
        this.containerActivity = containerActivity;
    }
    // Fragments use CreateView and thus uses an inflater to strap onto the fragment
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        // file that ocntains listview
        inflatedView = inflater.inflate(R.layout.fragment_start, container, false);
        new DownloadNews().execute();
        button=(Button) inflatedView.findViewById(R.id.button);

        // This button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                System.out.println("hi");
                String fname = ((EditText)inflatedView.findViewById(R.id.editText)).getText().toString();
                System.out.println(fname);
                String first="https://newsapi.org/v2/everything?sortBy=publishedAt&q=";
                String second="&from=2019-10-19&apiKey=530a5c059857443595116cf3702a1463";
                publicXML=first+fname+second;
                contacts.clear();
                new DownloadNews().execute();
            }
        });
        return inflatedView;
    }




    @Override
    public void onResume() {
        super.onResume();

    }

    // sets up contaact adapter for creation of dicitonary

    private void setupContactsAdapter() {
        // R.id.listNews- list of news
        System.out.println("FIRST");
        contactsListView =
                (ListView)containerActivity.findViewById(R.id.listNews
                );
        // R.layout. = xml file that is the row
        // R. id =textview in row
        System.out.println("SECOND");
        System.out.println(contacts);

        contactsAdapter = new
                ArrayAdapter<String>(containerActivity, R.layout.list_row,
                R.id.title, contacts);
        System.out.println("third");

        contactsListView.setAdapter(contactsAdapter);


    }



    class DownloadNews extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            System.out.println ("ON PRE EXECUTE");
            super.onPreExecute(); }

        protected String doInBackground(String... args) {
            System.out.println("DO IN BACKGROUND");
            System.out.println(publicXML);
//            String xml = Function.excuteGet("https://newsapi.org/v1/articles?source=" + NEWS_SOURCE + "&sortBy=top&apiKey=" + API_KEY);
            String xml = Function.excuteGet(publicXML);
            return xml;


        }


        // purpose of this function is to get the json object and parse through the information
        @Override
        protected void onPostExecute(String xml) {


            System.out.println("BLAH BLAH BLAH");
            if (xml.length() > 10) { // Just checking if not empty

                JSONObject jsonResponse = null;
                try {
                    jsonResponse = new JSONObject(xml);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                // The json response goes through object articles
                JSONArray jsonArray = jsonResponse.optJSONArray("articles");
                System.out.println(jsonArray);
                System.out.println ("BEFORE STORM");


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
                        // adds authors and information of fragment
                        try {

                            JSONObject image1=jsonArray.getJSONObject(i);

                            JSONObject test=image1.getJSONObject("source");

                            String lastone=test.getString("name");
                            contacts.add(lastone +"                "+"("+jsonObject.optString(KEY_AUTHOR)+")");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

//                        contacts.add("(author: "+jsonObject.optString(KEY_AUTHOR)+")");
                    }
                    System.out.println("THIS IS LIST");
                    System.out.println(dataList);
                    System.out.println(contacts);

                    setupContactsAdapter();
                // Updates the mouse click on the list news

                listNews=(ListView) inflatedView.findViewById(R.id.listNews);
                listNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {


                        System.out.println("blah");
                        // last part lol

//                        Intent i = new Intent(getActivity(), DetailsActivity.class);
//                        i.putExtra("url", dataList.get(+position).get(KEY_URL));
//                        startActivity(i);
//                    }

                    // Creates second page, passes on information
                    SecondPage cif=new SecondPage();
                    Bundle bundle=new Bundle();
                    bundle.putString("display_text", "asd;lfkjasdflkj");
                    cif.setArguments(bundle);

                    // implements fragment transaction
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    System.out.println("BLAH BLAH BLAH");
                    transaction.replace(R.id.initial, cif);
                    transaction.addToBackStack(null);
                    transaction.commit();


                        // Last part, didn't have time to implement it! Clicking and leading to web page

//
//            listNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                public void onItemClick(AdapterView<?> parent, View view,
//                                        int position, long id) {
//                    Intent i = new Intent(MainActivity.this, DetailsActivity.class);
//                    i.putExtra("url", dataList.get(+position).get(KEY_URL));
//                    startActivity(i);
//                }


                    }

                });


            }


            super.onPostExecute(xml);
        }
    }


}
