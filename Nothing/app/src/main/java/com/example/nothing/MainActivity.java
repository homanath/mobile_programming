package com.example.nothing;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText p,r,t;
    Button button;
    TextView result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        p=findViewById(R.id.p);
        r=findViewById(R.id.r);
        t=findViewById(R.id.t);
        button=findViewById(R.id.button);
        result=findViewById(R.id.result);

        button.setOnClickListener(v -> {
            double p= Double.parseDouble(this.p.getText().toString());
            double r= Double.parseDouble(this.r.getText().toString());
            double t= Double.parseDouble(this.t.getText().toString());
            double si=(p*r*t)/100;

            result.setText(String.valueOf(si));
        });
        }
    }

