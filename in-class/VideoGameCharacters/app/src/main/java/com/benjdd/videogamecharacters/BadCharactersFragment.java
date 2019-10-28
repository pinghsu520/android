package com.benjdd.videogamecharacters;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;


public class BadCharactersFragment extends Fragment {
    public Activity containerActivity = null;

    private ImageAdapter badAdapter;

    ListView badCharactersListView;

    Integer[] badCharacterIds = new Integer[]{
            R.drawable.bad_king_k_rool,
            R.drawable.bad_eggman,
            R.drawable.bad_bowser,
            R.drawable.bad_prophet
    };

    public BadCharactersFragment() { }

    public void setContainerActivity(Activity containerActivity) {
        this.containerActivity = containerActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bad_characters, container, false);

        badAdapter = new ImageAdapter(containerActivity, R.layout.character_row, badCharacterIds);
        badCharactersListView = v.findViewById(R.id.bad_characters);
        badCharactersListView.setAdapter(badAdapter);

        return v;
    }
}
