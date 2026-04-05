package com.example.viewcollectionapp;

import android.content.Context;
import android.view.*;
import android.widget.*;
import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> titles, descriptions;

    public CustomAdapter(Context context, ArrayList<String> titles, ArrayList<String> descriptions) {
        this.context = context;
        this.titles = titles;
        this.descriptions = descriptions;
    }

    @Override public int getCount() { return titles.size(); }
    @Override public Object getItem(int i) { return titles.get(i); }
    @Override public long getItemId(int i) { return i; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }
        TextView title = convertView.findViewById(R.id.title);
        TextView desc = convertView.findViewById(R.id.description);
        title.setText(titles.get(position));
        desc.setText(descriptions.get(position));
        return convertView;
    }
}