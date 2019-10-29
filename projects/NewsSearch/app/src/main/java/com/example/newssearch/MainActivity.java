package com.example.newssearch;

//https://newsapi.org/v2/everything?sortBy=publishedAt&q=bitcoin&from=2019-10-19&apiKey=530a5c059857443595116cf3702a1463
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import android.os.Bundle;

import com.example.newssearch.R;


//https://androstock.com/tutorials/create-a-news-app-on-android-android-studio.html

//api key: 530a5c059857443595116cf3702a1463
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//        start gFrag = new start();
//        gFrag.setContainerActivity(this);
//
//
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//
//        transaction.add(R.id.good_or_bad_layout, gFrag);
//        transaction.addToBackStack(null);
//        transaction.commit();
//
//    }
//}
public class MainActivity extends AppCompatActivity {






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        start gFrag = new start();
        gFrag.setContainerActivity(this);


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.add(R.id.format, gFrag);
        transaction.addToBackStack(null);
        transaction.commit();
//




    }



}