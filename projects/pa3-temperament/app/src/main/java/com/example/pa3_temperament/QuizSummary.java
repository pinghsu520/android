package com.example.pa3_temperament;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class QuizSummary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("FIRST BENCHMARK");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = String.valueOf(extras.getInt("score"));
            TextView txt_result = (TextView) findViewById(R.id.finalScore);
            txt_result.setText(value);
        }
        System.out.println("SECOND BENCHMARK");


        setContentView(R.layout.activity_quiz_summary);

    }
}
