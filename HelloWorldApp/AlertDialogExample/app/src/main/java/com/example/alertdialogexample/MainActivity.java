package com.example.alertdialogexample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.graphics.Color;
import java.util.Random;
import android.media.MediaPlayer;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShow = findViewById(R.id.btnShowDialog);
        Button btnShowCalculator = findViewById(R.id.btnShowCalculator);

        btnShow.setOnClickListener(v -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Alert Message");
            builder.setMessage("This is a simple Alert Dialog example.");

            builder.setPositiveButton("OK", (dialog, which) -> {

                Toast.makeText(MainActivity.this, "🎉 You pressed OK!", Toast.LENGTH_SHORT).show();

                // Play water droplet sound
                MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.water_drop);
                mp.start();

                // Change button label
                btnShow.setText("You clicked OK 😄");

                // Change button background color randomly
                int[] colors = { Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.CYAN };
                int randomColor = colors[new Random().nextInt(colors.length)];
                btnShow.setBackgroundColor(randomColor);

                // Return to first screen after 5 seconds
                new Handler().postDelayed(() -> {
                    recreate();
                }, 5000);

            });

            builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

            builder.create().show();
        });



        btnShowCalculator.setOnClickListener(v -> {
            // Inflate the calculator dialog layout
            android.view.View calculatorView = getLayoutInflater().inflate(R.layout.calculator_layout, null);

            AlertDialog.Builder calcBuilder = new AlertDialog.Builder(MainActivity.this);
            calcBuilder.setView(calculatorView);
            AlertDialog calcDialog = calcBuilder.create();

            // Get EditTexts and Buttons inside the dialog
            EditText editFirst = calculatorView.findViewById(R.id.editfirst);
            EditText editSecond = calculatorView.findViewById(R.id.editsecond);
            Button btnAddCalc = calculatorView.findViewById(R.id.btnAddCalc);
            Button btnDismissCalc = calculatorView.findViewById(R.id.btnDismissCalc);

            // Add button logic
            btnAddCalc.setOnClickListener(view -> {
                String num1 = editFirst.getText().toString();
                String num2 = editSecond.getText().toString();
                if(!num1.isEmpty() && !num2.isEmpty()) {
                    int sum = Integer.parseInt(num1) + Integer.parseInt(num2);
                    Toast.makeText(MainActivity.this, "Sum = " + sum, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
                }
            });

            // Dismiss button logic
            btnDismissCalc.setOnClickListener(view -> calcDialog.dismiss());

            calcDialog.show();
        });
    }



}
