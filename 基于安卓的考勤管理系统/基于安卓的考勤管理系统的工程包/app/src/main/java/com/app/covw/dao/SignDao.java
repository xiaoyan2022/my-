package com.app.covw.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.app.covw.bean.SignBean;
import com.app.covw.db.SignDb;

import java.util.ArrayList;
import java.util.List;


public class SignDao {

    private SignDb mSignDb;
    private static final String TAG = "=======";

    public SignDao(Context context) {
        mSignDb = mSignDb.getInstance(context);
    }


    public int insert(String class_number, String student_number, String student_name, String sign_try, String sign_state, String sign_time,String course_number) {
        SQLiteDatabase db = mSignDb.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("class_number", class_number);
        values.put("student_number", student_number);
        values.put("student_name", student_name);
        values.put("sign_try", sign_try);
        values.put("sign_state", sign_state);
        values.put("sign_time", sign_time);
        values.put("course_number", course_number);
        String nullColumnHack = "values(null,?,?,?,?,?,?,?)";
        //执行
        int insert = (int) db.insert("sign_table", nullColumnHack, values);
        db.close();
        return insert;
    }


    public List<SignBean> queryAll() {
        List<SignBean> beanList = new ArrayList<>();
        SQLiteDatabase db = mSignDb.getReadableDatabase();

        String sql = "select _id, class_number,student_number,student_name,sign_try,sign_state,sign_time,course_number from sign_table order by _id desc";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            int _id = cursor.getInt(cursor.getColumnIndex("_id"));
            String class_number = cursor.getString(cursor.getColumnIndex("class_number"));
            String student_number = cursor.getString(cursor.getColumnIndex("student_number"));
            String student_name = cursor.getString(cursor.getColumnIndex("student_name"));
            String sign_try = cursor.getString(cursor.getColumnIndex("sign_try"));
            String sign_state = cursor.getString(cursor.getColumnIndex("sign_state"));
            String sign_time = cursor.getString(cursor.getColumnIndex("sign_time"));
            String course_number = cursor.getString(cursor.getColumnIndex("course_number"));
            beanList.add(new SignBean(_id, class_number, student_number, student_name, sign_try, sign_state, sign_time,course_number));
        }
        cursor.close();
        db.close();
        return beanList;
    }

    public int update(String _id, String sign_state, String sign_time) {
        // 获取数据
        SQLiteDatabase db = mSignDb.getWritableDatabase();
        // 填充占位符
        ContentValues values = new ContentValues();
        values.put("sign_state", sign_state);
        values.put("sign_time", sign_time);
        // 执行SQL
        int update = db.update("sign_table", values, " _id=?", new String[]{_id});
        // 关闭数据库连接
        db.close();
        return update;
    }

    public int update(String _id, String sign_state) {
        // 获取数据
        SQLiteDatabase db = mSignDb.getWritableDatabase();
        // 填充占位符
        ContentValues values = new ContentValues();
        values.put("sign_state", sign_state);
        // 执行SQL
        int update = db.update("sign_table", values, " _id=?", new String[]{_id});
        // 关闭数据库连接
        db.close();
        return update;
    }






    public int delete(String _id) {
        // 获取数据
        SQLiteDatabase db = mSignDb.getWritableDatabase();
        // 执行SQL
        int delete = db.delete("sign_table", " _id=?", new String[]{_id});
        // 关闭数据库连接
        db.close();
        return delete;

    }

}
