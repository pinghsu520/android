package com.example.pa6flickr;

// doinBacground (json) onPostexecute  (json) onAttatchedtoWindwo (from imagefetcher)

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    public static MainActivity itself = null;
    String url_c1;
    String url_c2;
    private int i=0;
    Button goNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itself = this;

        new DownloadTask().execute();
    }

    public void clicked_image(View v){
        if(v.getId()==R.id.goNext){
            System.out.println("hi");
        }
    }



    public void onAttachedToWindow(String url_c1, String url_c2) {

        final int firstImageID=R.id.image1;
        final int secondImageID=R.id.image2;



        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                Bitmap image = (Bitmap) msg.obj;

                if(i==1){
                    System.out.println("FIRSTHIT");
                    ImageView secondimage = findViewById(secondImageID);
                    secondimage.setImageBitmap(image);
                }
                else{
                    System.out.println("SECONDHIT");
                    ImageView firstimage = findViewById(firstImageID);
                    firstimage.setImageBitmap(image);
                    i++;
                }


            }
        };

        Intent intent = new Intent(this, ImageService.class);
        intent.putExtra("MESSENGER", new Messenger(handler));
        String url1=url_c1;
        String url2=url_c2;
        intent.putExtra("test1", url1);
        intent.putExtra("test2", url2);
        startService(intent);
        i=0;
    }




    private class DownloadTask extends AsyncTask<Object, Void, JSONObject>  {
        public String newsBaseUrl = "https://www.flickr.com/services/rest/?method=flickr.photos.getRecent&api_key=c68268937007bf1cc8ac4be2d67276b0&extras=url_c%2Cdate_upload%2Ctags&per_page=2&page=1&format=json&nojsoncallback=1";

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
                JSONObject image1=array.getJSONObject(0);
                JSONObject image2=array.getJSONObject(1);
                String dateupload1=image1.getString("dateupload");
                url_c1=image1.getString("url_c");
                System.out.println("THIS IS FIRST ULR!!!"+url_c1);
                String tags1=image1.getString("tags");
                String dateupload2=image2.getString("dateupload");
                url_c2=image2.getString("url_c");
                String tags2=image2.getString("tags");
                System.out.println("THIS IS FIRST ULR!!!"+url_c2);
                onAttachedToWindow(url_c1,url_c2);

//
//                ImageView firstimage = findViewById(R.id.image1);
//                ImageView secondimage = findViewById(R.id.image2);
//
//                TextView setFirstDate=findViewById(R.id.firstdate);
//                setFirstDate.setText(dateupload1);
//                TextView setFirstTag=findViewById(R.id.firsttag);
//                setFirstTag.setText(tags1);
//
//                new DownloadImageTask(firstimage).execute(url_c1);
//                new DownloadImageTask(secondimage).execute(url_c2);



            } catch (Exception e) {
                e.printStackTrace();
            }

//            getIntent()


        }
    }
}