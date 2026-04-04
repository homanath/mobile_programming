package com.example.layoutcomparisonapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void java_onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // We will change this line to test different layouts
        setContentView(R.layout.activity_linear);
    }
}