package com.example.librarymanagement;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    EditText fname, lname, id, title;
    Button next, icon;
    @SuppressLint({"WrongViewCast", "MissingInflatedId", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fname = findViewById(R.id.enterfname);
        lname = findViewById(R.id.enterlname);
        id = findViewById(R.id.enterid);
        title = findViewById(R.id.entertitle);
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = fname.getText().toString();
                String lastname = lname.getText().toString();
                String studentID = id.getText().toString();
                String bTitle = title.getText().toString();
                Integer prn = Integer.parseInt(id.getText().toString());

                            Intent i = new Intent(MainActivity.this, NextActivity.class);
                            i.putExtra("fname",firstname);
                            i.putExtra("lname",lastname);
                            i.putExtra("id",studentID);
                            i.putExtra("title",bTitle);
                            startActivity(i);

            }//End of Next
        });
    }
}
