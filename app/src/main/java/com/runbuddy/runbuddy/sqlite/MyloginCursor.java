package com.runbuddy.runbuddy.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/4.
 */
public class MyloginCursor {
    private static final String TABLENAME = "mylogin";
    private SQLiteDatabase db = null;

    public MyloginCursor(SQLiteDatabase db) {
        this.db = db;
    }

    /**
     * 数据查找
     *
     * @param keyword 查找的关键字
     * @return
     */
    public List<String> find(String keyword) {
        List<String> all = new ArrayList<String>();
        String sql = "SELECT id,phonenum,password FROM " + TABLENAME
                + " WHERE (phonenum LIKE ? OR password LIKE ?) ";
        String args[] = new String[]{"%" + keyword + "%",
                "%" + keyword + "%",};
        Cursor result = this.db.rawQuery(sql, args);
        for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext()) {
            all.add("【" + result.getInt(0) + "】" + "," + result.getString(1)
                    + "," + result.getString(2) + ","); // 设置集合数据
        }
        this.db.close(); // 关闭数据库连接
        return all;

    }

}
