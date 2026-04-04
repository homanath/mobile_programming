package com.example.listviewwithdatabaseexample;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert;
    ListView plistView;
    ArrayList<Product> pList=new ArrayList<Product>();
    DbHelper dbHelper;
    ArrayAdapter<Product> adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);
        btnInsert=findViewById(R.id.btnInsert);
        plistView=findViewById(R.id.plistView);
        dbHelper=new DbHelper(this);
    }
}
