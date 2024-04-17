package com.app.covw.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;


public class SecurityDb extends SQLiteOpenHelper {
    private static final String TAG = "===========";
    public static SecurityDb sSecurityDb;

    private static final String DB_NAME = "security_info.db";
    private static final int VERSION = 1;

    public SecurityDb(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public synchronized static SecurityDb getInstance(Context context) {
        if (null == sSecurityDb) {
            sSecurityDb = new SecurityDb(context, DB_NAME, null, VERSION);
        }
        return sSecurityDb;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table security_table (_id integer primary key autoincrement, " +
                "security_number integer," +     //工号
                "security_name text," +     //姓名
                "security_pension integer," +     //养老金
                "security_medical integer," +     //医疗保险
                "security_inductrial integer," +     //工伤保险
                "security_unemployment integer," +     //失业保险
                "security_birth integer)" +    //生育保险
                "");


        Log.d(TAG, "onCreate: 建表成功");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
