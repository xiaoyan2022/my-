package com.app.covw.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.app.covw.bean.ClassManagerBean;
import com.app.covw.db.ClassManagerDb;

import java.util.ArrayList;
import java.util.List;
public class ClassManagerDao {
    private ClassManagerDb mClassManagerDb;
    private static final String TAG = "=======";

    public ClassManagerDao(Context context) {
        mClassManagerDb = ClassManagerDb.getInstance(context);
    }


    public int insert(String class_number, String class_name, String class_techer_number, String class_time) {

        SQLiteDatabase db = mClassManagerDb.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("class_number", class_number);
        values.put("class_name", class_name);
        values.put("class_techer_number", class_techer_number);
        values.put("class_time", class_time);
        String nullColumnHack = "values(null,?,?,?,?)";
        //执行
        int insert = (int) db.insert("class_table", nullColumnHack, values);
        db.close();
        return insert;
    }


    public List<ClassManagerBean> queryAll() {
        List<ClassManagerBean> beanList = new ArrayList<>();

        SQLiteDatabase db = mClassManagerDb.getReadableDatabase();

        String sql = "select _id,class_number,class_name,class_techer_number,class_time from class_table order by _id  desc";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            int _id = cursor.getInt(cursor.getColumnIndex("_id"));
            String class_number = cursor.getString(cursor.getColumnIndex("class_number"));
            String class_name = cursor.getString(cursor.getColumnIndex("class_name"));
            String class_techer_number = cursor.getString(cursor.getColumnIndex("class_techer_number"));
            String class_time = cursor.getString(cursor.getColumnIndex("class_time"));
            beanList.add(new ClassManagerBean(_id, class_number, class_name, class_techer_number, class_time));
        }
        cursor.close();
        db.close();
        return beanList;
    }


    public int update(String _id, String class_number, String class_name, String class_techer_number, String class_time) {
        // 获取数据
        SQLiteDatabase db = mClassManagerDb.getWritableDatabase();
        // 填充占位符
        ContentValues values = new ContentValues();
        values.put("class_number", class_number);
        values.put("class_name", class_name);
        values.put("class_techer_number", class_techer_number);
        values.put("class_time", class_time);
        // 执行SQL
        int update = db.update("class_table", values, " _id=?", new String[]{_id});
        // 关闭数据库连接
        db.close();
        return update;

    }

    public int delete(String _id) {
        // 获取数据
        SQLiteDatabase db = mClassManagerDb.getWritableDatabase();
        // 执行SQL
        int delete = db.delete("class_table", " _id=?", new String[]{_id});
        // 关闭数据库连接
        db.close();
        return delete;
    }

}
