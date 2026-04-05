package com.example.networkmapsapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    Button btnFetch, btnGoToMap;
    TextView textData;
    String url = "https://jsonplaceholder.typicode.com/todos/1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFetch = findViewById(R.id.btnFetch);
        btnGoToMap = findViewById(R.id.btnGoToMap);
        textData = findViewById(R.id.textData);

        btnFetch.setOnClickListener(v -> fetchData());

        btnGoToMap.setOnClickListener(v -> {
            startActivity(new Intent(this, MapsActivity.class));
        });
    }

    private void fetchData() {
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, url, null,
                response -> {
                    try {
                        int id = response.getInt("id");
                        String title = response.getString("title");
                        boolean completed = response.getBoolean("completed");
                        textData.setText("ID: " + id + "\nTitle: " + title + "\nStatus: " + (completed ? "Done" : "Pending"));
                    } catch (Exception e) {
                        textData.setText("Parsing Error");
                    }
                },
                error -> textData.setText("Network Error: " + error.getMessage())
        );
        Volley.newRequestQueue(this).add(request);
    }
}