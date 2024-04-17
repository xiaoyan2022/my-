package com.app.covw.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.app.covw.bean.LeaveManagerBean;
import com.app.covw.db.LeaveManagerDb;

import java.util.ArrayList;
import java.util.List;


public class LeaveManagerDao {

    private LeaveManagerDb mLeaveManagerDb;
    private static final String TAG = "=======";


    public LeaveManagerDao(Context context) {
        mLeaveManagerDb = LeaveManagerDb.getInstance(context);
    }


    public int insert(String leave_number, String student_name, String leave_start_time, String leave_end_time, String leave_why, String student_state) {
        SQLiteDatabase db = mLeaveManagerDb.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("leave_number", leave_number);
        values.put("student_name", student_name);
        values.put("leave_start_time", leave_start_time);
        values.put("leave_end_time", leave_end_time);
        values.put("leave_why", leave_why);
        values.put("student_state", student_state);
        String nullColumnHack = "values(null,?,?,?,?,?,?)";
        //执行
        int insert = (int) db.insert("leave_table", nullColumnHack, values);
        db.close();
        return insert;
    }


    public List<LeaveManagerBean> queryAll() {
        List<LeaveManagerBean> beanList = new ArrayList<>();

        SQLiteDatabase db = mLeaveManagerDb.getReadableDatabase();

        String sql = "select _id,leave_number,student_name,leave_start_time,leave_end_time,leave_why,student_state from leave_table order by _id desc";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            int _id = cursor.getInt(cursor.getColumnIndex("_id"));
            String leave_number = cursor.getString(cursor.getColumnIndex("leave_number"));
            String student_name = cursor.getString(cursor.getColumnIndex("student_name"));
            String leave_start_time = cursor.getString(cursor.getColumnIndex("leave_start_time"));
            String leave_end_time = cursor.getString(cursor.getColumnIndex("leave_end_time"));
            String leave_why = cursor.getString(cursor.getColumnIndex("leave_why"));
            String student_state = cursor.getString(cursor.getColumnIndex("student_state"));
            beanList.add(new LeaveManagerBean(_id, leave_number, student_name, leave_start_time, leave_end_time, leave_why, student_state));
        }
        cursor.close();
        db.close();

        return beanList;
    }

    public int update(String _id, String leave_number, String student_name, String leave_start_time, String leave_end_time, String leave_why, String student_state) {
        // 获取数据
        SQLiteDatabase db = mLeaveManagerDb.getWritableDatabase();
        // 填充占位符
        ContentValues values = new ContentValues();
        values.put("leave_number", leave_number);
        values.put("student_name", student_name);
        values.put("leave_start_time", leave_start_time);
        values.put("leave_end_time", leave_end_time);
        values.put("leave_why", leave_why);
        values.put("student_state", student_state);
        // 执行SQL
        int update = db.update("leave_table", values, " _id=?", new String[]{_id});
        // 关闭数据库连接
        db.close();
        return update;
    }

    public int update(String _id, String student_state) {
        // 获取数据
        SQLiteDatabase db = mLeaveManagerDb.getWritableDatabase();
        // 填充占位符
        ContentValues values = new ContentValues();
        values.put("student_state", student_state);
        // 执行SQL
        int update = db.update("leave_table", values, " _id=?", new String[]{_id});
        // 关闭数据库连接
        db.close();
        return update;

    }


    public int delete(String _id) {
        // 获取数据
        SQLiteDatabase db = mLeaveManagerDb.getWritableDatabase();
        // 执行SQL
        int delete = db.delete("leave_table", " _id=?", new String[]{_id});
        // 关闭数据库连接
        db.close();
        return delete;
    }
}
