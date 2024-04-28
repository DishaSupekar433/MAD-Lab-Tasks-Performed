package com.example.pr4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button clickme;
    TextView display;
    RadioGroup gender_selection;
    RadioButton gender;
    CheckBox MAD, AI, DIP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        clickme = findViewById(R.id.button);
        display = findViewById(R.id.display);
        MAD = findViewById(R.id.MAD);
        DIP = findViewById(R.id.DIP);
        AI = findViewById(R.id.AI);
        gender_selection = findViewById(R.id.gender_selection);
        clickme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString();
                String pass = password.getText().toString();
                gender=findViewById(gender_selection.getCheckedRadioButtonId());
                String name=gender.getText().toString();
                String mySub="";
                if(MAD.isChecked()){
                    mySub+=MAD.getText().toString();
                }
                if(DIP.isChecked()){
                    mySub+=DIP.getText().toString();
                }
                if(AI.isChecked()){
                    mySub+=AI.getText().toString();
                }
                display.setText("\nUsername: "+uname+"\nPassword: "+pass+"\nGender: "+name+"\nSubject: "+mySub);
            }
        });
    }
}