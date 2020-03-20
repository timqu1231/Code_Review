package com.example.liming.lab3;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double price;
    int start_size;
    int end_size;
    TextView finalPrice;
    SeekBar seek_Bar;
    RadioGroup crust;
    RadioGroup toGo;
    int prev_crust;
    int prev_toGo;
    int topping;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        price = 0.0f;
        finalPrice = (TextView) findViewById(R.id.final_price);
        seek_Bar = (SeekBar) findViewById(R.id.seekBar);
        crust = (RadioGroup) findViewById(R.id.crust);
        toGo = (RadioGroup) findViewById(R.id.toGoOrNO);
        topping = 0;
        start_size = 0;
        end_size = 0;

        seek_Bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                end_size = seekBar.getProgress();
                price = end_size * end_size * Math.PI * (0.05) / 4;
                price += end_size  * end_size * Math.PI * (0.05) * topping / 4;
                switch (prev_crust){
                    case R.id.thick:
                        price += 2.5;
                        break;
                    case R.id.soggy:
                        price += 5.0;
                        break;
                }
                switch (prev_toGo){
                    case R.id.deliver:
                        price += 3.0;
                        break;
                }

                if(end_size == 0){
                    price = 0;
                }

                String price_text = String.format("$ %.2f", price);
                finalPrice.setText(price_text);
                String size = end_size + " inch";
                ((TextView) findViewById(R.id.size)).setText(size);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//                start_size = seekBar.getProgress();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                end_size = seekBar.getProgress();
//                price += ((end_size - start_size) * (0.05));
//                price += ((end_size - start_size) * (0.05) * topping);
//
//                String price_text = String.format("$ %.2f", price);
//                finalPrice.setText(price_text);
//                String size = end_size + " inch";
//                ((TextView) findViewById(R.id.size)).setText(size);
//                start_size = end_size;
            }
        });

    }



    public void selectCrust(View view){

        switch (view.getId()){
            case R.id.thick:
                if(end_size == 0){
                    String price_text = String.format("$ %.2f", price);
                    finalPrice.setText(price_text);
                    prev_crust = R.id.thick;
                }else {
                    if (prev_crust == R.id.thick) {
                        String price_text = String.format("$ %.2f", price);
                        finalPrice.setText(price_text);
                    } else if (prev_crust == R.id.soggy && end_size != 0) {
                        price -= 5.0;
                        price += 2.5;
                        String price_text = String.format("$ %.2f", price);
                        finalPrice.setText(price_text);
                    } else {
                        price += 2.5;
                        String price_text = String.format("$ %.2f", price);
                        finalPrice.setText(price_text);
                    }
                    prev_crust = R.id.thick;
                }
                break;
            case R.id.soggy:
                if(end_size == 0){
                    String price_text = String.format("$ %.2f", price);
                    finalPrice.setText(price_text);
                    prev_crust = R.id.soggy;
                }else {
                    if (prev_crust == R.id.soggy) {
                        String price_text = String.format("$ %.2f", price);
                        finalPrice.setText(price_text);
                    } else if (prev_crust == R.id.thick) {
                        price -= 2.5;
                        price += 5.0;
                        String price_text = String.format("$ %.2f", price);
                        finalPrice.setText(price_text);
                    } else {
                        price += 5.0;
                        String price_text = String.format("$ %.2f", price);
                        finalPrice.setText(price_text);
                    }
                    prev_crust = R.id.soggy;
                }
                break;
            case R.id.crispy:
                if(end_size == 0){
                    String price_text = String.format("$ %.2f", price);
                    finalPrice.setText(price_text);
                    prev_crust = R.id.crispy;
                }else {
                    if (prev_crust == R.id.thick) {
                        price -= 2.5;
                        String price_text = String.format("$ %.2f", price);
                        finalPrice.setText(price_text);
                    } else if (prev_crust == R.id.soggy && end_size != 0) {
                        price -= 5.0;
                        String price_text = String.format("$ %.2f", price);
                        finalPrice.setText(price_text);
                    } else {
                        String price_text = String.format("$ %.2f", price);
                        finalPrice.setText(price_text);
                    }
                    prev_crust = R.id.crispy;
                }
                break;
        }
    }

    public void selectTopping(View view){
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()){

            case R.id.anchives:
                if(checked){
                    topping++;
                    price = end_size * end_size * Math.PI * 0.05 / 4;
                    price += topping * end_size * Math.PI * end_size * 0.05 / 4;
                    switch (prev_crust){
                        case R.id.thick:
                            price += 2.5;
                            break;
                        case R.id.soggy:
                            price += 5.0;
                            break;
                    }
                    switch (prev_toGo){
                        case R.id.deliver:
                            price += 3.0;
                            break;
                    }

                    String price_text = String.format("$ %.2f", price);
                    finalPrice.setText(price_text);

                }else{
                    topping--;
                    price = end_size * end_size * Math.PI * 0.05 / 4;
                    price += topping * end_size * end_size * Math.PI * 0.05 /4;
                    switch (prev_crust){
                        case R.id.thick:
                            price += 2.5;
                            break;
                        case R.id.soggy:
                            price += 5.0;
                            break;
                    }
                    switch (prev_toGo){
                        case R.id.deliver:
                            price += 3.0;
                            break;
                    }

                    String price_text = String.format("$ %.2f", price);
                    finalPrice.setText(price_text);

                }
                break;
            case R.id.pineapple:
                if(checked){
                    topping++;
                    price = end_size * end_size * Math.PI * 0.05 / 4;
                    price += topping * end_size * Math.PI * end_size * 0.05 / 4;
                    switch (prev_crust){
                        case R.id.thick:
                            price += 2.5;
                            break;
                        case R.id.soggy:
                            price += 5.0;
                            break;
                    }
                    switch (prev_toGo){
                        case R.id.deliver:
                            price += 3.0;
                            break;
                    }

                    String price_text = String.format("$ %.2f", price);
                    finalPrice.setText(price_text);
                }else{
                    topping--;
                    price = end_size * end_size * Math.PI * 0.05 / 4;
                    price += topping * end_size * Math.PI * end_size * 0.05 / 4;
                    switch (prev_crust){
                        case R.id.thick:
                            price += 2.5;
                            break;
                        case R.id.soggy:
                            price += 5.0;
                            break;
                    }
                    switch (prev_toGo){
                        case R.id.deliver:
                            price += 3.0;
                            break;
                    }

                    String price_text = String.format("$ %.2f", price);
                    finalPrice.setText(price_text);
                }
                break;
            case R.id.garlic:
                if(checked){
                    topping++;
                    price = end_size * end_size * Math.PI * 0.05 / 4;
                    price += topping * end_size * Math.PI * end_size * 0.05 / 4;
                    switch (prev_crust){
                        case R.id.thick:
                            price += 2.5;
                            break;
                        case R.id.soggy:
                            price += 5.0;
                            break;
                    }
                    switch (prev_toGo){
                        case R.id.deliver:
                            price += 3.0;
                            break;
                    }

                    String price_text = String.format("$ %.2f", price);
                    finalPrice.setText(price_text);
                }else{
                    topping--;
                    price = end_size * end_size * Math.PI * 0.05 / 4;
                    price += topping * end_size * Math.PI * end_size * 0.05 / 4;
                    switch (prev_crust){
                        case R.id.thick:
                            price += 2.5;
                            break;
                        case R.id.soggy:
                            price += 5.0;
                            break;
                    }
                    switch (prev_toGo){
                        case R.id.deliver:
                            price += 3.0;
                            break;
                    }

                    String price_text = String.format("$ %.2f", price);
                    finalPrice.setText(price_text);
                }
                break;
            case R.id.okra:
                if(checked){
                    topping++;
                    price = end_size * end_size * Math.PI * 0.05 / 4;
                    price += topping * end_size * Math.PI * end_size * 0.05 / 4;
                    switch (prev_crust){
                        case R.id.thick:
                            price += 2.5;
                            break;
                        case R.id.soggy:
                            price += 5.0;
                            break;
                    }
                    switch (prev_toGo){
                        case R.id.deliver:
                            price += 3.0;
                            break;
                    }

                    String price_text = String.format("$ %.2f", price);
                    finalPrice.setText(price_text);
                }else{
                    topping--;
                    price = end_size * end_size * Math.PI * 0.05 / 4;
                    price += topping * end_size * Math.PI * end_size * 0.05 / 4;
                    switch (prev_crust){
                        case R.id.thick:
                            price += 2.5;
                            break;
                        case R.id.soggy:
                            price += 5.0;
                            break;
                    }
                    switch (prev_toGo){
                        case R.id.deliver:
                            price += 3.0;
                            break;
                    }

                    String price_text = String.format("$ %.2f", price);
                    finalPrice.setText(price_text);
                }
                break;

        }
    }

    public void toGoOrNo(View view){
        switch (view.getId()){

            case R.id.deliver:
                if(end_size == 0){
                    String price_text = String.format("$ %.2f", price);
                    finalPrice.setText(price_text);
                    prev_toGo = R.id.deliver;
                }else {
                    if (prev_toGo == R.id.deliver) {
                        String price_text = String.format("$ %.2f", price);
                        finalPrice.setText(price_text);
                    } else {


                        price += 3.00;
                        String price_text = String.format("$ %.2f", price);
                        finalPrice.setText(price_text);

                    }
                    prev_toGo = R.id.deliver;
                }
                break;
            case R.id.atRestaurant:
                if(end_size == 0){
                    String price_text = String.format("$ %.2f", price);
                    finalPrice.setText(price_text);
                    prev_toGo = R.id.atRestaurant;
                }else {
                    if (prev_toGo == R.id.deliver) {
                        price -= 3.0;

                        String price_text = String.format("$ %.2f", price);
                        finalPrice.setText(price_text);
                    } else {
                        String price_text = String.format("$ %.2f", price);
                        finalPrice.setText(price_text);
                    }

                    prev_toGo = R.id.atRestaurant;
                }

                break;
            case R.id.pickup:
                if(end_size == 0){
                    String price_text = String.format("$ %.2f", price);
                    finalPrice.setText(price_text);
                    prev_toGo = R.id.pickup;
                }else {
                    if (prev_toGo == R.id.deliver && end_size != 0) {
                        price -= 3.0;

                        String price_text = String.format("$ %.2f", price);
                        finalPrice.setText(price_text);
                    } else {
                        String price_text = String.format("$ %.2f", price);
                        finalPrice.setText(price_text);
                    }
                    prev_toGo = R.id.pickup;
                }
                break;


        }
    }
}
