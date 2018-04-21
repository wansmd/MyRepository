package com.wansmd.king.mutao.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DBSQLHelper extends OrmLiteSqliteOpenHelper{

    private static DBSQLHelper helper = null;

    private DBSQLHelper(Context context) {
        super(context, "userName.db", null, 1);
    }
    public static synchronized DBSQLHelper getHelper(Context context){
        if (helper == null){
            helper = new DBSQLHelper(context);
        }
        return helper;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource,DBEntity.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource,DBEntity.class,true);
            onCreate(database,connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
