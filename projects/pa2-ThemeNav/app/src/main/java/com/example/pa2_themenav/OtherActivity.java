package com.example.pa2_themenav;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * The purpose of this file is to show the plyaer list through an arrayList. The file shows
 * all of the player names in the GSW and those that were in the finals!
 *
 */
public class OtherActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        // changes action bar color to blue
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000ff")));

        ListView playerListView = (ListView) findViewById(R.id.listView);

        // initialize list

        String[] array = {"Jordan Bell", "Chris Boucher", "Quinn Cook", "Stephen Curry",
                "Kevin Durant", "Draymond Green", "Andre Iguodala", "Shaun Livingston", "Javale McGee",
                "Klay Thompson", "David West", "Nick Young"};

        // changes array to list

        ArrayList<String> playerList = new ArrayList<String>(Arrays.asList(array));
        ArrayAdapter<String> arrayAdapter = new
                ArrayAdapter<String>(this, R.layout.player_list,
                R.id.player_list_row, playerList);

        playerListView.setAdapter(arrayAdapter);




    }



}
