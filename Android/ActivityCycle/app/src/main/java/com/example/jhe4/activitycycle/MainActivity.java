package com.example.jhe4.activitycycle;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String msg = "FirstActivity (Log) : ";

    EditText edit;
    Button btn1, update;
    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("FirstActivity--->onCreate");
        Log.d(msg, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = (EditText)findViewById(R.id.edit);
        text = (TextView)findViewById(R.id.text);

        btn1 = (Button)findViewById(R.id.transite);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), SecondActivity.class);
                startActivity(intent);

            }
        });

        update = (Button)findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(edit.getText().toString());
            }
        });

    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        System.out.println("FirstAcvity --->onDestory");
        Log.d(msg, "onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        System.out.println("FirstAcvity --->onPause");
        Log.d(msg, "onPause");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        // TODO Auto-generated method stub
        System.out.println("FirstAcvity --->onRestart");
        Log.d(msg, "onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        System.out.println("FirstAcvity --->onResume");
        Log.d(msg, "onResume");
        super.onResume();
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        System.out.println("FirstAcvity --->onStart");
        Log.d(msg, "onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        System.out.println("FirstAcvity --->onStop");
        Log.d(msg, "onStop");
        super.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("TEXT", (String)text.getText());

        Toast.makeText(this, "onSaveInstanceState()", Toast.LENGTH_LONG).show();

        Log.d(msg, (String)text.getText());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        text.setText(savedInstanceState.getString("TEXT"));

        Toast.makeText(this, "onRestoreInstanceState()", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }
}
