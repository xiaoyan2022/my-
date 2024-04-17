package com.Gcms.dao;

import com.Gcms.pojo.Repair;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : k
 * @Date : 2022/7/2
 * @Desc : 报修管理
 */
public interface RepairDao {

    //查询所有的报修管理
    ResultSet selectAll(Connection connection) throws SQLException;


    //添加报修管理
    int add(Connection connection, Repair repairManagement) throws SQLException;

    //根据id删除报修管理
    int delete(Connection connection,Integer id) throws SQLException;

    //根据id修改报修管理（主要用于修改物业完成状态和用户确认状态）
    int update(Connection connection, Repair repairManagement) throws SQLException;




}
