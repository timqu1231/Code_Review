package com.example.lab11;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

public class StudentProvider extends ContentProvider {
    public static final String AUTHORITY = "com.example.lab11";
    public static final String PATH_STUDENT_LIST = "STUDENT_LIST";
    public static final int STUDENT_LIST = 1;
    private static final UriMatcher MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
    static{
        MATCHER.addURI(AUTHORITY,PATH_STUDENT_LIST,STUDENT_LIST);
    }

    private StudentListDBAdapter studentListDBAdapter;

    @Override
    public boolean onCreate(){
        studentListDBAdapter = StudentListDBAdapter.getStudentListDBAdapterInstance(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder){
        Cursor cursor = null;
        switch (MATCHER.match(uri)){
            case STUDENT_LIST: cursor=studentListDBAdapter.getCursorsForAllStudents();
            break;
        }
        return cursor;
    }

    @Override
    public String getType(Uri uri){
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values){
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs){
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs){
        return 0;
    }
}