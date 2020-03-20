package com.example.liming.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView myTV;
    Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nameEidt = (EditText) findViewById(R.id.my_text_edit) ;
        myTV = (TextView) findViewById(R.id.button_view);


        myButton = (Button) findViewById(R.id.my_button);

        myButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                myTV.setText("Hello " + nameEidt.getText());
            }
        });

    }
}
