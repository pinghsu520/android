package com.example.pa7_sketcher;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

    private ListView contactsListView;
    ArrayAdapter<String> contactsAdapter = null;
    ArrayList<String> contacts = new ArrayList<String>();

    String publicXML="https://newsapi.org/v2/everything?sortBy=publishedAt&q=arizona&from=2019-10-19&apiKey=530a5c059857443595116cf3702a1463";
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
    button=(Button) inflatedView.findViewById(R.id.button);

    // This button
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            System.out.println("HI");
        }
    });
    return inflatedView;
}



@Override
public void onResume() {
        super.onResume();

        }


}

// sets up contaact adapter for creation of dicitonary

