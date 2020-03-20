package com.example.feiyang_lab5;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    Intent intent1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.main_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent1 = new Intent(Intent.ACTION_VIEW);
//                intent1.setAction("myAction1");
                intent1.addCategory(Intent.CATEGORY_BROWSABLE);
                intent1.setData(Uri.parse("https://developer.android.com/"));
//                Intent chooser = Intent.createChooser(intent1, "Use a different app");
//                startActivity(intent1);
                if (intent1.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent1);
                }else{
                    Toast.makeText(getApplicationContext(), "No Activity", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
