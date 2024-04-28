package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {
TextView showMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        showMessage = findViewById(R.id.tvMessage);
        showMessage.setText("Welcome, "+getIntent().getStringExtra("unamenext")+"\nPRN: "+getIntent().getIntExtra("prnnext",0));
    }
}