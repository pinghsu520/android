package com.example.themecode;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.app.ActionBar;
import android.app.Activity;
//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        ScrollView scrollView = new ScrollView(getApplicationContext());
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        TextView textView = new TextView(getApplicationContext());
        textView.setText("the boy");


        Button button = new Button(getApplicationContext());
        button.setText("This Button is dynamically created");


        LinearLayout linearLayout = new LinearLayout(getApplicationContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(textView);
        linearLayout.addView(button);
        scrollView.addView(linearLayout);


//second way



//
//
////        ScrollView scrollView = new ScrollView(this);
////        scrollView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
////                ViewGroup.LayoutParams.MATCH_PARENT));
////
//
//        TextView textView = new TextView(this);
//        textView.setTextColor(Color.parseColor("#0000ff"));
//        textView.setText("This TextView is dynamically created\n" +
//                "This TextView is dynamically created\n" +
//                "This TextView is dynamically created\n" +
//                "This TextView is dynamically created\n" +
//                "This TextView is dynamically created\n" +
//                "This TextView is dynamically created\n");
//
//
////        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//        LinearLayout linearLayout = new LinearLayout(this);
//        linearLayout.setOrientation(LinearLayout.VERTICAL);
//
//
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
//        this.addContentView(linearLayout, layoutParams);
//        linearLayout.addView(textView);
//
//
//
//        ImageView imageView1 = new ImageView(this);
//            LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            params1.setMargins(0, 100, 0, 30);
//            params1.gravity = Gravity.CENTER;
//            imageView1.setLayoutParams(params1);
//            imageView1.setImageResource(R.drawable.gsw1);
//            linearLayout.addView(imageView1);
//
//            ImageView imageView2 = new ImageView(this);
//            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            params1.setMargins(20, 10, 20, 10);
//            params1.gravity = Gravity.CENTER;
//            imageView1.setLayoutParams(params1);
//            imageView1.setImageResource(R.drawable.gsw1);
//            linearLayout.addView(imageView2);
//
//        Button button = new Button(this);
//        button.setText("This Button is dynamically created");
//
//        // stuff that is added
//
//
//        linearLayout.addView(button);
//
////        this.addContentView(scrollView, layoutParams);
////        scrollView.addView(linearLayout);
//
//




        // THIRD WAY?
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_main);
//
//            ScrollView scrollView = new ScrollView(this);
//            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//            scrollView.setLayoutParams(layoutParams);
//
//            LinearLayout linearLayout = new LinearLayout(this);
//            LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            linearLayout.setOrientation(LinearLayout.VERTICAL);
//            linearLayout.setLayoutParams(linearParams);
//
//            scrollView.addView(linearLayout);

//            ImageView imageView1 = new ImageView(this);
//            LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            params1.setMargins(0, 30, 0, 30);
//            params1.gravity = Gravity.CENTER;
//            imageView1.setLayoutParams(params1);
//            imageView1.setImageResource(R.drawable.gsw1);
//            linearLayout.addView(imageView1);
//
//            ImageView imageView2 = new ImageView(this);
//            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            params2.setMargins(0, 0, 0, 30);
//            params2.gravity = Gravity.CENTER;
//            imageView2.setLayoutParams(params2);
//            imageView2.setImageResource(R.drawable.gsw2);
//            linearLayout.addView(imageView2);
//
//            ImageView imageView3 = new ImageView(this);
//            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            params3.setMargins(0, 0, 0, 30);
//            params3.gravity = Gravity.CENTER;
//            imageView3.setLayoutParams(params3);
//            imageView3.setImageResource(R.drawable.gsw3);
//            linearLayout.addView(imageView3);
//
//            ImageView imageView4 = new ImageView(this);
//            LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            params4.setMargins(0, 0, 0, 30);
//            params4.gravity = Gravity.CENTER;
//            imageView4.setLayoutParams(params4);
//            imageView4.setImageResource(R.drawable.gsw4);
//            linearLayout.addView(imageView4);


//            LinearLayout linearLayout1 = findViewById(R.id.rootContainer);
//            if (linearLayout1 != null) {
//                linearLayout1.addView(scrollView);
//            }
//        }



    }
}