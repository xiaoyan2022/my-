package com.Gcms.serviceImpl;

import com.Gcms.dao.BaseDao;
import com.Gcms.dao.RubbishStationDao;
import com.Gcms.daoImpl.RubbishStationDaoImpl;
import com.Gcms.pojo.RubbishStation;
import com.Gcms.service.RubbishStationService;
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
 * @Desc : 垃圾站信息管理
 */
public class RubbishStationServiceImpl implements RubbishStationService {

    //业务层 要 调用dao层
    private final RubbishStationDao rubbishStationDao;
    private final static Logger LOGGER = LoggerFactory.getLogger("RubbishStationServiceImpl.class");

    public RubbishStationServiceImpl() {
        rubbishStationDao = new RubbishStationDaoImpl();
    }


    //查询所有的垃圾分类信息
    @Override
    public DefaultTableModel selectAll() {
        BaseDao.openConnection();
        ResultSet rs = null;
        DefaultTableModel dtm = null;
        try {
            rs = rubbishStationDao.selectAll(BaseDao.conn);
            dtm = DataTable.toDefaultTableModel(rs);
        } catch (SQLException e) {
            LOGGER.error("selectAll出错了");
        }
        BaseDao.closeResource(BaseDao.conn, BaseDao.pstmt, rs);
        return dtm;
    }


    //添加垃圾分类信息
    @Override
    public boolean add(String[] params) {
        boolean flag = false;
        RubbishStation rubbishStation = new RubbishStation();
        //rubbishStation.setId(Integer.parseInt(params[0]));
        rubbishStation.setClassificationName(Integer.parseInt(params[1]));
        rubbishStation.setNameStation(params[2]);
        rubbishStation.setContacts(params[3]);
        try {
            BaseDao.openConnection();
            BaseDao.conn.setAutoCommit(false);
            int i = rubbishStationDao.add(BaseDao.conn, rubbishStation);
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
            int i = rubbishStationDao.delete(BaseDao.conn, id);
            BaseDao.conn.commit();
            if (i > 0) {
                flag = true;
                LOGGER.info("删除成功");
                JOptionPane.showMessageDialog(null, "删除成功");
            } else {
                LOGGER.info("删除失败");
                JOptionPane.showMessageDialog(null, "删除失败");

            }
        } catch (SQLException e) {
            LOGGER.error("delete方法出错了");
        } finally {
            BaseDao.closeResource(BaseDao.conn, BaseDao.pstmt, null);
        }
        return flag;
    }

    //根据id修改垃圾分类信息
    @Override
    public boolean update(String[] params) {
        boolean flag = false;

        RubbishStation rubbishStation = new RubbishStation();
        rubbishStation.setId(Integer.parseInt(params[0]));
        rubbishStation.setClassificationName(Integer.parseInt(params[1]));
        rubbishStation.setNameStation(params[2]);
        rubbishStation.setContacts(params[3]);

        BaseDao.openConnection();
        try {
            BaseDao.conn.setAutoCommit(false);
            int i = rubbishStationDao.update(BaseDao.conn, rubbishStation);
            BaseDao.conn.commit();

            if (i > 0) {
                flag = true;
                LOGGER.info("修改成功");
                JOptionPane.showMessageDialog(null, "修改成功");
            } else {
                LOGGER.info("修改失败");
                JOptionPane.showMessageDialog(null, "修改失败");
            }
        } catch (SQLException e) {
            LOGGER.error("update方法出错了");
        } finally {
            BaseDao.closeResource(BaseDao.conn, BaseDao.pstmt, null);
        }
        return flag;
    }
}
