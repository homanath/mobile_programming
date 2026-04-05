package com.example.activitydemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textUser;
    Button btnSendBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textUser = findViewById(R.id.textUser);
        btnSendBack = findViewById(R.id.btnSendBack);

        // Retrieving the data passed from MainActivity
        String username = getIntent().getStringExtra("username");
        if (username != null) {
            textUser.setText("Welcome, " + username);
        }

        btnSendBack.setOnClickListener(v -> {
            // Preparing the result data to send BACK
            Intent resultIntent = new Intent();
            resultIntent.putExtra("reply", "Hello from Second Activity!");
            setResult(RESULT_OK, resultIntent);

            // finish() closes this activity and returns to MainActivity
            finish();
        });
    }
}