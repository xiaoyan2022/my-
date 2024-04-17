package com.Gcms.serviceImpl;

import com.Gcms.dao.BaseDao;
import com.Gcms.dao.RepairDao;
import com.Gcms.daoImpl.RepairDaoImpl;
import com.Gcms.pojo.Repair;
import com.Gcms.service.RepairService;
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
 * @Desc : 报修管理
 */
public class RepairServiceImpl implements RepairService {
    //业务层 要 调用dao层
    private final RepairDao repairDao;
    private static final Logger LOGGER = LoggerFactory.getLogger("RepairServiceImpl.class");

    public RepairServiceImpl() {
        repairDao = new RepairDaoImpl();
    }

    //查询所有的垃圾分类信息
    @Override
    public DefaultTableModel selectAll() {
        BaseDao.openConnection();
        ResultSet rs = null;
        DefaultTableModel dtm = null;

        try {
            rs = repairDao.selectAll(BaseDao.conn);
            dtm = DataTable.toDefaultTableModel(rs);
        } catch (SQLException e) {
            LOGGER.error("selectAll方法出错了");
        } finally {
            BaseDao.closeResource(BaseDao.conn, BaseDao.pstmt, rs);
        }
        return dtm;
    }


    //添加报修管理
    @Override
    public boolean add(String[] params) {
        boolean flag = false;

        Repair repair = new Repair();
        //repair.setId(Integer.parseInt(params[0]));
        repair.setTitle(params[1]);
        repair.setDetails(params[2]);
        repair.setApplicant(params[3]);
        repair.setPropertyCompletionStatus(Integer.parseInt(params[4]));
        repair.setUserConfirmationStatus(Integer.parseInt(params[5]));

        try {
            BaseDao.openConnection();
            BaseDao.conn.setAutoCommit(false);
            int i = repairDao.add(BaseDao.conn, repair);
            BaseDao.conn.commit();

            if (i > 0) {
                flag = true;
                LOGGER.info("添加成功");
                JOptionPane.showMessageDialog(null, "添加成功");
            } else {
                LOGGER.info("添加失败");
            }
        } catch (SQLException e) {
            LOGGER.error("add方法出错了");
        } finally {
            BaseDao.closeResource(BaseDao.conn, BaseDao.pstmt, null);
        }
        return flag;
    }

    //根据id删除报修管理
    @Override
    public boolean delete(Integer id) {

        boolean flag = false;
        BaseDao.openConnection();
        try {

            BaseDao.conn.setAutoCommit(false);
            int i = repairDao.delete(BaseDao.conn, id);
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

    //根据id修改报修管理
    @Override
    public boolean update(String[] params) {
        boolean flag = false;
        BaseDao.openConnection();

        Repair repair = new Repair();
        repair.setId(Integer.parseInt(params[0]));
        repair.setTitle(params[1]);
        repair.setDetails(params[2]);
        repair.setApplicant(params[3]);
        repair.setPropertyCompletionStatus(Integer.parseInt(params[4]));
        repair.setUserConfirmationStatus(Integer.parseInt(params[5]));

        try {
            BaseDao.conn.setAutoCommit(false);
            int i = repairDao.update(BaseDao.conn, repair);
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
            LOGGER.error("update出错了");
        } finally {
            BaseDao.closeResource(BaseDao.conn, BaseDao.pstmt, null);
        }
        return flag;
    }
}
