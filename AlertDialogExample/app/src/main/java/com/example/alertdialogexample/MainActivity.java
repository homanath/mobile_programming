package com.example.alertdialogexample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.widget.Button;
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
    }
}
