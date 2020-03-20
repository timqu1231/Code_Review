package com.example.homework3;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AddContactActivity extends AppCompatActivity {

    public final static int ADD_CONTACT = 100;

    EditText add_name;
    EditText add_phone;
    EditText add_email;
    EditText add_street;
    EditText add_city;
    Button add_save;


    String name;
    String phone;
    String email;
    String street;
    String city;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        add_name = (EditText) findViewById(R.id.name);
        add_phone = (EditText) findViewById(R.id.phone);
        add_email = (EditText) findViewById(R.id.email);
        add_street = (EditText) findViewById(R.id.street);
        add_city = (EditText) findViewById(R.id.city);
        add_save = (Button) findViewById(R.id.save);

        add_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = add_name.getText().toString();
                phone = add_phone.getText().toString();
                email = add_email.getText().toString();
                street = add_street.getText().toString();
                city = add_city.getText().toString();

                if (TextUtils.isEmpty(name)){
                    AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                    builder.setTitle("Contact Name is Required")
                            .setMessage("You must enter a contact name")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                    builder.show();
                }else{
                    MyAsyncTask myAsyncTask = new MyAsyncTask(AddContactActivity.this);
                    myAsyncTask.execute("add_contact", name, phone, email, street, city);
                    finish();
                }
            }


        });






    }
}
