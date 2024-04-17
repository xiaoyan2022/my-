package com.Gcms.dao;


import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

//操作数据库的公共类
public class BaseDao {

    private static final String driver;
    private static final String url;
    private static final String username;
    private static final String password;

    //每次打开资源都dao层使用这些静态成员进行引用，等在service层将ResultSet使用完后再使用这些静态成员关闭
    public static Connection conn;
    public static PreparedStatement pstmt;
    public static ResultSet rs;


    //静态代码块 类加载的时候就初始化
    static {
        ////通过类加载器读取对应的资源
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }

    //获取数据库的连接
    public static void openConnection() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //编写查询公共类
    public static ResultSet execute(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet, String sql) throws SQLException {
        //预编译的sql 在后面直接执行即可
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }


    //编写查询公共类
    public static ResultSet execute(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet, String sql, Object[] params) throws SQLException {
        //预编译的sql 在后面直接执行即可
        preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            //占位符从1开始，数组从0开始
            preparedStatement.setObject(i + 1, params[i]);
        }
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }


    //编写增删改公共方法
    public static int execute(Connection connection, PreparedStatement preparedStatement, String sql, Object[] params) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            //占位符从1开始，数组从0开始
            preparedStatement.setObject(i + 1, params[i]);
        }
        return preparedStatement.executeUpdate();
    }

    //关闭连接 释放资源
    public static boolean closeResource(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        boolean flag = true;
        if (resultSet != null) {
            try {
                resultSet.close();
                //gc回收
                resultSet = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }
        }

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
                //gc回收
                preparedStatement = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }
        }

        if (connection != null) {
            try {
                connection.close();
                //gc回收
                connection = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }
        }

        return flag;
    }


}
