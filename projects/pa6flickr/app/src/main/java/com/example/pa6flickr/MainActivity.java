package com.example.pa6flickr;

// doinBacground (json) onPostexecute  (json) onAttatchedtoWindwo (from imagefetcher)

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    public static MainActivity itself = null;
    String url_c1;
    String url_c2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itself = this;
        new DownloadTask().execute();
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();

        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                Bitmap image = (Bitmap) msg.obj;
                ImageView iv = findViewById(R.id.image1);
                iv.setImageBitmap(image);


//                Bitmap image2 = (Bitmap) msg.obj;
//                ImageView iv2 = findViewById(R.id.image2);
//                iv2.setImageBitmap(image2);
            }
        };

        Intent intent = new Intent(this, ImageService.class);
        intent.putExtra("MESSENGER", new Messenger(handler));
//        intent.putExtra(url_c1);
//        intent.putExtra(url_c1);
//        intent.putExtra();
        startService(intent);

        /** TODO (optional)
         * Can the image downloads be stopped when
         * the app goes into the background?
         */
    }

    private class DownloadTask extends AsyncTask<Object, Void, JSONObject>  {
        public String newsBaseUrl = "https://www.flickr.com/services/rest/?method=flickr.photos.getRecent&api_key=c68268937007bf1cc8ac4be2d67276b0&extras=url_c%2Cdate_upload%2Ctags&per_page=2&page=1&format=json&nojsoncallback=1";
        public String hardCodeimage = "https:\\/\\/live.staticflickr.com\\/65535\\/48938272337_8d788990fe_c.jpg";
        @Override
        protected JSONObject doInBackground(Object[] objects) {
            try {

                String json = "";
                String line;

                URL url = new URL(newsBaseUrl);

                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                while ((line = in.readLine()) != null) {
                    System.out.println("JSON LINE " + line);
                    json += line;
                }

                System.out.println(json);
                in.close();

                JSONObject jsonObject = new JSONObject(json);
                return jsonObject;
            } catch (Exception e) { e.printStackTrace(); }

            return null;
        }




        @Override
        protected void onPostExecute(JSONObject json) {

            try {

                System.out.println(json);
                JSONObject jsonObject1=json.getJSONObject("photos");
                JSONArray array=jsonObject1.getJSONArray("photo");
//                System.out.println("THIS IS ARR"+array);
                JSONObject image1=array.getJSONObject((0));
                JSONObject image2=array.getJSONObject(1);
                String dateupload1=image1.getString("dateupload");
                url_c1=image1.getString("url_c");
                String tags1=image1.getString("tags");
                String dateupload2=image2.getString("dateupload");
                url_c2=image2.getString("url_c");
                String tags2=image2.getString("tags");





            } catch (Exception e) {
                e.printStackTrace();
            }

//            getIntent()


        }
    }
    // test
}