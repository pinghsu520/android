package com.example.pa6flickr;

/*

The purpose of this program was to access FLICKR's API through the get Recent call. The interface
loads two pictures with all meta data information and is important respective to each photo. The interface
also has 3 buttons: back, reset and next which cycles through new pictures every click!

 */

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
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

    // declares global variables that are called
    public static MainActivity itself = null;
    String url_c1;
    String url_c2;
    private int i = 0;
    Button goNext;
    int pageNum = 1;
    int firstCount=1;

    String owner1;
    String owner2;
    String ownerID1;
    String ownerID2;
// Initializes main and starts activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itself = this;

        new DownloadTask().execute();
    }

    // When clicking on image, takes it to url. The purpose of this function is to allow the user to
    // enter a new page
    public void ClickImage(View V){
        // First image
        if(V.getId()==R.id.image1){
            String url_image="https://flickr.com/photos/"+owner1+"/"+ownerID1;
            System.out.println(url_image);
            Intent browserIntent=new Intent(Intent.ACTION_VIEW,  Uri.parse(url_image));
            startActivity(browserIntent);
        }
        else{
            String url_image2="https://flickr.com/photos/"+owner2+"/"+ownerID2;
            System.out.println(url_image2);
            Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse(url_image2));
            startActivity(browserIntent);
        }
    }

    // This clicks on the next picture and cycles to a new page!
    public void clicked_next_image(View v){
            System.out.println(this.pageNum);
            pageNum++;
            new DownloadTask().execute();


    }

    // This is for the reset button and takes them to the first page
    public void startAgain(View v){
        pageNum=1;
        new DownloadTask().execute();
    }

    // This clicks on the previous image
    public void clicked_prev_image(View v){
        System.out.println(this.pageNum);
        pageNum--;
        new DownloadTask().execute();


    }

    // The purpose of this function is to call a handler and demonstrates getting hte image URL and
    // also getting metadata information
    public void onAttachedToWindow(String url_c1, String url_c2) {

        final int firstImageID=R.id.image1;
        final int secondImageID=R.id.image2;


        // handler processes first and second images
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                Bitmap image = (Bitmap) msg.obj;

                if(i==1){
                    ImageView secondimage = findViewById(secondImageID);
                    secondimage.setImageBitmap(image);
                }
                else{
                    ImageView firstimage = findViewById(firstImageID);
                    firstimage.setImageBitmap(image);
                    i++;
                }


            }
        };

        // The purpose of this block is to start an intent and send in urls to the program
        Intent intent = new Intent(this, ImageService.class);
        intent.putExtra("MESSENGER", new Messenger(handler));
        String url1=url_c1;
        String url2=url_c2;
        intent.putExtra("test1", url1);
        intent.putExtra("test2", url2);
        startService(intent);
        i=0;
    }



    // This private class gets the json information through the URL api.
    private class DownloadTask extends AsyncTask<Object, Void, JSONObject>  {
        public String newsBaseUrl = "https://www.flickr.com/services/rest/?method=flickr.photos.getRecent&api_key=c68268937007bf1cc8ac4be2d67276b0&extras=url_c%2Cdate_upload%2Ctags&per_page=&page="+Integer.toString(pageNum)+"&format=json&nojsoncallback=1";

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


        // The purpose of this function is to call and execute that grabs the infromation needed
        // from the JSON object. I parsed through the object to grab the meta data.
        @Override
        protected void onPostExecute(JSONObject json) {

            try {

                System.out.println(json);
                JSONObject jsonObject1=json.getJSONObject("photos");
                JSONArray array=jsonObject1.getJSONArray("photo");
                // grabbed json object
                JSONObject image1=array.getJSONObject(0);
                JSONObject image2=array.getJSONObject(1);
                String dateupload1=image1.getString("dateupload");
                url_c1=image1.getString("url_c");
                // grabbed tag
                String tags1=image1.getString("tags");
                String dateupload2=image2.getString("dateupload");
                url_c2=image2.getString("url_c");
                String tags2=image2.getString("tags");
                // called on attatch to window
                onAttachedToWindow(url_c1,url_c2);
                String type1=url_c1.substring(url_c1.length() - 3);
                String type2=url_c2.substring(url_c2.length() - 3);
                TextView firstdate = (TextView)findViewById(R.id.textView);
                firstdate.setText(dateupload1);
                // set text blocks

                TextView secondate = (TextView)findViewById(R.id.textView7);
                secondate.setText(dateupload2);

                System.out.println(image1);
                System.out.println("first tag"+tags1);
                System.out.println("sec tag"+tags2);

                TextView firsttag = (TextView)findViewById(R.id.textView3);
                firsttag.setText(tags1);

                // set second text block
                TextView secondtag = (TextView)findViewById(R.id.textView6);
                secondtag.setText(tags2);


                TextView firstType = (TextView)findViewById(R.id.textView2);
                firstType.setText(type1);

                TextView secondType = (TextView)findViewById(R.id.textView5);
                secondType.setText(type2);
                // info for the images!
                owner1=image1.getString("owner");
                owner2=image2.getString("owner");


                ownerID1=image1.getString("id");
                ownerID2=image2.getString("id");



            } catch (Exception e) {
                e.printStackTrace();
            }



        }
    }
}