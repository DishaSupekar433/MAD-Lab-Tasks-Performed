/*package com.example.pr6_implicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button visit;
    EditText enter_url;
    //WebView wb;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        visit = findViewById(R.id.btnVisit);
        enter_url = findViewById(R.id.editText);
        //wb = findViewById(R.id.web);
        visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = enter_url.getText().toString();
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
                //wb.getSettings().setJavaScriptEnabled(true);
                //wb.loadUrl(url);

                //does not work from here
                wb.setWebViewClient(new WebViewClient() {
                    public boolean shouldOverrideUrlLoading(WebView view, String url){
                        view.loadUrl(url);
                        return false; // then it is not handled by default action
                    }
                });
                to here//
            }
        });//End of Visit Button
    }
}
*/

package com.example.pr6_implicit_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button visit;
    EditText enter_url;
    WebView wb;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        visit = findViewById(R.id.btnVisit);
        enter_url = findViewById(R.id.editText);
        wb = findViewById(R.id.web);

        wb.getSettings().setJavaScriptEnabled(true);

        wb.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView wb, String url) {
                // Load the requested URL in the WebView
                wb.loadUrl(url);
                return true; // Indicate that the URL request has been handled
            }
        });

        visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                //startActivity(i);
                String url = enter_url.getText().toString();
                wb.loadUrl(url);
            }
        });
    }
}

