package com.example.fragmentexample;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    Button btnCircle, btnRect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        btnCircle = findViewById(R.id.btnCircle);
        btnRect = findViewById(R.id.btnRect);

        btnCircle.setOnClickListener(v -> loadFragment(new CircleFragment()));
        btnRect.setOnClickListener(v -> loadFragment(new RectangleFragment()));
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.myFrame, fragment);
        transaction.commit();
    }
}
