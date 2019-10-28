package com.example.newssearch;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newssearch.MainActivity;
import com.example.newssearch.R;



import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class start extends Fragment {

    private Activity containerActivity = null;
    private View inflatedView = null;

    private ListView contactsListView;
    ArrayAdapter<String> contactsAdapter = null;
    private ArrayList<String> contacts = new ArrayList<String>();

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

        return inflatedView;
    }

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setupContactsAdapter();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

//    public void getContacts() {
//        int limit = 1000;
//        Cursor cursor = containerActivity.getContentResolver().query(
//                ContactsContract.Contacts.CONTENT_URI,null, null, null, null);
//        while (cursor.moveToNext() && limit > 0) {
//            String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
//            String given = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
//            String contact = given + " :: " + contactId;
//            contacts.add(contact);
//            limit--;
//        }
//        cursor.close();
//    }

    private void setupContactsAdapter() {
        // R.id.listNews- list of news
        System.out.println("FIRST");
        contactsListView =
                (ListView)containerActivity.findViewById(R.id.listNews);
        // R.layout. = xml file that is the row
        // R. id =textview in row
        System.out.println("SECOND");
        contactsAdapter = new
                ArrayAdapter<String>(containerActivity, R.layout.list_row,
                R.id.title, contacts);
        System.out.println("third");
        contactsListView.setAdapter(contactsAdapter);
//        MainActivity.DownloadNews newsTask = new MainActivity.DownloadNews();
//        newsTask.execute();
    }

}
