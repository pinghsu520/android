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
    button=(Button) inflatedView.findViewById(R.id.buttonRed);

    // This button
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            System.out.println("HI");
        }
    });


    dv = new DrawingView(this.containerActivity,null);
    LinearLayout ll = getActivity().findViewById(R.id.drawing);
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

