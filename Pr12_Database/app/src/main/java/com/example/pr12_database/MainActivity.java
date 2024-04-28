package com.example.pr12_database;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button insert, select, update, delete;
    EditText name, prn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insert = findViewById(R.id.insert);
        select = findViewById(R.id.select);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        name = findViewById(R.id.name);
        prn = findViewById(R.id.prn);
        tv = findViewById(R.id.textView);
        DatabaseHandler dbh = new DatabaseHandler(MainActivity.this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameOfStudent = name.getText().toString();
                String prnOfStudent = prn.getText().toString();
                dbh.opendb();
                dbh.insertValue(prnOfStudent, nameOfStudent);
                Toast.makeText(MainActivity.this, "Data Added", Toast.LENGTH_LONG).show();
                dbh.closedb();
            }
        }); //End of Insert Button

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbh.opendb();
                Cursor cursor = dbh.selectdata();
                if (cursor.getCount() == 0){
                    Toast.makeText(MainActivity.this, "Data Not Found",Toast.LENGTH_LONG).show();
                } else {
                    StringBuffer buffer = new StringBuffer();
                    while (cursor.moveToNext()){
                        buffer.append("PRN: "+cursor.getString(0)+", ");
                        buffer.append("Name: "+cursor.getString(1)+"\n");
                    }
                    tv.setText(buffer.toString());
                }
            }
        }); //End of Select Button


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = name.getText().toString().trim();
                String prnOfStudent = prn.getText().toString().trim();
                if (prnOfStudent.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter PRN to update record", Toast.LENGTH_LONG).show();
                    return;
                }
                dbh.opendb();
                boolean updated = dbh.updateValue(prnOfStudent, newName);
                if (updated) {
                    Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_LONG).show();
                }
                dbh.closedb();
            }
        }); //End of Update Button

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String prnOfStudent = prn.getText().toString().trim();
                if (prnOfStudent.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter PRN to delete record", Toast.LENGTH_LONG).show();
                    return;
                }
                dbh.opendb();
                boolean deleted = dbh.deleteValue(prnOfStudent);
                if (deleted) {
                    Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
                }
                dbh.closedb();
            }
        }); //End of Delete Button
    }
}
