package com.Gcms.daoImpl;

import com.Gcms.dao.BaseDao;
import com.Gcms.dao.ComplaintDao;
import com.Gcms.pojo.Complaint;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : k
 * @Date : 2022/7/2
 * @Desc : 投诉管理
 */
public class ComplaintDaoImpl implements ComplaintDao {

    //查询所有的报修管理
    @Override
    public ResultSet selectAll(Connection connection) throws SQLException {
        ResultSet rs = null;
        String sql = "select id as '用户ID'," +
                "title as '标题'," +
                "details as '详情'," +
                "complainant as '投诉人'," +
                "propertyCompletionStatus as '业务完成状态'," +
                "userConfirmationStatus as '用户确认状态'  from gui.complaint_management";
        rs = BaseDao.execute(connection, BaseDao.pstmt, null, sql);
        return rs;
    }



    //添加报修管理
    @Override
    public int add(Connection connection, Complaint complaintManagement) throws SQLException {
        int flag = 0;
        if (connection != null) {
            String sql = "insert into gui.complaint_management(" +
                    "title,details,complainant," +
                    "propertyCompletionStatus,userConfirmationStatus) " +
                    "values(?,?,?,?,?)";
            Object[] params = {complaintManagement.getTitle(), complaintManagement.getDetails(),
                    complaintManagement.getComplainant(), complaintManagement.getPropertyCompletionStatus(),
                    complaintManagement.getUserConfirmationStatus()};
            flag = BaseDao.execute(connection, BaseDao.pstmt, sql, params);

            //BaseDao.closeResource(connection, BaseDao.pstmt, null);
        }
        return flag;
    }

    //根据id删除报修管理
    @Override
    public int delete(Connection connection, Integer id) throws SQLException {
        int flag = 0;

        if (connection != null) {
            String sql = "delete from gui.complaint_management where id = ?";
            Object[] params = {id};
            flag = BaseDao.execute(connection, BaseDao.pstmt, sql, params);

            //BaseDao.closeResource(connection, BaseDao.pstmt, null);
        }
        return flag;
    }

    //根据id修改报修管理（主要用于修改物业完成状态和用户确认状态）
    @Override
    public int update(Connection connection, Complaint complaintManagement) throws SQLException {
        int flag = 0;

        if (connection != null) {
            String sql = "update gui.complaint_management set title=?," +
                    "details=?,complainant = ?,propertyCompletionStatus =?,userConfirmationStatus=? where id = ? ";

            Object[] params = {complaintManagement.getTitle(), complaintManagement.getDetails(),
                    complaintManagement.getComplainant(), complaintManagement.getPropertyCompletionStatus(),
                    complaintManagement.getUserConfirmationStatus(),
                    complaintManagement.getId()};
            flag = BaseDao.execute(connection, BaseDao.pstmt, sql, params);
            //BaseDao.closeResource(connection, BaseDao.pstmt, null);
        }
        return flag;
    }
}
