package com.example.pa6flickr;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}




//
//package com.benjdd.fetchjson;
//
//        import androidx.appcompat.app.AppCompatActivity;
//
//        import android.content.Context;
//        import android.os.AsyncTask;
//        import android.os.Bundle;
//        import android.widget.LinearLayout;
//        import android.widget.TextView;
//
//        import org.json.JSONArray;
//        import org.json.JSONObject;
//
//        import java.io.BufferedReader;
//        import java.io.InputStreamReader;
//        import java.net.URL;
//        import java.util.LinkedList;
//        import java.util.List;
//        import java.util.Map;
//
//public class MainActivity extends AppCompatActivity {
//
//    public static MainActivity itself = null;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        itself = this;
//        new DownloadTask().execute();
//    }
//
//    private class DownloadTask extends AsyncTask<Object, Void, JSONObject>  {
//
//        @Override
//        protected JSONObject doInBackground(Object[] objects) {
//            try {
//
//                String json = "";
//                String line;
//                URL url = new URL("put the url here"); /** TODO url */
//                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
//                while ((line = in.readLine()) != null) {
//                    System.out.println("JSON LINE " + line);
//                    json += line;
//                }
//                in.close();
//
//                /** TODO
//                 * Create a JSONObject from the string, and return it
//                 */
//            } catch (Exception e) { e.printStackTrace(); }
//
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(JSONObject tiobe) {
//            /** TODO
//             * Get the ranking title and date, and display on the activity UI
//             * Iterate through the rankings, and display in-order
//             */
//        }
//    }
//}