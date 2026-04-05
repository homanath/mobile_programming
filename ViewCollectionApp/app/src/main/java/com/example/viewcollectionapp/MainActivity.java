package com.example.viewcollectionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    GridView gridView;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Initialize Views
        listView = findViewById(R.id.listView);
        gridView = findViewById(R.id.gridView);
        recyclerView = findViewById(R.id.recyclerView);

        // 2. Setup ListView (CustomAdapter)
        ArrayList<String> titles = new ArrayList<>(Arrays.asList("Android", "Java", "Kotlin", "Firebase"));
        ArrayList<String> descriptions = new ArrayList<>(Arrays.asList("Mobile OS", "Language", "Modern Language", "Backend"));
        listView.setAdapter(new CustomAdapter(this, titles, descriptions));

        // 3. Setup GridView (ImageAdapter)
        // Ensure img1, img2, img3 are in your res/drawable folder
        gridView.setAdapter(new ImageAdapter(this));

        // 4. Setup RecyclerView (RecyclerAdapter)
        // Updated data to be more specific for your BCA Lab 7
        ArrayList<String> frameworkNames = new ArrayList<>(Arrays.asList(
                "Flutter", "React Native", "SwiftUI", "Jetpack Compose", "Git"
        ));

        ArrayList<String> frameworkDescs = new ArrayList<>(Arrays.asList(
                "UI Toolkit for cross-platform apps",
                "Mobile Framework (JavaScript)",
                "Declarative UI for Apple platforms",
                "Android's modern UI toolkit",
                "Distributed Version Control System"
        ));

        // Set LayoutManager and pass BOTH lists to the constructor
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerAdapter(frameworkNames, frameworkDescs));
    }
}