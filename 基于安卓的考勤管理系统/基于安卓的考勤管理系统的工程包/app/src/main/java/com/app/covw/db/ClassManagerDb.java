package com.app.covw.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;


public class ClassManagerDb extends SQLiteOpenHelper {
    private static final String TAG = "===========";
    public static ClassManagerDb sMClassManagerDb;

    private static final String DB_NAME = "class_info.db";
    private static final int VERSION = 1;

    public ClassManagerDb(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public synchronized static ClassManagerDb getInstance(Context context) {
        if (null == sMClassManagerDb) {
            sMClassManagerDb = new ClassManagerDb(context, DB_NAME, null, VERSION);
        }
        return sMClassManagerDb;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table class_table (_id integer primary key autoincrement, " +
                "class_number text," +     //班级编号
                "class_name text," +      //编辑名称
                "class_techer_number text," +     //教师编号
                "class_time text)" +  // 登记时间
                "");


        Log.d(TAG, "onCreate: j建表成功");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
