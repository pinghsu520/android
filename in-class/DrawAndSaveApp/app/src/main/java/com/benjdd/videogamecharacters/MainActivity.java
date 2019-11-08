package com.benjdd.videogamecharacters;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    DrawingView dv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dv = new DrawingView(this, null);
        LinearLayout ll = findViewById(R.id.drawing);
        ll.addView(dv);
    }

    public void clearDrawing(View v) {
        dv.startNew();
    }

    public void addDrawing(View v) {
        Bitmap b = dv.getBitmap();
        ImageView iv = new ImageView(this);
        iv.setImageBitmap(b);
        LinearLayout ll = findViewById(R.id.list_of_drawings);
        ll.addView(iv);
    }

}

