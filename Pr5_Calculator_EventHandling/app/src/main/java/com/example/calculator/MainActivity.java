package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    Button buttonAdd, buttonSub, buttonMul, buttonDiv, buttonPoint, buttonEqualsTo, buttonBackSpace, buttonClearAll;
    TextView tv;
    Float n1, n2, ans;
    String text, op="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b0=findViewById(R.id.b0);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);
        b9=findViewById(R.id.b9);
        buttonAdd=findViewById(R.id.buttonAdd);
        buttonSub=findViewById(R.id.buttonSub);
        buttonMul=findViewById(R.id.buttonMul);
        buttonDiv=findViewById(R.id.buttonDiv);
        buttonPoint=findViewById(R.id.buttonPoint);
        buttonEqualsTo=findViewById(R.id.buttonEqualsTo);
        buttonBackSpace=findViewById(R.id.buttonBackSpace);
        buttonClearAll=findViewById(R.id.buttonClear);
        tv=findViewById(R.id.textView);
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(tv.getText()+"0");
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(tv.getText()+"1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(tv.getText()+"2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(tv.getText()+"3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(tv.getText()+"4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(tv.getText()+"5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(tv.getText()+"6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(tv.getText()+"7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(tv.getText()+"8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(tv.getText()+"9");
            }
        });
        buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(tv.getText()+".");
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1 = Float.parseFloat(tv.getText()+"");
                op="+";
                tv.setText(null);
                //tv.setText(tv.getText()+"+");
            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1 = Float.parseFloat(tv.getText()+"");
                op="-";
                tv.setText(null);
                //tv.setText(tv.getText()+"-");
            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1 = Float.parseFloat(tv.getText()+"");
                op="*";
                tv.setText(null);
                //tv.setText(tv.getText()+"*");
            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1 = Float.parseFloat(tv.getText()+"");
                op="/";
                tv.setText(null);
                //tv.setText(tv.getText()+" /");
            }
        });
        buttonEqualsTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n2 = Float.parseFloat(tv.getText()+"");
                switch (op){
                    case "+" : ans = n1 + n2; break;
                    case "-" : ans = n1 - n2; break;
                    case "*" : ans = n1 * n2; break;
                    case "/" : ans = n1 / n2; break;
                }
                tv.setText(n1+""+op+""+n2+"="+ans+"");
            }
        });
        buttonBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = tv.getText().toString();
                text = text.substring(0, text.length()-1);
                tv.setText(text);
            }
        });
        buttonClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(null);
            }
        });
    }
}
