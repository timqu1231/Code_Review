package com.example.homework3;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;


public class DetailContactActivity extends AppCompatActivity {

    public static final String DETAIL_NAME = "detail_name";
    public static final String DETAIL_PHONE = "detail_phone";
    public static final String DETAIL_email = "detail_email";
    public static final String DETAIL_street = "detail_street";
    public static final String DETAIL_city = "detail_city";

    TextView textview_name;
    TextView textview_phone;
    TextView textview_email;
    TextView textview_street;
    TextView textview_city;

    String name;
    String phone;
    String email;
    String street;
    String city;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_contact);

        name = getIntent().getStringExtra(DETAIL_NAME);
        phone = getIntent().getStringExtra(DETAIL_PHONE);
        email = getIntent().getStringExtra(DETAIL_email);
        street = getIntent().getStringExtra(DETAIL_street);
        city = getIntent().getStringExtra(DETAIL_city);

        textview_name = findViewById(R.id.text_view_name);
        textview_phone = findViewById(R.id.text_view_phone);
        textview_city = findViewById(R.id.text_view_city);
        textview_email = findViewById(R.id.text_view_email);
        textview_street = findViewById(R.id.text_view_street);

        textview_name.setText(name);
        textview_street.setText(street);
        textview_email.setText(email);
        textview_street.setText(street);
        textview_phone.setText(phone);
        textview_city.setText(city);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete_contact:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Are you Sure?")
                        .setMessage("This will permanently delete the contact")
                        .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                MyAsyncTask myAsyncTask = new MyAsyncTask(DetailContactActivity.this);
                                myAsyncTask.execute("delete_contact", name);
                                finish();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                builder.show();
                break;

            case R.id.edit_contact:
                Intent intent = new Intent(this, EditContactActivity.class);
                intent.putExtra(EditContactActivity.EDIT_NAME, name);
                intent.putExtra(EditContactActivity.EDIT_city, city);
                intent.putExtra(EditContactActivity.EDIT_PHONE, phone);
                intent.putExtra(EditContactActivity.EDIT_email, email);
                intent.putExtra(EditContactActivity.EDIT_street, street);

                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
