package com.Gcms.daoImpl;

import com.Gcms.dao.BaseDao;
import com.Gcms.dao.RubbishTransportationDao;
import com.Gcms.pojo.RubbishTransportation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : k
 * @Date : 2022/7/2
 * @Desc : 垃圾运输信息管理
 */
public class RubbishTransportationDaoImpl implements RubbishTransportationDao {

    //查询所有的垃圾运输信息管理
    @Override
    public ResultSet selectAll(Connection connection) throws SQLException {
        ResultSet rs = null;

        String sql = "select id as '垃圾运输ID'," +
                "chargeName as '收费名称'," +
                "transportationQuantity as  '运输数量'," +
                "communityName as '小区名称'," +
                "rubbishType as '垃圾类型' ," +
                "transportationStatus as '运输状态'," +
                "createTime as '创建时间'," +
                "transportationTime as '运输时间' from gui.rubbish_transportation";

        rs = BaseDao.execute(connection, BaseDao.pstmt, null, sql);

        //BaseDao.closeResource(connection,pstm,rs);

        return rs;
    }


    //添加垃圾运输信息管理
    @Override
    public int add(Connection connection, RubbishTransportation rubbishTransportation) throws SQLException {
        int flag = 0;


        if (connection != null) {
            String sql = "insert into gui.rubbish_transportation(chargeName,transportationQuantity,communityName," +
                    "rubbishType,transportationStatus,createTime,\n" +
                    "transportationTime) values(?,?,?,?,?,?,?)";
            Object[] params = {rubbishTransportation.getChargeName(), rubbishTransportation.getTransportationQuantity(),
                    rubbishTransportation.getCommunityName(), rubbishTransportation.getRubbishType(),
                    rubbishTransportation.getTransportationStatus(), rubbishTransportation.getCreateTime(),
                    rubbishTransportation.getTransportationTime()};
            flag = BaseDao.execute(connection, BaseDao.pstmt, sql, params);

            //BaseDao.closeResource(connection, BaseDao.pstmt, null);
        }
        return flag;
    }

    //根据id删除垃圾运输信息管理
    @Override
    public int delete(Connection connection, Integer id) throws SQLException {

        int flag = 0;

        if (connection != null) {
            String sql = "delete from gui.rubbish_transportation where id = ?";
            Object[] params = {id};
            flag = BaseDao.execute(connection, BaseDao.pstmt, sql, params);

            //BaseDao.closeResource(connection, BaseDao.pstmt, null);
        }
        return flag;
    }

    //根据id修改垃圾运输信息管理
    @Override
    public int update(Connection connection, RubbishTransportation rubbishTransportation) throws SQLException {
        int flag = 0;

        if (connection != null) {
            String sql = "update gui.rubbish_transportation set chargeName=?," +
                    "transportationQuantity=?,communityName=?, rubbishType=?," +
                    "transportationStatus=?,createTime=?,transportationTime=? where id = ? ";


            Object[] params = {rubbishTransportation.getChargeName(), rubbishTransportation.getTransportationQuantity(),
                    rubbishTransportation.getCommunityName(), rubbishTransportation.getRubbishType(),
                    rubbishTransportation.getTransportationStatus(), rubbishTransportation.getCreateTime(),
                    rubbishTransportation.getTransportationTime(), rubbishTransportation.getId()};
            flag = BaseDao.execute(connection, BaseDao.pstmt, sql, params);
            //BaseDao.closeResource(connection, BaseDao.pstmt, null);
        }
        return flag;
    }
}
