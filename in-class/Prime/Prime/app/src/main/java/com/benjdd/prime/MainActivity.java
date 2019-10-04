package com.benjdd.prime;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculatePrime(View v) {
        EditText editText = this.findViewById(R.id.max_num);
        long number = Integer.parseInt(editText.getText().toString());
        boolean isPrime = isNumberPrime(number);
        TextView tv = findViewById(R.id.prime_num);
        tv.setText("Is it a prime number? " + isPrime);
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

    public boolean isNumberPrime(long number) {

        long maxNumber = number;

        boolean isPrime = true;
        for (long num = 2; num <= maxNumber; num++) {
            isPrime = true;
            for (long i=2; i <= num/2; i++) {
                if ( num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        return isPrime;
    }
}
