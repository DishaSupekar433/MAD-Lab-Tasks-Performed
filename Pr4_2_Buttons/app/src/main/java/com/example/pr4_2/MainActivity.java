package com.example.pr4_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.chip.Chip;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    ToggleButton likedislike;
    ConstraintLayout cl;
    FloatingActionButton chatbubble;
    Chip reply, skip;
    EditText writeReply;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        likedislike=findViewById(R.id.toggleButton);
        chatbubble=findViewById(R.id.floatingActionButton);
        cl=findViewById(R.id.myConstraintLayout);
        reply = findViewById(R.id.chipReply);
        skip = findViewById(R.id.chipSkip);
        writeReply = findViewById(R.id.editReply);
        likedislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(likedislike.isChecked()){
                    likedislike.setBackgroundResource(R.drawable.favorite_fill1_wght400_grad0_opsz24);
                }
                else {
                    likedislike.setBackgroundResource(R.drawable.favorite_fill0_wght400_grad0_opsz24);
                }

            }
        });//end of togglebutton

        reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeReply.setVisibility(View.VISIBLE);
            }
        });//End of Reply

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void floatingActionClick(View view){
        Snackbar.make(cl, "Do you want to undo?", BaseTransientBottomBar.LENGTH_LONG).setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Click on Undo", Toast.LENGTH_LONG).show();
            }
        }).show();
    }

}