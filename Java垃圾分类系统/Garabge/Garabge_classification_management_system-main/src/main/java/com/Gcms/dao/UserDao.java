package com.Gcms.dao;

import com.Gcms.pojo.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : k
 * @Date : 2022/7/2
 * @Desc : 用户管理
 */
public interface UserDao {

    //查询所有的用户管理信息
    public ResultSet selectAll(Connection connection) throws SQLException;

    public ResultSet selectAllWithoutPassword(Connection connection) throws SQLException;

    public ResultSet selectByUserName(Connection connection, String userName) throws SQLException;

    public ResultSet selectByNameByPassword(Connection connection, String username, String password) throws SQLException;

    public int insert(Connection connection, User user) throws SQLException;

    public int delete(Connection connection, String username) throws SQLException;

    public int update(Connection connection, User user) throws SQLException;

}
