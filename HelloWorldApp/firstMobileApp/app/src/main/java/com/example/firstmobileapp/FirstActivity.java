package com.example.firstmobileapp;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class FirstActivity extends Activity {
    Button btnOK;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        btnOK=findViewById(R.id.btnOK);
        btnOK.setOnClickListener( view->{
            Toast.makeText(FirstActivity.this, "Hi developers how are you !", Toast.LENGTH_LONG).show();

    });

}
}
