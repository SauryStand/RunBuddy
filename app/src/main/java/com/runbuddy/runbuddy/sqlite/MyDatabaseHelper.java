package com.runbuddy.runbuddy.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    // 数据库名
    private static final String databaseHelper = "FirstGroup.db";
    // 版本号
    private static final int version = 1;
    // 表名
    private static final String tablename = "mylogin";

    public MyDatabaseHelper(Context context) {
        super(context, databaseHelper, null, version);
    }

    // 创建数据表
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE  " + tablename + " ( "
                + "id           INTEGER         PRIMARY KEY ,"
                + "phonenum     VERCHAR(50)      NOT  NULL  ,"
                + "password     VERCHAR(50)      NOT  NULL   " + ")";
        db.execSQL(sql);
    }

    // 用于数据库的版本更新
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + tablename;
        db.execSQL(sql);
        this.onCreate(db);
    }

}

