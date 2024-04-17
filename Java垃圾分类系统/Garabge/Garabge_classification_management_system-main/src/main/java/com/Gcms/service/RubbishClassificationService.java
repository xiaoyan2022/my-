package com.Gcms.service;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;

/**
 * @author : k
 * @Date : 2022/7/2
 * @Desc : 垃圾分类信息管理
 */
public interface RubbishClassificationService {

    //查询所有的垃圾分类信息
    public DefaultTableModel selectAll() throws SQLException;

    //添加垃圾分类信息
    public boolean add(String[] params) throws SQLException;

    //根据id删除垃圾分类信息
    public boolean delete(Integer id);

    //根据id修改垃圾分类信息
    public boolean update(String[] params);
}
