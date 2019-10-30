package com.example.newssearch;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;



public class SecondPage extends Fragment {


    public SecondPage() { }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_second_page, container, false);
        String displayText=getArguments().getString("display_text");
        TextView tv=inflatedView.findViewById(R.id.contact_info_view);
        tv.setText(displayText);
        return inflatedView;
    }
}
