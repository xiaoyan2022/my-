package com.app.covw.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.app.covw.bean.StudentBean;
import com.app.covw.db.StudentDb;

import java.util.ArrayList;
import java.util.List;


public class StudioDao {

    private StudentDb mStudentDb;
    private static final String TAG = "=======";

    public StudioDao(Context context) {
        mStudentDb = StudentDb.getInstance(context);
    }

    public int insert(String student_number, String student_name, String class_number, String student_state, String student_time) {
        SQLiteDatabase db = mStudentDb.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("student_number", student_number);
        values.put("student_name", student_name);
        values.put("class_number", class_number);
        values.put("student_state", student_state);
        values.put("student_time", student_time);
        String nullColumnHack = "values(null,?,?,?,?,?)";
        //执行
        int insert = (int) db.insert("student_table", nullColumnHack, values);
        db.close();
        return insert;
    }


    public List<StudentBean> queryAll() {
        List<StudentBean> beanList = new ArrayList<>();
        SQLiteDatabase db = mStudentDb.getReadableDatabase();

        String sql = "select _id,student_number,student_name,class_number,student_state,student_time from student_table order by _id desc";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            int _id = cursor.getInt(cursor.getColumnIndex("_id"));
            String student_number = cursor.getString(cursor.getColumnIndex("student_number"));
            String student_name = cursor.getString(cursor.getColumnIndex("student_name"));
            String class_number = cursor.getString(cursor.getColumnIndex("class_number"));
            String student_state = cursor.getString(cursor.getColumnIndex("student_state"));
            String student_time = cursor.getString(cursor.getColumnIndex("student_time"));
            beanList.add(new StudentBean(_id, student_number, student_name, class_number, student_state, student_time));
        }
        cursor.close();
        db.close();
        return beanList;
    }

    /**
     * 查询全部
     * stuname   查询名字相同的所有数据
     */

    public StudentBean query(String student_number) {
        StudentBean mStudentBean = null;
        //获取数据
        SQLiteDatabase db = mStudentDb.getReadableDatabase();
        String sql = "select _id,student_number,student_name,class_number, student_state, student_time from student_table where student_number=?";
        String[] selectionArgs = {student_number};
        //执行SQL
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()) {

            int _id = cursor.getInt(cursor.getColumnIndex("_id"));
            String student_num = cursor.getString(cursor.getColumnIndex("student_number"));
            String student_name = cursor.getString(cursor.getColumnIndex("student_name"));
            String class_number = cursor.getString(cursor.getColumnIndex("class_number"));
            String student_state = cursor.getString(cursor.getColumnIndex("student_state"));
            String student_time = cursor.getString(cursor.getColumnIndex("student_time"));
            mStudentBean = new StudentBean(_id, student_num, student_name, class_number, student_state, student_time);
        }

        cursor.close();
        //关闭数据库连接
        db.close();

        return mStudentBean;

    }

    public int delate(String name) {

        SQLiteDatabase db = mStudentDb.getReadableDatabase();
        // 执行SQL
        int delete = db.delete("student_table", " student_name=?", new String[]{name});
        return delete;
    }

    public int update(String _id, String class_number, String student_state, String student_time) {
        SQLiteDatabase db = mStudentDb.getWritableDatabase();
        // 填充占位符
        ContentValues values = new ContentValues();
        values.put("class_number", class_number);
        values.put("student_state", student_state);
        values.put("student_time", student_time);
        // 执行SQL
        int update = db.update("student_table", values, " _id=?", new String[]{_id});
        // 关闭数据库连接
        db.close();
        return update;
    }


}
