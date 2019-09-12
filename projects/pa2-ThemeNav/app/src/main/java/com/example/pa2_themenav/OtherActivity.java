package com.example.pa2_themenav;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class OtherActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);



        ListView playerListView = (ListView) findViewById(R.id.listView);

        String[] array = {"Jordan Bell", "Chris Boucher", "Quinn Cook", "Stephen Curry",
                "Kevin Durant", "Draymond Green", "Andre Iguodala", "Shaun Livingston", "Javale McGee",
                "Klay Thompson", "David West", "Nick Young"};

        ArrayList<String> playerList = new ArrayList<String>(Arrays.asList(array));
        ArrayAdapter<String> arrayAdapter = new
                ArrayAdapter<String>(this, R.layout.player_list,
                R.id.player_list_row, playerList);

        playerListView.setAdapter(arrayAdapter);





    }



}
