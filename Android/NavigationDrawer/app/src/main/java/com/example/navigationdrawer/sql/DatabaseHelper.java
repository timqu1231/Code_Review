package com.example.navigationdrawer.sql;

import android.app.assist.AssistStructure;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.navigationdrawer.model.User;
import com.example.navigationdrawer.model.Venue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "mobileApp3.db";

    private static final String TABLE_USER = "user";
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";
    private static final String COLUMN_USER_IMAGE = "user_image";

    private static final String TABLE_BOOKMARK = "bookmarks";
    private static final String COLUMN_BOOKMARK_ID = "bookmarks_id";
    private static final String COLUMN_BOOKMARK_IMAGE = "bookmarks_image";
    private static final String COLUMN_BOOKMARK_NAME = "bookmarks_name";
    private static final String COLUMN_BOOKMARK_ADDRESS = "bookmarks_address";
    private static final String COLUMN_BOOKMARK_LONG = "bookmarks_long";
    private static final String COLUMN_BOOKMARK_LAT = "bookmarks_lat";


    private String CREATE_USER_TABLE =
            "CREATE TABLE " + TABLE_USER + " ("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT,"
            + COLUMN_USER_PASSWORD + " TEXT,"
            + COLUMN_USER_IMAGE + " BLOB)";

    private String CREATE_BOOKMARK_TABLE =
            "CREATE TABLE " + TABLE_BOOKMARK + " ("
            + COLUMN_BOOKMARK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_BOOKMARK_NAME + " TEXT,"
            + COLUMN_USER_ID + " INTEGER,"
            + COLUMN_BOOKMARK_IMAGE + " BLOB,"
            + COLUMN_BOOKMARK_ADDRESS + " TEXT,"
            + COLUMN_BOOKMARK_LONG + " TEXT,"
            + COLUMN_BOOKMARK_LAT + " TEXT,"
            + " FOREIGN KEY (" + COLUMN_USER_ID + ") REFERENCES " + TABLE_USER + "(" + COLUMN_USER_ID + "))";


    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    private String DROP_BOOKMARK_TABLE = "DROP TABLE IF EXISTS " + TABLE_BOOKMARK;

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_BOOKMARK_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_USER_TABLE);
        db.execSQL(DROP_BOOKMARK_TABLE);
        onCreate(db);
    }

    public void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());
        values.put(COLUMN_USER_IMAGE, user.getImage());

        db.insert(TABLE_USER, null, values);
        db.close();
    }

    // add user's favorite venue in BOOKMARK table
    public void addVenue(Venue venue){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_ID, venue.getUserID());
        values.put(COLUMN_BOOKMARK_IMAGE, venue.getImage());
        values.put(COLUMN_BOOKMARK_ADDRESS, venue.getAddress());
        values.put(COLUMN_BOOKMARK_NAME, venue.getName());
        values.put(COLUMN_BOOKMARK_LONG, venue.getLatitude());
        values.put(COLUMN_BOOKMARK_LAT, venue.getLatitude());

        db.insert(TABLE_BOOKMARK, null, values);
        db.close();
    }

    public void deleteVenue(String VenueName){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BOOKMARK, COLUMN_BOOKMARK_NAME + " = ?",
                new String[]{VenueName});
    }


    public boolean checkUser(String email){
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_USER_EMAIL + " =?";
        String[] selectionArgs = { email };

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);

        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0){
            return true;
        }
        return false;
    }

    public boolean checkUser(String email, String password){
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_USER_EMAIL + " =?" + " AND " + COLUMN_USER_PASSWORD + " =?";
        String[] selectionArgs = {email, password};

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0){
            return true;
        }
        return false;
    }

    public String getUserName(String email) {
        String[] columns = {
                COLUMN_USER_NAME
        };
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMN_USER_EMAIL + " =?";
        String[] selectionArgs = {email};

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        if (cursor != null){
            cursor.moveToFirst();
        }

        String name = cursor.getString(0);
        Log.i("test", name);
        cursor.close();
        db.close();
        return name;
    }

    // get user id as parameter for getting all favorite venues in BOOKMARK table
    public int getUserID(String email) {
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMN_USER_EMAIL + " =?";
        String[] selectionArgs = {email};

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        if (cursor != null){
            cursor.moveToFirst();
        }

        int id = cursor.getInt(cursor.getColumnIndex(COLUMN_USER_ID));
        cursor.close();
        db.close();
        return id;
    }



    public byte[] getUserImage(String email){
        String[] columns = {
                COLUMN_USER_IMAGE
        };
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMN_USER_EMAIL + " =?";
        String[] selectionArgs = {email};

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        if (cursor != null){
            cursor.moveToFirst();
        }

        byte[] image = cursor.getBlob(cursor.getColumnIndex(COLUMN_USER_IMAGE));
        cursor.close();
        db.close();
        return image;
    }

    // return user's favorites venues
    public List<Venue> getBookMarks(int userID){
        List<Venue> venue_list = new ArrayList<>();
        String[] columns = {
                COLUMN_BOOKMARK_NAME,
                COLUMN_BOOKMARK_ADDRESS,
                COLUMN_BOOKMARK_IMAGE,
                COLUMN_BOOKMARK_LONG,
                COLUMN_BOOKMARK_LAT,
        };
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMN_USER_ID + " =?";
        String[] selectionArgs = {Integer.toString(userID)};

        Cursor cursor = db.query(TABLE_BOOKMARK,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        if(cursor.getCount() > 0) {
            while (cursor.moveToNext()){
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_BOOKMARK_NAME));
                String address = cursor.getString(cursor.getColumnIndex(COLUMN_BOOKMARK_ADDRESS));
                String longitude = cursor.getString(cursor.getColumnIndex(COLUMN_BOOKMARK_LONG));
                String latitude = cursor.getString(cursor.getColumnIndex(COLUMN_BOOKMARK_LAT));
                byte[] image = cursor.getBlob(cursor.getColumnIndex(COLUMN_BOOKMARK_IMAGE));
                Venue venue = new Venue(image, address, name, userID, longitude, latitude);
                venue_list.add(venue);
            }
        }else{
            return null;
        }

        cursor.close();
        db.close();
        return venue_list;
    }


    // return all user's favorite venues' name for check bookmark
    public HashSet<String> getBookMarksName(int userID){
        HashSet<String> venue_name_list = new HashSet<>();
        String[] columns = {
                COLUMN_BOOKMARK_NAME,
        };
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMN_USER_ID + " =?";
        String[] selectionArgs = {Integer.toString(userID)};

        Cursor cursor = db.query(TABLE_BOOKMARK,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        if(cursor.getCount() > 0) {
            while (cursor.moveToNext()){
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_BOOKMARK_NAME));

                venue_name_list.add(name);
            }
        }else{
            return null;
        }

        cursor.close();
        db.close();
        return venue_name_list;
    }



}
