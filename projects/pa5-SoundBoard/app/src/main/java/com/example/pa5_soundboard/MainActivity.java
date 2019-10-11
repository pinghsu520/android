package com.example.pa5_soundboard;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    int count=0;
    Button theTopOne;
    private Handler mHandler;
    private Runnable mRunnable;
    int blah;
    // this variable excludes the first time from being called the sleep function!
    int delayTime=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHandler = new Handler();
        theTopOne=(Button) findViewById(R.id.delay);
        
        theTopOne.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                blah=0;
                count++;
                System.out.println("COUNT: "+count);
                if(count==1){
                    System.out.println("yellow");
                    delayTime=1500;
                    theTopOne.setBackgroundColor(Color.parseColor("#e6b121"));
                    
                }
                else if(count==2){
                    
                    System.out.println("green");
                    theTopOne.setBackgroundColor(Color.parseColor("#39ff14"));
                    delayTime=3000;
                    
                }
                else {
                    System.out.println("red");
                    delayTime=0;
                    theTopOne.setBackgroundColor(Color.parseColor("#ff0000"));
                    count-=3;
                }

            }
            });


        Button one = (Button) this.findViewById(R.id.button1);
        final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.tiger);

        one.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if(blah==1) {
                    try {
                        Thread.sleep(delayTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mp1.start();
                blah=1;
            }
        });


        Button two = (Button) this.findViewById(R.id.button2);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.polar);

        two.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                if(blah==1) {
                    try {
                        Thread.sleep(delayTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mp2.start();
                blah=1;
            }
        });



        Button three = (Button) this.findViewById(R.id.button3);
        final MediaPlayer mp3 = MediaPlayer.create(this, R.raw.wolf);

        three.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                if(blah==1) {
                    try {
                        Thread.sleep(delayTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mp3.start();
                blah=1;
            }
        });


        Button four = (Button) this.findViewById(R.id.button4);
        final MediaPlayer mp4 = MediaPlayer.create(this, R.raw.elephant);

        four.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                if(blah==1) {
                    try {
                        Thread.sleep(delayTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mp4.start();
                blah=1;
            }
        });

    }
}
