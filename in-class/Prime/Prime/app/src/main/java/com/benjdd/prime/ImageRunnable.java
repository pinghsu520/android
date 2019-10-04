package com.benjdd.prime;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageRunnable implements Runnable {


    String imageURL = null;
    AppCompatActivity invokerActivity = null;
    Bitmap imageData = null;

    public ImageRunnable(AppCompatActivity activity, String URL) {
    }

    @Override
    public void run() {
    }
}
