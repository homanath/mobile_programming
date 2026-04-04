package com.example.listviewwithdatabaseexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;  // ← Add this import

public class MyAdapter extends ArrayAdapter<Product> {

    private final Context context;
    private final List<Product> productList;  // ← Use List<Product>, not ArrayAdapter<Product>

    // Fixed constructor – pass the actual data list
    public MyAdapter(@NonNull Context context, @NonNull List<Product> productList) {
        // Important: pass the list to super so ArrayAdapter manages it
        super(context, R.layout.list_item_layout, productList);

        this.context     = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.list_item_layout, parent, false);
        }

        // Get references to the TextViews
        TextView txtCode     = convertView.findViewById(R.id.txtCode);
        TextView txtName     = convertView.findViewById(R.id.txtName);
        TextView txtQuantity = convertView.findViewById(R.id.txtQuantity);

        // Get the actual Product at this position (this is the correct way)
        Product product = getItem(position);          // or: productList.get(position)
        // Product product = productList.get(position);  // both work since we passed list to super

        // Set the values (assuming Product has these getters)
        txtCode.setText(String.valueOf(product.getProductCode()));
        txtName.setText(product.getProductName());
        txtQuantity.setText(String.valueOf(product.getQuantity()));

        return convertView;
    }
}