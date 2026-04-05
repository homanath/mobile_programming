package com.example.widgetdemoapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    CheckBox checkAgree;
    RadioGroup radioGroup;
    Spinner spinnerCourse;
    Button buttonSubmit;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Linking XML IDs to Java Objects
        editName = findViewById(R.id.editName);
        checkAgree = findViewById(R.id.checkAgree);
        radioGroup = findViewById(R.id.radioGroup);
        spinnerCourse = findViewById(R.id.spinnerCourse);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        textResult = findViewById(R.id.textResult);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String course = spinnerCourse.getSelectedItem().toString();

                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(selectedId);

                if(name.isEmpty()){
                    textResult.setText("Please enter your name.");
                    return;
                }

                if(!checkAgree.isChecked()){
                    textResult.setText("You must agree to the terms.");
                    return;
                }

                String gender = (radioButton != null) ? radioButton.getText().toString() : "Not Selected";

                String result = "Name: " + name +
                        "\nGender: " + gender +
                        "\nCourse: " + course;

                textResult.setText(result);
            }
        });
    }
}