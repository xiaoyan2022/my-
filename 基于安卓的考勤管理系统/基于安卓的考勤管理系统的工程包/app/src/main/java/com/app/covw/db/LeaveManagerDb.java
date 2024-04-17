package com.app.covw.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;


public class LeaveManagerDb extends SQLiteOpenHelper {
    private static final String TAG = "===========";
    public static LeaveManagerDb sLeaveManagerDb;

    private static final String DB_NAME = "leave_info.db";
    private static final int VERSION = 1;

    public LeaveManagerDb(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public synchronized static LeaveManagerDb getInstance(Context context) {
        if (null == sLeaveManagerDb) {
            sLeaveManagerDb = new LeaveManagerDb(context, DB_NAME, null, VERSION);
        }
        return sLeaveManagerDb;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table leave_table (_id integer primary key autoincrement, " +
                "leave_number text," +     //班级编号
                "student_name text," +     //学生编号
                "leave_start_time text," +   //开始时间
                "leave_end_time text," +     //结束时间
                "leave_why text," +     //请假原因
                "student_state text)" +  //状态
                "");


        Log.d(TAG, "onCreate: 建表成功");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
