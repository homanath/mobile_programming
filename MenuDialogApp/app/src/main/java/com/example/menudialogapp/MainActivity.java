package com.example.menudialogapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button btnDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        btnDialog = findViewById(R.id.btnDialog);

        // Register the TextView for a Context Menu
        registerForContextMenu(textView);

        btnDialog.setOnClickListener(v -> {
            DialogFragment dialog = new MyDialogFragment();
            dialog.show(getSupportFragmentManager(), "MyDialog");
        });
    }

    // 1. Options Menu: Inflating the XML
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_settings) {
            Toast.makeText(this, "Settings Selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menu_about) {
            Toast.makeText(this, "About Selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // 2. Context Menu: Created programmatically
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        menu.add(0, v.getId(), 0, "Edit");
        menu.add(0, v.getId(), 0, "Delete");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String title = item.getTitle().toString();
        if (title.equals("Edit")) {
            Toast.makeText(this, "Edit Selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (title.equals("Delete")) {
            Toast.makeText(this, "Delete Selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onContextItemSelected(item);
    }
}