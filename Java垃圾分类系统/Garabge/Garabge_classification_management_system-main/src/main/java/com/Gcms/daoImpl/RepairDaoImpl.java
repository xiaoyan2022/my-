package com.Gcms.daoImpl;

import com.Gcms.dao.BaseDao;
import com.Gcms.dao.RepairDao;
import com.Gcms.pojo.Repair;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : k
 * @Date : 2022/7/2
 * @Desc : 报修管理
 */
public class RepairDaoImpl implements RepairDao {

    //查询所有的报修管理
    @Override
    public ResultSet selectAll(Connection connection) throws SQLException {
        ResultSet rs = null;

        String sql = "select id as '报修ID'," +
                "title as '标题'," +
                "details as '详情'," +
                "applicant as '申请人'," +
                "propertyCompletionStatus as '业务完成状态'," +
                "userConfirmationStatus as '用户确认状态' from gui.repair_management";

        rs = BaseDao.execute(connection, BaseDao.pstmt, null, sql);
        //BaseDao.closeResource(connection,pstm,rs);
        return rs;

    }


    //添加报修管理
    @Override
    public int add(Connection connection, Repair repairManagement) throws SQLException {
        int flag = 0;

        if (connection != null) {
            String sql = "insert into gui.repair_management(" +
                    "title,details,applicant," +
                    "propertyCompletionStatus,userConfirmationStatus) " +
                    "values(?,?,?,?,?)";
            Object[] params = {repairManagement.getTitle(), repairManagement.getDetails(),
                    repairManagement.getApplicant(), repairManagement.getPropertyCompletionStatus(),
                    repairManagement.getUserConfirmationStatus()};
            flag = BaseDao.execute(connection, BaseDao.pstmt, sql, params);
            //BaseDao.closeResource(null, BaseDao.pstmt, null);
        }
        return flag;
    }

    //根据id删除报修管理
    @Override
    public int delete(Connection connection, Integer id) throws SQLException {
        PreparedStatement pstm = null;
        int flag = 0;

        if (connection != null) {
            String sql = "delete from gui.repair_management where id = ?";
            Object[] params = {id};
            flag = BaseDao.execute(connection, BaseDao.pstmt, sql, params);
            //BaseDao.closeResource(null, BaseDao.pstmt, null);
        }
        return flag;
    }

    //根据id修改报修管理（主要用于修改物业完成状态和用户确认状态）
    @Override
    public int update(Connection connection, Repair repairManagement) throws SQLException {
        int flag = 0;

        if (connection != null) {
            String sql = "update gui.repair_management set title=?," +
                    "details=?,applicant = ?,propertyCompletionStatus =?,userConfirmationStatus=? where id = ? ";

            Object[] params = {repairManagement.getTitle(), repairManagement.getDetails(),
                    repairManagement.getApplicant(), repairManagement.getPropertyCompletionStatus(),
                    repairManagement.getUserConfirmationStatus(),
                    repairManagement.getId()};
            flag = BaseDao.execute(connection, BaseDao.pstmt, sql, params);
            //BaseDao.closeResource(null, BaseDao.pstmt, null);
        }
        return flag;
    }
}
