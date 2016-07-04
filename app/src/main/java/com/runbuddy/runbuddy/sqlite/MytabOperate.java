package com.runbuddy.runbuddy.sqlite;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Administrator on 2016/6/4.
 */
public class MytabOperate {
    private static final String tablename = "mylogin";
    private SQLiteDatabase db = null;

    public MytabOperate(SQLiteDatabase db) {
        this.db = db;
    }

    public void insert(String phonenum, String password) {
        String sql = "INSERT INTO " + tablename
                + "(phonenum,password) VALUES (?,?)";
        Object args[] = new Object[] { phonenum, password };
        this.db.execSQL(sql, args);
        this.db.close();
    }

    public void updata(String phonenum, String password) {
        String sql = "UPDATE " + tablename + " SET password=? WHERE phonenum=?";
        Object args[] = new Object[] { phonenum, password };
        this.db.execSQL(sql, args);
        this.db.close();
    }

    public void delete(int id) {
        String sql = "DELETE FROM " + tablename + " WHERE id=?";
        Object args[] = new Object[] { id };
        this.db.execSQL(sql, args);
        this.db.close();
    }

}
