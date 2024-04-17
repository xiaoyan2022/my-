package com.Gcms.dao;

import com.Gcms.pojo.Complaint;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : k
 * @Date : 2022/7/2
 * @Desc : 投诉管理
 */
public interface ComplaintDao {
    //查询所有的投诉管理
    ResultSet selectAll(Connection connection) throws SQLException;


    //添加投诉管理
    int add(Connection connection, Complaint complaintManagement) throws SQLException;

    //根据id删除投诉管理
    int delete(Connection connection, Integer id) throws SQLException;

    //根据id修改投诉管理（主要用于修改物业完成状态和用户确认状态）
    int update(Connection connection, Complaint complaintManagement) throws SQLException;
}
