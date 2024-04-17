package com.Gcms.serviceImpl;

import com.Gcms.dao.BaseDao;
import com.Gcms.dao.RubbishClassificationDao;
import com.Gcms.daoImpl.RubbishClassificationDaoImpl;
import com.Gcms.pojo.RubbishClassification;
import com.Gcms.service.RubbishClassificationService;
import com.Gcms.view.DataTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : k
 * @Date : 2022/7/2
 * @Desc : 垃圾分类信息管理
 */
public class RubbishClassificationServiceImpl implements RubbishClassificationService {


    //业务层 要 调用dao层
    private final RubbishClassificationDao rubbishClassificationDao;
    private final static Logger LOGGER = LoggerFactory.getLogger("RubbishClassificationServiceImpl.class");

    public RubbishClassificationServiceImpl() {
        rubbishClassificationDao = new RubbishClassificationDaoImpl();
    }

    //查询所有的垃圾分类信息
    @Override
    public DefaultTableModel selectAll() {
        BaseDao.openConnection();
        ResultSet rs = null;
        DefaultTableModel dtm = null;
        try {
            rs = rubbishClassificationDao.selectAll(BaseDao.conn);
            dtm = DataTable.toDefaultTableModel(rs);
        } catch (SQLException e) {
            LOGGER.error("selectAll方法出错了");
        }
        BaseDao.closeResource(BaseDao.conn, BaseDao.pstmt, rs);
        return dtm;
    }


    //添加垃圾分类信息
    @Override
    public boolean add(String[] params) {
        boolean flag = false;
        try {
            BaseDao.openConnection();

            RubbishClassification rubbishClassification = new RubbishClassification();
            //rubbishClassification.setId(Integer.parseInt(params[0]));
            rubbishClassification.setClassificationName(params[1]);
            rubbishClassification.setRubbishType(params[2]);


            BaseDao.conn.setAutoCommit(false);
            int i = rubbishClassificationDao.add(BaseDao.conn, rubbishClassification);
            BaseDao.conn.commit();

            if (i > 0) {
                flag = true;
                LOGGER.info("添加成功");
                JOptionPane.showMessageDialog(null, "添加成功");
            } else {
                LOGGER.info("添加失败");
                JOptionPane.showMessageDialog(null, "添加失败");
            }
        } catch (SQLException e) {
            LOGGER.error("add方法出错了");
        } finally {
            BaseDao.closeResource(BaseDao.conn, BaseDao.pstmt, null);
        }
        return flag;
    }

    //根据id删除垃圾分类信息
    @Override
    public boolean delete(Integer id) {

        boolean flag = false;
        BaseDao.openConnection();
        try {
            BaseDao.conn.setAutoCommit(false);
            int i = rubbishClassificationDao.delete(BaseDao.conn, id);
            BaseDao.conn.commit();
            if (i > 0) {
                flag = true;
                LOGGER.info("删除成功");
                JOptionPane.showMessageDialog(null, "删除成功");
            } else {
                LOGGER.info("删除失败");
                JOptionPane.showMessageDialog(null, "删除成功");
            }
        } catch (SQLException e) {
            LOGGER.error("delete出错了");
        } finally {
            BaseDao.closeResource(BaseDao.conn, BaseDao.pstmt, null);
        }
        return flag;
    }

    //根据id修改垃圾分类信息
    @Override
    public boolean update(String[] params) {
        boolean flag = false;
        BaseDao.openConnection();
        RubbishClassification rubbishClassification = new RubbishClassification();
        rubbishClassification.setId(Integer.parseInt(params[0]));
        rubbishClassification.setClassificationName(params[1]);
        rubbishClassification.setRubbishType(params[2]);

        try {
            BaseDao.conn.setAutoCommit(false);
            int i = rubbishClassificationDao.update(BaseDao.conn, rubbishClassification);
            BaseDao.conn.commit();

            if (i > 0) {
                flag = true;
                LOGGER.info("修改成功");
                JOptionPane.showMessageDialog(null, "修改成功");
            } else {
                LOGGER.info("修改失败");
                JOptionPane.showMessageDialog(null, "修改成功");
            }
        } catch (SQLException e) {
            LOGGER.error("update方法出错了");
        } finally {
            BaseDao.closeResource(BaseDao.conn, BaseDao.pstmt, null);
        }
        return flag;
    }
}
