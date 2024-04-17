package com.Gcms.dao;

import com.Gcms.pojo.EquipmentList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : k
 * @Date : 2022/7/3
 * @Desc : 设备列表
 */
public interface EquipmentListDao {
    //查询所有的设备列表
    ResultSet selectAll(Connection connection) throws SQLException;


    //添加设备列表
    int add(Connection connection, EquipmentList equipmentList) throws SQLException;

    //根据id删除设备列表
    int delete(Connection connection,Integer id) throws SQLException;

    //根据id修改设备列表
    int update(Connection connection,EquipmentList equipmentList) throws SQLException;
}
