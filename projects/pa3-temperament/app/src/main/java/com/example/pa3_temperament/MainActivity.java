package com.example.pa3_temperament;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button secondButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.team_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });

        String test = "";
        Context context = getApplicationContext();


        ArrayList<String> answer = new ArrayList<String>();

        test = readRawTextFile(context);
        String updated[] = test.split("\\r?\\n");
//        System.out.println("HERE IT IS:" + (test));
        ArrayList<String> cholericList = new ArrayList<String>(Arrays.asList(updated));
        System.out.println("HERE IT IS:" + (cholericList));
        Collections.shuffle(cholericList);
        answer.add(cholericList.get(0));
        answer.add(cholericList.get(1));
        answer.add(cholericList.get(2));

        System.out.println("BIG LIST:" + (answer));


//        ArrayList<String> first=new ArrayList<String>();
//        try {
//            first=readLine("choleric.txt");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        for (String member : first){
//            Log.i("Member name: ", member);
//        }

    }


    public void openActivity1() {
        Intent intent = new Intent(this, OtherActivity.class);
        startActivity(intent);
    }


    public String readRawTextFile(Context ctx) {
        InputStream inputStream = getResources().openRawResource(
                getResources().getIdentifier("choleric",
                        "raw", getPackageName()));

        InputStreamReader inputreader = new InputStreamReader(inputStream);
        BufferedReader buffreader = new BufferedReader(inputreader);
        String line;
        StringBuilder text = new StringBuilder();

        try {
            while ((line = buffreader.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
        } catch (IOException e) {
            return null;
        }
        return text.toString();
    }
}


