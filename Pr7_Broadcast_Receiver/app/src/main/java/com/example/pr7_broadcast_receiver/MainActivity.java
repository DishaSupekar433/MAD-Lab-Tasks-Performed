/*package com.example.pr7_broadcast_receiver;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView showlevel;
    ProgressBar pb;
    BatteryReceiver myReceiver = new BatteryReceiver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showlevel = findViewById(R.id.show_level);
        pb = findViewById(R.id.progressBar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(myReceiver,ifilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myReceiver);
    }

    private class BatteryReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
            showlevel.setText("Battery status: "+level);
            pb.setProgress(level);
        }
    }
}
*/
package com.example.pr7_broadcast_receiver;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView showlevel;
    ProgressBar pb;
    BatteryReceiver batteryReceiver = new BatteryReceiver();
    BluetoothReceiver bluetoothReceiver = new BluetoothReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showlevel = findViewById(R.id.show_level);
        pb = findViewById(R.id.progressBar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter batteryIntentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(batteryReceiver, batteryIntentFilter);

        IntentFilter bluetoothIntentFilter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        registerReceiver(bluetoothReceiver, bluetoothIntentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(batteryReceiver);
        unregisterReceiver(bluetoothReceiver);
    }

    private class BatteryReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            showlevel.setText("Battery Status: " + level +"%");
            pb.setProgress(level);
        }
    }

    private class BluetoothReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR);
            switch (state) {
                case BluetoothAdapter.STATE_OFF:
                    // Bluetooth turned off
                    showToast(context, "Bluetooth turned off");
                    break;
                case BluetoothAdapter.STATE_TURNING_OFF:
                    // Bluetooth turning off
                    showToast(context, "Bluetooth turning off");
                    break;
                case BluetoothAdapter.STATE_ON:
                    // Bluetooth turned on
                    showToast(context, "Bluetooth turned on");
                    break;
                case BluetoothAdapter.STATE_TURNING_ON:
                    // Bluetooth turning on
                    showToast(context, "Bluetooth turning on");
                    break;
            }
        }
    }

    private void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
