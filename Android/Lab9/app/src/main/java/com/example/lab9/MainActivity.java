package com.example.lab9;

import android.Manifest;
import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.CallLog;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;



public class MainActivity extends AppCompatActivity {
    TextView display;
    EditText search;
    Button search_button, delete_button;
    String  type;
    Long dateInt;
    private String[] myColumnProjection = new String[]{
            CallLog.Calls.TYPE,
            CallLog.Calls.DATE,
            CallLog.Calls.NUMBER};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = (TextView) findViewById(R.id.display);
        search = (EditText) findViewById(R.id.search);
        search_button = (Button) findViewById(R.id.search_button);
        delete_button = (Button) findViewById(R.id.delete_button);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CALL_LOG},20);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_CALL_LOG},20);

        ContentResolver contentResolver=getContentResolver();

        Cursor cursor=contentResolver.query(CallLog.Calls.CONTENT_URI,
                myColumnProjection,
                null,
                null,
                null);

        if(cursor!=null && cursor.getCount()>0){
            StringBuilder stringBuilderQueryResult=new StringBuilder("");
            while (cursor.moveToNext()){
                dateInt = Long.parseLong(cursor.getString(1));
                Date dateLong = new Date(dateInt);
                SimpleDateFormat dateformat = new SimpleDateFormat("MMM dd, yyyy HH:mm");
                type = cursor.getString(0);
                if (type.equals("1")){
                    type = "Income Call";
                }else if (type.equals("2")){
                    type = "Outcome Call";
                }else{
                    type = "Missing Call";
                }
                stringBuilderQueryResult.append(type);
                stringBuilderQueryResult.append(", " + dateformat.format(dateLong) + ", ");
                stringBuilderQueryResult.append("from " + cursor.getString(2));
                stringBuilderQueryResult.append("\n");
            }
            display.setText(stringBuilderQueryResult.toString());
        }else{
            display.setText("No Contacts in device");
        }
        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //display.setText("No Contacts Found");
                ContentResolver contentResolver=getContentResolver();
                Cursor cursor=contentResolver.query(CallLog.Calls.CONTENT_URI,
                        myColumnProjection,
                        null,
                        null,
                        null);
                StringBuilder stringBuilderQueryResult=new StringBuilder("");
                String whereClause=CallLog.Calls.TYPE;
                if(cursor!=null && cursor.getCount()>0) {
                    if (search.getText().toString().equals("")) {
                        while (cursor.moveToNext()){
                            dateInt = Long.parseLong(cursor.getString(1));
                            Date dateLong = new Date(dateInt);
                            SimpleDateFormat dateformat = new SimpleDateFormat("MMM dd, yyyy HH:mm");
                            type = cursor.getString(0);
                            if (type.equals("1")){
                                type = "Income Call";
                            }else if (type.equals("2")){
                                type = "Outcome Call";
                            }else{
                                type = "Missing Call";
                            }
                            stringBuilderQueryResult.append(type);
                            stringBuilderQueryResult.append(", " + dateformat.format(dateLong) + ", ");
                            stringBuilderQueryResult.append("from " + cursor.getString(2));
                            stringBuilderQueryResult.append("\n");
                        }
                        display.setText(stringBuilderQueryResult.toString());
                    } else if (search.getText().toString().equals("1")) {
                        while (cursor.moveToNext()){
                            dateInt = Long.parseLong(cursor.getString(1));
                            Date dateLong = new Date(dateInt);
                            SimpleDateFormat dateformat = new SimpleDateFormat("MMM dd, yyyy HH:mm");
                            type = cursor.getString(0);
                            if (type.equals("1")) {
                                type = "Income Call";
                                stringBuilderQueryResult.append(type);
                                stringBuilderQueryResult.append(", " + dateformat.format(dateLong) + ", ");
                                stringBuilderQueryResult.append("from " + cursor.getString(2));
                                stringBuilderQueryResult.append("\n");
                            }
                        }
                        display.setText(stringBuilderQueryResult.toString());
                    } else if (search.getText().toString().equals("2")) {
                        while (cursor.moveToNext()){
                            dateInt = Long.parseLong(cursor.getString(1));
                            Date dateLong = new Date(dateInt);
                            SimpleDateFormat dateformat = new SimpleDateFormat("MMM dd, yyyy HH:mm");
                            type = cursor.getString(0);
                            if (type.equals("2")) {
                                type = "Outcome Call";
                                stringBuilderQueryResult.append(type);
                                stringBuilderQueryResult.append(", " + dateformat.format(dateLong) + ", ");
                                stringBuilderQueryResult.append("from " + cursor.getString(2));
                                stringBuilderQueryResult.append("\n");
                            }
                        }
                        display.setText(stringBuilderQueryResult.toString());
                    } else if (search.getText().toString().equals("3")) {
                        while (cursor.moveToNext()){
                            dateInt = Long.parseLong(cursor.getString(1));
                            Date dateLong = new Date(dateInt);
                            SimpleDateFormat dateformat = new SimpleDateFormat("MMM dd, yyyy HH:mm");
                            type = cursor.getString(0);
                            if (type.equals(("3"))) {
                                type = "Missing Call";
                                stringBuilderQueryResult.append(type);
                                stringBuilderQueryResult.append(", " + dateformat.format(dateLong) + ", ");
                                stringBuilderQueryResult.append("from " + cursor.getString(2));
                                stringBuilderQueryResult.append("\n");
                            }
                        }
                        display.setText(stringBuilderQueryResult.toString());
                    } else {
                        display.setText("No Contacts Found");
                    }
                }else{
                    display.setText("No Contacts in deceive");
                }
            }
        });
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CALL_LOG},20);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_CALL_LOG},20);

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String whereClause=CallLog.Calls.TYPE+ " = '"+search.getText().toString()+"'";
                //String whereClause=CallLog.Calls.TYPE+ " = 1";
                getContentResolver().delete(CallLog.Calls.CONTENT_URI,whereClause,null);
            }
        });
    }
}
