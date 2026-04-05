package com.example.viewcollectionapp;

import android.content.Context;
import android.view.*;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    Context context;
    int[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3};

    public ImageAdapter(Context context) { this.context = context; }

    @Override public int getCount() { return images.length; }
    @Override public Object getItem(int i) { return images[i]; }
    @Override public long getItemId(int i) { return i; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = (ImageView) LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(images[position]);
        return imageView;
    }
}