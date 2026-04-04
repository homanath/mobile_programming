package com.example.fragmentexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RectangleFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.rectangle_layout, container, false);
        Button btnCalc = v.findViewById(R.id.btnRectArea);
        EditText editLength, editBreadth;
        editLength = v.findViewById(R.id.rectLength);
        editBreadth = v.findViewById(R.id.rectBreadth);
        btnCalc.setOnClickListener(e-> {
            float length = Float.parseFloat(editLength.getText().toString());
            float breadth = Float.parseFloat(editBreadth.getText().toString());
            Toast.makeText(getContext(), "Area is "+(length*breadth), Toast.LENGTH_LONG).show();
        });

        return v;
    }
}

