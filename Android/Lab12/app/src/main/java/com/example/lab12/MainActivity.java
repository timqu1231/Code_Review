package com.example.lab12;

import android.app.Dialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyView myView;
    Dialog dialogOption;
    public SeekBar redSeekBarValue;
    public SeekBar greenSeekBarValue;
    public SeekBar blueSeekBarValue;
    public TextView redTextView;
    public TextView greenTextView;
    public TextView blueTextView;
    public TextView selectedColor;
    public int redValue = 0;
    public int greenValue = 0;
    public int blueValue = 255;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = new MyView(this, null);
        setContentView(myView);
    }

    void showColorDialog() {
        dialogOption = new Dialog(MainActivity.this);
        dialogOption.setContentView(R.layout.color);
        dialogOption.setTitle("Select Color");
        dialogOption.show();
        redSeekBarValue = (SeekBar) dialogOption.findViewById(R.id.redseekBar);
        greenSeekBarValue = (SeekBar) dialogOption.findViewById(R.id.greenseekBar);
        blueSeekBarValue = (SeekBar) dialogOption.findViewById(R.id.blueseekBar);
        redTextView = (TextView) dialogOption.findViewById(R.id.redselected);
        greenTextView = (TextView) dialogOption.findViewById(R.id.greenselected);
        blueTextView = (TextView) dialogOption.findViewById(R.id.blueselected);
        selectedColor = (TextView) dialogOption.findViewById(R.id.selectedColortv);
        redTextView.setText(redValue + "");
        greenTextView.setText(greenValue + "");
        blueTextView.setText(blueValue + "");
        redSeekBarValue.setProgress(redValue);
        greenSeekBarValue.setProgress(greenValue);
        blueSeekBarValue.setProgress(blueValue);
        selectedColor.setBackgroundColor(Color.rgb(redValue,greenValue,blueValue));

        redSeekBarValue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                redValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                redTextView.setText(redValue + "");
                int color = Color.rgb(redValue, greenValue, blueValue);
                selectedColor.setBackgroundColor(color);
            }
        });

        greenSeekBarValue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                greenValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                greenTextView.setText(greenValue + "");
                int color = Color.rgb(redValue, greenValue, blueValue);
                selectedColor.setBackgroundColor(color);
            }
        });

        blueSeekBarValue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blueValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                blueTextView.setText(blueValue + "");
                int color = Color.rgb(redValue, greenValue, blueValue);
                selectedColor.setBackgroundColor(color);
            }
        });

        Button setColorButton  = (Button) dialogOption.findViewById(R.id.setColor);
        setColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(myView);
                int color = Color.rgb(redValue, greenValue, blueValue);
                myView.setColor(color);
                dialogOption.dismiss();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.color:
                showColorDialog();
                break;
            case R.id.reset:
                myView.reset();
                break;
            case R.id.circle:
                myView.setCurrent_shape(myView.CIRCLE);
                break;
            case R.id.triangle:
                myView.setCurrent_shape(myView.TRIANGLE);
                break;
            case R.id.rectangle:
                myView.setCurrent_shape(myView.RECTANGLE);
                break;
            case R.id.shrink:
                if (myView.current_shape == myView.CIRCLE) {
                    myView.shrinkCircle();
                }else if (myView.current_shape == myView.TRIANGLE) {
                    myView.shrinkTriangle();
                }else if(myView.current_shape == myView.RECTANGLE) {
                    myView.shrinkRectangle();
                }
                break;
            case R.id.enlarge:
                if (myView.current_shape == myView.CIRCLE) {
                    myView.enLargeCircle();
                }else if (myView.current_shape == myView.TRIANGLE) {
                    myView.enLargeTriangle();
                }else if(myView.current_shape == myView.RECTANGLE) {
                    myView.enLargeRectangle();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
