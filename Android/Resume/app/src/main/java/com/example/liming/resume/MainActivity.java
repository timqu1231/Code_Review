package com.example.liming.resume;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> selections = new ArrayList<>();
    TextView text;
    Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        text = (TextView) findViewById(R.id.seekbarView);
//        text.setVisibility(View.INVISIBLE);
//        aSwitch = (Switch) findViewById(R.id.switch_button);
//        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    text.setText("Switch On");
//                    text.setVisibility(View.VISIBLE);
//                }else{
//                    text.setText("Switch Off");
//                }
//            }
//        });

        final SeekBar mySeekBar = (SeekBar) findViewById(R.id.my_Seek_Bar);
//        seekBar.setMin(3);
        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(getApplicationContext(), "The current value is: " + mySeekBar.getProgress(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


//        SharedPreferences sp = getSharedPreferences("pref_name", MODE_PRIVATE);
//        SharedPreferences.Editor editor = sp.edit();
//        editor.putString("today", "2016-1-1");
//        editor.putBoolean("bValue", true);
//        editor.apply();
    }

    public void toggleClick(View view){
        boolean checked = ((ToggleButton) view).isChecked();
        if(checked){
            text.setText("Toggle On");
            text.setVisibility(View.VISIBLE);
        }else{
            text.setText("Toggle Off");
        }
    }
    public void selectItem(View view){
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.apple:
                if (checked){
                    selections.add("apple");
                }else{
                    selections.remove("apple");
                }
                break;
            case R.id.orange:
                if(checked){
                    selections.add("orange");
                }else{
                    selections.remove("orange");
                }
                break;
            case R.id.grape:
                if(checked){
                    selections.add("grape");
                }else{
                    selections.remove("grape");
                }
                break;
        }
    }

    public void finalResult(View view){
        text = (TextView) findViewById(R.id.my_text);
        String result = "";
        for(String selectItem : selections){
            result += selectItem + "\n";
        }
        text.setText(result);
        text.setEnabled(true);
    }

    public void radioItem(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.radio_apple:
                if(checked){
                    text.setText("apple");
                    text.setEnabled(true);
                }else{
                    text.setEnabled(false);
                }
                break;
            case R.id.radio_orange:
                if(checked){
                    text.setText("orange");
                    text.setEnabled(true);
                }else{
                    text.setEnabled(false);
                }
                break;
            case R.id.radio_grape:
                if(checked){
                    text.setText("grape");
                    text.setEnabled(true);
                }else{
                    text.setEnabled(false);
                }
                break;
        }
    }
}
