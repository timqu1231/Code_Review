package com.example.lab11_db;

import android.content.ContentResolver;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private ContentResolver contentResolver;
    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        contentResolver = getContentResolver();
        display = findViewById(R.id.display);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getStudents();
            }
        });
    }

    private void getStudents(){
        Cursor cursor = contentResolver.query(StudentsProviderConstants.CONTENT_URI, null, null, null,
                null, null);

        StringBuilder stringBuilder = new StringBuilder("");

        if(cursor != null && cursor.getCount()>0){
            while(cursor.moveToNext()){
                stringBuilder.append(cursor.getString(1) + ", "+cursor.getString(2)+ "\n");
            }
            cursor.close();
            display.setText(stringBuilder.toString());
        }
    }
}
