package com.app.covw.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.app.covw.bean.UserInfo;
import com.app.covw.db.UserDb;

public class UserDao {

    private UserDb mUserDb;


    public UserDao(Context context) {
        mUserDb = UserDb.getInstance(context);
    }

    public int insert(String name, String password, String nikename, String signature, String credit, String home, String hometown, String professional, String status, String school, String school_scl) {
        SQLiteDatabase db = mUserDb.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("password", password);
        values.put("nikename", nikename);
        values.put("signature", signature);
        values.put("credit", credit);
        values.put("home", home);
        values.put("hometown", hometown);
        values.put("professional", professional);
        values.put("status", status);
        values.put("school", school);
        values.put("school_scl", school_scl);
        String nullColumnHack = "values(null,?,?,?,?,?,?,?,?,?,?,?)";
        //执行
        int insert = (int) db.insert("user_table", nullColumnHack, values);
        db.close();
        return insert;
    }


    public UserInfo queryAll(String username) {
        SQLiteDatabase db = mUserDb.getReadableDatabase();
        UserInfo userInfo = null;
        String sql = "select _id,name,password,nikename,signature,credit,home,hometown,professional,status,school ,school_scl from user_table where name=?";
        String[] selectionArgs = {username};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()) {
            int _id = cursor.getInt(cursor.getColumnIndex("_id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            String nikename = cursor.getString(cursor.getColumnIndex("nikename"));
            String signature = cursor.getString(cursor.getColumnIndex("signature"));
            String credit = cursor.getString(cursor.getColumnIndex("credit"));
            String home = cursor.getString(cursor.getColumnIndex("home"));
            String hometown = cursor.getString(cursor.getColumnIndex("hometown"));
            String professional = cursor.getString(cursor.getColumnIndex("professional"));
            String status = cursor.getString(cursor.getColumnIndex("status"));
            String school = cursor.getString(cursor.getColumnIndex("school"));
            String school_scl = cursor.getString(cursor.getColumnIndex("school_scl"));
            userInfo = new UserInfo(_id, name, password, nikename, signature, credit, home, hometown, professional, status, school, school_scl);
        }
        cursor.close();
        db.close();
        return userInfo;
    }

    public int update(String username, String home, String hometown, String professional, String status, String school, String school_scl, String signature) {
        SQLiteDatabase db = mUserDb.getReadableDatabase();

        String sql = "update user_table set home=?,hometown=?,professional=?,status=?,school=?,school_scl=?,signature=? where name=?";
// 填充占位符
        ContentValues values = new ContentValues();
        values.put("home", home);
        values.put("hometown", hometown);
        values.put("professional", professional);
        values.put("status", status);
        values.put("school", school);
        values.put("school_scl", school_scl);
        values.put("signature", signature);
        // 执行SQL
        int update = db.update("user_table", values, " name=?", new String[]{username});
        // 关闭数据库连接
        db.close();
        return update;
    }
}
