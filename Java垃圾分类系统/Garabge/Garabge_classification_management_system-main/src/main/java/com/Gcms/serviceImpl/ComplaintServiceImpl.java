package com.Gcms.serviceImpl;

import com.Gcms.dao.BaseDao;
import com.Gcms.dao.ComplaintDao;
import com.Gcms.daoImpl.ComplaintDaoImpl;
import com.Gcms.pojo.Complaint;
import com.Gcms.service.ComplaintService;
import com.Gcms.view.DataTable;
import com.Gcms.view.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : k
 * @Date : 2022/7/2
 * @Desc : 投诉管理
 */
public class ComplaintServiceImpl implements ComplaintService {

    //业务层 要 调用dao层
    private final ComplaintDao complaintManagementDao;
    private final static Logger LOGGER = LoggerFactory.getLogger("ComplaintServiceImpl.class");

    public ComplaintServiceImpl() {
        complaintManagementDao = new ComplaintDaoImpl();
    }


    @Override
    public DefaultTableModel selectAll() {
        BaseDao.openConnection();//获取数据库连接，直接传给静态成员BaseDao.Conn
        ResultSet rs = null;//调用dao层方法
        DefaultTableModel dtm = null;
        try {
            rs = complaintManagementDao.selectAll(BaseDao.conn);
            dtm = DataTable.toDefaultTableModel(rs);//将resultSet转化为DefaultTableModel
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error("selectAll方法出错");
        } finally {
            //在service层进行connection连接的关闭
            BaseDao.closeResource(BaseDao.conn, BaseDao.pstmt, rs);//关闭资源
        }
        return dtm;
    }


    @Override
    public boolean add(String[] params) {
        boolean flag = false;

        //---------------将传入的字符数组封装为pojo对象-----------
        Complaint complaintManagement = new Complaint();
        //complaintManagement.setId(Integer.parseInt(params[0]));
        complaintManagement.setTitle(params[1]);
        complaintManagement.setDetails(params[2]);
        complaintManagement.setComplainant(params[3]);
        complaintManagement.setPropertyCompletionStatus(Integer.parseInt(params[4]));
        complaintManagement.setUserConfirmationStatus(Integer.parseInt(params[5]));

        try {
            BaseDao.openConnection();
            BaseDao.conn.setAutoCommit(false);
            int i = complaintManagementDao.add(BaseDao.conn, complaintManagement);
            BaseDao.conn.commit();
            if (i > 0) {
                flag = true;
                LOGGER.info("添加成功");
                JOptionPane.showMessageDialog(Menu.menu, "添加成功");
            } else {
                LOGGER.info("添加失败");
                JOptionPane.showMessageDialog(Menu.menu, "添加失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error("add方法出错了");
        } finally {
            BaseDao.closeResource(BaseDao.conn, BaseDao.pstmt, null);
        }
        return flag;
    }

    @Override
    public boolean delete(Integer id) {
        boolean flag = false;
        BaseDao.openConnection();
        try {
            BaseDao.conn.setAutoCommit(false);
            int i = complaintManagementDao.delete(BaseDao.conn, id);
            BaseDao.conn.commit();
            if (i > 0) {
                flag = true;
                LOGGER.info("删除成功");
                JOptionPane.showMessageDialog(Menu.menu, "删除成功");
            } else {
                LOGGER.info("删除失败");
                JOptionPane.showMessageDialog(Menu.menu, "删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error("delete出错了");
        } finally {
            //在service层进行connection连接的关闭
            BaseDao.closeResource(BaseDao.conn, BaseDao.pstmt, null);
        }
        return flag;
    }

    @Override
    public boolean update(String[] params) {
        boolean flag = false;
        BaseDao.openConnection();
        //---------------将传入的字符数组封装为pojo对象-----------
        Complaint complaintManagement = new Complaint();
        complaintManagement.setId(Integer.parseInt(params[0]));
        complaintManagement.setTitle(params[1]);
        complaintManagement.setDetails(params[2]);
        complaintManagement.setComplainant(params[3]);
        complaintManagement.setPropertyCompletionStatus(Integer.parseInt(params[4]));
        complaintManagement.setUserConfirmationStatus(Integer.parseInt(params[5]));

        try {
            BaseDao.conn.setAutoCommit(false);
            int i = complaintManagementDao.update(BaseDao.conn, complaintManagement);
            BaseDao.conn.commit();

            if (i > 0) {
                flag = true;
                LOGGER.info("修改成功");
                JOptionPane.showMessageDialog(Menu.menu, "修改成功");
            } else {
                LOGGER.info("修改失败");
                JOptionPane.showMessageDialog(Menu.menu, "修改失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error("update方法出错了");
        } finally {
            //在service层进行connection连接的关闭
            BaseDao.closeResource(BaseDao.conn, BaseDao.pstmt, null);
        }
        return flag;
    }


}
