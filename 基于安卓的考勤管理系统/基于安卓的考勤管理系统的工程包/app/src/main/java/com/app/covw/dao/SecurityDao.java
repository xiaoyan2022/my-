package com.app.covw.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.app.covw.bean.SecurityBean;
import com.app.covw.db.SecurityDb;

import java.util.ArrayList;
import java.util.List;


public class SecurityDao {

    private SecurityDb mSecurityDb;
    private static final String TAG = "=======";

    public SecurityDao(Context context) {
        mSecurityDb = mSecurityDb.getInstance(context);
    }


    public int insert(int security_number, String security_name, int security_pension, int security_medical, int security_inductrial, int security_unemployment, int security_birth) {
        SQLiteDatabase db = mSecurityDb.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("security_number", security_number);
        values.put("security_name", security_name);
        values.put("security_pension", security_pension);
        values.put("security_medical", security_medical);
        values.put("security_inductrial", security_inductrial);
        values.put("security_unemployment", security_unemployment);
        values.put("security_birth", security_birth);
        String nullColumnHack = "values(null,?,?,?,?,?,?,?)";
        //执行
        int insert = (int) db.insert("security_table", nullColumnHack, values);
        db.close();
        return insert;
    }


    public List<SecurityBean> queryAll() {
        List<SecurityBean> beanList = new ArrayList<>();
        SQLiteDatabase db = mSecurityDb.getReadableDatabase();

        String sql = "select security_number,security_name,security_pension,security_medical,security_inductrial,security_unemployment,security_birth from security_table";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("security_number"));
            String name = cursor.getString(cursor.getColumnIndex("security_name"));
            int pension = cursor.getInt(cursor.getColumnIndex("security_pension"));
            int medical = cursor.getInt(cursor.getColumnIndex("security_medical"));
            int inductrial = cursor.getInt(cursor.getColumnIndex("security_inductrial"));
            int unemployment = cursor.getInt(cursor.getColumnIndex("security_unemployment"));
            int birth = cursor.getInt(cursor.getColumnIndex("security_birth"));
            beanList.add(new SecurityBean(id, name, pension, medical, inductrial, unemployment, birth));
        }
        cursor.close();
        db.close();
        return beanList;
    }

    public int update(String security_number, String security_pension, String security_medical, String security_inductrial, String security_unemployment, String security_birth) {
        // 获取数据
        SQLiteDatabase db = mSecurityDb.getWritableDatabase();
        String sql = "update security_table set security_pension=?,security_medical=?,security_inductrial=?,security_unemployment=?,security_birth=? where name=?";
        // 填充占位符
        ContentValues values = new ContentValues();
        values.put("security_pension", security_pension);
        values.put("security_medical", security_medical);
        values.put("security_inductrial", security_inductrial);
        values.put("security_unemployment", security_unemployment);
        values.put("security_birth", security_birth);
        // 执行SQL
        int update = db.update("security_table", values, " security_number=?", new String[]{security_number});
        // 关闭数据库连接
        db.close();
        return update;

    }



    public int delete(String security_number) {
        // 获取数据
        SQLiteDatabase db = mSecurityDb.getWritableDatabase();
        // 执行SQL
        int delete = db.delete("security_table", " security_number=?", new String[]{security_number});
        // 关闭数据库连接
        db.close();
        return delete;
    }

}
