package com.example.pa3_temperament;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class QuizSummary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_summary);
        System.out.println("FIRST BENCHMARK");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = String.valueOf(extras.getString("score"));
            System.out.println(value+ "ABSCDSA ");
            TextView txt_result = findViewById(R.id.finalScore);
            System.out.println(txt_result);
            System.out.println("MID BENCHMARK");
            txt_result.setText(value);
        }
        System.out.println("SECOND BENCHMARK");




    }
}
