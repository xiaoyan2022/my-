package com.Gcms.daoImpl;

import com.Gcms.dao.BaseDao;
import com.Gcms.dao.RubbishClassificationDao;
import com.Gcms.pojo.RubbishClassification;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : k
 * @Date : 2022/7/2
 * @Desc : 垃圾分类信息管理
 */
public class RubbishClassificationDaoImpl implements RubbishClassificationDao {

    //查询所有的垃圾分类信息
    @Override
    public ResultSet selectAll(Connection connection) throws SQLException {
        ResultSet rs = null;

        String sql = "select id as '垃圾分类ID'," +
                "classificationName as '垃圾分类名'," +
                "rubbishType as '垃圾类型' from gui.rubbish_classification";

        rs = BaseDao.execute(connection, BaseDao.pstmt, null, sql);

        //BaseDao.closeResource(connection, pstm, rs);

        return rs;


    }


    //添加垃圾分类信息
    @Override
    public int add(Connection connection, RubbishClassification rubbishClassification) throws SQLException {
        int flag = 0;

        if (connection != null) {
            String sql = "insert into gui.rubbish_classification(classificationName,rubbishType) values(?,?)";
            Object[] params = {rubbishClassification.getClassificationName(), rubbishClassification.getRubbishType()};
            flag = BaseDao.execute(connection, BaseDao.pstmt, sql, params);

            //BaseDao.closeResource(connection, BaseDao.pstmt, null);
        }
        return flag;
    }


    //根据id删除垃圾分类信息
    @Override
    public int delete(Connection connection, Integer id) throws SQLException {
        int flag = 0;

        if (connection != null) {
            String sql = "delete from gui.rubbish_classification where id = ?";
            Object[] params = {id};
            flag = BaseDao.execute(connection, BaseDao.pstmt, sql, params);

            //BaseDao.closeResource(connection, BaseDao.pstmt, null);
        }
        return flag;
    }


    //根据id修改垃圾分类信息
    @Override
    public int update(Connection connection, RubbishClassification rubbishClassification) throws SQLException {
        int flag = 0;

        if (connection != null) {
            String sql = "update gui.rubbish_classification set classificationName=?," +
                    "rubbishType=? where id = ? ";

            Object[] params = {rubbishClassification.getClassificationName(), rubbishClassification.getRubbishType(),
                    rubbishClassification.getId()};
            flag = BaseDao.execute(connection, BaseDao.pstmt, sql, params);
            //BaseDao.closeResource(connection, BaseDao.pstmt, null);
        }
        return flag;
    }
}
