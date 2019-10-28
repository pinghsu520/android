package com.benjdd.contentproviderstest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContactsFragment cf = new ContactsFragment();
        cf.setContainerActivity(this);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.outer, cf);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void onContactClick(View v) {
        String text = ((TextView)v).getText().toString();
        String name = text.substring(0, text.indexOf(" :: "));
        String id = text.substring(text.indexOf(" :: ") + 4);
        String contactInfo = "";

        contactInfo += "Name: " + name + "\n";

        Cursor phones = getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = " + id, null, null);
        while (phones.moveToNext()) {
            String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            contactInfo += "Phone: " + phoneNumber + "\n";
        }
        phones.close();

        /**
         * TODO:
         * Use a content resolver to get the emails for the contact, based on the id.
         * Doing so would be similar to the way the phone number(s) are fetched, shown above.
         */

        /** TODO
         * (A) Create a new ContactInfoFragment
         * (B) Create a bundle, and put the contactInfo string into the bundle
         * (C) set the arguments of the transaction to be the bundle
         * (D) Show the fragment
         */
    }
}
