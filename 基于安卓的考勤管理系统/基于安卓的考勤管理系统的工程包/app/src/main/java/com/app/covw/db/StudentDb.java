package com.app.covw.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;


public class StudentDb extends SQLiteOpenHelper {
    private static final String TAG = "===========";
    public static StudentDb sStudentDb;

    private static final String DB_NAME = "student_info.db";
    private static final int VERSION = 1;

    public StudentDb(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public synchronized static StudentDb getInstance(Context context) {
        if (null == sStudentDb) {
            sStudentDb = new StudentDb(context, DB_NAME, null, VERSION);
        }
        return sStudentDb;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table student_table (_id integer primary key autoincrement, " +
                "student_number text," +     //工号
                "student_name text," +     //姓名
                "class_number text," +     //班级编号
                "student_state text," +     //状态
                "student_time text)" +    //登记时间
                "");


        Log.d(TAG, "onCreate: 建表成功");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
