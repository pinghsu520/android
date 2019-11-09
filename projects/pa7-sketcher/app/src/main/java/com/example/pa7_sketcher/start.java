package com.example.pa7_sketcher;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The purpose of this fragment is to show the display of the initial screen with the drawing.
 * This fragment calls on the
 *
 */
public class start extends Fragment {

    ListView listNews;
    ProgressBar loader;
    TextView outer;
    private Activity containerActivity = null;
    private View inflatedView = null;

    DrawingView dv = null;
    Button button;

    public start() { }

    public void setContainerActivity(Activity containerActivity) {
        this.containerActivity = containerActivity;
    }
@Override
public View onCreateView(LayoutInflater inflater,
                         ViewGroup container,
                         Bundle savedInstanceState) {

    // file that ocntains listview
    inflatedView = inflater.inflate(R.layout.fragment_start, container, false);

    // This button makes red color
    button=(Button) inflatedView.findViewById(R.id.buttonRed);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            dv.drawPaint.setColor(getResources().getColor((R.color.red)));
        }
    });


    // This button makes green color
    button=(Button) inflatedView.findViewById(R.id.buttonGreen);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            dv.drawPaint.setColor(getResources().getColor((R.color.green)));
        }
    });


    // This button makes blue color
    button=(Button) inflatedView.findViewById(R.id.buttonBlue);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            dv.drawPaint.setColor(getResources().getColor((R.color.blue)));
        }
    });


    // This button makes gold color
    button=(Button) inflatedView.findViewById(R.id.buttonGold);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            dv.drawPaint.setColor(getResources().getColor((R.color.gold)));
        }
    });



    // This button makes small stroke
    button=(Button) inflatedView.findViewById(R.id.small);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            dv.drawPaint.setStrokeWidth(7.0f);
        }
    });


    // This button makes medium stroke
    button=(Button) inflatedView.findViewById(R.id.medium);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            dv.drawPaint.setStrokeWidth(22.0f);
        }
    });


    // This button makes small stroke
    button=(Button) inflatedView.findViewById(R.id.large);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            dv.drawPaint.setStrokeWidth(30.0f);
        }
    });




    // This button clears screen
    button=(Button) inflatedView.findViewById(R.id.clear);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            dv.startNew();
        }
    });


    // This button makes new fragment share
    button=(Button) inflatedView.findViewById(R.id.share);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            System.out.println("share");
        }
    });




    dv = new DrawingView(this.containerActivity,null);
    LinearLayout ll = (LinearLayout)inflatedView.findViewById(R.id.drawing);
    ll.addView(dv);


    return inflatedView;
}

//    public void clearDrawing(View v) {
//        dv.startNew();
//    }



//
//    public void addDrawing(View v) {
//        Bitmap b = dv.getBitmap();
//        ImageView iv = new ImageView(this);
//        iv.setImageBitmap(b);
////        LinearLayout ll = getActivity().findViewById(R.id.list_of_drawings);
////        ll.addView(iv);
//    }



@Override
public void onResume() {
        super.onResume();

        }


}

// sets up contaact adapter for creation of dicitonary

