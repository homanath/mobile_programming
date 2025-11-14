package com.example.spinnerexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SpinnerExample extends Activity {

    Button btnClick;
    Spinner spinner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        btnClick = findViewById(R.id.btnClick);
        spinner = findViewById(R.id.spinner);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedLanguage = spinner.getSelectedItem().toString();

                Toast.makeText(SpinnerExample.this,
                        "Selected Language: " + selectedLanguage,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
