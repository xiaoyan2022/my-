package com.Gcms.daoImpl;

import com.Gcms.dao.BaseDao;
import com.Gcms.dao.UserDao;
import com.Gcms.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : k
 * @Date : 2022/7/2
 * @Desc :
 */
public class UserDaoImpl implements UserDao {
    @Override
    public ResultSet selectAll(Connection connection) throws SQLException {
        ResultSet rs = null;
        String sql = "select " +
                "username as '用户名'," +
                "password as '密码'," +
                "name as '负责人'," +
                "communityName as '小区名' ," +
                "email as '邮箱'," +
                "phone as '手机号'," +
                "status as '状态'," +
                "createTime as '创建时间'  from gui.user";
        rs = BaseDao.execute(connection, BaseDao.pstmt, null, sql);
        return rs;
    }

    @Override
    public ResultSet selectAllWithoutPassword(Connection connection) throws SQLException {
        ResultSet rs = null;
        String sql = "select " +
                "name as '负责人'," +
                "communityName as '小区名' ," +
                "email as '邮箱'," +
                "phone as '手机号'," +
                "createTime as '创建时间'  from gui.user";
        rs = BaseDao.execute(connection, BaseDao.pstmt, null, sql);
        return rs;
    }

    /**
     * 根据ID查询用户
     *
     * @param connection
     * @param
     * @return
     */
    @Override
    public ResultSet selectByUserName(Connection connection, String userName) throws SQLException {
        ResultSet rs = null;
        String sql = "select * from user where username = ?";
        Object[] params = {userName};
        rs = BaseDao.execute(connection, BaseDao.pstmt, null, sql, params);
        return rs;

    }

    /**
     * 登录
     *
     * @param connection
     * @param username
     * @param password
     * @return
     */
    @Override
    public ResultSet selectByNameByPassword(Connection connection, String username, String password) throws SQLException {
        ResultSet rs = null;
        String sql = "select * from user where username=? and password = ?";
        Object[] params = {username, password};//预处理对象的参数，会在BaseDao.execute中被设置
        rs = BaseDao.execute(connection, BaseDao.pstmt, null, sql, params);
        return rs;
    }

    /**
     * 插入新数据
     *
     * @param connection
     * @param user
     * @return
     * @throws SQLException
     */
    @Override
    public int insert(Connection connection, User user) throws SQLException {
        int flag = 0;
        if (connection != null) {
            String sql = "insert into user(username,password,name,communityName,email,phone,status,createTime) " +
                    "values(?,?,?,?,?,?,?,?)";
            Object[] params = {user.getUsername(), user.getPassword(), user.getName(), user.getCommunityName(),
                    user.getEmail(), user.getPhone(), user.getStatus(), user.getCreateTime()};
            flag = BaseDao.execute(connection, BaseDao.pstmt, sql, params);
            //BaseDao.closeResource(connection, BaseDao.pstmt, null);
        }
        return flag;
    }

    @Override
    public int delete(Connection connection, String username) throws SQLException {
        int flag = 0;
        if (connection != null) {
            String sql = "delete from gui.user where username = ?";
            Object[] params = {username};
            flag = BaseDao.execute(connection, BaseDao.pstmt, sql, params);//依次为pstmt设置delete语句的参数
            //BaseDao.closeResource(connection, BaseDao.pstmt, null);
        }
        return flag;
    }

    @Override
    public int update(Connection connection, User user) throws SQLException {
        PreparedStatement pstm = null;
        int flag = 0;

        if (connection != null) {
            String sql = "update gui.user set " +
                    "password=?,name=?, communityName=?," +
                    "email=?,phone=?,status=? ,createTime = ? where username = ? ";
            //获取参数
            Object[] params = {user.getPassword(), user.getName(), user.getCommunityName(),
                    user.getEmail(), user.getPhone(), user.getStatus(), user.getCreateTime(), user.getUsername()};
            flag = BaseDao.execute(connection, pstm, sql, params);
            //BaseDao.closeResource(connection, BaseDao.pstmt, null);
        }
        return flag;
    }
}
