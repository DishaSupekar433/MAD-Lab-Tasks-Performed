package com.example.loginapp;

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
    EditText username, password, prn;
    Button login, icon;
    @SuppressLint({"WrongViewCast", "MissingInflatedId", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.editName);
        password = findViewById(R.id.editPass);
        prn = findViewById(R.id.editPRN);
        login = findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString();
                String pass = password.getText().toString();
                Integer roll = Integer.parseInt(prn.getText().toString());
                if (uname.equals("Vedshree") && pass.equals("1234") && roll==3149){
                    AlertDialog.Builder altdg = new AlertDialog.Builder(MainActivity.this);
                    altdg.setTitle("Continue!");
                    altdg.setMessage("Do you want to continue?");
                    altdg.setCancelable(false);
                    altdg.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent i = new Intent(MainActivity.this, NextActivity.class);
                            i.putExtra("unamenext",uname);
                            i.putExtra("prnnext",roll);
                            startActivity(i);
                        }
                    }); //End of Positive Button
                    altdg.setNeutralButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    }); //End of Neutral Button
                    AlertDialog a = altdg.create();
                    altdg.show();
                }//End of If
                else {
                    AlertDialog.Builder alt = new AlertDialog.Builder(MainActivity.this);
                    alt.setTitle("Error");
                    alt.setMessage("Invalid Credentials!");
                    alt.setIcon(R.drawable.error_fill1_wght400_grad0_opsz24);
                    alt.setCancelable(false);
                    alt.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });//End of Positive ButtonDishaDi
                    alt.setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });//End of Negative Button
                    alt.show();
                }
        }//End of Login
    });
    }
}


