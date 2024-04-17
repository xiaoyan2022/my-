package com.Gcms.service;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

/**
 * @author : k
 * @Date : 2022/7/2
 * @Desc : 投诉管理
 */
public interface ComplaintService {
    //查询所有的投诉管理
    public DefaultTableModel selectAll() throws SQLException;


    //添加投诉管理
    public boolean add(String[] params) throws SQLException;

    //根据id删除投诉管理
    public boolean delete(Integer id);

    //根据id修改投诉管理
    public boolean update(String[] params);
}
