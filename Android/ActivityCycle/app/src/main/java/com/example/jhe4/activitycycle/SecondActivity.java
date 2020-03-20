package com.example.jhe4.activitycycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by jhe4 on 8/25/2017.
 */

public class SecondActivity extends AppCompatActivity {

    Button btn2;
    String msg = "SecondActivity (Log) : ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("SecondActivity--->onCreate");
        Log.d(msg, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn2 = (Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        System.out.println("SecondActivity--->onDestory");
        Log.d(msg, "onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        System.out.println("SecondActivity--->onPause");
        Log.d(msg, "onPause");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        // TODO Auto-generated method stub
        System.out.println("SecondActivity--->onRestart");
        Log.d(msg, "onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        System.out.println("SecondActivity--->onResume");
        Log.d(msg, "onResume");
        super.onResume();
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        System.out.println("SecondActivity--->onStart");
        Log.d(msg, "onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        System.out.println("SecondActivity--->onStop");
        Log.d(msg, "onStop");
        super.onStop();
    }

}
