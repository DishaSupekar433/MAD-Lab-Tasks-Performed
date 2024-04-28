package com.example.pr_12_1_Firebase_Example;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText prn, name, email;
    Button insert, select, update, delete;

    DatabaseReference databaseReference;
    DataSnapshot dsp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prn = findViewById(R.id.prn);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        insert = findViewById(R.id.insert);
        select = findViewById(R.id.select);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);

        databaseReference = FirebaseDatabase.getInstance().getReference("StudentDetaills");
        databaseReference.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                dsp = snapshot;
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });// End of addValueEventListener

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String student_prn = prn.getText().toString();
                String student_name = name.getText().toString();
                String student_email = email.getText().toString();
                StudentDetails info;
                info = new StudentDetails(student_prn,student_name,student_email);
                databaseReference.child(student_prn).setValue(info);
                Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
            }
        });// End of insert button

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = prn.getText().toString();
                String data = dsp.child(key).getValue().toString();
                Toast.makeText(MainActivity.this,""+data,Toast.LENGTH_LONG).show();
            }
        });// End of select button

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String student_prn = prn.getText().toString();
                String student_name = name.getText().toString();
                String student_email = email.getText().toString();
                if (student_prn.isEmpty() || student_name.isEmpty() || student_email.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_LONG).show();
                    return;
                }
                StudentDetails info = new StudentDetails(student_prn, student_name, student_email);
                databaseReference.child(student_prn).setValue(info);
                Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_LONG).show();
            }
        }); // End of update button

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String student_prn = prn.getText().toString();
                if (student_prn.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter PRN to delete record", Toast.LENGTH_LONG).show();
                    return;
                }
                databaseReference.child(student_prn).removeValue();
                Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
            }
        }); // End of delete button
    }
}