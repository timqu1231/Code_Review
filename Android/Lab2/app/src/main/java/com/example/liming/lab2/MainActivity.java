package com.example.liming.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double price = 0.0;
    int start_size;
    int end_size;
    TextView finalPrice = (TextView) findViewById(R.id.final_price);
    SeekBar seek_Bar = (SeekBar) findViewById(R.id.seekBar);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seek_Bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                start_size = seekBar.getProgress();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                end_size = seekBar.getProgress();
                price += (end_size - start_size) * .05;
                String price_text = "$ " + price;
                finalPrice.setText(price_text);
            }
        });

    }

    public void selectCrust(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.thick:
                if(checked){
                    price += 2.5;
                    String price_text = "$ " + price;price_text += price;
                    finalPrice.setText(price_text);
                }else{
                    price -= 2.5;
                    String price_text = "$ " + price;
                    finalPrice.setText(price_text);
                }
                break;
            case R.id.soggy:
                if(checked){
                    price += 5.0;
                    String price_text = "$ " + price;
                    finalPrice.setText(price_text);
                }else{
                    price -= 5.0;
                    String price_text = "$ " + price;
                    finalPrice.setText(price_text);
                }
                break;
        }
    }

    public void selectTopping(View view){
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()){

            case R.id.anchives:
                if(checked){
                    price += end_size * .05;
                    String price_text = "$ " + price;
                    finalPrice.setText(price_text);
                }else{
                    price -= end_size * .05;
                    String price_text = "$ " + price;
                    finalPrice.setText(price_text);
                }
                break;
            case R.id.pineapple:
                if(checked){
                    price += end_size * .05;
                    String price_text = "$ " + price;
                    finalPrice.setText(price_text);
                }else{
                    price -= end_size * .05;
                    String price_text = "$ " + price;
                    finalPrice.setText(price_text);
                }
                break;
            case R.id.garlic:
                if(checked){
                    price += end_size * .05;
                    String price_text = "$ " + price;
                    finalPrice.setText(price_text);
                }else{
                    price -= end_size * .05;
                    String price_text = "$ " + price;
                    finalPrice.setText(price_text);
                }
                break;
            case R.id.okra:
                if(checked){
                    price += end_size * .05;
                    String price_text = "$ " + price;
                    finalPrice.setText(price_text);
                }else{
                    price -= end_size * .05;
                    String price_text = "$ " + price;
                    finalPrice.setText(price_text);
                }
                break;

        }
    }

    public void toGoOrNo(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){

            case R.id.deliver:
                if(checked) {
                    price += 3.00;
                    String price_text = "$ " + price;
                    finalPrice.setText(price_text);
                }else{
                    price -= 3.00;
                    String price_text = "$ " + price;
                    finalPrice.setText(price_text);
                }
                break;

        }
    }


}
