package com.example.viewcollectionapp;

import android.view.*;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    // CHANGE: Store two distinct lists
    ArrayList<String> names, descs;

    // CHANGE: The constructor must now accept both lists
    public RecyclerAdapter(ArrayList<String> names, ArrayList<String> descs) {
        this.names = names;
        this.descs = descs;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // CHANGE: Link both text fields in your layout
        TextView textName, textDesc;

        public ViewHolder(View itemView) {
            super(itemView);
            // Links to the TextViews in recycler_item.xml (see Step 3)
            textName = itemView.findViewById(R.id.recyclerFrameworkName);
            textDesc = itemView.findViewById(R.id.recyclerFrameworkDesc);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // CHANGE: Ensure you use your customized layout file
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // CHANGE: Bind data to BOTH TextViews using the current position
        holder.textName.setText(names.get(position));
        holder.textDesc.setText(descs.get(position));
    }

    @Override
    public int getItemCount() { return names.size(); }
}