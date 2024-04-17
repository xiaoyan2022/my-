package com.app.covw.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;


public class CourseDb extends SQLiteOpenHelper {
    private static final String TAG = "===========";
    public static CourseDb sMCourseDb;

    private static final String DB_NAME = "course_info.db";
    private static final int VERSION = 1;

    public CourseDb(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public synchronized static CourseDb getInstance(Context context) {
        if (null == sMCourseDb) {
            sMCourseDb = new CourseDb(context, DB_NAME, null, VERSION);
        }
        return sMCourseDb;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table course_table (_id integer primary key autoincrement, " +
                "course_number text," +     //课程编号
                "course_name text," +     //课程名称
                "course_teacher text," +      //任课老师
                "course_time text)" +    //登记时间
                "");


        Log.d(TAG, "onCreate: j建表成功");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
