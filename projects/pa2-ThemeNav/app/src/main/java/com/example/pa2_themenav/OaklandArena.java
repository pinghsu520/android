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
 * The purpose of this file is to show the Oakland Arena listView starting from the pictures
 * of each image and a description to help the user understand it *
 *
 */
public class OaklandArena extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000ff")));

        // grabbed the text

        String info1 = getResources().getString(R.string.info1);;
        String info2 = getResources().getString(R.string.info2);
        String info3 = getResources().getString(R.string.info3);;
        String info4 = getResources().getString(R.string.info4);


        ListView playerListView = (ListView) findViewById(R.id.listView);

        // adds string to use

        String[] array = {info1, info2, info3, info4};


        ArrayList<String> playerList = new ArrayList<String>(Arrays.asList(array));
        ArrayAdapter<String> arrayAdapter = new
                ArrayAdapter<String>(this, R.layout.player_list,
                R.id.player_list_row, playerList);

        playerListView.setAdapter(arrayAdapter);

        // maps dict to arraylist

        ListView shoppingImageListView = (ListView) findViewById(R.id.listView);
        int[] shoppingImageArray = new int[]{R.drawable.angle1, R.drawable.angle2, R.drawable.angle3, R.drawable.outside};
        ArrayList<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
        for(int i = 0; i < shoppingImageArray.length; i++){
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("imageView", Integer.toString(shoppingImageArray[i]));
            hm.put("shopping_list_row_item", playerList.get(i));
            aList.add(hm);
        }

        // maps from array and to array to the simple adapter

        String[] from = {"imageView", "shopping_list_row_item"};
        int[] to = {R.id.imageView, R.id.player_list_row};
        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.player_list , from, to);
        playerListView = findViewById(R.id.listView);
        playerListView.setAdapter(simpleAdapter);
    }

}
