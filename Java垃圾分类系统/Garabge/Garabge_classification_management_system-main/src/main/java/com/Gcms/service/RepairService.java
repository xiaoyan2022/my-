package com.Gcms.service;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

/**
 * @author : k
 * @Date : 2022/7/2
 * @Desc : 报修管理
 */
public interface RepairService {
    //查询所有的报修管理
    public DefaultTableModel selectAll() throws SQLException;

    //添加报修管理
    public boolean add(String[] params) throws SQLException;

    //根据id删除报修管理
    public boolean delete(Integer id);

    //根据id修改报修管理
    public boolean update(String[] params);
}
