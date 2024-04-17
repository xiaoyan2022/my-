package com.Gcms.service;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

/**
 * @author : k
 * @Date : 2022/7/2
 * @Desc :
 */
public interface UserService {


    //查询所有的用户信息
    public DefaultTableModel selectAll() throws SQLException;


    public DefaultTableModel selectByUserName(String userName);

    public boolean login(String username, String password);

    public boolean register(String[] params);

    public boolean delete(String userName);

    public boolean update(String[] params);


}
