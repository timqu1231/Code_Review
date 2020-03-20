package com.example.feiyang_hw1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText Input;
    TextView Tip1;
    TextView Tip2;
    TextView Tip3;
    TextView Total1;
    TextView Total2;
    TextView Total3;
    SeekBar seekBar;
    TextView SeekBar_Display;
    TextView Tip_Display;
    TextView Display_Total;
    double check_Size;
    double input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check_Size = 0.00;

        Input = ((EditText) findViewById(R.id.Input));
        Tip1 = (TextView) findViewById(R.id.Tip1);
        Tip2 = (TextView) findViewById(R.id.Tip2);
        Tip3 = (TextView) findViewById(R.id.Tip3);
        Total1 = (TextView) findViewById(R.id.Total1);
        Total2 = (TextView) findViewById(R.id.Total2);
        Total3 = (TextView) findViewById(R.id.Total3);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        SeekBar_Display = (TextView) findViewById(R.id.SeekBar_Display);
        Tip_Display = (TextView) findViewById(R.id.Tip_Display);
        Display_Total = (TextView) findViewById(R.id.Display_Total);

        Input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if (!s.toString().equals("")) {

                    input = Double.parseDouble(Input.getText().toString());
                    Tip1.setText(String.format("%.2f", input * 0.1));
                    Tip2.setText(String.format("%.2f", input * 0.15));
                    Tip3.setText(String.format("%.2f", input * 0.2));
                    Total1.setText(String.format("%.2f", input * 1.1));
                    Total2.setText(String.format("%.2f", input * 1.15));
                    Total3.setText(String.format("%.2f", input * 1.2));
                    Tip_Display.setText(String.format("%.2f", (input * (1 + check_Size / 100)-input)));
                    Display_Total.setText(String.format("%.2f", input * (1 + check_Size/100)));
                }
            }

            @Override
            public void afterTextChanged(Editable s)
                {
                    if (s.toString().equals("") || s.toString().startsWith("0")) {
                        input = 0;
                        Tip1.setText(String.format("%.2f", input * 0.1));
                        Tip2.setText(String.format("%.2f", input * 0.15));
                        Tip3.setText(String.format("%.2f", input * 0.2));
                        Total1.setText(String.format("%.2f", input * 1.1));
                        Total2.setText(String.format("%.2f", input * 1.15));
                        Total3.setText(String.format("%.2f", input * 1.2));
                        Tip_Display.setText(String.format("%.2f", (input * (1 + check_Size / 100)-input)));
                        Display_Total.setText(String.format("%.2f", input * (1 + check_Size/100)));
                    }
                }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                // handle progress change
                check_Size = seekBar.getProgress();
                SeekBar_Display.setText(seekBar.getProgress() + "%");
                    if (check_Size == 0.00) {
                        Tip1.setText(String.format("%.2f", input * 0.1));
                        Tip2.setText(String.format("%.2f", input * 0.15));
                        Tip3.setText(String.format("%.2f", input * 0.2));
                        Total1.setText(String.format("%.2f", input * 1.1));
                        Total2.setText(String.format("%.2f", input * 1.15));
                        Total3.setText(String.format("%.2f", input * 1.2));
                        Tip_Display.setText(String.format("%.2f", (input * (1 + check_Size / 100)-input)));
                        Display_Total.setText(String.format("%.2f", input * (1 + check_Size / 100)));

                    } else {
                        Tip1.setText(String.format("%.2f", input * 0.1));
                        Tip2.setText(String.format("%.2f", input * 0.15));
                        Tip3.setText(String.format("%.2f", input * 0.2));
                        Total1.setText(String.format("%.2f", input * 1.1));
                        Total2.setText(String.format("%.2f", input * 1.15));
                        Total3.setText(String.format("%.2f", input * 1.2));
                        Tip_Display.setText(String.format("%.2f", input * check_Size / 100));
                        Display_Total.setText(String.format("%.2f", input * (1 + check_Size / 100)));
                    }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });

    }
}
