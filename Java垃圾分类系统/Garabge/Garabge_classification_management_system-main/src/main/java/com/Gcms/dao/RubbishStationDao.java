package com.Gcms.dao;

import com.Gcms.pojo.RubbishStation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : k
 * @Date : 2022/7/2
 * @Desc : 垃圾站信息管理
 */
public interface RubbishStationDao {

    //查询所有的垃圾分类信息
    ResultSet selectAll(Connection connection) throws SQLException;



    //添加垃圾分类信息
    int add(Connection connection, RubbishStation rubbishStation) throws SQLException;

    //根据id删除垃圾分类信息
    int delete(Connection connection, Integer id) throws SQLException;

    //根据id修改垃圾分类信息
    int update(Connection connection, RubbishStation rubbishStation) throws SQLException;

}
