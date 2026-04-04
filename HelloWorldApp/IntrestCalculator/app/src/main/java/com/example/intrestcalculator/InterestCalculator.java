package com.example.intrestcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class InterestCalculator extends Activity {

    EditText editPrinciple, editRate, editTime;
    Button btnCalculate;
    TextView txtInterest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_layout);

        editPrinciple = findViewById(R.id.editPrinciple);
        editRate = findViewById(R.id.editRate);
        editTime = findViewById(R.id.editTime);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtInterest = findViewById(R.id.txtInterest);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateInterest();
            }
        });
    }

    private void calculateInterest() {
        String principleStr = editPrinciple.getText().toString();
        String rateStr = editRate.getText().toString();
        String timeStr = editTime.getText().toString();

        if (!principleStr.isEmpty() && !rateStr.isEmpty() && !timeStr.isEmpty()) {
            double principle = Double.parseDouble(principleStr);
            double rate = Double.parseDouble(rateStr);
            double time = Double.parseDouble(timeStr);

            // Simple Interest formula: SI = (P * R * T) / 100
            double interest = (principle * rate * time) / 100;

            txtInterest.setText("Interest: " + interest);
        } else {
            txtInterest.setText("Please enter all values!");
        }
    }
}
