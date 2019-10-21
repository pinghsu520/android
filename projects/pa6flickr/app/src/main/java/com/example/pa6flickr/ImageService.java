package com.example.pa6flickr;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class ImageService extends IntentService {


    Handler handler;

    public ImageService() {
        super("ImageFetcherService");
    }

    public ImageService(String name) {
        super(name);
    }

    @Override
    public void onCreate() {
        handler = new Handler();
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle == null) {
            return;
        }

        Messenger messenger = (Messenger) bundle.get("MESSENGER");
        String url_c1=(String) bundle.get("test1");
        String url_c2=(String) bundle.get("test2");
        String toDisplay=url_c1;


        Bitmap image=getBitmapFromURL(url_c1);
        Bitmap image2=getBitmapFromURL(url_c2);
        Message msg=Message.obtain();
        Message msg2=Message.obtain();
        msg.obj=image;
        msg2.obj=image2;

            try {
                messenger.send(msg);
                messenger.send(msg2);
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }



    }

    public static Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
//    @Override
//    protected void onHandleIntent(Intent intent) {
//        if (intent != null) {
//            final String action = intent.getAction();
//            if (ACTION_FOO.equals(action)) {
//                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
//                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
//                handleActionFoo(param1, param2);
//            } else if (ACTION_BAZ.equals(action)) {
//                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
//                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
//                handleActionBaz(param1, param2);
//            }
//        }
//    }



}
