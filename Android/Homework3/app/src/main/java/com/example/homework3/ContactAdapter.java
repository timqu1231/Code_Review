package com.example.homework3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends ArrayAdapter {

    List list = new ArrayList();
    public ContactAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(Object object) {
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ContactHolder contactHolder;
        if(row == null){
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.display_contact_row, parent, false);
            contactHolder = new ContactHolder();
            contactHolder.contact_name = row.findViewById(R.id.contact_name);
            row.setTag(contactHolder);
        }else{
            contactHolder = (ContactHolder)row.getTag();
        }

        Contact contact = (Contact)getItem(position);
        contactHolder.contact_name.setText(contact.getName());
        return row;
    }

    static class ContactHolder{
        TextView contact_name;
    }
}
