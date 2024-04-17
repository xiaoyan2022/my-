package com.Gcms.daoImpl;

import com.Gcms.dao.BaseDao;
import com.Gcms.dao.RubbishStationDao;
import com.Gcms.pojo.RubbishStation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : k
 * @Date : 2022/7/2
 * @Desc : 垃圾站信息管理
 */
public class RubbishStationDaoImpl implements RubbishStationDao {

    //查询所有的垃圾站信息
    @Override
    public ResultSet selectAll(Connection connection) throws SQLException {
        ResultSet rs = null;

        String sql = "select id as '垃圾站ID'," +
                "classificationName as '垃圾存放类型'," +
                "nameStation as '垃圾站名称'," +
                "contacts as '联系人' from gui.rubbish_station";

        rs = BaseDao.execute(connection, BaseDao.pstmt, null, sql);

        //BaseDao.closeResource(connection,pstm,rs);

        return rs;
    }


    //添加垃圾站信息
    @Override
    public int add(Connection connection, RubbishStation rubbishStation) throws SQLException {

        int flag = 0;

        if (connection != null) {
            String sql = "insert into gui.rubbish_station(classificationName,nameStation,contacts) values(?,?,?)";
            Object[] params = {rubbishStation.getClassificationName(), rubbishStation.getNameStation(), rubbishStation.getContacts()};
            flag = BaseDao.execute(connection, BaseDao.pstmt, sql, params);

            //BaseDao.closeResource(connection, BaseDao.pstmt, null);
        }
        return flag;
    }


    //根据id删除垃圾站信息
    @Override
    public int delete(Connection connection, Integer id) throws SQLException {
        int flag = 0;

        if (connection != null) {
            String sql = "delete from gui.rubbish_station where id = ?";
            Object[] params = {id};
            flag = BaseDao.execute(connection, BaseDao.pstmt, sql, params);

            //BaseDao.closeResource(connection, BaseDao.pstmt, null);
        }
        return flag;
    }


    //根据id修改垃圾站信息
    @Override
    public int update(Connection connection, RubbishStation rubbishStation) throws SQLException {
        int flag = 0;

        if (connection != null) {
            String sql = "update gui.rubbish_station set classificationName=?," +
                    "nameStation=?,contacts=? where id = ? ";
            Object[] params = {rubbishStation.getClassificationName(), rubbishStation.getNameStation(),
                    rubbishStation.getContacts(), rubbishStation.getId()};
            flag = BaseDao.execute(connection, BaseDao.pstmt, sql, params);
            //BaseDao.closeResource(null, BaseDao.pstmt, null);
        }
        return flag;
    }

}
