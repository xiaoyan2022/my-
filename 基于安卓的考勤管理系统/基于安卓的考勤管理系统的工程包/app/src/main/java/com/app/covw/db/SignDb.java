package com.app.covw.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;


public class SignDb extends SQLiteOpenHelper {
    private static final String TAG = "===========";
    public static SignDb sSignDb;

    private static final String DB_NAME = "sign_info.db";
    private static final int VERSION = 1;

    public SignDb(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public synchronized static SignDb getInstance(Context context) {
        if (null == sSignDb) {
            sSignDb = new SignDb(context, DB_NAME, null, VERSION);
        }
        return sSignDb;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table sign_table (_id integer primary key autoincrement, " +
                "class_number text," +     //班级编号
                "student_number text," +     //学生编号
                "student_name text," +     //学生编号
                "sign_try text," +     //考勤方式
                "sign_state text," +     //状态
                "sign_time text," +     //登记时间
                "course_number text)" +
                "");


        Log.d(TAG, "onCreate: 建表成功");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
