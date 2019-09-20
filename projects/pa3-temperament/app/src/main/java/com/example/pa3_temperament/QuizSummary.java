package com.example.pa3_temperament;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;

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
        TextView txt_result1 = findViewById(R.id.cholericScore);
        txt_result1.setText("Your choleric score is: "+choleric);
        int melancholic=Character.getNumericValue(lastStr.charAt(6))+Character.getNumericValue(lastStr.charAt(8))
                +Character.getNumericValue(lastStr.charAt(10));
        TextView txt_result2 = findViewById(R.id.melancholicScore);
        txt_result2.setText("Your melancholic score is: "+melancholic);
        int phlegmatic=Character.getNumericValue(lastStr.charAt(12))+Character.getNumericValue(lastStr.charAt(14))
                +Character.getNumericValue(lastStr.charAt(16));
        TextView txt_result3 = findViewById(R.id.phlegmaticScore);
        txt_result3.setText("Your phlegmatic score is: "+phlegmatic);
        int sanguine=Character.getNumericValue(lastStr.charAt(18))+Character.getNumericValue(lastStr.charAt(20))
                +Character.getNumericValue(lastStr.charAt(22));
        TextView txt_result4 = findViewById(R.id.sanguineScore);
        txt_result4.setText("Your sanguine score is: "+sanguine);
        int[] nums=new int[4];
        nums[0]=choleric;
        nums[1]=melancholic;
        nums[2]=phlegmatic;
        nums[3]=sanguine;
        Arrays.sort(nums);
        int maxval=nums[nums.length-1];
        System.out.println("Maximum = " + maxval);
        System.out.println("This is chloreic score"+choleric);
        System.out.println("This is melancholic score"+melancholic);
        System.out.println("This is phlegmatic score"+phlegmatic);
        System.out.println("This is sanguine score"+sanguine);
        // second stringindex at 7,9,11 is melanchol...


    }
}
