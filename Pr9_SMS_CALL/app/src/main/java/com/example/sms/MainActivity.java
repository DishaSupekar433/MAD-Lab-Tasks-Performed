package com.example.sms;

// Import required packages
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare variables+91
    EditText phoneNumberEditText, messageEditText;
    Button sendSMSButton, makeCallButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        phoneNumberEditText = findViewById(R.id.number);
        messageEditText = findViewById(R.id.message);
        sendSMSButton = findViewById(R.id.send);
        makeCallButton = findViewById(R.id.call);

        // Set onClickListener for sending SMS button
        sendSMSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSMS();
            }
        });

        // Set onClickListener for making call button
        makeCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCall();
            }
        });
    }

    // Method to send SMS
    private void sendSMS() {
        String phoneNumber = phoneNumberEditText.getText().toString();
        String message = messageEditText.getText().toString();

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumber, null, message, null, null);

        Toast.makeText(getApplicationContext(), "SMS Sent Successfully", Toast.LENGTH_SHORT).show();
    }

    // Method to make a phone call
    private void makeCall() {
        String phoneNumber = phoneNumberEditText.getText().toString();

        Intent phoneIntent = new Intent(Intent.ACTION_CALL);
        phoneIntent.setData(Uri.parse("tel:" + phoneNumber));

        startActivity(phoneIntent);
    }
}
