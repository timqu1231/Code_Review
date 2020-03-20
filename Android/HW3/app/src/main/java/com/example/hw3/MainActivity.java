package com.example.hw3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyAsyncTask myAsyncTask = new MyAsyncTask(this);
        myAsyncTask.execute("get_contacts");
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyAsyncTask myAsyncTask = new MyAsyncTask(this);
        myAsyncTask.execute("get_contacts");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_contact:
                Intent intent = new Intent(this, AddContactActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
