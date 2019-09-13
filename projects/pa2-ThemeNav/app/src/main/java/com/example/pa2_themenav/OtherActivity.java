package com.example.pa2_themenav;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class OtherActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
//
//        ActionBar bar = getActionBar();
//        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000ff")));

        ListView playerListView = (ListView) findViewById(R.id.listView);

        String[] array = {"Jordan Bell", "Chris Boucher", "Quinn Cook", "Stephen Curry",
                "Kevin Durant", "Draymond Green", "Andre Iguodala", "Shaun Livingston", "Javale McGee",
                "Klay Thompson", "David West", "Nick Young"};

        ArrayList<String> playerList = new ArrayList<String>(Arrays.asList(array));
        ArrayAdapter<String> arrayAdapter = new
                ArrayAdapter<String>(this, R.layout.player_list,
                R.id.player_list_row, playerList);

        playerListView.setAdapter(arrayAdapter);



        // second view
        // gotta change line 53 haha, right now getting player!

//        ListView shoppingImageListView = (ListView) findViewById(R.id.listView);
//        int[] shoppingImageArray = new int[]{R.drawable.angle1, R.drawable.angle2, R.drawable.angle3, R.drawable.outside};
//        ArrayList<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
//        for(int i = 0; i < shoppingImageArray.length; i++){
//            HashMap<String, String> hm = new HashMap<String, String>();
//            hm.put("imageView", Integer.toString(shoppingImageArray[i]));
//            hm.put("shopping_list_row_item", playerList.get(i));
//            aList.add(hm);
//        }
//
//        String[] from = {"imageView", "shopping_list_row_item"};
//        int[] to = {R.id.imageView, R.id.player_list_row};
//        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.player_list , from, to);
//        playerListView = findViewById(R.id.listView);
//        playerListView.setAdapter(simpleAdapter);



    }



}
