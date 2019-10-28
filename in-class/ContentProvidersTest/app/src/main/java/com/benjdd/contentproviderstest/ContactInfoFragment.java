package com.benjdd.contentproviderstest;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;



public class ContactInfoFragment extends Fragment {


    public ContactInfoFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_contact_info, container, false);
        /** TODO
         * Get the display text, and display in the fragment.
         */
        return inflatedView;
    }
}
