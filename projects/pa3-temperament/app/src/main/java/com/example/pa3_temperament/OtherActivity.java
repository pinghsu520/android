package com.example.pa3_temperament;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);


        String test = "";
        String test2="";
        String test3="";
        String test4="";
        Context context = getApplicationContext();


        ArrayList<String> answer = new ArrayList<String>();

        test = readRawTextFile(context, "choleric");
        String updated[] = test.split("\\r?\\n");
        ArrayList<String> cholericList = new ArrayList<String>(Arrays.asList(updated));
        Collections.shuffle(cholericList);
        answer.add(cholericList.get(0));
        answer.add(cholericList.get(1));
        answer.add(cholericList.get(2));


        test2 = readRawTextFile(context, "melancholic");
        String updated2[] = test2.split("\\r?\\n");
        ArrayList<String> melancholicList = new ArrayList<String>(Arrays.asList(updated2));
        Collections.shuffle(melancholicList);
        answer.add(melancholicList.get(0));
        answer.add(melancholicList.get(1));
        answer.add(melancholicList.get(2));
        System.out.println("BIG LIST:" + (answer));

        test3 = readRawTextFile(context, "phlegmatic");
        String updated3[] = test3.split("\\r?\\n");
        ArrayList<String> phlegmaticList = new ArrayList<String>(Arrays.asList(updated3));
        Collections.shuffle(phlegmaticList);
        answer.add(phlegmaticList.get(0));
        answer.add(phlegmaticList.get(1));
        answer.add(phlegmaticList.get(2));



        test4 = readRawTextFile(context, "sanguine");
        String updated4[] = test4.split("\\r?\\n");
        ArrayList<String> sanguineList = new ArrayList<String>(Arrays.asList(updated4));
        Collections.shuffle(sanguineList);
        answer.add(sanguineList.get(0));
        answer.add(sanguineList.get(1));
        answer.add(sanguineList.get(2));
        System.out.println("BIG LIST:" + (answer));


        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

    }

    public void openActivity2() {
        Intent intent = new Intent(this, QuizSummary.class);
        startActivity(intent);
    }


    public void buttonClick(View v, ArrayList<String> answer)
    {
        System.out.print("HELLO");
        for(int i=0;i<12;i++) {
            TextView tv = (TextView) findViewById(R.id.question);
            tv.setText(answer.get(i));
            openActivity2();
        }
    }

    public String readRawTextFile(Context ctx, String title) {
        InputStream inputStream = getResources().openRawResource(
                getResources().getIdentifier(title,
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
