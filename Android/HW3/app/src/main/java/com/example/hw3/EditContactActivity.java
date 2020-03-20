package com.example.hw3;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditContactActivity extends AppCompatActivity{

    public static final String EDIT_NAME = "edit_name";
    public static final String EDIT_PHONE = "edit_phone";
    public static final String EDIT_email = "edit_email";
    public static final String EDIT_street = "edit_street";
    public static final String EDIT_city = "edit_city";

    EditText edit_name;
    EditText edit_phone;
    EditText edit_street;
    EditText edit_city;
    EditText edit_email;

    Button save_button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        Intent intent = getIntent();

        edit_name = (EditText) findViewById(R.id.edit_name);
        edit_city = (EditText) findViewById(R.id.edit_city);
        edit_email = (EditText) findViewById(R.id.edit_email);
        edit_phone = (EditText) findViewById(R.id.edit_phone);
        edit_street = (EditText) findViewById(R.id.edit_street);
        save_button = (Button) findViewById(R.id.edit_save);

        final String old_name = intent.getStringExtra(EDIT_NAME).trim();
        edit_name.setText(old_name);
        edit_email.setText(intent.getStringExtra(EDIT_email));
        edit_street.setText(intent.getStringExtra(EDIT_street));
        edit_phone.setText(intent.getStringExtra(EDIT_PHONE));
        edit_city.setText(intent.getStringExtra(EDIT_city));



        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String new_name = edit_name.getText().toString().trim();
                String new_phone = edit_phone.getText().toString().trim();
                String new_email = edit_email.getText().toString().trim();
                String new_city = edit_city.getText().toString().trim();
                String new_street = edit_street.getText().toString().trim();

                if (TextUtils.isEmpty(new_name)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(EditContactActivity.this);
                    builder.setTitle("Contact Name is Required")
                            .setMessage("You must enter a contact name")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                    builder.show();
                } else {
                    MyAsyncTask myAsyncTask = new MyAsyncTask(EditContactActivity.this);
                    myAsyncTask.execute("update_contact", old_name, new_name, new_phone, new_email, new_street, new_city);
                    Intent intent = new Intent(EditContactActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
