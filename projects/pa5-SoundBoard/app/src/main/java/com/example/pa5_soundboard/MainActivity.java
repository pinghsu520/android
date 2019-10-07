package com.example.pa5_soundboard;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button one = (Button) this.findViewById(R.id.button1);
        final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.tiger);
        one.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                mp1.start();
            }
        });


        Button two = (Button) this.findViewById(R.id.button2);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.polar);
        two.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                mp2.start();
            }
        });



        Button three = (Button) this.findViewById(R.id.button3);
        final MediaPlayer mp3 = MediaPlayer.create(this, R.raw.wolf);
        three.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                mp3.start();
            }
        });


        Button four = (Button) this.findViewById(R.id.button4);
        final MediaPlayer mp4 = MediaPlayer.create(this, R.raw.elephant);
        four.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                mp4.start();
            }
        });
    }
}
