package com.example.lab11;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StudentListDBAdapter {
    private static  final String TAG = "test";

    public static final String DB_NAME = "studentlist.db";
    public static final int DB_VERSION = 4;
    public static final String TABLE_STUDENT = "student";
    public static final String COLUMN_STUDENT_ID = "student_id";
    public static final String COLUMN_STUDENT_NAME = "student_name";
    public static final String COLUMN_STUDENT_GRADE = "student_grade";

    public static String CREATE_STUDENT_TABLE = "CREATE TABLE " + TABLE_STUDENT + "(" + COLUMN_STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_STUDENT_NAME + " TEXT NOT NULL," + COLUMN_STUDENT_GRADE + " TEXT);";

    public static String DROP_STUDENT_TABLE = "DROP TABLE IF EXISTS " + TABLE_STUDENT;

    private Context context;
    private SQLiteDatabase sqLiteDatabase;
    private static StudentListDBAdapter studentListDBAdapterInstance;
    private static StudentListDBHelper studentListDBHelper;

    private StudentListDBAdapter(Context context){
        this.context = context;
        studentListDBHelper = new StudentListDBHelper(this.context, DB_NAME, null, DB_VERSION);
    }

    public static StudentListDBAdapter getStudentListDBAdapterInstance(Context context){
        if(studentListDBAdapterInstance == null){
            studentListDBAdapterInstance = new StudentListDBAdapter(context);
        }
        return studentListDBAdapterInstance;
    }

    public Cursor getCursorsForAllStudents(){
        Cursor cursor = studentListDBHelper.getReadableDatabase().query(TABLE_STUDENT, new String[]{COLUMN_STUDENT_ID, COLUMN_STUDENT_NAME, COLUMN_STUDENT_GRADE}, null, null,
                null, null, null);
        return cursor;
    }

    public List<Student> getAllStudents(){
        List<Student> studentList = new ArrayList<>();
        Cursor cursor = getCursorsForAllStudents();
        if(cursor != null && cursor.getCount() > 0){
            while (cursor.moveToNext()){
                Student student = new Student(cursor.getString(1), cursor.getString(2));
                studentList.add(student);
            }
        }
        cursor.close();
        return studentList;
    }

    public boolean insert(String name, String grade){
        SQLiteDatabase db = studentListDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_STUDENT_NAME, name);
        contentValues.put(COLUMN_STUDENT_GRADE, grade);
        return db.insert(TABLE_STUDENT, null, contentValues)>0;
    }

    private static class StudentListDBHelper extends SQLiteOpenHelper{
        public StudentListDBHelper(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int dbVersion) {
            super(context,databaseName, factory, dbVersion);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            db.execSQL(CREATE_STUDENT_TABLE);
            Log.i(TAG, "create student table");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            db.execSQL(DROP_STUDENT_TABLE);
            onCreate(db);
        }
    }
}
