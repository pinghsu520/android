package com.example.pa3_temperament;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class QuizSummary extends AppCompatActivity {
    private String lastStr="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_summary);
        System.out.println("FIRST BENCHMARK");
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = String.valueOf(extras.getString("score"));
            System.out.println(value+ "ABSCDSA ");
            lastStr=value;
            TextView txt_result = findViewById(R.id.finalScore);
            System.out.println(txt_result);
            System.out.println("MID BENCHMARK");
            txt_result.setText(value);
        }
        System.out.println("SECOND BENCHMARK");

        // first stringindexat(1,3,5) is score for chloeric...
//        System.out.println(lastStr.charAt(0));
//
//        System.out.println(lastStr.charAt(2));
//
//        System.out.println(lastStr.charAt(4));
        int choleric=Character.getNumericValue(lastStr.charAt(0))+Character.getNumericValue(lastStr.charAt(2))
                +Character.getNumericValue(lastStr.charAt(4));
        int melancholic=Character.getNumericValue(lastStr.charAt(6))+Character.getNumericValue(lastStr.charAt(8))
                +Character.getNumericValue(lastStr.charAt(10));
        int phlegmatic=Character.getNumericValue(lastStr.charAt(12))+Character.getNumericValue(lastStr.charAt(14))
                +Character.getNumericValue(lastStr.charAt(16));
        int sanguine=Character.getNumericValue(lastStr.charAt(18))+Character.getNumericValue(lastStr.charAt(20))
                +Character.getNumericValue(lastStr.charAt(22));
        System.out.println("This is chloreic score"+choleric);
        System.out.println("This is melancholic score"+melancholic);
        System.out.println("This is phlegmatic score"+phlegmatic);
        System.out.println("This is sanguine score"+sanguine);
        // second stringindex at 7,9,11 is melanchol...


    }
}
