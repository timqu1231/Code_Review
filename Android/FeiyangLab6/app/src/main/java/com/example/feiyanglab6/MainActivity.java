package com.example.feiyanglab6;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnStart, btnStop;
    TextView myTV, display;
    Intent serviceIntent;
    RandomNumberService myService;
    IntentFilter myIF;
    boolean check = false;
    /*MyBroadcastReceiver myBroadcastReceiver;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = (Button) findViewById(R.id.start);
        btnStop = (Button) findViewById(R.id.stop);
        myTV = (TextView)findViewById(R.id.random);
        display = (TextView)findViewById(R.id.display);
        myIF = new IntentFilter("com.example.MyService");
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(myBroadcastReceiver,myIF);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myBroadcastReceiver);
    }

    public void onClick(View view)
    {
        switch (view.getId()){
            case R.id.start:
                serviceIntent = new Intent(getApplicationContext(), RandomNumberService.class);
                //IntentFilter theFilter = new IntentFilter();
                //IntentFilter theFilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
                //theFilter.addAction(BROADCAST_ACTION);
                //theFilter.addAction(ACTION);
                startService(serviceIntent);
                check = true;
                break;
            case R.id.stop:
                //serviceIntent = new Intent(getApplicationContext(), RandomNumberService.class);
                if (check == true) {
                    stopService(serviceIntent);
                }else{

                    //return null;
                    //Toast.makeText("Service not start", Toast.LENGTH_SHORT).show();
                }
                //unregisterReceiver(myBroadcastReceiver);
                break;

        }
    }

    BroadcastReceiver myBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //IntentFilter theFilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
            //theFilter.addAction(BROADCAST_ACTION);
            //theFilter.addAction(ACTION);

            //context.startService(serviceIntent);
            //Toast.makeText(context, "Broadcast Receiver is triggered", Toast.LENGTH_SHORT).show();
            char a = intent.getCharExtra("character", 'A');
            display.setText("Random Letter: " + a);
        }
    };
}
