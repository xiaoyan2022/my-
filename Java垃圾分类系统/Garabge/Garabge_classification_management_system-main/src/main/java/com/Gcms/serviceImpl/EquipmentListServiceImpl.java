package com.Gcms.serviceImpl;

import com.Gcms.dao.BaseDao;
import com.Gcms.dao.EquipmentListDao;
import com.Gcms.daoImpl.EquipmentListDaoImpl;
import com.Gcms.pojo.EquipmentList;
import com.Gcms.service.EquipmentListService;
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
 * @Date : 2022/7/3
 * @Desc : 设备列表
 */
public class EquipmentListServiceImpl implements EquipmentListService {

    //业务层 要 调用dao层
    private final EquipmentListDao equipmentListDao;
    private static final Logger LOGGER = LoggerFactory.getLogger("EquipmentListServiceImpl.class");

    public EquipmentListServiceImpl() {
        equipmentListDao = new EquipmentListDaoImpl();
    }


    @Override
    public DefaultTableModel selectAll() {
        BaseDao.openConnection();
        ResultSet rs = null;
        DefaultTableModel dtm = null;
        try {
            rs = equipmentListDao.selectAll(BaseDao.conn);
            dtm = DataTable.toDefaultTableModel(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        BaseDao.closeResource(BaseDao.conn, BaseDao.pstmt, rs);
        return dtm;
    }


    @Override
    public boolean add(String[] params) {
        boolean flag = false;

        //封装pojo类
        EquipmentList equipmentList = new EquipmentList();
        equipmentList.setEquipmentName(params[1]);
        equipmentList.setDeliveryPort(params[2]);
        equipmentList.setCleaner(params[3]);
        equipmentList.setDeliveryPortCapacity(Integer.parseInt(params[4]));
        equipmentList.setDeliveryPortTemperature(Integer.parseInt(params[5]));
        equipmentList.setDeliveryPortWeight(Integer.parseInt(params[6]));
        equipmentList.setDeliveryPortHumidity(Integer.parseInt(params[7]));
        equipmentList.setDeliveryPortHarmfulGas(params[8]);
        equipmentList.setDeliveryPortStatus(Integer.parseInt(params[9]));

        try {
            BaseDao.openConnection();
            BaseDao.conn.setAutoCommit(false);
            int i = equipmentListDao.add(BaseDao.conn, equipmentList);
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
            int i = equipmentListDao.delete(BaseDao.conn, id);
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
            LOGGER.error("delete方法出错了");
        } finally {
            BaseDao.closeResource(BaseDao.conn, BaseDao.pstmt, null);
        }
        return flag;
    }

    @Override
    public boolean update(String[] params) {
        boolean flag = false;

        EquipmentList equipmentList = new EquipmentList();
        equipmentList.setId(Integer.parseInt(params[0]));
        equipmentList.setEquipmentName(params[1]);
        equipmentList.setDeliveryPort(params[2]);
        equipmentList.setCleaner(params[3]);
        equipmentList.setDeliveryPortCapacity(Integer.parseInt(params[4]));
        equipmentList.setDeliveryPortTemperature(Integer.parseInt(params[5]));
        equipmentList.setDeliveryPortWeight(Integer.parseInt(params[6]));
        equipmentList.setDeliveryPortHumidity(Integer.parseInt(params[7]));
        equipmentList.setDeliveryPortHarmfulGas(params[8]);
        equipmentList.setDeliveryPortStatus(Integer.parseInt(params[9]));

        BaseDao.openConnection();
        try {
            BaseDao.conn.setAutoCommit(false);
            int i = equipmentListDao.update(BaseDao.conn, equipmentList);
            BaseDao.conn.commit();

            if (i > 0) {
                flag = true;
                LOGGER.info("修改成功");
                JOptionPane.showMessageDialog(null, "修改成功");
            } else {
                System.out.println("修改失败");
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
