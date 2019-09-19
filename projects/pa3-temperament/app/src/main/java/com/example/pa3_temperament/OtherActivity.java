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
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

    private int count=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);


        String test = "";
        String test2="";
        String test3="";
        String test4="";
        Context context = getApplicationContext();


        final ArrayList<String> answer = new ArrayList<String>();

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
                buttonClick(v, answer);
            }
        });

    }

    public void openActivity2() {
        Intent intent = new Intent(this, QuizSummary.class);
        startActivity(intent);
    }


    public void buttonClick(View v, ArrayList<String> answer)
    {
        count=count+1;
        System.out.println(count);
            TextView question = (TextView) findViewById(R.id.question);
            question.setText(answer.get(count));
            if(count==11){
                openActivity2();
            }

    }

    public void onRadioButtonClicked(View view) {
        View rdS1 = findViewById(R.id.rd_s1);
        View rdS2 = findViewById(R.id.rd_s2);
        View rdS3 =  findViewById(R.id.rd_s3);
        View rdS4 = findViewById(R.id.rd_s4);
        Intent i = new Intent(OtherActivity.this, QuizSummary.class);
        RadioGroup rdgS=rdgS = (RadioGroup) findViewById(R.id.rdS1);

        switch (rdgS.getCheckedRadioButtonId()) {
            case R.id.rd_s1:

                i.putExtra("score", 10);
                break;
            case R.id.rd_s2:
                i.putExtra("score1", 20);
                break;
            case R.id.rd_s3:
                i.putExtra("score2", 30);
                break;
            case R.id.rd_s4:
                i.putExtra("score3", 40);
                break;

            default:
                break;
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
