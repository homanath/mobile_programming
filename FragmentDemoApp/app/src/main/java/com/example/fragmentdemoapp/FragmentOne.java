package com.example.fragmentdemoapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class FragmentOne extends Fragment {

    public FragmentOne() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Toast.makeText(getActivity(), "Fragment One: onCreateView()", Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getActivity(), "Fragment One: onDestroy()", Toast.LENGTH_SHORT).show();
    }
}