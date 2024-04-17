package com.app.covw.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.app.covw.bean.CourseBean;
import com.app.covw.db.CourseDb;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;


public class CourseDao {

    private CourseDb mCourseDb;
    private static final String TAG = "=======";

    public CourseDao(Context context) {
        mCourseDb = CourseDb.getInstance(context);
    }


    public int insert(String course_number, String course_name, String course_teacher, String course_time) {
        SQLiteDatabase db = mCourseDb.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("course_number", course_number);
        values.put("course_name", course_name);
        values.put("course_teacher", course_teacher);
        values.put("course_time", course_time);
        String nullColumnHack = "values(null,?,?,?,?)";
        //执行
        int insert = (int) db.insert("course_table", nullColumnHack, values);
        db.close();
        return insert;
    }


    public List<CourseBean> queryAll() {
        List<CourseBean> beanList = new ArrayList<>();
        SQLiteDatabase db = mCourseDb.getReadableDatabase();

        String sql = "select _id,course_number,course_name,course_teacher,course_time from course_table order by _id desc";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            int _id = cursor.getInt(cursor.getColumnIndex("_id"));
            String course_number = cursor.getString(cursor.getColumnIndex("course_number"));
            String course_name = cursor.getString(cursor.getColumnIndex("course_name"));
            String course_teacher = cursor.getString(cursor.getColumnIndex("course_teacher"));
            String course_time = cursor.getString(cursor.getColumnIndex("course_time"));
            beanList.add(new CourseBean(_id, course_number, course_name, course_teacher, course_time));
        }
        cursor.close();
        db.close();

        return beanList;
    }

    public int update(String _id, String course_name, String course_teacher, String course_time) {
        // 获取数据
        SQLiteDatabase db = mCourseDb.getWritableDatabase();
        // 填充占位符
        ContentValues values = new ContentValues();
        values.put("course_name", course_name);
        values.put("course_teacher", course_teacher);
        values.put("course_time", course_time);
        // 执行SQL
        int update = db.update("course_table", values, " _id=?", new String[]{_id});
        // 关闭数据库连接
        db.close();
        return update;
    }


    public int delete(String _id) {
        // 获取数据
        SQLiteDatabase db = mCourseDb.getWritableDatabase();
        // 执行SQL
        int delete = db.delete("course_table", " _id=?", new String[]{_id});
        // 关闭数据库连接
        db.close();
        return delete;
    }

}
