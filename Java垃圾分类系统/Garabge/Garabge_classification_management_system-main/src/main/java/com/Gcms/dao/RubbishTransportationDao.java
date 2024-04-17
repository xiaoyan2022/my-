package com.Gcms.dao;

import com.Gcms.pojo.RubbishTransportation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : k
 * @Date : 2022/7/2
 * @Desc : 垃圾运输信息管理
 */
public interface RubbishTransportationDao {
    //查询所有的垃圾运输信息管理
    ResultSet selectAll(Connection connection) throws SQLException;


    //添加垃圾运输信息管理
    int add(Connection connection, RubbishTransportation rubbishTransportation) throws SQLException;

    //根据id删除垃圾运输信息管理
    int delete(Connection connection,Integer id) throws SQLException;

    //根据id修改垃圾运输信息管理
    int update(Connection connection,RubbishTransportation rubbishTransportation) throws SQLException;
}
