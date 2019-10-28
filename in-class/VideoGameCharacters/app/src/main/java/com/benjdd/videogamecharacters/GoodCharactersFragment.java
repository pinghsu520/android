package com.benjdd.videogamecharacters;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class GoodCharactersFragment extends Fragment {


    public Activity containerActivity = null;

    private ImageAdapter goodAdapter;

    ListView goodCharactersListView;

    Integer[] goodCharacterIds = new Integer[]{
            R.drawable.good_donkey_kong,
            R.drawable.good_master_cheif,
            R.drawable.good_super_mario,
            R.drawable.good_samus,
            R.drawable.good_sonic,
            R.drawable.good_princess_peach
    };

    public GoodCharactersFragment() { }

    public void setContainerActivity(Activity containerActivity) {
        this.containerActivity = containerActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_good_characters, container, false);

        goodAdapter = new ImageAdapter(containerActivity, R.layout.character_row, goodCharacterIds);
        goodCharactersListView = v.findViewById(R.id.good_characters);
        goodCharactersListView.setAdapter(goodAdapter);

        return v;
    }
}


