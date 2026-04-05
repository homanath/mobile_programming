package com.example.sqlitecrudapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;
    EditText editId, editName, editEmail;
    Button btnInsert, btnView, btnUpdate, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);

        editId = findViewById(R.id.editId);
        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        btnInsert = findViewById(R.id.btnInsert);
        btnView = findViewById(R.id.btnView);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        // CREATE
        btnInsert.setOnClickListener(v -> {
            String name = editName.getText().toString();
            String email = editEmail.getText().toString();
            if(name.isEmpty() || email.isEmpty()){
                Toast.makeText(this, "Please fill fields", Toast.LENGTH_SHORT).show();
                return;
            }
            boolean inserted = dbHelper.insertStudent(name, email);
            if(inserted) {
                Toast.makeText(this, "Student Added", Toast.LENGTH_SHORT).show();
                clearFields();
            } else {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });

        // READ
        btnView.setOnClickListener(v -> {
            Cursor cursor = dbHelper.getAllStudents();
            if(cursor.getCount() == 0){
                showMessage("Database Empty", "No student records found.");
                return;
            }
            StringBuilder buffer = new StringBuilder();
            while(cursor.moveToNext()){
                buffer.append("ID: ").append(cursor.getString(0)).append("\n");
                buffer.append("Name: ").append(cursor.getString(1)).append("\n");
                buffer.append("Email: ").append(cursor.getString(2)).append("\n\n");
            }
            showMessage("All Students", buffer.toString());
        });

        // UPDATE
        btnUpdate.setOnClickListener(v -> {
            boolean updated = dbHelper.updateStudent(
                    editId.getText().toString(),
                    editName.getText().toString(),
                    editEmail.getText().toString());
            Toast.makeText(this, updated ? "Updated Successfully" : "Update Failed", Toast.LENGTH_SHORT).show();
        });

        // DELETE
        btnDelete.setOnClickListener(v -> {
            boolean deleted = dbHelper.deleteStudent(editId.getText().toString());
            Toast.makeText(this, deleted ? "Record Deleted" : "Delete Failed", Toast.LENGTH_SHORT).show();
        });
    }

    private void clearFields() {
        editName.setText("");
        editEmail.setText("");
        editId.setText("");
    }

    private void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}