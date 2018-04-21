package com.wansmd.king.mutao.db;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBDao {
    private Dao<DBEntity,Integer> dao;
    private DBSQLHelper helper;

    public DBDao(Context context) {
        helper = DBSQLHelper.getHelper(context);
        try {
            dao=helper.getDao(DBEntity.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<DBEntity> querty(String userName, String passWord){
        List<DBEntity> list = new ArrayList<>();
        try {
            list = dao.queryBuilder().where().eq("userName",userName).and().eq("passWord",passWord).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<DBEntity> quertyByUser(String userName){
        List<DBEntity> list = new ArrayList<>();
        try {
            list = dao.queryForEq("userName",userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insert(DBEntity entity){
        try {
            dao.create(entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
