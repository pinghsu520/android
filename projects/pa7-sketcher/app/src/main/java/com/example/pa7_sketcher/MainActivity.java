package com.example.pa7_sketcher;

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


// purpose of main is to call the fragment through transaction
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create first pages
        start gFrag = new start();
        gFrag.setContainerActivity(this);
        // implement transaction

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // add second page
        transaction.add(R.id.format, gFrag);
        transaction.addToBackStack(null);
        transaction.commit();

    }

}