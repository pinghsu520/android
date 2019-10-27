package com.example.newssearch;

//https://newsapi.org/v2/everything?sortBy=publishedAt&q=bitcoin&from=2019-10-19&apiKey=530a5c059857443595116cf3702a1463
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


//api key: 530a5c059857443595116cf3702a1463
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
