package com.example.librarymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {
    TextView showFname, showLname, showID, showTitle;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        showFname = findViewById(R.id.viewfname);
        showFname.setText(getIntent().getStringExtra("fname"));
        showLname = findViewById(R.id.viewlname);
        showLname.setText(getIntent().getStringExtra("lname"));
        showID = findViewById(R.id.viewID);
        showID.setText(getIntent().getStringExtra("id"));
        showTitle = findViewById(R.id.viewtitle);
        showTitle.setText(getIntent().getStringExtra("title"));
        back = findViewById(R.id.button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NextActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}