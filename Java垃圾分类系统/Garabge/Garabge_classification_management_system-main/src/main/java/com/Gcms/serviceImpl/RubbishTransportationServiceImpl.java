package com.Gcms.serviceImpl;

import com.Gcms.dao.BaseDao;
import com.Gcms.dao.RubbishTransportationDao;
import com.Gcms.daoImpl.RubbishTransportationDaoImpl;
import com.Gcms.pojo.RubbishTransportation;
import com.Gcms.service.RubbishTransportationService;
import com.Gcms.view.DataTable;
import com.Gcms.view.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : k
 * @Date : 2022/7/2
 * @Desc : 垃圾运输信息管理
 */
public class RubbishTransportationServiceImpl implements RubbishTransportationService {

    //业务层 要 调用dao层
    private final RubbishTransportationDao rubbishTransportationDao;
    private final static Logger LOGGER = LoggerFactory.getLogger("RubbishTransportationServiceImpl.class");

    public RubbishTransportationServiceImpl() {
        rubbishTransportationDao = new RubbishTransportationDaoImpl();
    }


    @Override
    public DefaultTableModel selectAll() {
        BaseDao.openConnection();
        ResultSet rs = null;
        DefaultTableModel dtm = null;
        try {
            rs = rubbishTransportationDao.selectAll(BaseDao.conn);
            dtm = DataTable.toDefaultTableModel(rs);
        } catch (SQLException e) {
            LOGGER.error("selectAll方法出错了");
        }
        BaseDao.closeResource(BaseDao.conn, BaseDao.pstmt, rs);
        return dtm;
    }


    @Override
    public boolean add(String[] params) {
        boolean flag = false;
        RubbishTransportation rubbishTransportation = new RubbishTransportation();
        //rubbishTransportation.setId(); //ID为数据库自增 无需设置
        rubbishTransportation.setChargeName(params[1]);
        rubbishTransportation.setTransportationQuantity(Integer.parseInt(params[2]));
        rubbishTransportation.setCommunityName(params[3]);
        rubbishTransportation.setRubbishType(Integer.parseInt(params[4]));
        rubbishTransportation.setTransportationStatus(Integer.parseInt(params[5]));
        rubbishTransportation.setCreateTime(new Date());//设置为当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            rubbishTransportation.setTransportationTime(sdf.parse(params[7]));
            BaseDao.openConnection();
            BaseDao.conn.setAutoCommit(false);
            int i = rubbishTransportationDao.add(BaseDao.conn, rubbishTransportation);
            BaseDao.conn.commit();

            if (i > 0) {
                flag = true;
                LOGGER.info("添加成功");
                JOptionPane.showMessageDialog(Menu.menu, "添加成功");
            } else {
                LOGGER.info("添加失败");
                JOptionPane.showMessageDialog(Menu.menu, "添加失败");
            }
        } catch (ParseException parseException) {
            LOGGER.error("用户输入的时间有误");
            JOptionPane.showMessageDialog(null, "请按照”yyyy-MM-dd HH:mm:ss“输入时间");
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
            int i = rubbishTransportationDao.delete(BaseDao.conn, id);
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

    @Override
    public boolean update(String[] params) {
        boolean flag = false;
        BaseDao.openConnection();
        RubbishTransportation rubbishTransportation = new RubbishTransportation();
        //rubbishTransportation.setId(); //ID为数据库自增 无需设置
        rubbishTransportation.setChargeName(params[1]);
        rubbishTransportation.setTransportationQuantity(Integer.parseInt(params[2]));
        rubbishTransportation.setCommunityName(params[3]);
        rubbishTransportation.setRubbishType(Integer.parseInt(params[4]));
        rubbishTransportation.setTransportationStatus(Integer.parseInt(params[5]));
        rubbishTransportation.setCreateTime(new Date());//设置为当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            rubbishTransportation.setTransportationTime(sdf.parse(params[7]));
        } catch (ParseException parseException) {
            LOGGER.error("时间参数无法解析");
        }
        try {
            BaseDao.conn.setAutoCommit(false);
            int i = rubbishTransportationDao.update(BaseDao.conn, rubbishTransportation);
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
