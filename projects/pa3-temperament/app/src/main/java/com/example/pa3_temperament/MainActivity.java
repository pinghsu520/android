package com.example.pa3_temperament;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

//        secondButton = (Button) findViewById(R.id.OakArena);
//        secondButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openActivity1();
//            }
//        });



    }

    public void openActivity1() {
        Intent intent = new Intent(this, OtherActivity.class);
        startActivity(intent);
    }

//    public void openActivity2() {
//        Intent intent = new Intent(this, OaklandArena.class);
//        startActivity(intent);
//    }
}