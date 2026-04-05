package com.example.fragmentdemoapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class FragmentTwo extends Fragment {

    public FragmentTwo() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Change "Fragment One" to "Fragment Two"
        Toast.makeText(getActivity(), "Fragment Two: onCreateView()", Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Added onStart to track lifecycle properly
        Toast.makeText(getActivity(), "Fragment Two: onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Change "Fragment One" to "Fragment Two"
        Toast.makeText(getActivity(), "Fragment Two: onDestroy()", Toast.LENGTH_SHORT).show();
    }
}