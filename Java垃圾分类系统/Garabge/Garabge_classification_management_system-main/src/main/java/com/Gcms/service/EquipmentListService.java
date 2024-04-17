package com.Gcms.service;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

/**
 * @author : k
 * @Date : 2022/7/3
 * @Desc : 设备列表
 */
public interface EquipmentListService {
    //查询所有的设备列表
    public DefaultTableModel selectAll() throws SQLException;



    //添加设备列表
    public boolean add(String[] params) throws SQLException;

    //根据id删除设备列表
    public boolean delete(Integer id);

    //根据id修改设备列表
    public boolean update(String[] params);
}
