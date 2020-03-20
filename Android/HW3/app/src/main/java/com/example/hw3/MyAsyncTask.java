package com.example.hw3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MyAsyncTask extends AsyncTask<String, Contact, String> {
    Context ctx;
    ContactAdapter contactAdapter;
    Activity activity;
    ListView listView;

    MyAsyncTask(Context ctx){
        this.ctx = ctx;
        activity = (Activity) ctx;
    }

    @Override
    protected String doInBackground(String... params) {

        String method = params[0];
        if (method.equals("add_contact")){
            String name = params[1];
            String phone = params[2];
            String email = params[3];
            String street = params[4];
            String city = params[5];

            DatabaseHelper.getInstance(ctx).addContact(name, phone, email, street,city);



            return "One Contact Inserted...";

        }else if (method.equals("get_contacts")){

            listView = activity.findViewById(R.id.list_view);
            contactAdapter = new ContactAdapter(ctx, R.layout.display_contact_row);
            contactAdapter.notifyDataSetChanged();

            Cursor cursor = DatabaseHelper.getInstance(ctx).getContacts();
            while (cursor.moveToNext()) {

                String name_ = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_CONTACT_NAME));
                String email_ = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_CONTACT_EMAIL));
                String phone_ = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_CONTACT_PHONE));
                String street_ = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_CONTACT_STREET));
                String city_ = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_CONTACT_CITY));

                Contact contact = new Contact(name_, phone_, email_, street_, city_);
                publishProgress(contact);
            }

            return "get_contacts";

        }else if(method.equals("delete_contact")){
            String name = params[1];
            DatabaseHelper.getInstance(ctx).deleteContact(name);
            return "delete contact";

        }else if(method.equals("update_contact")){
            String old_name = params[1];
            String new_name = params[2];
            String phone = params[3];
            String email = params[4];
            String street = params[5];
            String city = params[6];
            DatabaseHelper.getInstance(ctx).updateContact(old_name, new_name, phone, email, street, city);
            return "update contact";
        }
        return null;

    }

    @Override
    protected void onProgressUpdate(Contact... values) {
        contactAdapter.add(values[0]);

    }

    @Override
    protected void onPostExecute(String s) {
        if (s.equals("get_contacts")){
            listView.setAdapter(contactAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Contact contact = (Contact) parent.getItemAtPosition(position);
                    Intent intent = new Intent(ctx, DetailContactActivity.class);
                    intent.putExtra(DetailContactActivity.DETAIL_NAME, contact.getName());
                    intent.putExtra(DetailContactActivity.DETAIL_email, contact.getEmail());
                    intent.putExtra(DetailContactActivity.DETAIL_PHONE, contact.getPhone());
                    intent.putExtra(DetailContactActivity.DETAIL_street, contact.getStreet());
                    intent.putExtra(DetailContactActivity.DETAIL_city, contact.getCity());
                    ctx.startActivity(intent);
                }
            });
        }else{
            Toast.makeText(ctx, s, Toast.LENGTH_LONG).show();
        }
    }
}
