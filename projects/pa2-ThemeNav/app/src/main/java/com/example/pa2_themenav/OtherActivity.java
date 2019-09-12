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
    String[] array = {"Jordan Bell", "Chris Boucher", "Quinn Cook", "Stephen Curry",
    "Kevin Durant", "Draymond Green", "Andre Iguodala", "Shaun Livingston", "Javale McGee",
    "Klay Thompson", "David West", "Nick Young"};
    ArrayList<String> playerList = new ArrayList<String>(Arrays.asList(array));

    // Get a reference to the ListView
    shoppingListView =
            (ListView)findViewById(R.id.shopping_list_view);

    // Create a new Array Adapter
// Specify which layout and view to use for a row
// and the data (array) to use
    ArrayAdapter<String> arrayAdapter = new
            ArrayAdapter<String>(this, R.layout.player_list_row,
            R.id.player_list_row, playerList);

// Link the ListView and the Adapter
shoppingListView.setAdapter(arrayAdapter);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
    }



}
