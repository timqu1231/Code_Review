package com.example.homework3;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper databaseHelper;

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "homework3.db";

    private static final String TABLE_CONTACT = "contact";
    private static final String COLUMN_CONTACT_ID = "contact_id";
    public static final String COLUMN_CONTACT_NAME = "contact_name";
    public static final String COLUMN_CONTACT_PHONE = "contact_phone";
    public static final String COLUMN_CONTACT_EMAIL = "contact_email";
    public static final String COLUMN_CONTACT_STREET = "contact_street";
    public static final String COLUMN_CONTACT_CITY = "contact_city";

    private String CREATE_CONTACT_TABLE =
            "CREATE TABLE " + TABLE_CONTACT + "("
            + COLUMN_CONTACT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_CONTACT_NAME + " TEXT,"
            + COLUMN_CONTACT_PHONE + " TEXT,"
            + COLUMN_CONTACT_EMAIL + " TEXT,"
            + COLUMN_CONTACT_STREET + " TEXT,"
            + COLUMN_CONTACT_CITY + " TEXT)";

    private String DROP_CONTACT_TABLE = "DROP TABLE IF EXISTS " + TABLE_CONTACT;

    public static DatabaseHelper getInstance(Context context){
        if (databaseHelper == null){
            synchronized (DatabaseHelper.class){
                if (databaseHelper == null){
                    databaseHelper = new DatabaseHelper(context.getApplicationContext());
                }
            }
        }
        return databaseHelper;
    }

    private DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CONTACT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_CONTACT_TABLE);
        onCreate(db);
    }

    public void addContact(String name, String phone, String email, String street, String city){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_CONTACT_NAME, name);
        values.put(COLUMN_CONTACT_PHONE, phone);
        values.put(COLUMN_CONTACT_EMAIL, email);
        values.put(COLUMN_CONTACT_STREET, street);
        values.put(COLUMN_CONTACT_CITY, city);

        db.insert(TABLE_CONTACT, null, values);
        db.close();
    }

    public void updateContact(String old_name, String new_name, String phone, String email, String street, String city){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_CONTACT_NAME, new_name);
        values.put(COLUMN_CONTACT_PHONE, phone);
        values.put(COLUMN_CONTACT_EMAIL, email);
        values.put(COLUMN_CONTACT_STREET, street);
        values.put(COLUMN_CONTACT_CITY, city);

        String[] whereArgs = new String[]{String.valueOf(old_name)};
        db.update(TABLE_CONTACT, values, COLUMN_CONTACT_NAME + " =?", whereArgs);
    }


    public void deleteContact(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACT, COLUMN_CONTACT_NAME + " =?",
                new String[]{String.valueOf(name)});
    }

    public Contact getContact(String name){
        String[] columns = {
                COLUMN_CONTACT_PHONE,
                COLUMN_CONTACT_EMAIL,
                COLUMN_CONTACT_STREET,
                COLUMN_CONTACT_CITY
        };

        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMN_CONTACT_NAME + " =?";
        String[] selectionArgs = {name};

        Cursor cursor = db.query(TABLE_CONTACT,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);

        if (cursor != null && cursor.getCount() != 0){
            cursor.moveToFirst();
            String email_ = cursor.getString(cursor.getColumnIndex(COLUMN_CONTACT_EMAIL));
            String phone_ = cursor.getString(cursor.getColumnIndex(COLUMN_CONTACT_PHONE));
            String street_ = cursor.getString(cursor.getColumnIndex(COLUMN_CONTACT_STREET));
            String city_ = cursor.getString(cursor.getColumnIndex(COLUMN_CONTACT_CITY));

            Contact contact = new Contact(name, phone_, email_, street_, city_);

            return contact;
        }else{
            return null;
        }
    }

    public Cursor getContacts(){


        String[] columns = {
                COLUMN_CONTACT_NAME,
                COLUMN_CONTACT_PHONE,
                COLUMN_CONTACT_EMAIL,
                COLUMN_CONTACT_STREET,
                COLUMN_CONTACT_CITY
        };

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACT,
                columns,
                null,
                null,
                null,
                null,
                null);

        return cursor;
    }


}
