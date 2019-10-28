package com.benjdd.videogamecharacters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class ImageAdapter extends ArrayAdapter<Integer> {

    private Integer[] items;
    Context c;

    public ImageAdapter(Context context, int textViewResourceId, Integer[] items) {
        super(context, textViewResourceId, items);
        c = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.character_row, null);
        }
        Integer id = items[position];
        ImageView iv = (ImageView) v.findViewById(R.id.character_row_image);
        if (iv != null) {
            iv.setImageResource(id);
        }
        return v;
    }
}